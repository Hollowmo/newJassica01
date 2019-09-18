package com.jassica.jassica.mvp.model;

import com.jassica.jassica.api.Api;
import com.jassica.jassica.base.BaseModel;
import com.jassica.jassica.bean.RegisterBean;
import com.jassica.jassica.bean.LoginBean;
import com.jassica.jassica.net.BaseObserver;
import com.jassica.jassica.net.HttpUtils;
import com.jassica.jassica.net.ResultCallBack;
import com.jassica.jassica.net.RxUtils;

import java.util.Map;

import io.reactivex.disposables.Disposable;

public class RegisterBModel extends BaseModel {
    public void getLogin2Data(final ResultCallBack<RegisterBean> resultCallBack, Map<String,Object> map) {
        Api navigationApi = HttpUtils.getInstance().getApiserver(Api.NAVIGATION_URL, Api.class);
        navigationApi.getLogin2Data(map).compose(RxUtils.<RegisterBean>rxObserableSchedulerHelper()).subscribe(
                new BaseObserver<RegisterBean>() {
                    @Override
                    public void onNext(RegisterBean loginBean) {
                        if (loginBean!=null){
                            resultCallBack.onSuccess(loginBean);
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

    public void getRegisterData(final ResultCallBack<LoginBean> resultCallBack, Map<String,Object> map) {
        Api navigationApi = HttpUtils.getInstance().getApiserver(Api.NAVIGATION_URL, Api.class);
        navigationApi.getRegisterData(map).compose(RxUtils.<LoginBean>rxObserableSchedulerHelper()).subscribe(
                new BaseObserver<LoginBean>() {
                    @Override
                    public void onNext(LoginBean RegisterBean) {
                        if (RegisterBean!=null){
                            resultCallBack.onSuccess(RegisterBean);
                        }
                    }

                    @Override
                    public void error(String msg) {
                        resultCallBack.onFail(msg);
                    }

                    @Override
                    protected void subscribe(Disposable d) {

                    }
                }
        );
    }
}
