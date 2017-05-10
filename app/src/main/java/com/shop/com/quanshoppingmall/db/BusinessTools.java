package com.shop.com.quanshoppingmall.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.shop.com.quanshoppingmall.R;
import com.shop.com.quanshoppingmall.models.Business;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caowenjuan on 16/10/28.
 * 商家表的辅助类
 */
public class BusinessTools {

    private SQLiteDatabase database;
    private Context context;
    private DBHelper helper;

    public BusinessTools(DBHelper helper, Context context) {
        this.helper = helper;
        this.context = context;
    }

    // 查询推荐的商家
    public List<Business> queryByIsCollected(int type) {
        List<Business> businesses = new ArrayList<>();
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.home_img);
        database = helper.getReadableDatabase();
        Cursor cursor = database.rawQuery("select * from business where business_type = ?",
                new String[]{String.valueOf(type)});
        while (cursor.moveToNext()) {
            Business bus = new Business();
            bus.setBus_bitmap(bitmap);
            bus.setBus_id(getItemId(cursor));
            bus.setBus_name(getItemName(cursor));
            bus.setBus_address(getItemAddress(cursor));
            bus.setBus_type(getItemType(cursor));
            bus.setBus_fans_num(getItemFansNum(cursor));
            bus.setBus_ems_money(getItemEmsMoney(cursor));
            businesses.add(bus);
        }
        cursor.close();
        database.close();
        return businesses;
    }

    // 数据分页
    public List<Business> getScrollBusiness(int offset, int maxResult) {
        List<Business> businesses = new ArrayList<>();
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.home_img);
        database = helper.getReadableDatabase();
        Cursor cursor = database.rawQuery("select * from business order by _id asc limit=?,?",
                new String[]{String.valueOf(offset),String.valueOf(maxResult)});
        while (cursor.moveToNext()){
            Business bus = new Business();
            bus.setBus_bitmap(bitmap);
            bus.setBus_id(getItemId(cursor));
            bus.setBus_name(getItemName(cursor));
            bus.setBus_address(getItemAddress(cursor));
            bus.setBus_type(getItemType(cursor));
            bus.setBus_fans_num(getItemFansNum(cursor));
            bus.setBus_ems_money(getItemEmsMoney(cursor));
            businesses.add(bus);
        }
        cursor.close();
        database.close();
        return businesses;
    }

    // 解析Cursor
    private int getItemId(Cursor cursor) {
        return cursor.getInt(cursor.getColumnIndex(SQLTools.Business.BUSINESS_ID));
    }

    private String getItemName(Cursor cursor) {
        return cursor.getString(cursor.getColumnIndex(SQLTools.Business.BUSINESS_NAME));
    }

    private String getItemAddress(Cursor cursor) {
        return cursor.getString(cursor.getColumnIndex(SQLTools.Business.BUSINESS_ADDRESS));
    }

    private int getItemType(Cursor cursor) {
        return cursor.getInt(cursor.getColumnIndex(SQLTools.Business.BUSINESS_TYPE));
    }

    private int getItemFansNum(Cursor cursor) {
        return cursor.getInt(cursor.getColumnIndex(SQLTools.Business.BUSINESS_FANS_NUM));
    }

    private String getItemEmsMoney(Cursor cursor) {
        return cursor.getString(cursor.getColumnIndex(SQLTools.Business.BUSINESS_EMS_MONEY));
    }
}



