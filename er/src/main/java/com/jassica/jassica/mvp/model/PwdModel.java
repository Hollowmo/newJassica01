package com.jassica.jassica.mvp.model;

import com.jassica.jassica.api.Api;
import com.jassica.jassica.base.BaseModel;
import com.jassica.jassica.bean.PwdLoginBean;
import com.jassica.jassica.net.BaseObserver;
import com.jassica.jassica.net.HttpUtils;
import com.jassica.jassica.net.ResultCallBack;
import com.jassica.jassica.net.RxUtils;

import java.util.Map;

import io.reactivex.disposables.Disposable;

public class PwdModel extends BaseModel {

    public void getPwdLoginData(final ResultCallBack<PwdLoginBean> resultCallBack, Map<String,Object> map) {
        Api navigationApi = HttpUtils.getInstance().getApiserver(Api.NAVIGATION_URL, Api.class);
        navigationApi.getPwdLoginData(map).compose(RxUtils.<PwdLoginBean>rxObserableSchedulerHelper()).subscribe(
                new BaseObserver<PwdLoginBean>() {
                    @Override
                    public void onNext(PwdLoginBean pwdLoginBean) {
                        if (pwdLoginBean!=null){
                            resultCallBack.onSuccess(pwdLoginBean);
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
