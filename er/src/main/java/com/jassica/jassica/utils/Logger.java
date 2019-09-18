package com.jassica.jassica.utils;

import android.util.Log;

import com.jassica.jassica.base.Constants;

public  class Logger {
    public static void logD(String tag, String msg){
        if (Constants.isDebug){
            Log.d(tag, "logD: "+msg);
        }
    }
}
