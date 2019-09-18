package com.jassica.jassica.ui.register.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jassica.jassica.R;
import com.jassica.jassica.api.Api;
import com.jassica.jassica.base.BaseFragment;
import com.jassica.jassica.bean.GenverifiCodeBean;
import com.jassica.jassica.mvp.prestent.EmptyPrestent;
import com.jassica.jassica.mvp.view.EmptyView;
import com.jassica.jassica.net.BaseObserver;
import com.jassica.jassica.net.HttpUtils;
import com.jassica.jassica.net.RxUtils;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.reactivex.disposables.Disposable;
/*
* 注册新账号绑定
* */
public class NewFragment extends BaseFragment<EmptyView, EmptyPrestent> implements EmptyView {

    @BindView(R.id.new_phone)
    EditText mNewPhone;
    @BindView(R.id.new_pwdd)
    EditText mNewPwdd;
    @BindView(R.id.new_img)
    ImageView mNewImg;
    @BindView(R.id.new_note)
    EditText mNewNote;
    @BindView(R.id.new_send_code)
    Button mNewSendCode;
    @BindView(R.id.new_pwd)
    EditText mNewPwd;
    @BindView(R.id.new_confirmpwd)
    EditText mNewConfirmpwd;
    @BindView(R.id.new_login)
    Button mNewLogin;
    Unbinder unbinder;

    private String captchaKey;
    private String url = "https://api.dev.kingpower-cn.com/captcha/makecaptcha?captchaKey=";


    @Override
    protected EmptyPrestent initPresenter() {
        return new EmptyPrestent();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_new;
    }

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void initData() {
        super.initData();
        httpGetImage();
        mNewImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                httpGetImage();
            }
        });
    }

    private void httpGetImage() {
        Api navigationApi = HttpUtils.getInstance().getApiserver(Api.NAVIGATION_URL, Api.class);
        navigationApi.getVerifiCode().compose(RxUtils.<GenverifiCodeBean>rxObserableSchedulerHelper()).subscribe(
                new BaseObserver<GenverifiCodeBean>() {
                    @Override
                    public void onNext(GenverifiCodeBean genverifiCodeBean) {
                        if (genverifiCodeBean != null) {
                            captchaKey = genverifiCodeBean.getDatas().getCaptchaKey();
                            Glide.with(getActivity()).load(url + captchaKey + "&clientType=android").into(mNewImg);
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

    @OnClick(R.id.new_login)
    public void onViewClicked() {
    }
}
