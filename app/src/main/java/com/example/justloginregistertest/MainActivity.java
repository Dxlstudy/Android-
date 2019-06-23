package com.example.justloginregistertest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.justloginregistertest.FoodAdpater.IfoodDeleteListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by littlecurl 2018/6/24
 */
public class MainActivity extends AppCompatActivity {

    private DBOpenHelper dbOpenHelper;
    private List<Food> foods = new ArrayList<>();
    private FoodAdpater adpter;
    @BindView(R.id.seachtext)
    EditText searchTextEt;
    @BindView(R.id.search)
    ImageButton searchIB;
    @BindView(R.id.add)
    ImageButton addIb;
    private boolean admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbOpenHelper = new DBOpenHelper(MainActivity.this, Constants.DB_NAME);

        /**
         * 一定 一定 一定记得加这句，而且是固定位置，在setContentView()之下
         * 否则无论写的什么逻辑  都不会在Activity中起作用
         */
        ButterKnife.bind(this);
        String name = getIntent().getStringExtra("name");
        admin = dbOpenHelper.isAdmin(name);
        if (admin) {
            addIb.setVisibility(View.VISIBLE);
        } else {
            addIb.setVisibility(View.GONE);
        }
        initData();
        adpter = new FoodAdpater(this, foods, admin);
        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(adpter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Food food = foods.get(position);
                Intent intent = new Intent(MainActivity.this, DetilActivity.class);
                intent.putExtra("food", food);
                startActivity(intent);
            }
        });
        adpter.setOnFoodDeleteListener(new IfoodDeleteListener() {
            @Override
            public void delete(Food food) {
                int deleteFood = dbOpenHelper.deleteFood(food);
                if (deleteFood != 0) {
                    initData();
                } else {
                    Toast.makeText(MainActivity.this, "操作失败", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initData() {
        if (!foods.isEmpty()) {
            foods.clear();
        }
        if (dbOpenHelper != null) {
            try {
                ArrayList<Food> allFoodData = dbOpenHelper.getAllFoodData();
                if (allFoodData != null && !allFoodData.isEmpty()) {
                    foods.addAll(allFoodData);
                }
            } catch (Exception e) {
            }
        }
        if (adpter != null) {
            adpter.notifyDataSetChanged();
        }
    }


    public void myClick(View view) {
        Intent intent = new Intent(MainActivity.this, addActivity.class);
        intent.putExtra("name",getIntent().getStringExtra("name"));
        startActivity(intent);
    }


    @BindView(R.id.logout)
    Button mBtMainLogout;

    @OnClick({
            R.id.logout, R.id.search
    })
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.search:
                searchTextEt.clearFocus();
                hideKeyboard(searchTextEt);
                Editable searchTextEtText = searchTextEt.getText();
                if (searchTextEtText != null && searchTextEtText.length() > 0) {
                    String foodKey = searchTextEtText.toString();
                    ArrayList<Food> keyWordFoods = dbOpenHelper.searchFoodData(foodKey);
                    if (keyWordFoods != null && !keyWordFoods.isEmpty()) {
                        foods.clear();
                        foods.addAll(keyWordFoods);
                        adpter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(this, "食品名称输入错误", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "请输入食品名称", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.logout:
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
            default:
                break;
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        intent.putExtra("name",getIntent().getStringExtra("name"));
        startActivity(intent);
    }

    public void hideKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
