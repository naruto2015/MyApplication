package com.gds.activity;

import android.os.Bundle;

import com.gds.activity.appbarlayout.AppBarTablayoutActivity;
import com.gds.activity.appbarlayout.AppbarLayoutActivity;
import com.gds.activity.appbarlayout.CollapsingToolbarActivity;


import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.AppbarLayoutActivity)
    void AppbarLayoutActivity(){

        changeActivity(AppbarLayoutActivity.class);

    }


    @OnClick(R.id.AppBarTablayoutActivity)
    void AppBarTablayoutActivity(){

        changeActivity(AppBarTablayoutActivity.class);

    }


    @OnClick(R.id.CollapsingToolbarActivity)
    void CollapsingToolbarActivity(){

        changeActivity(CollapsingToolbarActivity.class);

    }











}
