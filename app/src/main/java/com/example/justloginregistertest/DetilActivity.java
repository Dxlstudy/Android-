package com.example.justloginregistertest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.squareup.picasso.Picasso;

public class DetilActivity extends AppCompatActivity {

    @BindView(R.id.image2)
    ImageView iV;
    @BindView(R.id.biaoti)
    TextView titleTv;
    @BindView(R.id.jieshao)
    TextView infoTv;
    @BindView(R.id.neirong)
    TextView contentTv;

    private DBOpenHelper dbOpenHelper;

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
            infoTv.setText(food.getDetail());
        }
    }

    public void myClickBK(View view) {
        finish();
    }
        public void myClickDZ(View view){
            Toast.makeText(DetilActivity.this,"点赞+1",Toast.LENGTH_SHORT).show();
        }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
