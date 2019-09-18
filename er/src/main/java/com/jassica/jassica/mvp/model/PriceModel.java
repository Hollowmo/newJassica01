package com.jassica.jassica.mvp.model;

import com.jassica.jassica.api.Api;
import com.jassica.jassica.base.BaseModel;
import com.jassica.jassica.bean.PriceBean;
import com.jassica.jassica.net.BaseObserver;
import com.jassica.jassica.net.HttpUtils;
import com.jassica.jassica.net.ResultCallBack;
import com.jassica.jassica.net.RxUtils;

import java.util.HashMap;

import io.reactivex.disposables.Disposable;

public class PriceModel extends BaseModel {

    public void PriceData(HashMap<String,String> map, final ResultCallBack<PriceBean> resultCallBack) {
        Api navigationApi = HttpUtils.getInstance().getApiserver(Api.NAVIGATION_URL, Api.class);
        navigationApi.getPriceData(map).compose(RxUtils.<PriceBean>rxObserableSchedulerHelper()).subscribe(
                new BaseObserver<PriceBean>() {
                    @Override
                    public void onNext(PriceBean classifyBean) {
                        if (classifyBean!=null){
                            resultCallBack.onSuccess(classifyBean);
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
