package com.jassica.jassica.ui.forget.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.jassica.jassica.R;
import com.jassica.jassica.base.BaseActivity;
import com.jassica.jassica.bean.ForNextBean;
import com.jassica.jassica.mvp.prestent.ForgetSubmitPrestent;
import com.jassica.jassica.mvp.view.ForgetSubmitView;
import com.jassica.jassica.ui.login.fragment.PwdFragment;
import com.jassica.jassica.utils.Logger;
import com.jassica.jassica.utils.ToastUtil;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;

/*
 * 重置密码提交
 * */
public class ForgetSubmitActivity extends BaseActivity<ForgetSubmitView, ForgetSubmitPrestent> implements ForgetSubmitView {

    @BindView(R.id.forget_out)
    ImageView mForgetOut;
    @BindView(R.id.forget2_yhm)
    EditText mForget2Yhm;
    @BindView(R.id.forget2_code)
    EditText mForget2Code;
    @BindView(R.id.forget2_pwd)
    EditText mForget2Pwd;
    @BindView(R.id.forget2_btn)
    Button mForget2Btn;

    private String captchaKey;
    private String mPhone;

    @Override
    protected ForgetSubmitPrestent initPresenter() {
        return new ForgetSubmitPrestent();
    }

    @Override
    protected int getLayoutId() {
        setStatusBar(ForgetSubmitActivity.this);
        return R.layout.activity_forgetsubmit;
    }

    @OnClick({R.id.forget_out, R.id.forget2_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.forget_out:
                finish();
                break;
            case R.id.forget2_btn:
                initForgetSubmit();
                break;
        }
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        mPhone = intent.getStringExtra("phone");
        Logger.logD("phone", mPhone);
    }

    private void initForgetSubmit() {
        // 获取输入框 验证码
        String mEtYhm = mForget2Yhm.getText().toString().trim();
        // 获取输入框 密码
        String mEtPwd = mForget2Code.getText().toString();
        // 获取输入框 确认密码
        String mEtPwd1 = mForget2Pwd.getText().toString();
        /**
         *  可以包含字母数字和常用特殊字符，但不能是纯字母纯数字，特殊字符可以有也可以没有，只能6-20位
         */
//        String regex = "^[(?=.*\\d)(?=.*[A-Za-z])[\\x20-\\x7e]{6,20}$]";
        String regex = "^(?![\\d]+$)(?![a-zA-Z]+$)(?![!#$%^&*]+$)[\\da-zA-Z!#$%^&*]{6,20}$\n";

        if (mEtYhm != "") {
            if (mEtPwd != "") {
                if (mEtPwd1 != "") {
//                    if (mEtPwd.matches(regex)) {
                        if (mEtPwd.equals(mEtPwd1)) {

                            HashMap<String, Object> map = new HashMap<>();
                            map.put("mobile",mPhone);
                            map.put("smsAuthCode", mForget2Yhm.getText().toString());
                            map.put("memberPwdRepeat", mForget2Code.getText().toString());
                            map.put("memberPwd", mForget2Pwd.getText().toString());
                            mPresenter.getForgetNext(map);
                        } else {
                            ToastUtil.showShort("两次密码不一致");
                        }
                   /* } else {
                        ToastUtil.showShort("长度不足");
                    }*/
                } else {
                    ToastUtil.showShort("请输入确认密码");
                }
            } else {
                ToastUtil.showShort("请输入修改的密码");
            }
        } else {
            ToastUtil.showShort("请输入正确验证码");
        }
    }


    /*private HashMap<String, Object> getMapList(String pEtYhm, String pEtPwd) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("mobile", pEtYhm);
        map.put("captchaVal", pEtPwd);
        map.put("captchaKey", captchaKey);
        map.put("sendType", "3");
        return map;
    }*/

  /*  @Override
    public void getForgetSubmitDatas(ForgetSubmitBean bean) {
        *//*Intent intent = new Intent(ForgetSubmitActivity.this, PwdFragment.class);
        startActivity(intent);*//*
    }*/

    @Override
    public void getForgetNextDatas(ForNextBean bean) {
        if (bean.getCode() == 200) {
            ToastUtil.showShort("修改成功");
            Intent intent = new Intent(ForgetSubmitActivity.this, PwdFragment.class);
            startActivity(intent);
            finish();
        } else {
            ToastUtil.showShort("修改失败");
        }
    }
}
