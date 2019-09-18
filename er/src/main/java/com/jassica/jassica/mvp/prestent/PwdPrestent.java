package com.jassica.jassica.mvp.prestent;

import com.jassica.jassica.base.BasePresenter;
import com.jassica.jassica.bean.PwdLoginBean;
import com.jassica.jassica.mvp.model.PwdModel;
import com.jassica.jassica.mvp.view.PwdView;
import com.jassica.jassica.net.ResultCallBack;

import java.util.Map;

public class PwdPrestent extends BasePresenter<PwdView> {
    private PwdModel mPwdModel;

    @Override
    protected void initModel() {
        mPwdModel = new PwdModel();
        mModels.add(mPwdModel);
    }
    public void getPwdLogin(Map<String,Object> map){
        mPwdModel.getPwdLoginData(new ResultCallBack<PwdLoginBean>() {
            @Override
            public void onSuccess(PwdLoginBean bean) {
                if (bean!=null){
                    if (mMvpView!=null){
                        mMvpView.getPwdLoginDatas(bean);
                    }
                }
            }

            @Override
            public void onFail(String msg) {

            }
        },map);
    }
}
