package com.jassica.jassica.base;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;


import com.jassica.jassica.R;
import com.jassica.jassica.ui.main.activity.MainActivity;
import com.jassica.jassica.utils.StatusBarUtil;
import com.jassica.jassica.widget.LoadingDialog;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.ycbjie.ycstatusbarlib.StatusBarUtils;
import cn.ycbjie.ycstatusbarlib.bar.YCAppBar;

/**
 * Created by $sl on 2019/5/20 16:13.
 */
public abstract class BaseActivity<V extends BaseView,P extends BasePresenter> extends AppCompatActivity implements BaseView {

    protected P mPresenter;
    private LoadingDialog mLoadingDialog;
    private Unbinder bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        bind = ButterKnife.bind(this);
        mPresenter = initPresenter();
        if(mPresenter != null){
            mPresenter.bind((V)this);
        }
        initView();
        initListener();
        initData();
    }


    protected abstract P initPresenter();

    protected void initData() {

    }

    protected void initListener() {

    }

    protected void initView(){

    }

    protected abstract int getLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onDestory();
            mPresenter = null;
        }
        if (bind != null) {
            bind.unbind();
        }
        if (mLoadingDialog != null && mLoadingDialog.isShowing()) {
            mLoadingDialog.dismiss();
            mLoadingDialog.cancel();
        }
    }

    @Override
    public void showLoading() {
        if (mLoadingDialog == null) {
            mLoadingDialog = new LoadingDialog(this);
        }
        mLoadingDialog.show();
    }

    @Override
    public void hideLoading() {
        if (mLoadingDialog != null && mLoadingDialog.isShowing()){
            mLoadingDialog.dismiss();
        }
    }

    protected void setStatusBar(Activity activity) {
        YCAppBar.setStatusBarColor(activity,
                ContextCompat.getColor(activity,
                        R.color.white));
        StatusBarUtils.StatusBarLightMode(activity);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
