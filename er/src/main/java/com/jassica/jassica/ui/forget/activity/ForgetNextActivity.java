package com.jassica.jassica.ui.forget.activity;

import android.content.Intent;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jassica.jassica.R;
import com.jassica.jassica.api.Api;
import com.jassica.jassica.base.BaseActivity;
import com.jassica.jassica.bean.GenverifiCodeBean;
import com.jassica.jassica.bean.RegisterBean;
import com.jassica.jassica.mvp.prestent.ForgetNextPrestent;
import com.jassica.jassica.mvp.view.ForgetNextView;
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
 * 重置密码下一步
 * */
public class ForgetNextActivity extends BaseActivity<ForgetNextView, ForgetNextPrestent> implements ForgetNextView {

    @BindView(R.id.forget_out)
    ImageView mForgetOut;
    @BindView(R.id.forget_yhm)
    EditText mForgetYhm;
    @BindView(R.id.forget_code)
    EditText mForgetCode;
    @BindView(R.id.forget_img)
    ImageView mForgetImg;
    @BindView(R.id.forget_send_code)
    Button mForgetSendCode;
    @BindView(R.id.forget_btn)
    Button mForgetBtn;

    private String captchaKey;
    private String url = "https://api.dev.kingpower-cn.com/captcha/makecaptcha?captchaKey=";
    private String mName;
    private MyCountDownTimer myCountDownTimer;


    //复写倒计时
    private class MyCountDownTimer extends CountDownTimer {

        MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        //计时过程
        @Override
        public void onTick(long l) {
            //防止计时过程中重复点击
            mForgetSendCode.setClickable(false);
            mForgetSendCode.setText("发送验证码(" + l / 1000 + "s)");
        }

        //计时完毕的方法
        @Override
        public void onFinish() {
            //设置可点击
            mForgetSendCode.setClickable(true);
            //重新给Button设置文字
            mForgetSendCode.setText("重新获取验证码");
        }
    }


    @Override
    protected ForgetNextPrestent initPresenter() {
        return new ForgetNextPrestent();
    }

    @Override
    protected int getLayoutId() {
        setStatusBar(ForgetNextActivity.this);
        return R.layout.activity_forgetnext;
    }

    @Override
    protected void initView() {
        super.initView();
        //new倒计时对象,总共的时间,每隔多少秒更新一次时间
        myCountDownTimer = new MyCountDownTimer(60000, 1000);
        //给Button设置点击时间,触发倒计时
        mForgetSendCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String, Object> map = new HashMap<>();
                map.put("mobile", mForgetYhm.getText().toString());
                map.put("captchaKey", captchaKey);
                map.put("captchaVal", mForgetCode.getText().toString());
                map.put("sendType", "3");
                mPresenter.getForgetNextData(map);
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        //获取图片验证码
        httpGetImage();
        mForgetImg.setOnClickListener(new View.OnClickListener() {
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
                            Glide.with(ForgetNextActivity.this).load(url + captchaKey + "&clientType=android").into(mForgetImg);
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

    @OnClick({R.id.forget_out, R.id.forget_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.forget_out:
                finish();
                break;
            case R.id.forget_btn:
                initForget();
                break;
        }
    }

    private void initForget() {
        // 获取 输入框 [手机号]
        mName = mForgetYhm.getText().toString().trim();
        // 获取 输入框 [验证码]
        String code = mForgetCode.getText().toString().trim();
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4])|(18[0-9])|(17[0-9])|(147))\\d{8}$");
        Matcher m = p.matcher(mName);
        if (!mName.equals("")) {
            if (!code.equals("")) {
                if (m.matches()) {
                    HashMap<String, Object> map = new HashMap<>();
                    map.put("mobile", mForgetYhm.getText().toString());
                    map.put("captchaVal", mForgetCode.getText().toString());
                    map.put("captchaKey", captchaKey);
                    map.put("sendType", "3");
                    mPresenter.getForNext(map);
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

    //手机短信验证码回调
    @Override
    public void getForgetNextDatas(RegisterBean bean) {
        int code = bean.getCode();
        if (code == 200) {
            myCountDownTimer.start();
            Toast.makeText(ForgetNextActivity.this, "发送成功", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(ForgetNextActivity.this, "发送失败", Toast.LENGTH_SHORT).show();
        }

    }

    //下一步接口回调
    @Override
    public void getForNextData(RegisterBean bean) {
        Intent intent = new Intent(ForgetNextActivity.this, ForgetSubmitActivity.class);
        intent.putExtra("phone", mName);
        if (bean.getCode() == 200) {
            startActivity(intent);
        } else {
            Toast.makeText(ForgetNextActivity.this, "输入有误", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (myCountDownTimer != null) myCountDownTimer.cancel();
    }
}
