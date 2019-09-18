package com.jassica.jassica.ui.me.activity;

import android.app.Activity;
import android.webkit.JavascriptInterface;

// 继承自Object类
public class AndroidJs extends Object {
    private Activity mActivity;

    public AndroidJs(Activity activity) {
        mActivity = activity;
    }

    // 定义JS需要调用的方法
    // 被JS调用的方法必须加入@JavascriptInterface注解
    @JavascriptInterface
    public void close() {
        if (mActivity != null) {
            mActivity.finish();
        }
    }
}
