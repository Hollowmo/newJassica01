package com.jassica.jassica.ui.main.activity;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
/*
* 判断是否有网下载
* */
public class CopyOfOffLineService extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //new一个新类 判断网络
        NetWorkUtils netUtils = new NetWorkUtils(getApplicationContext());
        int i = netUtils.netWorkType();//获得当前网络状态类型
        //1.wifi 2.移动网路 3.没网
        if(i == 1){
            //请求数据，并保存
            Log.i("TAG", "开始离线下载......");


        }else if(i == 2){
            Log.i("TAG", "提示是移动数据，是否继续下载......");
        }else{
            Log.i("TAG", "没网，不需要下载......");
        }

        return super.onStartCommand(intent, flags, startId);
    }
    @Override
    public IBinder onBind(Intent intent) {


        return null;
    }

}
