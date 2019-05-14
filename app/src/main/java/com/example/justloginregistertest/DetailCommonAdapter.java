package com.example.justloginregistertest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.IllegalFormatCodePointException;
import java.util.List;

public class DetailCommonAdapter extends BaseAdapter {

    Context mContext;
    List<CommonBean> beans;

    public DetailCommonAdapter(Context context, List<CommonBean> commonBeans) {
        mContext = context;
        beans = commonBeans;
    }


    @Override
    public int getCount() {
        return beans.size();
    }

    @Override
    public Object getItem(int position) {
        return beans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CommonBean commonBean = beans.get(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_detail_common_layou, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.commonTv = convertView.findViewById(R.id.common_tv);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.commonTv.setText(commonBean.getCommon());
        return convertView;
    }


    class ViewHolder {
        TextView commonTv;
    }
}
