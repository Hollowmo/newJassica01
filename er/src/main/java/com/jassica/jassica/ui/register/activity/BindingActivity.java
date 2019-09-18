package com.jassica.jassica.ui.register.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import com.jassica.jassica.R;
import com.jassica.jassica.base.BaseActivity;
import com.jassica.jassica.mvp.prestent.EmptyPrestent;
import com.jassica.jassica.mvp.view.EmptyView;
import com.jassica.jassica.ui.login.fragment.PhoneFragment;
import com.jassica.jassica.ui.login.fragment.PwdFragment;
import com.jassica.jassica.ui.login.adapter.LoginAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
/*
* 绑定
* */
public class BindingActivity extends BaseActivity<EmptyView, EmptyPrestent> implements EmptyView {

    @BindView(R.id.bind_out)
    ImageView mBindOut;
    @BindView(R.id.bind_tabl)
    TabLayout mBindTabl;
    @BindView(R.id.bind_vp)
    ViewPager mBindVp;

    @Override
    protected EmptyPrestent initPresenter() {
        return new EmptyPrestent();
    }

    @Override
    protected int getLayoutId() {
        setStatusBar(BindingActivity.this);
        return R.layout.activity_binding;
    }

    @Override
    protected void initView() {
        super.initView();
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new PwdFragment());
        fragments.add(new PhoneFragment());
        ArrayList<String> strings = new ArrayList<>();
        strings.add("注册新账号并绑定");
        strings.add("绑定已有账号");
        LoginAdapter registerAdapter = new LoginAdapter(getSupportFragmentManager(), fragments, strings);
        mBindVp.setAdapter(registerAdapter);
        mBindTabl.setupWithViewPager(mBindVp);
    }


    @OnClick(R.id.bind_out)
    public void onViewClicked() {
        finish();
    }
}
