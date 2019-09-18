package com.jassica.jassica.ui.login.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import com.jassica.jassica.R;
import com.jassica.jassica.base.BaseActivity;
import com.jassica.jassica.mvp.prestent.LoginPrestent;
import com.jassica.jassica.mvp.view.LoginView;
import com.jassica.jassica.ui.login.adapter.LoginAdapter;
import com.jassica.jassica.ui.login.fragment.PhoneFragment;
import com.jassica.jassica.ui.login.fragment.PwdFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
/*
* 登录
* */
public class LoginActivity extends BaseActivity<LoginView, LoginPrestent> implements LoginView {

    @BindView(R.id.register_out)
    ImageView mRegisterOut;
    @BindView(R.id.register_tabl)
    TabLayout mRegisterTabl;
    @BindView(R.id.register_vp)
    ViewPager mRegisterVp;

    @Override
    protected LoginPrestent initPresenter() {
        return new LoginPrestent();
    }

    @Override
    protected int getLayoutId() {
        setStatusBar(LoginActivity.this);
        return R.layout.activity_register;
    }



    @Override
    protected void initView() {
        super.initView();
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new PwdFragment());
        fragments.add(new PhoneFragment());
        ArrayList<String> strings = new ArrayList<>();
        strings.add("账号密码登录");
        strings.add("手机验证码登录");
        LoginAdapter registerAdapter = new LoginAdapter(getSupportFragmentManager(),fragments,strings);
        mRegisterVp.setAdapter(registerAdapter);
        mRegisterTabl.setupWithViewPager(mRegisterVp);
    }

    @OnClick(R.id.register_out)
    public void onViewClicked() {
        finish();
    }
}
