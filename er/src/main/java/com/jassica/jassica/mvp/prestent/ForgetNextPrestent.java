package com.jassica.jassica.mvp.prestent;

import com.jassica.jassica.base.BasePresenter;
import com.jassica.jassica.bean.ForNextBean;
import com.jassica.jassica.bean.RegisterBean;
import com.jassica.jassica.mvp.model.ForgetNextModel;
import com.jassica.jassica.mvp.view.ForgetNextView;
import com.jassica.jassica.net.ResultCallBack;

import java.util.Map;

public class ForgetNextPrestent extends BasePresenter<ForgetNextView> {

    private ForgetNextModel forgetNextModel;

    @Override
    protected void initModel() {
        forgetNextModel = new ForgetNextModel();
        mModels.add(forgetNextModel);
    }
    public void getForNext(Map<String,Object> map) {
        forgetNextModel.getForNextData(new ResultCallBack<RegisterBean>() {
            @Override
            public void onSuccess(RegisterBean bean) {
                if (bean != null) {
                    if (mMvpView != null) {
                        mMvpView.getForNextData(bean);
                    }
                }
            }

            @Override
            public void onFail(String msg) {

            }
        }, map);
    }
    //下一步
    public void getForgetNextData(Map<String,Object> map){
        forgetNextModel.getForgetNextData(new ResultCallBack<RegisterBean>() {
            @Override
            public void onSuccess(RegisterBean bean) {
                if (bean!=null){
                    if (mMvpView!=null){
                        mMvpView.getForgetNextDatas(bean);
                    }
                }
            }
            @Override
            public void onFail(String msg) {

            }
        },map);
    }
}
