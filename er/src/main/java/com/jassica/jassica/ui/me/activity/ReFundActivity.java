package com.jassica.jassica.ui.me.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.jassica.jassica.R;
import com.jassica.jassica.base.BaseActivity;
import com.jassica.jassica.base.BasePresenter;
import com.jassica.jassica.ui.me.fragment.ReFundFragment;
import com.jassica.jassica.ui.me.fragment.SalesFragment;
import com.jassica.jassica.utils.TabIndicatorWidthUtil;

import java.util.ArrayList;
import java.util.Objects;

import butterknife.BindView;
import butterknife.OnClick;

/*
 * 我的 退款
 * */
public class ReFundActivity extends BaseActivity {

    @BindView(R.id.refund_out)
    ImageView refundOut;
    @BindView(R.id.refund_tabl)
    TabLayout refundTabl;
    @BindView(R.id.refund_vp)
    ViewPager refundVp;
    @BindView(R.id.refund_tool)
    Toolbar refundTool;

    private String[] tabList = new String[]{"退款", "退货"};
    private ArrayList<Fragment> fragments = new ArrayList<>();


    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        super.initView();
        TabIndicatorWidthUtil.modifyTabIndicatorWidth(refundTabl, 0, 0);
        refundTool.setTitle("");
        setSupportActionBar(refundTool);

        if (fragments != null) fragments.clear();
        refundTabl.removeAllTabs();

        fragments.add(new ReFundFragment());//退款
        fragments.add(new SalesFragment());//退货

        refundVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });

        refundTabl.addTab(refundTabl.newTab().setText(tabList[0]));
        refundTabl.addTab(refundTabl.newTab().setText(tabList[1]));
        refundTabl.setupWithViewPager(refundVp);
        Objects.requireNonNull(refundTabl.getTabAt(0)).setText(tabList[0]);
        Objects.requireNonNull(refundTabl.getTabAt(1)).setText(tabList[1]);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_re_fund;
    }

    @OnClick(R.id.refund_out)
    public void onViewClicked() {
        finish();
    }
}
