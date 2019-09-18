package com.jassica.jassica.mvp.model;

import com.jassica.jassica.api.Api;
import com.jassica.jassica.base.BaseModel;
import com.jassica.jassica.bean.ClassifyBean;
import com.jassica.jassica.net.BaseObserver;
import com.jassica.jassica.net.HttpUtils;
import com.jassica.jassica.net.ResultCallBack;
import com.jassica.jassica.net.RxUtils;

import io.reactivex.disposables.Disposable;

public class ClassifyModel extends BaseModel {
    public void getData(final ResultCallBack<ClassifyBean> resultCallBack) {
        Api navigationApi = HttpUtils.getInstance().getApiserver(Api.NAVIGATION_URL, Api.class);
        navigationApi.getClassify().compose(RxUtils.<ClassifyBean>rxObserableSchedulerHelper()).subscribe(
                new BaseObserver<ClassifyBean>() {
                    @Override
                    public void onNext(ClassifyBean classifyBean) {
                        if (classifyBean!=null){
                            resultCallBack.onSuccess(classifyBean);
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
