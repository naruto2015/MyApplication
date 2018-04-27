package com.gds.activity.appbarlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.gsm.SmsMessage;

import com.gds.activity.BaseActivity;
import com.gds.activity.R;

import butterknife.ButterKnife;

public class AppbarLayoutActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appbar_layout);
        ButterKnife.bind(this);


    }
}
