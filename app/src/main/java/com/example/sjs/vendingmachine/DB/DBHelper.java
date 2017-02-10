package com.example.sjs.vendingmachine.DB;

/**
 * Created by SJS on 2017/2/8.
 */


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DBHelper extends SQLiteOpenHelper {
    //数据库版本号
    private static final int DATABASE_VERSION=1;

    //数据库名称
    private static final String DATABASE_NAME="DB_bjsyjxyjs.db";

    public DBHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建数据表
        String CREATE_TABLE_EVENT="CREATE TABLE "+ Goods.TABLE+"("
                +Goods.GoodsId+" INTEGER PRIMARY KEY AUTOINCREMENT ,"
                +Goods.GoodsNum+" TEXT, "
                +Goods.GoodsName+" TEXT, "
                +Goods.GoodsPrice+" TEXT, "
                +Goods.GooodsInfo+" TEXT, "
                +Goods.GoodsImage+" TEXT, "

                +Goods.GoodsType+" TEXT, "
                +Goods.GoodsStatus+" TEXT, "
                +Goods.GoodsNumber+" TEXT, "
                +Goods.GoodsCost+" TEXT, "
                +Goods.GoodsTemperature+" TEXT, "


                +Goods.GoodsLight+" TEXT, "
                +Goods.GoodsLife+ " TEXT)";
        db.execSQL(CREATE_TABLE_EVENT);

        Log.i("DBHelper","EVENT表创建");


    }
    //数据更新时重新考虑
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //如果旧表存在，删除，所以数据将会消失
//        db.execSQL("DROP TABLE IF EXISTS "+ Event.TABLE);
//        db.execSQL("DROP TABLE IF EXISTS "+ User.TABLE);

        //再次创建表
        onCreate(db);
    }
}