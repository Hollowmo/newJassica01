package com.jassica.jassica.ui.login.fragment;


import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jassica.jassica.R;
import com.jassica.jassica.api.Api;
import com.jassica.jassica.base.BaseFragment;
import com.jassica.jassica.bean.GenverifiCodeBean;
import com.jassica.jassica.bean.PwdLoginBean;
import com.jassica.jassica.mvp.prestent.PwdPrestent;
import com.jassica.jassica.mvp.view.PwdView;
import com.jassica.jassica.net.BaseObserver;
import com.jassica.jassica.net.HttpUtils;
import com.jassica.jassica.net.RxUtils;
import com.jassica.jassica.ui.forget.activity.ForgetNextActivity;
import com.jassica.jassica.ui.main.activity.MainActivity;
import com.jassica.jassica.ui.register.activity.RegisterAActivity;
import com.jassica.jassica.utils.ToastUtil;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.disposables.Disposable;

/**
 * 账号密码登录
 */
public class PwdFragment extends BaseFragment<PwdView, PwdPrestent> implements PwdView {


    @BindView(R.id.register_yhm)
    EditText mRegisterYhm;
    @BindView(R.id.register_pwd)
    EditText mRegisterPwd;
    @BindView(R.id.rgister_code)
    EditText mRgisterCode;
    @BindView(R.id.pwd_image)
    ImageView mPwdImg;
    @BindView(R.id.pwd_please_register)
    TextView mPwdPleaseRegister;
    @BindView(R.id.pwd_nopwd)
    TextView mPwdNopwd;
    @BindView(R.id.pwd_seekpwd)
    TextView mPwdSeekpwd;
    @BindView(R.id.pwd_forget)
    LinearLayout mPwdForget;
    @BindView(R.id.pwd_btn)
    TextView mPwdBtn;
    @BindView(R.id.pwd_wecha)
    TextView mPwdWecha;
    @BindView(R.id.pwd_zhifu)
    TextView mPwdZhifu;

    private String captchaKey;
    private String url = "https://api.dev.kingpower-cn.com/captcha/makecaptcha?captchaKey=";

    @Override
    protected PwdPrestent initPresenter() {
        return new PwdPrestent();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_pwd;
    }

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void initData() {
        super.initData();
        httpGetImage();
        mPwdImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                httpGetImage();
            }
        });
    }

    //获取图片验证码
    private void httpGetImage() {
        Api navigationApi = HttpUtils.getInstance().getApiserver(Api.NAVIGATION_URL, Api.class);
        navigationApi.getVerifiCode().compose(RxUtils.<GenverifiCodeBean>rxObserableSchedulerHelper()).subscribe(
                new BaseObserver<GenverifiCodeBean>() {
                    @Override
                    public void onNext(GenverifiCodeBean genverifiCodeBean) {
                        if (genverifiCodeBean != null) {
                            captchaKey = genverifiCodeBean.getDatas().getCaptchaKey();
                            Glide.with(getActivity()).load(url + captchaKey + "&clientType=android").into(mPwdImg);
                        }
                    }
                    @Override
                    public void error(String msg) {
                    }
                    @Override
                    protected void subscribe(Disposable d) {
                    }
                }
        );
    }

    @OnClick({R.id.pwd_please_register, R.id.pwd_btn,R.id.pwd_forget})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.pwd_please_register:
                Intent intent = new Intent(getActivity(), RegisterAActivity.class);
                startActivity(intent);
                break;
            case R.id.pwd_btn:
                initPwd();
                break;
            case R.id.pwd_forget:
                Intent forget = new Intent(getContext(), ForgetNextActivity.class);
                startActivity(forget);
                break;
        }
    }

    private void initPwd() {
        String name = mRegisterYhm.getText().toString();
        String pwd = mRegisterPwd.getText().toString();
        String code = mRgisterCode.getText().toString();
        Pattern email = Pattern.compile("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");//邮箱
        Pattern phone = Pattern.compile("^((13[0-9])|(15[^4])|(18[0-9])|(17[0-9])|(147))\\\\d{8}$");//手机号
        Pattern yhm = Pattern.compile("^[A-Za-z0-9]{6,20}+$");//用户名
        Matcher mEmail = email.matcher(name);
        Matcher mPhone = phone.matcher(name);
        Matcher mYhm = yhm.matcher(name);

        if (!TextUtils.isEmpty(name)) {
            if (!TextUtils.isEmpty(pwd)) {
                    if(!TextUtils.isEmpty(code)){
                        if (mEmail.matches()||mPhone.matches()||mYhm.matches()) {
                            HashMap<String, Object> map = new HashMap<>();
                            map.put("memberName",mRegisterYhm.getText().toString());
                            map.put("password",mRegisterPwd.getText().toString());
                            map.put("captchaKey",captchaKey);
                            map.put("captchaVal",mRgisterCode.getText().toString());
                            map.put("clientType","android");
                            mPresenter.getPwdLogin(map);
                        } else {
                            ToastUtil.showShort("请输入正确的用户名/邮箱/手机号");
                        }
                    }else{
                ToastUtil.showShort("请输入验证码！");
                }
            } else {
                ToastUtil.showShort("请输入密码！");
            }
        } else {
            ToastUtil.showShort("请输入用户名/邮箱/手机号！");
        }

    }

    @Override
    public void getPwdLoginDatas(PwdLoginBean bean) {
        if (bean.getCode() == 200) {
            startActivity(new Intent(getActivity(), MainActivity.class).putExtra("register", true));
            getActivity().finish();
        } else {
            Toast.makeText(getActivity(), "输入有误", Toast.LENGTH_SHORT).show();
        }
    }
}
