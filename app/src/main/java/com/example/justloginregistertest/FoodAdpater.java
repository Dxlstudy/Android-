package com.example.justloginregistertest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.List;


public class FoodAdpater extends BaseAdapter {

    private List<Food> foods;
    private Context mConstext;
    private boolean isAdmin;

    public FoodAdpater(Context context, List<Food> foods, boolean isAdmin) {
        this.foods = foods;
        mConstext = context;
        this.isAdmin = isAdmin;
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
            viewHolder.deleteTv = convertView.findViewById(R.id.delete);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (isAdmin) {
            viewHolder.deleteTv.setVisibility(View.VISIBLE);
        } else {
            viewHolder.deleteTv.setVisibility(View.GONE);
        }
        Food food = foods.get(position);
        viewHolder.locationTv.setText(food.getLocation());
        viewHolder.priceTv.setText(food.getDetail());
        viewHolder.titleTv.setText(food.getName());
        Picasso.get().load(food.getImage())
                .placeholder(R.drawable.ic_launcher_background)
                .into(viewHolder.imageView);
        viewHolder.deleteTv.setOnClickListener(obtainOnClickListener(food));
        return convertView;
    }

    public View.OnClickListener obtainOnClickListener(final Food food) {
        return new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.delete(food);
                }
            }
        };
    }

    class ViewHolder {

        ImageView imageView;
        TextView titleTv;
        TextView priceTv;
        TextView locationTv;
        TextView deleteTv;
    }

    private IfoodDeleteListener listener;

    public void setOnFoodDeleteListener(IfoodDeleteListener listener) {
        this.listener = listener;
    }

    public interface IfoodDeleteListener {

        void delete(Food food);
    }
}
