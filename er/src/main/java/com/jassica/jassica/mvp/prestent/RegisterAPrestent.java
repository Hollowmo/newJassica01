package com.jassica.jassica.mvp.prestent;

import com.jassica.jassica.base.BasePresenter;
import com.jassica.jassica.bean.RegisterBean;
import com.jassica.jassica.mvp.model.RegisterAModel;
import com.jassica.jassica.mvp.view.RegisterAView;
import com.jassica.jassica.net.ResultCallBack;

import java.util.Map;

public class RegisterAPrestent extends BasePresenter<RegisterAView> {
    private RegisterAModel mLoginModel;

    @Override
    protected void initModel() {
        mLoginModel = new RegisterAModel();
        mModels.add(mLoginModel);
    }
    public void getLoginNextData(Map<String,Object> map){
        mLoginModel.getData(new ResultCallBack<RegisterBean>() {
            @Override
            public void onSuccess(RegisterBean bean) {
                if (bean!=null){
                    if (mMvpView!=null){
                        mMvpView.getNextDatas(bean);
                    }
                }
            }

            @Override
            public void onFail(String msg) {

            }
        },map);
    }
}
