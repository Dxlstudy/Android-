package com.example.justloginregistertest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.List;


public class FoodAdpater extends BaseAdapter {

    private List<Food> foods;
    private Context mConstext;

    public FoodAdpater(Context context, List<Food> foods) {
        this.foods = foods;
        mConstext = context;
    }

    @Override
    public int getCount() {
        return foods.size();
    }

    @Override
    public Food getItem(int position) {
        return foods.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mConstext).inflate(R.layout.tupianmingcheng, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.imageView = convertView.findViewById(R.id.image);
            viewHolder.titleTv = convertView.findViewById(R.id.title);
            viewHolder.priceTv = convertView.findViewById(R.id.jiage);
            viewHolder.locationTv = convertView.findViewById(R.id.weizhi);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Food food = foods.get(position);
        viewHolder.locationTv.setText(food.getLocation());
        viewHolder.priceTv.setText(food.getDetail());
        viewHolder.titleTv.setText(food.getName());
        Picasso.get().load(food.getImage())
                .placeholder(R.drawable.ic_launcher_background)
                .into(viewHolder.imageView);
        return convertView;
    }

    class ViewHolder {
        ImageView imageView;
        TextView titleTv;
        TextView priceTv;
        TextView locationTv;
    }
}
