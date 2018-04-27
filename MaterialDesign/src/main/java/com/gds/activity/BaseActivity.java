package com.gds.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/4/25.
 */

public abstract class BaseActivity extends AppCompatActivity{


    public Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context=this;
    }



    /**
     * 跳转界面
     */
    public void changeActivity(Class<?> clz)
    {
        Intent intent = new Intent(this, clz);
        startActivity(intent);

    }


}
