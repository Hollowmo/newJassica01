package com.jassica.jassica.ui.me.fragment;


import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jassica.jassica.R;
import com.jassica.jassica.base.BaseFragment;
import com.jassica.jassica.mvp.prestent.EmptyPrestent;
import com.jassica.jassica.mvp.view.EmptyView;
import com.jassica.jassica.ui.login.activity.LoginActivity;
import com.jassica.jassica.ui.me.activity.AboutOsActivity;
import com.jassica.jassica.ui.me.activity.CouponActivity;
import com.jassica.jassica.ui.me.activity.HelpCententActivity;
import com.jassica.jassica.ui.me.activity.OrderActivity;
import com.jassica.jassica.ui.me.activity.PrivacyActivity;
import com.jassica.jassica.ui.me.activity.ReFundActivity;
import com.jassica.jassica.ui.me.activity.ShippingaddressActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 我的
 */
public class MeFragment extends BaseFragment<EmptyView, EmptyPrestent> implements EmptyView {

    @BindView(R.id.me_rigster_login)
    TextView mMeRigsterLogin;
    @BindView(R.id.me_nopayment)
    TextView mMeNopayment;
    @BindView(R.id.me_help_center)
    RelativeLayout me_help_center;
    @BindView(R.id.me_myorder)
    RelativeLayout meMyorder;
    @BindView(R.id.me_nodeliver)
    TextView meNodeliver;
    @BindView(R.id.me_notake)
    TextView meNotake;
    @BindView(R.id.me_finish)
    TextView meFinish;
    @BindView(R.id.me_refund)
    TextView meRefund;
    private String string;

    @Override
    protected EmptyPrestent initPresenter() {
        return new EmptyPrestent();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_me;
    }

    @Override
    protected void initView() {
        super.initView();
    }

    @OnClick({R.id.me_rigster_login, R.id.me_myorder, R.id.me_coupon,R.id.me_help_center, R.id.me_about_us, R.id.me_privacy, R.id.me_shipping_address,R.id.me_nopayment, R.id.me_nodeliver, R.id.me_notake, R.id.me_finish, R.id.me_refund})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.me_rigster_login://登录注册
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.me_myorder://我的订单
                Intent intent1 = new Intent(getActivity(), OrderActivity.class);
                string = "我的订单";
                intent1.putExtra("s",string);
                startActivity(intent1);
                break;
            case R.id.me_coupon://我的优惠券
                startActivity(new Intent(getActivity(), CouponActivity.class));
                break;
            case R.id.me_shipping_address://收货地址
                startActivity(new Intent(getActivity(), ShippingaddressActivity.class));
                break;
            case R.id.me_help_center://帮助中心
                startActivity(new Intent(getActivity(), HelpCententActivity.class));
                break;
            case R.id.me_about_us://关于我们
                startActivity(new Intent(getActivity(), AboutOsActivity.class));
                break;
            case R.id.me_privacy://隐私权限
                startActivity(new Intent(getActivity(), PrivacyActivity.class));
                break;
            case R.id.me_nopayment://代付款
                Intent nopayment = new Intent(getContext(), OrderActivity.class);
                string = mMeNopayment.getText().toString();
                nopayment.putExtra("s",string);
                startActivity(nopayment);
                break;
            case R.id.me_nodeliver://代发货
                Intent nodeliver = new Intent(getContext(), OrderActivity.class);
                string = meNodeliver.getText().toString();
                nodeliver.putExtra("s",string);
                startActivity(nodeliver);
                break;
            case R.id.me_notake://代收货
                Intent notake = new Intent(getContext(), OrderActivity.class);
                string = meNotake.getText().toString();
                notake.putExtra("s",string);
                startActivity(notake);
                break;
            case R.id.me_finish://已完成
                Intent finish = new Intent(getContext(), OrderActivity.class);
                string = meFinish.getText().toString();
                finish.putExtra("s",string);
                startActivity(finish);
                break;
            case R.id.me_refund://退款
                startActivity(new Intent(getActivity(), ReFundActivity.class));
                break;
        }
    }
}
