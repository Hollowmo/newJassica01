package com.jassica.jassica.ui.main.activity;

import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jassica.jassica.R;
import com.jassica.jassica.base.BaseActivity;
import com.jassica.jassica.base.BaseApp;
import com.jassica.jassica.mvp.prestent.EmptyPrestent;
import com.jassica.jassica.mvp.view.EmptyView;
import com.jassica.jassica.ui.classify.fragment.ClassifyFragment;
import com.jassica.jassica.ui.commodity.fragmennt.CommodityFragment;
import com.jassica.jassica.ui.home.fragment.HomeFragment;
import com.jassica.jassica.ui.me.fragment.MeFragment;
import com.jassica.jassica.ui.sopping.fragment.SoppingFragment;
import com.jassica.jassica.utils.StatusBarUtil;
import com.jassica.jassica.utils.TabIndicatorWidthUtil;
import com.jassica.jassica.widget.CustomViewPager;

import java.util.ArrayList;

import butterknife.BindView;
import cn.ycbjie.ycstatusbarlib.StatusBarUtils;
import cn.ycbjie.ycstatusbarlib.bar.YCAppBar;

public class MainActivity extends BaseActivity<EmptyView, EmptyPrestent> implements EmptyView {


    @BindView(R.id.main_vp)
    CustomViewPager mMainVp;
    @BindView(R.id.main_tabl)
    TabLayout mMainTabl;
    private ArrayList<Integer> titleList = new ArrayList<>();
    private ArrayList<Integer> titleImgList = new ArrayList<>();
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private ImageView mTabIv;
    private TextView mTabTv;

    @Override
    protected EmptyPrestent initPresenter() {
        return new EmptyPrestent();
    }

    @Override
    protected int getLayoutId() {
        setStatusBar(MainActivity.this);
        return R.layout.activity_main;
    }


    @Override
    protected void initView() {
        super.initView();
        initTitle();
        initFragment();
        mMainVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                        setStatusBar(MainActivity.this);
                        break;
                    case 4:
                        //设置状态栏为白色
                        YCAppBar.setStatusBarColor(MainActivity.this,
                                ContextCompat.getColor(MainActivity.this,
                                        R.color.transparent));
                        //状态栏亮色模式，设置状态栏黑色文字、图标
                        StatusBarUtils.StatusBarLightMode(MainActivity.this);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        // 防止Tab栏标题文字过多
        TabIndicatorWidthUtil.modifyTabIndicatorWidth(mMainTabl, 0, 0);
    }

    private void initTitle() {
        titleList.add(R.string.mainpage);
        titleList.add(R.string.commodity);
        titleList.add(R.string.classify);
        titleList.add(R.string.sopping);
        titleList.add(R.string.me);
        titleImgList.add(R.drawable.mainselector1);
        titleImgList.add(R.drawable.mainselector2);
        titleImgList.add(R.drawable.mainselector3);
        titleImgList.add(R.drawable.mainselector4);
        titleImgList.add(R.drawable.mainselector5);
    }

    private void initFragment() {
        if (fragments != null) fragments.clear();
        mMainTabl.removeAllTabs();
        fragments.add(new HomeFragment()); // 首页
        fragments.add(new CommodityFragment()); // 全部商品
        fragments.add(new ClassifyFragment()); // 分类
        fragments.add(new SoppingFragment()); // 购物车
        fragments.add(new MeFragment()); // 我的

        mMainVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });

        for (int i = 0; i < titleList.size(); i++) {
            mMainTabl.addTab(mMainTabl.newTab().setText(titleList.get(i)));
        }

        mMainTabl.setupWithViewPager(mMainVp);
        for (int i = 0; i < titleList.size(); i++) {
            TabLayout.Tab tabAt = mMainTabl.getTabAt(i);
            View inflate = LayoutInflater.from(BaseApp.getInstance()).inflate(R.layout.tab, null);
            mTabIv = inflate.findViewById(R.id.tab_iv);
            mTabTv = inflate.findViewById(R.id.tab_tv);
            mTabIv.setImageResource(titleImgList.get(i));
            mTabTv.setText(titleList.get(i));
            if (i == 0) {
                mTabTv.setTextColor(ContextCompat.getColor(BaseApp.getInstance(), R.color.color_blue));
            }
            if (tabAt != null) {
                tabAt.setCustomView(inflate);
            }
        }

        mMainTabl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                View customView = tab.getCustomView();
                TextView mTv = null;
                if (customView != null) {
                    mTv = customView.findViewById(R.id.tab_tv);
                }
                if (mTv != null) {
                    mTv.setTextColor(ContextCompat.getColor(BaseApp.getInstance(), R.color.color_blue));
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View customView = tab.getCustomView();
                TextView mTv = null;
                if (customView != null) {
                    mTv = customView.findViewById(R.id.tab_tv);
                }
                if (mTv != null) {
                    mTv.setTextColor(ContextCompat.getColor(BaseApp.getInstance(), R.color.c_8a000000));
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (getIntent() != null) {
            boolean registers = getIntent().getBooleanExtra("register", false);
            if (registers) {
                mMainVp.setCurrentItem(3);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mMainTabl != null) {
            mMainTabl.removeAllTabs();
        }
        if (mMainVp != null) {
            mMainVp.removeAllViewsInLayout();
            mMainVp.removeAllViews();
        }
        assert mMainVp != null;
        mMainVp.addOnPageChangeListener(null);
        mMainTabl.addOnTabSelectedListener(null);
    }
}
