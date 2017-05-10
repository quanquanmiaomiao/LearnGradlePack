package com.shop.com.quanshoppingmall.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.joanzapata.android.BaseAdapterHelper;
import com.joanzapata.android.QuickAdapter;
import com.shop.com.quanshoppingmall.R;
import com.shop.com.quanshoppingmall.activity.GoodsInfoActivity;
import com.shop.com.quanshoppingmall.models.Chart;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;

/**
 * 购物车
 */
public class ChartFragment extends Fragment {


    @BindView(R.id.list_charts)
    ListView listChart;
    @BindView(R.id.txt_money_all)
    TextView txtMoneyAll;
    @BindView(R.id.txt_pay)
    TextView txtPay;
    @BindView(R.id.checkout_selected_all)
    CheckBox checkSelected;
    private int total = 0;
    private QuickAdapter<Chart> chartQuickAdapter;
    private List<Chart> listCharts = new ArrayList<>();

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chart, container, false);
        ButterKnife.bind(this, view);
        initCharts();
        initAdapter();
        listChart.setAdapter(chartQuickAdapter);
        listChart.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getActivity(), GoodsInfoActivity.class));
            }
        });
        return view;
    }


    @OnCheckedChanged(R.id.checkout_selected_all)
    void selectedAll() {
        total = 0;
        if (checkSelected.isChecked()) {
            for (Chart chart : listCharts) {
                total += chart.getChartGoodsMoney();
                chart.setSelected(true);
            }
        } else {
            for (Chart chart : listCharts) {
                total = 0;
                chart.setSelected(false);
            }
        }
        chartQuickAdapter.notifyDataSetChanged();
        txtMoneyAll.setText("合计:" + total);
    }

    // 适配器配置
    private void initAdapter() {
        chartQuickAdapter = new QuickAdapter<Chart>(getContext(), R.layout.fragment_chart_list_item, listCharts) {
            @Override
            protected void convert(final BaseAdapterHelper helper, final Chart item) {
                helper.setText(R.id.txt_chart_shop_name, item.getChartShopName())
                        .setText(R.id.txt_chart_goods_name, item.getChartGoodsName())
                        .setText(R.id.txt_chart_info, item.getChartGoodsInfo())
                        .setText(R.id.txt_chart_money, "￥" + item.getChartGoodsMoney())
                        .setChecked(R.id.check_selected, item.isSelected())
                        // 多选
                        .setOnClickListener(R.id.check_selected, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (item.isSelected()) {
                                    item.setSelected(false);
                                    total -= item.getChartGoodsMoney();
                                } else {
                                    item.setSelected(true);
                                    total += item.getChartGoodsMoney();
                                }
                                txtMoneyAll.setText("合计:" + total);
                            }
                        });
            }
        };
    }


    // 初始化数据
    private void initCharts() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.order_shop_icon);
        String names[] = {"四川菜馆", "聚星楼", "蓝山咖啡", "大鸭梨", "海底捞", "初页"};
        String contents[] = {"干锅千叶豆腐等2件商品", "超级大鸡排等2件商品", "蓝山等1件商品",
                "土豆烧鸡等1件商品", "鸭舌虾滑等2件商品", "天鹅蛋等1件商品"};
        String info[] = {"颜色:灰、尺码:S", "颜色:灰、尺码:S", "颜色:灰、尺码:S",
                "颜色:灰、尺码:S", "颜色:灰、尺码:S", "颜色:灰、尺码:S"};
        int moneys[] = {73, 10, 68, 32, 78, 60};
        for (int i = 0; i < names.length; i++) {
            Chart chart = new Chart();
            chart.setChartGoodsLogo(bitmap);
            chart.setChartGoodsInfo(info[i]);
            chart.setChartShopName(names[i]);
            chart.setChartGoodsName(contents[i]);
            chart.setChartGoodsMoney(moneys[i]);
            chart.setSelected(false);
            listCharts.add(chart);
        }
    }
}
