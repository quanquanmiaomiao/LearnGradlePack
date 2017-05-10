package com.shop.com.quanshoppingmall.models;

import android.graphics.Bitmap;

/**
 * Created by caowenjuan on 16/10/26.
 * 订单数据模型
 */
public class Order {
    private String orderShopName;
    private Bitmap orderShopLogo;
    private String orderShopContent;
    private String orderShopDate;
    private String orderMoney;

    public String getOrderShopName() {
        return orderShopName;
    }

    public Bitmap getOrderShopLogo() {
        return orderShopLogo;
    }

    public String getOrderShopContent() {
        return orderShopContent;
    }

    public String getOrderShopDate() {
        return orderShopDate;
    }

    public String getOrderMoney() {
        return orderMoney;
    }

    public void setOrderShopName(String orderShopName) {
        this.orderShopName = orderShopName;
    }

    public void setOrderShopLogo(Bitmap orderShopLogo) {
        this.orderShopLogo = orderShopLogo;
    }

    public void setOrderShopContent(String orderShopContent) {
        this.orderShopContent = orderShopContent;
    }

    public void setOrderShopDate(String orderShopDate) {
        this.orderShopDate = orderShopDate;
    }

    public void setOrderMoney(String orderMoney) {
        this.orderMoney = orderMoney;
    }
}
