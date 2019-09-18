package com.jassica.jassica.ui.main.activity;

import android.content.Intent;
import android.os.CountDownTimer;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jassica.jassica.R;
import com.jassica.jassica.base.BaseActivity;
import com.jassica.jassica.bean.ThemeImageBean;
import com.jassica.jassica.bean.ThemeImageDataBean;
import com.jassica.jassica.mvp.prestent.WelcoomPrestent;
import com.jassica.jassica.mvp.view.WelcoomView;
import com.jassica.jassica.utils.GlideUtil;

import java.lang.reflect.Type;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/*
 * 开屏广告
 * */
public class WelcoomActivity extends BaseActivity<WelcoomView, WelcoomPrestent> implements WelcoomView {

    @BindView(R.id.welcoom_tv)
    TextView tv;
    @BindView(R.id.iv_themeImage)
    ImageView mIvThemeImage;
    private CountDownTimer start;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        start.cancel();
    }

    @Override
    protected void initView() {
        super.initView();
        start = new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tv.setText("跳过 (" + millisUntilFinished / 1000 + ")");
            }

            @Override
            public void onFinish() {
                if (isFinishing()) {
                    return;
                }
                gotoMainPage();
            }
        }.start();
    }

    @Override
    protected WelcoomPrestent initPresenter() {
        return new WelcoomPrestent();
    }

    @Override
    protected int getLayoutId() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        return R.layout.activity_welcoom;
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.getThemeData();
    }


    private void gotoMainPage() {
        Intent intent = new Intent(WelcoomActivity.this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.enter_anim,R.anim.exit_anim);
        start.cancel();
        finish();
    }

    /**
     * 点击跳过
     */
    @OnClick(R.id.welcoom_tv)
    public void onViewClicked() {
        //从闪屏界面跳转到首界面
        gotoMainPage();
    }



    @Override
    public void setThemeData(ThemeImageBean bean) {
        Type type = new TypeToken<ArrayList<ThemeImageDataBean>>() {
        }.getType();
        ArrayList<ThemeImageDataBean> themeImageDataBeans = new Gson().fromJson(bean.getDatas().getCoopenList().get(0).getImgOperateJson(), type);
        GlideUtil.loadCacheImg(this,R.drawable.default_image,themeImageDataBeans.get(0).getThemeImageUrl(),mIvThemeImage);
    }

}
