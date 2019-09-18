package com.jassica.jassica.ui.me.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.jassica.jassica.R;
import com.jassica.jassica.base.BaseActivity;
import com.jassica.jassica.base.BasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.internal.schedulers.NewThreadScheduler;

/*
 * 收货地址
 * */
public class ShippingaddressActivity extends BaseActivity {

    @BindView(R.id.shpadd_out)
    ImageView shpaddOut;
    @BindView(R.id.shipping_btn)
    Button shippingBtn;

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        setStatusBar(ShippingaddressActivity.this);
        return R.layout.activity_shippingaddress;
    }

    @OnClick({R.id.shpadd_out, R.id.shipping_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.shpadd_out:
                finish();
                break;
            case R.id.shipping_btn:
                startActivity(new Intent(ShippingaddressActivity.this, NewShippingaddressActivity.class));
                break;
        }
    }
}
