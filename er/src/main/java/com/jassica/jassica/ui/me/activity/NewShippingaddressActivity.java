package com.jassica.jassica.ui.me.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.jassica.jassica.R;
import com.jassica.jassica.base.BaseActivity;
import com.jassica.jassica.base.BasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewShippingaddressActivity extends BaseActivity {

    @BindView(R.id.shpadd_out)
    ImageView shpaddOut;
    @BindView(R.id.newshipping_too)
    Toolbar newshippingToo;

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        setStatusBar(NewShippingaddressActivity.this);
        return R.layout.activity_new_shippingaddress;
    }

    @OnClick(R.id.shpadd_out)
    public void onViewClicked() {
        finish();
    }
}
