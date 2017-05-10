package com.shop.com.quanshoppingmall.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by caowenjuan on 16/10/28.
 * 数据库的创建
 */
public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLTools.Business.CREATE_BUSINESS_TABLE);
        for (int i = 0; i < SQLTools.Business.BUSINESS_INSERT.length; i++) {
            db.execSQL(SQLTools.Business.BUSINESS_INSERT[i]);
        }
        //db.execSQL(SQLTools.Goods.CREATE_TABLE_GOODS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
