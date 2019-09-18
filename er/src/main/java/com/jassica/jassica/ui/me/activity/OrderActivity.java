package com.jassica.jassica.ui.me.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jassica.jassica.R;
import com.jassica.jassica.base.BaseActivity;
import com.jassica.jassica.base.BasePresenter;
import com.jassica.jassica.ui.me.fragment.AccomplishFragment;
import com.jassica.jassica.ui.me.fragment.AllFragment;
import com.jassica.jassica.ui.me.fragment.NoPaymentFragment;
import com.jassica.jassica.ui.me.fragment.NoReceivingFragment;
import com.jassica.jassica.ui.me.fragment.NoShipmentsFragment;
import com.jassica.jassica.utils.TabIndicatorWidthUtil;
import com.jassica.jassica.widget.CustomViewPager;

import java.util.ArrayList;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderActivity extends BaseActivity {

    @BindView(R.id.orser_out)
    ImageView orserOut;
    @BindView(R.id.order_tabl)
    TabLayout orderTabl;
    @BindView(R.id.orser_vp)
    CustomViewPager orserVp;
    @BindView(R.id.order_too)
    Toolbar orderToo;
    private String[] tabList = new String[]{"全部", "代付款", "代发货", "代收货", "已完成"};
    private ArrayList<Fragment> fragments = new ArrayList<>();

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        setStatusBar(OrderActivity.this);
        return R.layout.activity_order;
    }

    private void initFragment() {
        if (fragments != null) fragments.clear();
        orderTabl.removeAllTabs();
        fragments.add(new AllFragment());//全部
        fragments.add(new NoPaymentFragment());//代付款
        fragments.add(new NoShipmentsFragment());//代发货
        fragments.add(new NoReceivingFragment());//代收货
        fragments.add(new AccomplishFragment());//待已完成

        orserVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });

        for (String s1 : tabList) {
            orderTabl.addTab(orderTabl.newTab().setText(s1));
        }
        orderTabl.setupWithViewPager(orserVp);
        for (int i = 0; i < tabList.length; i++) {
            Objects.requireNonNull(orderTabl.getTabAt(i)).setText(tabList[i]);
        }
        String s = getIntent().getStringExtra("s");
        switch (s) {
            case "我的订单":
                Objects.requireNonNull(orderTabl.getTabAt(0)).select();
                break;
            case "代付款":
                Objects.requireNonNull(orderTabl.getTabAt(1)).select();
                break;
            case "代发货":
                Objects.requireNonNull(orderTabl.getTabAt(2)).select();
                break;
            case "代收货":
                Objects.requireNonNull(orderTabl.getTabAt(3)).select();
                break;
            case "已完成":
                Objects.requireNonNull(orderTabl.getTabAt(4)).select();
                break;
        }
    }

    @Override
    protected void initView() {
        super.initView();
        initFragment();
        TabIndicatorWidthUtil.modifyTabIndicatorWidth(orderTabl, 0, 0);
        orderToo.setTitle("");
        setSupportActionBar(orderToo);
    }

    @OnClick(R.id.orser_out)
    public void onViewClicked() {
        finish();
    }
}
