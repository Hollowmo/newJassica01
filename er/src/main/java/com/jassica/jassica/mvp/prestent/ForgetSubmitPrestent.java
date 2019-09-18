package com.jassica.jassica.mvp.prestent;

import com.jassica.jassica.base.BasePresenter;
import com.jassica.jassica.bean.ForNextBean;
import com.jassica.jassica.mvp.model.ForgetSubmitModel;
import com.jassica.jassica.mvp.view.ForgetSubmitView;
import com.jassica.jassica.net.ResultCallBack;

import java.util.Map;

public class ForgetSubmitPrestent extends BasePresenter<ForgetSubmitView> {
    private ForgetSubmitModel forgetSubmitModel;

    @Override
    protected void initModel() {
        forgetSubmitModel = new ForgetSubmitModel();
        mModels.add(forgetSubmitModel);
    }
    /*public void getForgetSubmit(Map<String,Object> map){
        forgetSubmitModel.getForgetSubmitData(new ResultCallBack<ForgetSubmitBean>() {
            @Override
            public void onSuccess(ForgetSubmitBean bean) {
                if (bean!=null){
                    if (mMvpView!=null){
                        mMvpView.getForgetSubmitDatas(bean);
                    }
                }
            }

            @Override
            public void onFail(String msg) {

            }
        },map);
    }*/

    public void getForgetNext(Map<String,Object> map){
        forgetSubmitModel.getForgetNextData(new ResultCallBack<ForNextBean>() {
            @Override
            public void onSuccess(ForNextBean bean) {
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
