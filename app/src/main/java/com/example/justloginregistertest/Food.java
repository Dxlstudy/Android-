package com.example.justloginregistertest;

import android.os.Parcel;

/**
 * 用于保存食品信息
 */
public class Food implements android.os.Parcelable {
    private String foodname;            //食品名
    private String image;            //图片
    private String detail;            //详情
    private String location;            //定位

    public Food(String name, String image, String detail, String location) {
        this.foodname = name;
        this.image = image;
        this.detail = detail;
        this.location = location;
    }

    public String getName() {
        return foodname;
    }

    public void setName(String name) {
        this.foodname = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + foodname + '\'' +
                ",detail='" + detail + '\'' +
                ",image='" + image + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.foodname);
        dest.writeString(this.image);
        dest.writeString(this.detail);
        dest.writeString(this.location);
    }

    protected Food(Parcel in) {
        this.foodname = in.readString();
        this.image = in.readString();
        this.detail = in.readString();
        this.location = in.readString();
    }

    public static final Creator<Food> CREATOR = new Creator<Food>() {
        @Override
        public Food createFromParcel(Parcel source) {
            return new Food(source);
        }

        @Override
        public Food[] newArray(int size) {
            return new Food[size];
        }
    };
}

