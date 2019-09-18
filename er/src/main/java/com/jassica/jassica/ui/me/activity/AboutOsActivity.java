package com.jassica.jassica.ui.me.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.jassica.jassica.R;
import com.jassica.jassica.base.BaseActivity;
import com.jassica.jassica.base.BasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*
 * 关于我们
 * */
public class AboutOsActivity extends BaseActivity {

    @BindView(R.id.about_web)
    WebView aboutWeb;
    @BindView(R.id.about_out)
    ImageView aboutOut;

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void initView() {
        super.initView();
        aboutWeb.loadUrl("https://wap.taihaitao.com/tmpl/member/about_us.html");
        aboutWeb.addJavascriptInterface(new AndroidJs(this), "android");
        WebSettings settings = aboutWeb.getSettings();
        settings.setJavaScriptEnabled(true);
        aboutWeb.setWebViewClient(new WebViewClient());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_about_os;
    }

    @OnClick(R.id.about_out)
    public void onViewClicked() {
        finish();
    }
}
