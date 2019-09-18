package com.jassica.jassica.ui.me.activity;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.jassica.jassica.R;
import com.jassica.jassica.base.BaseActivity;
import com.jassica.jassica.base.BasePresenter;

import butterknife.BindView;
import butterknife.OnClick;
/*
* 隐私权限
* */
public class PrivacyActivity extends BaseActivity {

    @BindView(R.id.privacy_web)
    WebView privacyWeb;
    @BindView(R.id.privacy_out)
    ImageView privacyOut;

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        super.initView();
        privacyWeb.loadUrl("https://wap.taihaitao.com/tmpl/member/document.html");
        privacyWeb.addJavascriptInterface(new AndroidJs(this), "android");
        WebSettings settings = privacyWeb.getSettings();
        settings.setJavaScriptEnabled(true);
        privacyWeb.setWebViewClient(new WebViewClient());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_privacy;
    }

    @OnClick(R.id.privacy_out)
    public void onViewClicked() {
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
