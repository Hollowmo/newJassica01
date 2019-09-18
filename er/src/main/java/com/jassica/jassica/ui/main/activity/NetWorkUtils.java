package com.jassica.jassica.ui.main.activity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Log;
/*
* 网络连接
* */
public class NetWorkUtils {
        Context mcontext;
        public NetWorkUtils(Context mcontext){
            this.mcontext = mcontext;
        }

        public int netWorkType(){
            //获取管理
            ConnectivityManager mConnectivity = (ConnectivityManager)mcontext.getSystemService(Context.CONNECTIVITY_SERVICE);
            TelephonyManager mTelephony = (TelephonyManager)mcontext.getSystemService(Context.TELEPHONY_SERVICE);
            //检查网络连接
            NetworkInfo info = mConnectivity.getActiveNetworkInfo();

            if (info == null || !mConnectivity.getBackgroundDataSetting()) {
                Log.i("TAG","网络未连接.....");
                return 3;
            }

            int netType = info.getType();
            int netSubtype = info.getSubtype();
            Log.i("TAG",netType+",,"+netSubtype+",,"+mTelephony.isNetworkRoaming());
            if (netType == ConnectivityManager.TYPE_WIFI) {  //WIFI
                Log.i("TAG","wifi连接.....");
                return 1;
            } else if (netType == ConnectivityManager.TYPE_MOBILE && netSubtype == TelephonyManager.NETWORK_TYPE_UMTS && !mTelephony.isNetworkRoaming()) {   //MOBILE
                Log.i("TAG","移动数据连接.....");
                return 2;
            }
            return 3;
        }
}
