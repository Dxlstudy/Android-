package com.example.justloginregistertest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by littlecurl 2018/6/24
 */
public class MainActivity extends AppCompatActivity {

    private DBOpenHelper dbOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbOpenHelper = new DBOpenHelper(MainActivity.this, Constants.DB_NAME);

//        final EditText etSearch=(EditText)findViewById(R.id.seachtext);
//        ImageButton btnSearch=(ImageButton)findViewById(R.id.search);
//        btnSearch.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                 String key=etSearch.getText().toString();
//                Cursor cursor=dbOpenHelper.getReadableDatabase().query("food" ,null,"foodname=?",new  String[]{key},null,null,null);
//
//            }
//        });
        /**
         * 一定 一定 一定记得加这句，而且是固定位置，在setContentView()之下
         * 否则无论写的什么逻辑  都不会在Activity中起作用
         */
        ButterKnife.bind(this);
        int[] imageid = new int[]{R.drawable.lvdagun, R.drawable.ic_launcher_background};
        String[] title = new String[]{"123", "223"};
        String[] weizhi = new String[]{"1234", "2234"};
        String[] jiage = new String[]{"$123", "$123"};
        List<Map<String, Object>> listitem = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < imageid.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", imageid[i]);
            map.put("title", title[i]);
            map.put("location", weizhi[i]);
            map.put("jiage", jiage[i]);
            listitem.add(map);
        }
        SimpleAdapter adpter = new SimpleAdapter(this, listitem, R.layout.tupianmingcheng,
                new String[]{"title", "image", "location", "jiage"},
                new int[]{R.id.title, R.id.image, R.id.weizhi, R.id.jiage});
        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(adpter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Map<String, Object> map = (Map<String, Object>) parent.getItemAtPosition(position);
                Intent intent = new Intent(MainActivity.this, DetilActivity.class);
                startActivity(intent);

            }
        });
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
