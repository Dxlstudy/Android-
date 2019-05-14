package com.example.justloginregistertest;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.List;

public class DetilActivity extends AppCompatActivity {

    @BindView(R.id.image2)
    ImageView iV;
    @BindView(R.id.biaoti)
    TextView titleTv;
    @BindView(R.id.jieshao)
    TextView infoTv;
    @BindView(R.id.neirong)
    TextView contentTv;
    @BindView(R.id.detail_common_list)
    ListView detaiCommonlist;
    @BindView(R.id.common_et)
    EditText commonEt;
    @BindView(R.id.common_btn)
    Button commonBtn;
    @BindView(R.id.fanhui)
    Button backBtn;

    private DBOpenHelper dbOpenHelper;
    private List<CommonBean> beans = new ArrayList<>();
    private int id = -1;
    private DetailCommonAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shipinxiangqing);
        ButterKnife.bind(this);
        dbOpenHelper = new DBOpenHelper(DetilActivity.this, Constants.DB_NAME);
        Food food = getIntent().getParcelableExtra("food");
        if (food != null) {
            Picasso.get().load(food.getImage())
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(iV);
            titleTv.setText(food.getName());
            contentTv.setText(food.getDetail());
            id = food.getId();
        }
        commonEt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    backBtn.setVisibility(View.GONE);
                }else {
                    backBtn.setVisibility(View.VISIBLE);
                }
            }
        });
        queryCommons(id + "");
        mAdapter = new DetailCommonAdapter(this, beans);
        detaiCommonlist.setAdapter(mAdapter);
    }

    public void myClickBK(View view) {
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }


    private void queryCommons(String detailId) {
        List<CommonBean> commonBeans = dbOpenHelper.queryDetailCommons(detailId);
        if (commonBeans != null && !commonBeans.isEmpty()) {
            beans.clear();
            beans.addAll(commonBeans);
        }
    }

    private void sendCommon() {
        commonEt.clearFocus();
        hideKeyboard(commonEt);
        Editable text = commonEt.getText();
        if (text != null && text.length() > 0) {
            String common = text.toString();
            boolean isCommon = dbOpenHelper.addCommon(common, id + "");
            if (isCommon){
                queryCommons(id+"");
                mAdapter.notifyDataSetChanged();
                detaiCommonlist.setSelection(detaiCommonlist.getBottom());
            }else {
                Toast.makeText(this, "发表评论失败", Toast.LENGTH_SHORT).show();
            }
            commonEt.setText("");
        } else {
            Toast.makeText(this, "请输入评论", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick({R.id.common_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.common_btn:
                sendCommon();
                break;
            default:
                break;
        }
    }

    public void hideKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
