package com.jassica.jassica.mvp.model;

import com.jassica.jassica.api.Api;
import com.jassica.jassica.base.BaseModel;
import com.jassica.jassica.bean.ThemeImageBean;
import com.jassica.jassica.net.BaseObserver;
import com.jassica.jassica.net.HttpUtils;
import com.jassica.jassica.net.ResultCallBack;
import com.jassica.jassica.net.RxUtils;

import io.reactivex.disposables.Disposable;

public class WelcoomModel extends BaseModel {
    public void getThemeDatas(final ResultCallBack<ThemeImageBean> themeImageBeanResultCallBack) {
        Api navigationApi = HttpUtils.getInstance().getApiserver(Api.NAVIGATION_URL, Api.class);
        navigationApi.getThemeImage().compose(RxUtils.<ThemeImageBean>rxObserableSchedulerHelper()).subscribe(
                new BaseObserver<ThemeImageBean>() {
                    @Override
                    public void onNext(ThemeImageBean themeImageBean) {
                        if (themeImageBean!=null){
                            themeImageBeanResultCallBack.onSuccess(themeImageBean);
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
}
