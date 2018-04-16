package com.gds.test;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.annotation.Nullable;

import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Administrator on 2018/3/20.
 */

public class ChartView extends View {


    private Paint paint,rectPaint,bgPaint,hPaint;

    private int width,height;

    private int histogramwidth;

    private int count=10;

    private int averag;

    private String y1="10";

    private Rect rect,bgRect;

    private RectF hRect;

    private int[] histogramHeights;

    public ChartView(Context context) {
        this(context,null);
    }

    public ChartView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        paint=new Paint();
        paint.setAntiAlias(true);
        paint.setColor(getResources().getColor(R.color.black));
        paint.setStrokeWidth(1);

        rectPaint=new Paint();
        rectPaint.setAntiAlias(true);
        rectPaint.setColor(getResources().getColor(R.color.white));
        rectPaint.setStrokeWidth(1);

        bgPaint=new Paint();
        bgPaint.setAntiAlias(true);
        bgPaint.setColor(getResources().getColor(R.color.dark));
        bgPaint.setStrokeWidth(1);
        bgPaint.setStyle(Paint.Style.FILL);

        hPaint=new Paint();
        hPaint.setAntiAlias(true);
        hPaint.setColor(getResources().getColor(R.color.colorPrimary));
        hPaint.setStrokeWidth(1);
        hPaint.setStyle(Paint.Style.FILL);



    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width=w;
        height=h;
        histogramwidth=width/(2*count+1);
        averag=(height-1)/5;

        histogramHeights=new int[]{120,110,130,120,120,140,110,20,40,20,20};


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int bottom=height-1;
//        paint.setStyle(Paint.Style.FILL);
//        paint.setTextSize(22);
//        rect=new Rect();
//
//        paint.getTextBounds(y1,0,y1.length(),rect);

        //canvas.drawText();


        int x=histogramwidth-5;

        paint.setTextSize(30);
        paint.setTextAlign(Paint.Align.RIGHT);


        for(int j=1;j<5;j+=1){
            int y=bottom-averag*j;
            y1=String.valueOf(10*j);
            canvas.drawText(y1,x,y,paint);
        }



        rect=new Rect();

        for(int i=0;i<count;i+=1){

            bgRect=new Rect((i*2+1)*histogramwidth,0,(i*2+2)*histogramwidth,bottom+averag/2);
            canvas.drawRect(bgRect,bgPaint);


            LinearGradient backGradient = new LinearGradient((i*2+1)*histogramwidth,histogramHeights[i],(i*2+2)*histogramwidth,bottom+averag/2, new int[]{getResources().getColor(R.color.colorPrimary), getResources().getColor(R.color.white)}, null, Shader.TileMode.CLAMP);
            hPaint.setShader(backGradient);
            hRect=new RectF((i*2+1)*histogramwidth,histogramHeights[i],(i*2+2)*histogramwidth,bottom+averag/2);
            canvas.drawRoundRect(hRect,averag/2,averag/2,hPaint);
        }


        canvas.drawLine(0,height-1,width,bottom,paint);


        /*
        hRect=new Rect(histogramwidth,height-histogramHeights[0],2*histogramwidth,height-2);
        canvas.drawRect(hRect,hPaint);
        */




    }



    public void setData(int data){

        for(int i=0;i<histogramHeights.length-1;i++){

            histogramHeights[i]=histogramHeights[i+1];

        }
        histogramHeights[10]=data;
        invalidate();


    }




}
