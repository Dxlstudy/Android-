package com.example.justloginregistertest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import butterknife.BindView;

//1.是否从数据库获取了数据
//2.将这个页面在MainActivity上显示
//3.循环显示这个界面
public class viewActivity extends AppCompatActivity {

    private DBOpenHelper mDBOpenHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tupianmingcheng);
        mDBOpenHelper = new DBOpenHelper(this, Constants.DB_NAME);
    }

    @BindView(R.id.title)
    EditText mTitle;
    @BindView(R.id.image)
    EditText mImag;
    @BindView(R.id.weizhi)
    EditText mWeizhi;

    public void showfood() {
        mTitle.getText();
        mImag.getText();
        mWeizhi.getText();
    }
}
