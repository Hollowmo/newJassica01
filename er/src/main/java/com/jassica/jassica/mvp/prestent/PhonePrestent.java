package com.jassica.jassica.mvp.prestent;

import com.jassica.jassica.base.BasePresenter;
import com.jassica.jassica.bean.RegisterBean;
import com.jassica.jassica.bean.PhoneBean;
import com.jassica.jassica.mvp.model.PhoneModel;
import com.jassica.jassica.mvp.view.PhoneView;
import com.jassica.jassica.net.ResultCallBack;

import java.util.Map;

public class PhonePrestent extends BasePresenter<PhoneView> {
    private PhoneModel mPhoneModel;

    @Override
    protected void initModel() {
        mPhoneModel = new PhoneModel();
        mModels.add(mPhoneModel);
    }

    public void getLogin(Map<String,Object> map) {
        mPhoneModel.getPhoneLoginNoteData(new ResultCallBack<RegisterBean>() {
            @Override
            public void onSuccess(RegisterBean bean) {
                if (bean != null) {
                    if (mMvpView != null) {
                        mMvpView.getPhoneLoginNoteDatas(bean);
                    }
                }
            }

            @Override
            public void onFail(String msg) {

            }
        }, map);
    }
    public void getPhoneLogin(Map<String,Object> map){
        mPhoneModel.getPhoneLoginData(new ResultCallBack<PhoneBean>() {
            @Override
            public void onSuccess(PhoneBean bean) {
                if (bean!=null){
                    if (mMvpView!=null){
                        mMvpView.getPhoneLoginDatas(bean);
                    }
                }
            }

            @Override
            public void onFail(String msg) {

            }
        },map);
    }
}
