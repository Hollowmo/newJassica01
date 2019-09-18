package com.jassica.jassica.base;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatDelegate;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import com.jassica.jassica.utils.SpUtil;
import com.jassica.jassica.utils.UIModeUtil;

public class BaseApp extends Application {
    public static BaseApp sBaseApp;
    public static int mWidthPixels;
    public static int mHeightPixels;
    private static Context mContext;
    //默认不是夜间模式
    public static int mMode = AppCompatDelegate.MODE_NIGHT_NO;

    @Override
    public void onCreate() {
        super.onCreate();
        sBaseApp = this;
        mContext = this;
        getScreenWH();
        setDayNightMode();
    }

    //计算屏幕宽高
    private void getScreenWH() {
        WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display defaultDisplay = manager.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        defaultDisplay.getMetrics(metrics);
        mWidthPixels = metrics.widthPixels;
        mHeightPixels = metrics.heightPixels;
    }

    private void setDayNightMode() {
        //设置以前用户的模式选项
        mMode = (int) SpUtil.getParam(Constants.MODE,AppCompatDelegate.MODE_NIGHT_NO);
        UIModeUtil.setAppMode(mMode);
    }

    public static BaseApp getInstance(){
        return sBaseApp;
    }

    public static Resources getRes() {
        return sBaseApp.getResources();
    }
    public static Context getContext() {
        if (mContext != null) {
            return mContext;
        }
        return null;
    }
}


