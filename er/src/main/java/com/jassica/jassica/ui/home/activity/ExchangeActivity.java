package com.jassica.jassica.ui.home.activity;

import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.jassica.jassica.R;
import com.jassica.jassica.base.BaseActivity;
import com.jassica.jassica.base.BasePresenter;
import com.jassica.jassica.bean.ExchangeBean;
import com.jassica.jassica.ui.home.adapter.ExchangeAdapte;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class ExchangeActivity extends BaseActivity {

    @BindView(R.id.exchange_out)
    ImageView exchangeOut;
    @BindView(R.id.exchange_too)
    Toolbar exchangeToo;
    @BindView(R.id.iv_thb)
    ImageView ivThb;
    @BindView(R.id.iv_chy)
    ImageView ivChy;
    @BindView(R.id.exchange_unionpay)
    ImageView exchangeUnionpay;
    @BindView(R.id.exchange_unionpay_tv)
    TextView exchangeUnionpayTv;
    @BindView(R.id.exchange_thb)
    TextView exchangeThb;
    @BindView(R.id.exchange_right)
    ImageView exchangeRight;
    @BindView(R.id.exchange_yuan)
    TextView exchangeYuan;
    @BindView(R.id.exchange_unionpay2)
    ImageView exchangeUnionpay2;
    @BindView(R.id.exchange_unionpay_tv2)
    TextView exchangeUnionpayTv2;
    @BindView(R.id.exchange_thb2)
    TextView exchangeThb2;
    @BindView(R.id.exchange_right2)
    ImageView exchangeRight2;
    @BindView(R.id.exchange_yuan2)
    TextView exchangeYuan2;
    @BindView(R.id.exchange_unionpay3)
    ImageView exchangeUnionpay3;
    @BindView(R.id.exchange_unionpay_tv3)
    TextView exchangeUnionpayTv3;
    @BindView(R.id.exchange_thb3)
    TextView exchangeThb3;
    @BindView(R.id.exchange_right3)
    ImageView exchangeRight3;
    @BindView(R.id.exchange_yuan3)
    TextView exchangeYuan3;

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_exchange;
    }

    @OnClick(R.id.exchange_out)
    public void onViewClicked() {
        finish();
    }

    @Override
    protected void initView() {
        super.initView();
        ArrayList<ExchangeBean> exchangeBeans = new ArrayList<>();
        ExchangeAdapte exchangeAdapte = new ExchangeAdapte();
    }
}
