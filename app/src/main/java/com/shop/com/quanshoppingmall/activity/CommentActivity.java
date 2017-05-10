package com.shop.com.quanshoppingmall.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.shop.com.quanshoppingmall.R;

import butterknife.BindView;

public class CommentActivity extends AppCompatActivity {


    @BindView(R.id.list_comment)
    ListView listComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
    }
}
