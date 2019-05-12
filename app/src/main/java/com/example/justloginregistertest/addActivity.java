package com.example.justloginregistertest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//import android.widget.Button;
//import android.widget.TextView;
//import android.widget.Toast;

public class addActivity extends AppCompatActivity {

    private DBOpenHelper mDBOpenHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.add);
        setContentView(R.layout.add);
        ButterKnife.bind(this);
        mDBOpenHelper = new DBOpenHelper(this, Constants.DB_NAME);
    }

    public void myClick(View view) {
        Intent intent = new Intent(addActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(addActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @BindView(R.id.foodName)
    EditText mFoodName;
    @BindView(R.id.detail)
    EditText mDetail;
    @BindView(R.id.selectImage)
    EditText mImage;
    @BindView(R.id.currentLocation)
    EditText mCurrentLocation;
    @BindView(R.id.insert)
    Button mInsert;
    @BindView(R.id.zengjia)
    TextView mZenjia;
    @BindView(R.id.fanhuizhuye)
    Button mFanhuizhuye;

    @OnClick({
            R.id.insert
    })
    public void clickAdd(View view) {
        switch (view.getId()) {
            case R.id.insert:
                String foodname = mFoodName.getText().toString().trim();
                String detail = mDetail.getText().toString().trim();
                String image = mImage.getText().toString().trim();
                String location = mCurrentLocation.getText().toString().trim();
                if (!TextUtils.isEmpty(foodname) && !TextUtils.isEmpty(image) && !TextUtils.isEmpty(detail)) {
                    mDBOpenHelper.add("food", foodname, detail, image, location);
                    //添加判断
                    Toast.makeText(this, "添加成功!", Toast.LENGTH_SHORT).show();
                    mFoodName.setText("");
                    mDetail.setText("");
                    mImage.setText("");
                    mCurrentLocation.setText("");
                }
        }
    }
}

