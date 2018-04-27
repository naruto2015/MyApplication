package com.gds.activity.appbarlayout;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.gds.activity.BaseActivity;
import com.gds.activity.R;
import com.gds.utils.StatusBarUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CollapsingToolbarActivity extends BaseActivity {


    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsing_toolbar;

    @BindView(R.id.appbar)
    AppBarLayout appbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing_toolbar);

        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        StatusBarUtils.setTranslucentImageHeader(this,0,toolbar);

        //toolbar.setTitle("ToolBar");
        toolbar.setTitleTextColor(Color.TRANSPARENT);
        collapsing_toolbar.setTitle("");
        collapsing_toolbar.setCollapsedTitleTextColor(getResources().getColor(R.color.white));
        collapsing_toolbar.setExpandedTitleColor(getResources().getColor(R.color.white));
        collapsing_toolbar.setExpandedTitleColor(Color.TRANSPARENT);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        appbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                Log.e("zhouwei","appbarHeight:"+appBarLayout.getHeight()+" getTotalScrollRange:"+appBarLayout.getTotalScrollRange()+" offSet:"+verticalOffset);
                if(Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()){
                    toolbar.setTitleTextColor(getResources().getColor(R.color.white));
                    collapsing_toolbar.setTitle("AppbarLayout");
                }else{
                    collapsing_toolbar.setTitle("");
                }
            }
        });



    }


}
