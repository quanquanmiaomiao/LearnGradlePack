package com.shop.com.quanshoppingmall.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.shop.com.quanshoppingmall.R;
import com.shop.com.quanshoppingmall.fragment.CenterFragment;
import com.shop.com.quanshoppingmall.fragment.ChartFragment;
import com.shop.com.quanshoppingmall.fragment.HomeFragment;
import com.shop.com.quanshoppingmall.fragment.OrderFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**主界面 FRAGMENT*/

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.home)
    TextView txtHome;
    @BindView(R.id.order)
    TextView txtOrder;
    @BindView(R.id.chart)
    TextView txtChart;
    @BindView(R.id.center)
    TextView txtCenter;

    private HomeFragment homeFragment;
    private OrderFragment orderFragment;
    private ChartFragment chartFragment;
    private CenterFragment centerFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        fragmentManager = getSupportFragmentManager();
        txtHome.performClick();
    }

    // 重置所有文本选中的状态
    private void resetState() {
        txtHome.setSelected(false);
        txtOrder.setSelected(false);
        txtChart.setSelected(false);
        txtCenter.setSelected(false);
    }

    // 隐藏所有Fragment
    private void hideFragment(FragmentTransaction transaction) {
        if (homeFragment != null)
            transaction.hide(homeFragment);
        if (orderFragment != null)
            transaction.hide(orderFragment);
        if (chartFragment != null)
            transaction.hide(chartFragment);
        if (centerFragment != null)
            transaction.hide(centerFragment);
    }

    @OnClick(R.id.home)
    void homeClick() {
        resetState();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragment(transaction);
        txtHome.setSelected(true);
        if (homeFragment == null) {
            homeFragment = new HomeFragment();
            transaction.add(R.id.fragment, homeFragment);
        } else {
            transaction.show(homeFragment);
        }
        transaction.commit();
    }

    @OnClick(R.id.order)
    void orderClick() {
        resetState();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragment(transaction);
        txtOrder.setSelected(true);
        if (orderFragment == null) {
            orderFragment = new OrderFragment();
            transaction.add(R.id.fragment, orderFragment);
        } else {
            transaction.show(orderFragment);
        }
        transaction.commit();
    }

    @OnClick(R.id.chart)
    void chartClick() {
        resetState();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragment(transaction);
        txtChart.setSelected(true);
        if (chartFragment == null) {
            chartFragment = new ChartFragment();
            transaction.add(R.id.fragment, chartFragment);
        } else {
            transaction.show(chartFragment);
        }
        transaction.commit();
    }

    @OnClick(R.id.center)
    void centerClick() {
        resetState();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragment(transaction);
        txtCenter.setSelected(true);
        if (centerFragment == null) {
            centerFragment = new CenterFragment();
            transaction.add(R.id.fragment, centerFragment);
        } else {
            transaction.show(centerFragment);
        }
        transaction.commit();
    }
}
