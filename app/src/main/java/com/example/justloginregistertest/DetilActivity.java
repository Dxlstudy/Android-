package com.example.justloginregistertest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class DetilActivity extends AppCompatActivity {
    private DBOpenHelper dbOpenHelper;

     @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shipinxiangqing);
        dbOpenHelper=new DBOpenHelper(DetilActivity.this,Constants.DB_NAME);

    }

    public void myClickBK(View view) {
        Intent intent = new Intent(DetilActivity.this, MainActivity.class);
        startActivity(intent);
    }


}
