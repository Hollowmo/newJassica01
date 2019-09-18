package com.jassica.jassica.ui.commodity.activity;

import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jassica.jassica.R;
import com.jassica.jassica.base.BaseActivity;
import com.jassica.jassica.mvp.prestent.ParticlarsPrestent;
import com.jassica.jassica.mvp.view.ParticlarsView;
import com.jassica.jassica.ui.commodity.fragmennt.IntroduceFragment;
import com.jassica.jassica.ui.commodity.fragmennt.NoticeFragment;
import com.jassica.jassica.utils.TabIndicatorWidthUtil;
import com.jassica.jassica.widget.CustomViewPager;
import com.youth.banner.Banner;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class ParticularsActivity extends BaseActivity<ParticlarsView, ParticlarsPrestent> implements ParticlarsView {

    @BindView(R.id.hot_out)
    ImageView mHotOut;
    @BindView(R.id.hot_tab)
    TabLayout mHotTab;
    @BindView(R.id.hot_vp)
    CustomViewPager mHotVp;
    @BindView(R.id.hot_too)
    Toolbar mHotToo;
    @BindView(R.id.hot_banner)
    Banner mHotBanner;
    @BindView(R.id.hot_name)
    TextView mHotName;
    @BindView(R.id.hot_style)
    TextView mHotStyle;
    @BindView(R.id.hot_sku)
    TextView mHotSku;
    @BindView(R.id.hot_price)
    TextView mHotPrice;
    @BindView(R.id.hot_about_price)
    TextView mHotAboutPrice;
    @BindView(R.id.hot_select_ll1)
    LinearLayout mHotSelectLl1;
    @BindView(R.id.hot_site)
    TextView mHotSite;
    @BindView(R.id.hot_select_ll2)
    LinearLayout mHotSelectLl2;
    private String[] tabList = new String[]{"商品介绍", "购物须知"};
    private ArrayList<Fragment> fragments;

    @Override
    protected ParticlarsPrestent initPresenter() {
        return new ParticlarsPrestent();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_particulars;
    }

    @Override
    protected void initView() {
        super.initView();
        initFragment();
        TabIndicatorWidthUtil.modifyTabIndicatorWidth(mHotTab, 0, 0);
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.clear();
        mHotTab.removeAllTabs();
        fragments.add(new IntroduceFragment());
        fragments.add(new NoticeFragment());
        mHotVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

        });
        mHotTab.addTab(mHotTab.newTab().setText(tabList[0]));
        mHotTab.addTab(mHotTab.newTab().setText(tabList[1]));
        mHotTab.setupWithViewPager(mHotVp);
        mHotTab.getTabAt(0).setText(tabList[0]);
        mHotTab.getTabAt(1).setText(tabList[1]);

    }


    @OnClick(R.id.hot_out)
    public void onViewClicked() {
        finish();
    }
}
