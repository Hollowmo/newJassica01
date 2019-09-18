package com.jassica.jassica.mvp.model;

import com.jassica.jassica.api.Api;
import com.jassica.jassica.base.BaseModel;
import com.jassica.jassica.bean.RegisterBean;
import com.jassica.jassica.net.BaseObserver;
import com.jassica.jassica.net.HttpUtils;
import com.jassica.jassica.net.ResultCallBack;
import com.jassica.jassica.net.RxUtils;

import java.util.Map;

import io.reactivex.disposables.Disposable;

public class RegisterAModel extends BaseModel {
    public void getData(final ResultCallBack<RegisterBean> resultCallBack, Map<String,Object> map) {
        Api navigationApi = HttpUtils.getInstance().getApiserver(Api.NAVIGATION_URL, Api.class);
        navigationApi.getLoginNextData(map).compose(RxUtils.<RegisterBean>rxObserableSchedulerHelper()).subscribe(
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
}
