package com.shop.com.quanshoppingmall.view;

/**
 * Created by caozhiyu on 16/10/27.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;


import com.shop.com.quanshoppingmall.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by caozhiyu on 16/10/10.
 */
public class NavBarView extends FrameLayout {

    private Context context;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.img_title)
    ImageView imgTitle;
    @BindView(R.id.txt_left)
    TextView txtLeft;
    @BindView(R.id.txt_right)
    TextView txtRight;
    @BindView(R.id.img_left)
    ImageView imgLeft;
    @BindView(R.id.img_right)
    ImageView imgRight;


    public NavBarView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public NavBarView(Context context, AttributeSet set) {
        super(context, set);
        this.context = context;
        init();
    }

    public NavBarView(Context context, AttributeSet set, int defStyleAttr) {
        super(context, set, defStyleAttr);
        this.context = context;
        init();
    }

    private void init() {
        View view = LayoutInflater.from(context).inflate(R.layout.nav_bar, this);
        ButterKnife.bind(this, view);
    }

    public void setTitleTxt(String str) {
        txtTitle.setText(str);
    }

    public void setTitleImg(Bitmap bitmap) {
        imgTitle.setImageBitmap(bitmap);
    }

    public void setLeftTxt(String str) {
        txtLeft.setText(str);
    }

    public void setLeftImg(Bitmap bitmap) {
        imgLeft.setImageBitmap(bitmap);
    }

    public void setRightTxt(String str) {
        txtRight.setText(str);
    }

    public void setRightImg(Bitmap bitmap) {
        imgRight.setImageBitmap(bitmap);
    }

    public void hideTitleTxt(int type) {
        txtTitle.setVisibility(type);
    }

    public void hideTitleImg(int type) {
        imgTitle.setVisibility(type);
    }

    public void hideLeftText(int type) {
        txtLeft.setVisibility(type);
    }

    public void hideRightText(int type) {
        txtRight.setVisibility(type);
    }

    public void hideLeftImg(int type) {
        imgLeft.setVisibility(type);
    }

    public void hideRightImg(int type) {
        imgRight.setVisibility(type);
    }

}
