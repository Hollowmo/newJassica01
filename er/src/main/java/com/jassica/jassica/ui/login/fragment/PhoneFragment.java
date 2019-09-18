package com.jassica.jassica.ui.login.fragment;


import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jassica.jassica.R;
import com.jassica.jassica.api.Api;
import com.jassica.jassica.base.BaseFragment;
import com.jassica.jassica.bean.GenverifiCodeBean;
import com.jassica.jassica.bean.RegisterBean;
import com.jassica.jassica.bean.PhoneBean;
import com.jassica.jassica.mvp.prestent.PhonePrestent;
import com.jassica.jassica.mvp.view.PhoneView;
import com.jassica.jassica.net.BaseObserver;
import com.jassica.jassica.net.HttpUtils;
import com.jassica.jassica.net.RxUtils;
import com.jassica.jassica.ui.main.activity.MainActivity;
import com.jassica.jassica.ui.register.activity.RegisterAActivity;
import com.jassica.jassica.utils.ToastUtil;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.reactivex.disposables.Disposable;

/**
 * 手机验证码登录
 */
public class PhoneFragment extends BaseFragment<PhoneView, PhonePrestent> implements PhoneView {

    @BindView(R.id.phone_please_register)
    TextView mPhonePleaseRegister;
    @BindView(R.id.phone_login)
    TextView mPhoneBtn;
    @BindView(R.id.phone_wecha)
    TextView mPhoneWecha;
    @BindView(R.id.phone_zhifu)
    TextView mPhoneZhifu;
    @BindView(R.id.phone_img)
    ImageView mPhoneImg;
    @BindView(R.id.phone_yhm)
    EditText mPhoneYhm;
    @BindView(R.id.phone_code)
    EditText mPhoneCode;
    @BindView(R.id.phone_note_code)
    EditText mPhoneNoteCode;
    @BindView(R.id.phone_send_code)
    Button mPhoneSendCode;

    private String captchaKey;
    private String url = "https://api.dev.kingpower-cn.com/captcha/makecaptcha?captchaKey=";

    //复写倒计时
    private class MyCountDownTimer extends CountDownTimer {

        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        //计时过程
        @Override
        public void onTick(long l) {
            //防止计时过程中重复点击
            mPhoneSendCode.setClickable(false);
            mPhoneSendCode.setText("发送验证码(" + l / 1000 + "s)");
        }

        //计时完毕的方法
        @Override
        public void onFinish() {
            //设置可点击
            mPhoneSendCode.setClickable(true);
            //重新给Button设置文字
            mPhoneSendCode.setText("重新获取验证码");
        }
    }


    @Override
    protected PhonePrestent initPresenter() {
        return new PhonePrestent();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_phone;
    }

    @Override
    protected void initView() {
        super.initView();
        //new倒计时对象,总共的时间,每隔多少秒更新一次时间
        final MyCountDownTimer myCountDownTimer = new MyCountDownTimer(60000, 1000);

        //给Button设置点击时间,触发倒计时
        mPhoneSendCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myCountDownTimer.start();
                HashMap<String, Object> map = new HashMap<>();
                map.put("mobile",mPhoneYhm.getText().toString());
                map.put("captchaKey",captchaKey);
                map.put("captchaVal",mPhoneCode.getText().toString());
                map.put("sendType","2");
                mPresenter.getLogin(map);
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        //获取图片验证码
        httpGetImage();
        mPhoneImg.setOnClickListener(new View.OnClickListener() {
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
                            Glide.with(getActivity()).load(url + captchaKey + "&clientType=android").into(mPhoneImg);
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

    @OnClick({R.id.phone_please_register, R.id.phone_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.phone_please_register:
                Intent intent = new Intent(getActivity(), RegisterAActivity.class);
                startActivity(intent);
                break;
            case R.id.phone_login:
                initPhoneLogin();
                break;
        }
    }

    private void initPhoneLogin() {
        //  "[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}"邮箱
        //  "^((13[0-9])|(15[^4,\\D])|(18[0,0-9]))\\d{8}$"手机号
        //  "^[A-Za-z0-9]{6,20}+$"用户名
        String name = mPhoneYhm.getText().toString();
        String pwd = mPhoneCode.getText().toString();
        String code = mPhoneNoteCode.getText().toString();
        Pattern email = Pattern.compile("^((13[0-9])|(15[^4])|(18[0-9])|(17[0-9])|(147))\\d{8}$");//手机号
        Matcher yhm = email.matcher(name);
        if (name != "") {
            if (pwd != "") {
                if(code != ""){
                    if (yhm.matches()) {
                        HashMap<String, Object> map = new HashMap<>();
                        map.put("mobile",mPhoneYhm.getText().toString());
                        map.put("smsAuthCode",mPhoneNoteCode.getText().toString());
                        map.put("clientType","android");
                        map.put("captchaVal",mPhoneCode.getText().toString());
                        map.put("captchaKey",captchaKey);
                        mPresenter.getPhoneLogin(map);
                    } else {
                        ToastUtil.showShort("请输入正确的用户名");
                    }
                }else{
                    ToastUtil.showShort("请输入验证码！");
                }
            } else {
                ToastUtil.showShort("请输入短信验证码！");
            }
        } else {
            ToastUtil.showShort("请输入用户名！");
        }

    }
    //登录接口回调
    @Override
    public void getPhoneLoginDatas(PhoneBean bean) {
        if (bean.getCode() == 200) {
            startActivity(new Intent(getActivity(), MainActivity.class).putExtra("register", "true"));
        } else {
            Toast.makeText(getActivity(), "输入有误", Toast.LENGTH_SHORT).show();
        }
    }

    //手机短信验证码回调
    @Override
    public void getPhoneLoginNoteDatas(RegisterBean bean) {
        int code = bean.getCode();
        if (code == 200){
            Toast.makeText(getActivity(), "发送成功", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getActivity(), "发送失败", Toast.LENGTH_SHORT).show();
        }
    }
}
