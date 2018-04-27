package com.gds.activity.appbarlayout;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.gds.activity.BaseActivity;
import com.gds.activity.R;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;


public class AppBarTablayoutActivity extends BaseActivity {


    //@BindView(R.id.recycleView)
    RecyclerView recyclerView;

    TabLayout tabs;

    private List<String> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_bar_tablayout);
        ButterKnife.bind(this);
        recyclerView=findViewById(R.id.recycleView);
        tabs=findViewById(R.id.tabs);
        for(int i=0;i<3;i++){
            tabs.addTab(tabs.newTab().setText("i"+i));
        }

        for(int i=0;i<30;i++){
            list.add("i"+i);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new CommonAdapter(this,R.layout.item,list) {
            @Override
            protected void convert(ViewHolder holder, Object o, int position) {

            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            }
        });


    }





}
