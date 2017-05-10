package com.shop.com.quanshoppingmall.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.joanzapata.android.BaseAdapterHelper;
import com.joanzapata.android.QuickAdapter;
import com.shop.com.quanshoppingmall.R;
import com.shop.com.quanshoppingmall.activity.BusinessActivity;
import com.shop.com.quanshoppingmall.db.BusinessTools;
import com.shop.com.quanshoppingmall.db.DBHelper;
import com.shop.com.quanshoppingmall.db.SQLTools;
import com.shop.com.quanshoppingmall.models.Business;
import com.shop.com.quanshoppingmall.view.NavBarView;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTouch;

/**
 * 主页
 */
public class HomeFragment extends Fragment {

    // 最小距离
    private final static int MIN_MOVE = 200;
    private int[] mipmapId = {
            R.mipmap.home_flipper_one,
            R.mipmap.home_flipper_two,
            R.mipmap.home_flipper_three,
            R.mipmap.home_flipper_four};
    @BindView(R.id.nav_bar)
    NavBarView navBarView;
    @BindView(R.id.view_flipper)
    ViewFlipper viewFlipper;
    @BindView(R.id.grid_business)
    GridView gridBusiness;

    private Context context;
    private GestureListener listener;
    private GestureDetector detector;
    private QuickAdapter<Business> businessAdapter;
    private BusinessTools businessTools;
    private DBHelper dbHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        context = getContext();
        dbHelper = new DBHelper(context, "mall.db", null, 1);
        businessTools = new BusinessTools(dbHelper, context);
        listener = new GestureListener();
        detector = new GestureDetector(context, listener);
        initNavBar();
        initFlipper();
        businessAdapter = new QuickAdapter<Business>(getContext(),
                R.layout.fragment_home_grid_item, businessTools.
                queryByIsCollected(SQLTools.Business.BUSINESS_TYPE_YES)) {
            @Override
            protected void convert(BaseAdapterHelper helper, Business item) {
                helper.setImageBitmap(R.id.img_business, item.getBus_bitmap());
                helper.setText(R.id.txt_business, item.getBus_name());
            }
        };
        gridBusiness.setAdapter(businessAdapter);
        gridBusiness.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getActivity(), BusinessActivity.class));
            }
        });
        return view;
    }

    // 初始化导航栏
    private void initNavBar() {
        navBarView.hideTitleImg(View.VISIBLE);
        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.mipmap.nav_bar_home_top_icon);
        navBarView.setTitleImg(bitmap1);
        navBarView.hideRightImg(View.VISIBLE);
        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.mipmap.nav_bar_home_top_search);
        navBarView.setRightImg(bitmap2);
    }


    // 初始化ViewFlipper的数据
    private void initFlipper() {
        for (int i = 0; i < mipmapId.length; i++) {
            viewFlipper.addView(getImgView(mipmapId[i]));
        }
        viewFlipper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        viewFlipper.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return detector.onTouchEvent(event);
            }
        });
    }

    private ImageView getImgView(int id) {
        ImageView img = new ImageView(context);
        img.setBackgroundResource(id);
        return img;
    }

    // 自定义GestureListener
    private class GestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (e1.getX() - e2.getX() < MIN_MOVE) {
                viewFlipper.setInAnimation(context, R.anim.view_flipper_right_in);
                viewFlipper.setOutAnimation(context, R.anim.view_flipper_right_out);
                viewFlipper.showNext();
            } else {
                viewFlipper.setInAnimation(context, R.anim.view_flipper_left_in);
                viewFlipper.setOutAnimation(context, R.anim.view_flipper_left_out);
                viewFlipper.showPrevious();
            }
            return true;
        }
    }

}
