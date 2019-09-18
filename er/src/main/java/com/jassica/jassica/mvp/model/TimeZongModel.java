package com.jassica.jassica.mvp.model;

import com.jassica.jassica.api.Api;
import com.jassica.jassica.base.BaseModel;
import com.jassica.jassica.bean.ClassifyBean;
import com.jassica.jassica.bean.TimeZoneBean;
import com.jassica.jassica.net.BaseObserver;
import com.jassica.jassica.net.HttpUtils;
import com.jassica.jassica.net.ResultCallBack;
import com.jassica.jassica.net.RxUtils;

import io.reactivex.disposables.Disposable;

public class TimeZongModel extends BaseModel {

    public void getData(final ResultCallBack<TimeZoneBean> resultCallBack) {
        Api navigationApi = HttpUtils.getInstance().getApiserver(Api.NAVIGATION_URL, Api.class);
        navigationApi.getTimeZongData().compose(RxUtils.<TimeZoneBean>rxObserableSchedulerHelper()).subscribe(
                new BaseObserver<TimeZoneBean>() {
                    @Override
                    public void onNext(TimeZoneBean timeZoneBean) {
                        if (timeZoneBean!=null){
                            resultCallBack.onSuccess(timeZoneBean);
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
