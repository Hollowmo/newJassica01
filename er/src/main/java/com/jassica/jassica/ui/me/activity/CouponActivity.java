package com.jassica.jassica.ui.me.activity;

import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.jassica.jassica.R;
import com.jassica.jassica.base.BaseActivity;
import com.jassica.jassica.base.BasePresenter;
import com.jassica.jassica.ui.me.fragment.AccomplishFragment;
import com.jassica.jassica.ui.me.fragment.AllFragment;
import com.jassica.jassica.ui.me.fragment.NoCouponFragment;
import com.jassica.jassica.ui.me.fragment.NoPaymentFragment;
import com.jassica.jassica.ui.me.fragment.NoReceivingFragment;
import com.jassica.jassica.ui.me.fragment.NoShipmentsFragment;
import com.jassica.jassica.ui.me.fragment.YseCouponFragment;
import com.jassica.jassica.utils.TabIndicatorWidthUtil;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*
 * 我的 我的优惠券
 * */
public class CouponActivity extends BaseActivity {

    @BindView(R.id.refund_out)
    ImageView refundOut;
    @BindView(R.id.refund_tool)
    Toolbar refundTool;
    @BindView(R.id.coupon_tabl)
    TabLayout couponTabl;
    @BindView(R.id.coupon_vp)
    ViewPager couponVp;

    private String[] tabList = new String[]{"可用优惠券", "不可用优惠券"};
    private ArrayList<Fragment> fragments = new ArrayList<>();

    @Override
    protected void initView() {
        super.initView();
        initFragment();
        TabIndicatorWidthUtil.modifyTabIndicatorWidth(couponTabl, 0, 0);
        refundTool.setTitle("");
        setSupportActionBar(refundTool);
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        setStatusBar(CouponActivity.this);
        return R.layout.activity_coupon;
    }

    private void initFragment() {
        if (fragments != null) fragments.clear();
        couponTabl.removeAllTabs();
        fragments.add(new YseCouponFragment());//可用优惠券
        fragments.add(new NoCouponFragment());//不可用优惠券

        couponVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        couponTabl.addTab(couponTabl.newTab().setText(tabList[0]));
        couponTabl.addTab(couponTabl.newTab().setText(tabList[1]));
        couponTabl.setupWithViewPager(couponVp);
        Objects.requireNonNull(couponTabl.getTabAt(0)).setText(tabList[0]);
        Objects.requireNonNull(couponTabl.getTabAt(1)).setText(tabList[1]);
    }

    @OnClick(R.id.refund_out)
    public void onViewClicked() {
        finish();
    }
}
