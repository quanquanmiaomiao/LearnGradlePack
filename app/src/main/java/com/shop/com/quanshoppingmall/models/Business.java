package com.shop.com.quanshoppingmall.models;

import android.graphics.Bitmap;

/**
 * Created by caowenjuan on 16/10/25.
 * 商家数据模型
 */


public class Business {
    private int bus_id;
    private String bus_name;
    private String bus_address;
    private int bus_type;
    private int bus_fans_num;
    private String bus_ems_money;
    private Bitmap bus_bitmap;

    public int getBus_id() {
        return bus_id;
    }

    public String getBus_name() {
        return bus_name;
    }

    public String getBus_address() {
        return bus_address;
    }

    public int getBus_type() {
        return bus_type;
    }

    public int getBus_fans_num() {
        return bus_fans_num;
    }

    public String getBus_ems_money() {
        return bus_ems_money;
    }

    public Bitmap getBus_bitmap() {
        return bus_bitmap;
    }

    public void setBus_id(int bus_id) {
        this.bus_id = bus_id;
    }

    public void setBus_name(String bus_name) {
        this.bus_name = bus_name;
    }

    public void setBus_address(String bus_address) {
        this.bus_address = bus_address;
    }

    public void setBus_type(int bus_type) {
        this.bus_type = bus_type;
    }

    public void setBus_fans_num(int bus_fans_num) {
        this.bus_fans_num = bus_fans_num;
    }

    public void setBus_ems_money(String bus_ems_money) {
        this.bus_ems_money = bus_ems_money;
    }

    public void setBus_bitmap(Bitmap bus_bitmap) {
        this.bus_bitmap = bus_bitmap;
    }
}
