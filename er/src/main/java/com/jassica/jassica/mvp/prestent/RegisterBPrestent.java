package com.jassica.jassica.mvp.prestent;

import com.jassica.jassica.base.BasePresenter;
import com.jassica.jassica.bean.RegisterBean;
import com.jassica.jassica.bean.LoginBean;
import com.jassica.jassica.mvp.model.RegisterBModel;
import com.jassica.jassica.mvp.view.RegisterBView;
import com.jassica.jassica.net.ResultCallBack;

import java.util.Map;

public class RegisterBPrestent extends BasePresenter<RegisterBView> {
    private RegisterBModel mLogin2Model;

    @Override
    protected void initModel() {
        mLogin2Model = new RegisterBModel();
        mModels.add(mLogin2Model);
    }
    public void getLogin(Map<String,Object> map){
        mLogin2Model.getLogin2Data(new ResultCallBack<RegisterBean>() {
            @Override
            public void onSuccess(RegisterBean bean) {
                if (bean!=null){
                    if (mMvpView!=null){
                        mMvpView.getLogin2Datas(bean);
                    }
                }
            }

            @Override
            public void onFail(String msg) {

            }
        },map);
    }

    public void getRegister(Map<String,Object> map){
        mLogin2Model.getRegisterData(new ResultCallBack<LoginBean>() {
            @Override
            public void onSuccess(LoginBean bean) {
                if (bean!=null){
                    if (mMvpView!=null){
                        mMvpView.getRegisterDatas(bean);
                    }
                }
            }

            @Override
            public void onFail(String msg) {

            }
        },map);
    }
}
