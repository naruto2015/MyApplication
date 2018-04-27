package com.gds.test.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;

import com.gds.test.ChartView;
import com.gds.test.R;

public class ChartViewActivity extends AppCompatActivity {

    private ChartView chartView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart_view);
        chartView=findViewById(R.id.chartView);



        getIMSI(this);

    }


    /**
     * 获取手机IMSI号
     */
    public static String getIMSI(Context context){
        TelephonyManager mTelephonyMgr = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String imsi = mTelephonyMgr.getSubscriberId();

        return imsi ;
    }

    public void play(View view) {

       //handler.sendEmptyMessageDelayed(0,1000);
        startActivity(new Intent(this,MainActivity.class));
    }


    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int ii= (int) (Math.random()*500);
            Log.e("-------",ii+"-----");
            chartView.setData(ii);
            handler.sendEmptyMessageDelayed(0,1500);
        }
    };


}
