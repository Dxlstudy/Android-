package com.example.justloginregistertest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by littlecurl 2018/6/24
 */
public class MainActivity extends AppCompatActivity {

    private DBOpenHelper dbOpenHelper;
    private List<Food> foods = new ArrayList<>();
    private FoodAdpater adpter;

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
        adpter = new FoodAdpater(this, foods);
        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(adpter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetilActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (!foods.isEmpty()) {
            foods.clear();
        }
        int[] imageid = new int[]{R.drawable.lvdagun, R.drawable.ic_launcher_background};
        String[] title = new String[]{"123", "223"};
        String[] weizhi = new String[]{"1234", "2234"};
        String[] jiage = new String[]{"$123", "$123"};
        Food food;
        for (int i = 0; i < imageid.length; i++) {
            food = new Food(title[i],
                    "http://img.jituwang.com/uploads/allimg/140425/259439-14042514195949.jpg", jiage[i], weizhi[i]);
            foods.add(food);
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

    @Override
    protected void onResume() {
        super.onResume();

    }

    public void myClick(View view) {
        Intent intent = new Intent(MainActivity.this, addActivity.class);
        startActivity(intent);
    }


    @BindView(R.id.logout)
    Button mBtMainLogout;

    @OnClick({
            R.id.logout
    })
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.logout:
                Intent intent = new Intent(this, loginActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
