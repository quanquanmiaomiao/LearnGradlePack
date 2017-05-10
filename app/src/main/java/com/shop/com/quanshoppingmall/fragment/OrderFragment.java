package com.shop.com.quanshoppingmall.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.joanzapata.android.BaseAdapterHelper;
import com.joanzapata.android.QuickAdapter;
import com.shop.com.quanshoppingmall.R;
import com.shop.com.quanshoppingmall.models.Order;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**订单*/
public class OrderFragment extends Fragment {

    @BindView(R.id.list_order)
    ListView listOrder;
    private QuickAdapter<Order> adapter;
    private List<Order> oreders = new ArrayList<>();


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order, container, false);
        ButterKnife.bind(this, view);
        initData();
        adapter = new QuickAdapter<Order>(getContext(), R.layout.fragment_order_list_item, oreders) {
            @Override
            protected void convert(BaseAdapterHelper helper, Order item) {
                helper.setText(R.id.txt_shop_name, item.getOrderShopName())
                        .setText(R.id.txt_content, item.getOrderShopContent())
                        .setText(R.id.txt_date, item.getOrderShopDate())
                        .setText(R.id.txt_money, item.getOrderMoney())
                        .setImageBitmap(R.id.img_shop_logo, item.getOrderShopLogo());
            }
        };
        listOrder.setAdapter(adapter);
        return view;
    }
    // 初始化数据
    private void initData() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.order_shop_icon);
        String names[] = {"四川菜馆", "聚星楼", "蓝山咖啡", "大鸭梨", "海底捞", "初页"};
        String contents[] = {"干锅千叶豆腐等2件商品", "超级大鸡排等2件商品", "蓝山等1件商品",
                "土豆烧鸡等1件商品", "鸭舌虾滑等2件商品", "天鹅蛋等1件商品"};
        String dates[] = {"2016-05-09 12:34", "2016-06-018 13:04", "2016-06-29 14:25", "2016-07-01 13:15",
                "2016-07-11 11:34", "2016-08-19 12:00"};
        String moneies[] = {"￥73", "￥10", "￥68", "￥32", "￥78", "￥60"};
        for (int i = 0; i < names.length; i++) {
            Order order = new Order();
            order.setOrderShopName(names[i]);
            order.setOrderShopContent(contents[i]);
            order.setOrderShopDate(dates[i]);
            order.setOrderShopLogo(bitmap);
            order.setOrderMoney(moneies[i]);
            oreders.add(order);
        }
    }
}
