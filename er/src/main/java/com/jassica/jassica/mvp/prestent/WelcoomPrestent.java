package com.jassica.jassica.mvp.prestent;

import com.jassica.jassica.base.BasePresenter;
import com.jassica.jassica.bean.ThemeImageBean;
import com.jassica.jassica.mvp.model.WelcoomModel;
import com.jassica.jassica.mvp.view.EmptyView;
import com.jassica.jassica.mvp.view.WelcoomView;
import com.jassica.jassica.net.ResultCallBack;

public class WelcoomPrestent extends BasePresenter<WelcoomView> {
    private WelcoomModel welcoomModel;

    @Override
    protected void initModel() {
        welcoomModel = new WelcoomModel();
        mModels.add(welcoomModel);
    }

    public void getThemeData() {
        welcoomModel.getThemeDatas(new ResultCallBack<ThemeImageBean>(){

            @Override
            public void onSuccess(ThemeImageBean bean) {
                mMvpView.setThemeData(bean);
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }
}
