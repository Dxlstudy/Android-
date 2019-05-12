package com.example.justloginregistertest;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by littlecurl 2018/6/24
 */

public class DBOpenHelper extends SQLiteOpenHelper {

    /**
     * 声明一个AndroidSDK自带的数据库变量db
     */
    private SQLiteDatabase db;

    /**
     * 写一个这个类的构造函数，参数为上下文context，所谓上下文就是这个类所在包的路径 指明上下文，数据库名，工厂默认空值，版本号默认从1开始 super(context,"db_test",null,1);
     * 把数据库设置成可写入状态，除非内存已满，那时候会自动设置为只读模式 不过，以现如今的内存容量，估计一辈子也见不到几次内存占满的状态 db = getReadableDatabase();
     */
    public String databaseName;

    public DBOpenHelper(Context context, String databaseName) {
        super(context, databaseName, null, 2);
        this.databaseName = databaseName;
        db = getReadableDatabase();
    }

    /**
     * 重写两个必须要重写的方法，因为class DBOpenHelper extends SQLiteOpenHelper 而这两个方法是 abstract 类 SQLiteOpenHelper 中声明的 abstract 方法
     * 所以必须在子类 DBOpenHelper 中重写 abstract 方法 想想也是，为啥规定这么死必须重写？ 因为，一个数据库表，首先是要被创建的，然后免不了是要进行增删改操作的
     * 所以就有onCreate()、onUpgrade()两个方法
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS user(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "password TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS admin(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS food(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "foodname TEXT," +
                "detail TEXT," +
                "location TEXT," +
                "image TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS user");
        db.execSQL("DROP TABLE IF EXISTS food");
        db.execSQL("DROP TABLE IF EXISTS admin");
        onCreate(db);
    }

    /**
     * 创建一个admin
     * @param name
     * @param pwd
     */
    public void createAdmin(String name, String pwd) {
        List<String> admins = new ArrayList<>();
        Cursor cursor = db.query("admin", null, "name =?", new String[]{name}, null, null, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String adminName = cursor.getString(cursor.getColumnIndex("name"));
                admins.add(adminName);
            }
        }
        if (admins.isEmpty()) {
            db.execSQL("INSERT INTO admin (name) VALUES(?)", new Object[]{name});
            db.execSQL("INSERT INTO user (name,password) VALUES(?,?)", new Object[]{name, pwd});
        }
    }

    /**
     * 判断是否是 admin
     * @param name
     * @return
     */
    public boolean isAdmin(String name) {
        boolean isAdmin;
        List<String> admins = new ArrayList<>();
        Cursor cursor = db.query("admin", null, "name =?", new String[]{name}, null, null, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String adminName = cursor.getString(cursor.getColumnIndex("name"));
                admins.add(adminName);
            }
        }
        if (admins.isEmpty()) {
            isAdmin = false;
        } else {
            isAdmin = true;
        }
        return isAdmin;
    }

    /**
     * 接下来写自定义的增删改查方法 这些方法，写在这里归写在这里，以后不一定都用 add() delete() update() getAllData()
     */
    public void add(String... args) {
        if (args[0] == "user") {
            db.execSQL("INSERT INTO user (name,password) VALUES(?,?)", new Object[]{args[1], args[2]});
        } else if (args[0] == "food") {
            db.execSQL("INSERT INTO food (foodname,detail,image,location) VALUES(?,?,?,?)",
                    new Object[]{args[1], args[2], args[3], args[4]});
        }
    }


    public void delete(String... args) {
        if (args[0] == "user") {
            db.execSQL("SElECT FROM user WHERE name = AND password =" + args[1] + args[2]);
        } else if (args[0] == "food") {
            db.execSQL("SElECT FROM food WHERE foodname =" + args[1]);
        }
    }

    public int deleteFood(Food food){
      return db.delete("food", "foodname=?", new String[]{food.getName()});

    }

    public void show(String... args) {
        if (args[0] == "user") {
            db.execSQL("SELECT user,passward From user" + args[1] + args[2]);
        } else if (args[0] == "food") {
            db.execSQL("SELECT foodname,image,location,detail FROM food " + args[1] + args[2] + args[3] + args[4]);
        }
    }

    public void updata(String... args) {
        if (args[0] == "user") {
            db.execSQL("UPDATE user SET password = ?", new Object[]{args[1]});
        }
    }

    /**
     * 前三个没啥说的，都是一套的看懂一个其他的都能懂了 下面重点说一下查询表user全部内容的方法 我们查询出来的内容，需要有个容器存放，以供使用， 所以定义了一个ArrayList类的list
     * 有了容器，接下来就该从表中查询数据了， 这里使用游标Cursor，这就是数据库的功底了， 在Android中我就不细说了，因为我数据库功底也不是很厚， 但我知道，如果需要用Cursor的话，第一个参数："表名"，中间5个：null，
     * 最后是查询出来内容的排序方式："name DESC" 游标定义好了，接下来写一个while循环，让游标从表头游到表尾 在游的过程中把游出来的数据存放到list容器中
     */
    public ArrayList<User> getAllData() {
        ArrayList<User> list = new ArrayList<User>();
        Cursor cursor = db.query("user", null, null, null, null, null, "name DESC");
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String password = cursor.getString(cursor.getColumnIndex("password"));
            list.add(new User(name, password));
        }
        return list;
    }

    public ArrayList<Food> searchFoodData(String keyword) {
        ArrayList<Food> list = new ArrayList<Food>();
        Cursor cursor;
        cursor = db.query("food", null, "foodname LIKE ?", new String[]{"%" + keyword + "%"}, null, null, "foodname");
        while (cursor.moveToNext()) {
            String foodname = cursor.getString(cursor.getColumnIndex("foodname"));
            String image = cursor.getString(cursor.getColumnIndex("image"));
            String detail = cursor.getString(cursor.getColumnIndex("detail"));
            String location = cursor.getString(cursor.getColumnIndex("location"));
            list.add(new Food(foodname, detail, image, location));
        }
        return list;
    }

    public ArrayList<Food> getAllFoodData() {
        ArrayList<Food> list = new ArrayList<Food>();
        Cursor cursor = db.query("food", null, null, null, null, null, "foodname");
        while (cursor.moveToNext()) {
            String foodname = cursor.getString(cursor.getColumnIndex("foodname"));
            String image = cursor.getString(cursor.getColumnIndex("image"));
            String detail = cursor.getString(cursor.getColumnIndex("detail"));
            String location = cursor.getString(cursor.getColumnIndex("location"));
            list.add(new Food(foodname, detail, image, location));
        }
        return list;
    }
}