package com.jassica.jassica.ui.register.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jassica.jassica.R;
import com.jassica.jassica.api.Api;
import com.jassica.jassica.base.BaseActivity;
import com.jassica.jassica.bean.GenverifiCodeBean;
import com.jassica.jassica.bean.RegisterBean;
import com.jassica.jassica.mvp.prestent.RegisterAPrestent;
import com.jassica.jassica.mvp.view.RegisterAView;
import com.jassica.jassica.net.BaseObserver;
import com.jassica.jassica.net.HttpUtils;
import com.jassica.jassica.net.RxUtils;
import com.jassica.jassica.utils.ToastUtil;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.disposables.Disposable;
/*
* 注册
* */
public class RegisterAActivity extends BaseActivity<RegisterAView, RegisterAPrestent> implements RegisterAView {

    @BindView(R.id.login_out)
    ImageView mLoginOut;
    @BindView(R.id.login_yhm)
    EditText mLoginYhm;
    @BindView(R.id.login_code)
    EditText mLoginCode;
    @BindView(R.id.login_img)
    ImageView mLoginImg;
    @BindView(R.id.login_nextstop)
    Button mLoginNextstop;
    private String captchaKey;

    private String url = "https://api.staging.taihaitao.com/captcha/makecaptcha?captchaKey=";


    @Override
    protected RegisterAPrestent initPresenter() {
        return new RegisterAPrestent();
    }

    @Override
    protected void initView() {
        super.initView();
    }

    private void httpGetImage() {
        Api navigationApi = HttpUtils.getInstance().getApiserver(Api.NAVIGATION_URL, Api.class);
        navigationApi.getVerifiCode().compose(RxUtils.<GenverifiCodeBean>rxObserableSchedulerHelper()).subscribe(
                new BaseObserver<GenverifiCodeBean>() {
                    @Override
                    public void onNext(GenverifiCodeBean genverifiCodeBean) {
                        if (genverifiCodeBean != null) {
                            captchaKey = genverifiCodeBean.getDatas().getCaptchaKey();
                            Glide.with(RegisterAActivity.this).load(url + captchaKey + "&clientType=android").into(mLoginImg);
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

    @Override
    protected void initData() {
        super.initData();
        httpGetImage();
        mLoginImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                httpGetImage();
            }
        });
    }

    @Override
    protected int getLayoutId() {

        setStatusBar(RegisterAActivity.this);
        return R.layout.activity_login;
    }

    @OnClick({R.id.login_out, R.id.login_nextstop})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_out:
                finish();
                break;
            case R.id.login_nextstop:
                initPhone();
                break;
        }
    }

    private void initPhone() {
        String name = mLoginYhm.getText().toString();
        String code = mLoginCode.getText().toString();
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4])|(18[0-9])|(17[0-9])|(147))\\d{8}$");
        Matcher m = p.matcher(name);
        if (name != "") {
            if (code != "") {
                if (m.matches()) {
//                    下一步
                        HashMap<String, Object> map = new HashMap<>();
                        map.put("mobile",mLoginYhm.getText().toString());
                        map.put("captchaVal",mLoginCode.getText().toString());
                        map.put("captchaKey",captchaKey);
                        map.put("sendType","1");
                        mPresenter.getLoginNextData(map);
                } else {
                    ToastUtil.showShort("请输入正确的手机号");
                }
            } else {
                ToastUtil.showShort("请输入验证码！");
            }
        } else {
            ToastUtil.showShort("请输入手机号！");
        }
    }

    @Override
    public void getNextDatas(RegisterBean bean) {
        if (bean.getCode() == 200) {
            Intent intent = new Intent(RegisterAActivity.this, RegisterBActivity.class);
            intent.putExtra("phone", mLoginYhm.getText().toString());
            intent.putExtra("captchaKey", captchaKey);
            intent.putExtra("captchaVal", mLoginCode.getText().toString());
            startActivity(intent);
        }else{
            httpGetImage();
            ToastUtil.showShort(bean.getDatas().getError());
        }
    }
}
