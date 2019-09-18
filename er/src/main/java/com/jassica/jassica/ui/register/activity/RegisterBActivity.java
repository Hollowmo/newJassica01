package com.jassica.jassica.ui.register.activity;

import android.content.Intent;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jassica.jassica.R;
import com.jassica.jassica.base.BaseActivity;
import com.jassica.jassica.bean.RegisterBean;
import com.jassica.jassica.bean.LoginBean;
import com.jassica.jassica.mvp.prestent.RegisterBPrestent;
import com.jassica.jassica.mvp.view.RegisterBView;
import com.jassica.jassica.ui.main.activity.MainActivity;
import com.jassica.jassica.utils.ToastUtil;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.OnClick;

public class RegisterBActivity extends BaseActivity<RegisterBView, RegisterBPrestent> implements RegisterBView {

    @BindView(R.id.login2_out)
    ImageView mLogin2Out;
    @BindView(R.id.login2_yhm)
    EditText mLogin2Yhm;
    @BindView(R.id.login2_code)
    EditText mLogin2Code;
    @BindView(R.id.login2_note)
    EditText mLogin2Note;
    @BindView(R.id.login2_send_code)
    Button mLogin2SendCode;
    @BindView(R.id.login2_login)
    Button mLogin2Login;
    @BindView(R.id.login2_phone)
    TextView mLogin2Phone;

    //复写倒计时
    private class MyCountDownTimer extends CountDownTimer {

        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        //计时过程
        @Override
        public void onTick(long l) {
            //防止计时过程中重复点击
            mLogin2SendCode.setClickable(false);
            mLogin2SendCode.setText("发送验证码(" + l / 1000 + "s)");
        }

        //计时完毕的方法
        @Override
        public void onFinish() {
            //设置可点击
            mLogin2SendCode.setClickable(true);
            //重新给Button设置文字
            mLogin2SendCode.setText("重新获取验证码");
        }
    }


    @Override
    protected RegisterBPrestent initPresenter() {
        return new RegisterBPrestent();
    }

    @Override
    protected int getLayoutId() {
        setStatusBar(RegisterBActivity.this);
        return R.layout.activity_login2;
    }

    @Override
    protected void initData() {
        super.initData();
        mLogin2Phone.setText(getIntent().getStringExtra("phone"));

    }

    @OnClick({R.id.login2_out, R.id.login2_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login2_out:
                finish();
                break;
            case R.id.login2_login:
                initLogin2();
//                Intent intent = new Intent(RegisterBActivity.this, Login3Activity.class);
//                startActivity(intent);
                break;
        }
    }

    @Override
    protected void initView() {
        super.initView();
        //new倒计时对象,总共的时间,每隔多少秒更新一次时间
        final MyCountDownTimer myCountDownTimer = new MyCountDownTimer(60000, 1000);

        //给Button设置点击时间,触发倒计时
        mLogin2SendCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myCountDownTimer.start();
                Intent intent = getIntent();
                HashMap<String, Object> map = new HashMap<>();
                String phone = intent.getStringExtra("phone");
                String captchaKey = intent.getStringExtra("captchaKey");
                String captchaVal = intent.getStringExtra("captchaVal");
                map.put("mobile",phone);
                map.put("captchaKey",captchaKey);
                map.put("captchaVal",captchaVal);
                map.put("sendType","1");
                mPresenter.getLogin(map);
            }
        });
    }

    private void initLogin2() {
        String pwd = mLogin2Yhm.getText().toString();
        String pwdd = mLogin2Code.getText().toString();
        Pattern p = Pattern.compile("^(?![\\d]+$)(?![a-zA-Z]+$)(?![^\\da-zA-Z]+$).{6,20}$");
        Matcher m = p.matcher(pwd);
        if (!TextUtils.isEmpty(pwd) && !TextUtils.isEmpty(pwdd)) {
            if (pwd.equals(pwd)) {
                if (m.matches()) {
                    //注册
                    Intent intent = getIntent();
                    HashMap<String, Object> map = new HashMap<>();
                    map.put("mobile", intent.getStringExtra("phone"));
                    map.put("smsAuthCode", mLogin2Note.getText().toString());
                    map.put("captchaKey", intent.getStringExtra("captchaKey"));
                    map.put("captchaVal", intent.getStringExtra("captchaVal"));
                    map.put("clientType", "android");
                    map.put("memberPwd", mLogin2Yhm.getText().toString());
                    map.put("memberPwdRepeat", mLogin2Code.getText().toString());
                    mPresenter.getRegister(map);
                } else {
                    ToastUtil.showShort("请输入正确格式的密码");
                }
            } else {
                ToastUtil.showShort("两次密码输入不一致，请重新输入");
            }
        } else {
            ToastUtil.showShort("密码不能为空");
        }
    }
    //手机短信验证码回调
    @Override
    public void getLogin2Datas(RegisterBean bean) {
        int code = bean.getCode();
        if (code == 200){
            Toast.makeText(this, "发送成功", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "发送失败", Toast.LENGTH_SHORT).show();
        }
    }
    //注册接口回调
    @Override
    public void getRegisterDatas(LoginBean bean) {
        if (bean.getCode() == 200) {
            startActivity(new Intent(this, MainActivity.class).putExtra("register", "true"));
        } else {
            Toast.makeText(this, "输入有误", Toast.LENGTH_SHORT).show();
        }
    }
}
