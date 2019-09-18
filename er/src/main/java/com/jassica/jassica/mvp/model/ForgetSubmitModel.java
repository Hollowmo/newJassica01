package com.jassica.jassica.mvp.model;

import com.jassica.jassica.api.Api;
import com.jassica.jassica.base.BaseModel;
import com.jassica.jassica.bean.ForNextBean;
import com.jassica.jassica.net.BaseObserver;
import com.jassica.jassica.net.HttpUtils;
import com.jassica.jassica.net.ResultCallBack;
import com.jassica.jassica.net.RxUtils;
import com.jassica.jassica.utils.Logger;

import java.util.Map;

import io.reactivex.disposables.Disposable;

public class ForgetSubmitModel extends BaseModel {

  /*  public void getForgetSubmitData(final ResultCallBack<ForgetSubmitBean> resultCallBack, Map<String,Object> map) {
        Api navigationApi = HttpUtils.getInstance().getApiserver(Api.NAVIGATION_URL, Api.class);
        navigationApi.getforgetSubmitData(map).compose(RxUtils.<ForgetSubmitBean>rxObserableSchedulerHelper()).subscribe(
                new BaseObserver<ForgetSubmitBean>() {
                    @Override
                    public void onNext(ForgetSubmitBean forgetSubmitBean) {
                        if (forgetSubmitBean!=null){
                            resultCallBack.onSuccess(forgetSubmitBean);
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
    }*/

    public void getForgetNextData(final ResultCallBack<ForNextBean> resultCallBack, Map<String, Object> map) {
        Api navigationApi = HttpUtils.getInstance().getApiserver(Api.NAVIGATION_URL, Api.class);
        navigationApi.getforgetNextData(map)
                .compose(RxUtils.<ForNextBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<ForNextBean>() {
                    @Override
                    public void onNext(ForNextBean forNextBean) {
                        if (forNextBean != null) {
                            resultCallBack.onSuccess(forNextBean);
                        }
                    }

                    @Override
                    public void error(String msg) {
                        Logger.logD("msg",msg);
                    }

                    @Override
                    protected void subscribe(Disposable d) {
                        addDisposable(d);
                    }
                }
        );
    }
}
