package com.shop.com.quanshoppingmall.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

import com.joanzapata.android.BaseAdapterHelper;
import com.joanzapata.android.QuickAdapter;
import com.shop.com.quanshoppingmall.R;
import com.shop.com.quanshoppingmall.models.Business;
import com.shop.com.quanshoppingmall.models.Chart;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 商家详情页
 **/
public class BusinessActivity extends AppCompatActivity {

    @BindView(R.id.grid_business_goods)
    GridView gridGoods;
    private QuickAdapter<Business> businessQuickAdapter;
    private List<Business> businessList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business);
        ButterKnife.bind(this);
        initData();
        businessQuickAdapter = new QuickAdapter<Business>(this, R.layout.activity_business_grid_item, businessList) {
            @Override
            protected void convert(BaseAdapterHelper helper, Business item) {
                helper.setImageBitmap(R.id.img_goods_logo, item.getBus_bitmap())
                        .setText(R.id.txt_goods_name, item.getBus_name())
                        .setText(R.id.txt_goods_money, item.getBus_ems_money());
            }
        };
        gridGoods.setAdapter(businessQuickAdapter);
    }

    // 初始化数据
    private void initData() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.home_img);
        String contents[] = {"干锅千叶豆腐等2件商品", "超级大鸡排等2件商品", "蓝山等1件商品",
                "土豆烧鸡等1件商品", "鸭舌虾滑等2件商品", "天鹅蛋等1件商品"};
        String moneys[] = {"￥73", "￥10", "￥68", "￥32", "￥78", "￥60"};
        for (int i = 0; i < contents.length; i++) {
            Business bus = new Business();
            bus.setBus_name(contents[i]);
            bus.setBus_bitmap(bitmap);
            bus.setBus_ems_money(moneys[i]);
            businessList.add(bus);
        }
    }
}
