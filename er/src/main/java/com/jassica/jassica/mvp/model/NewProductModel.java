package com.jassica.jassica.mvp.model;

import com.jassica.jassica.api.Api;
import com.jassica.jassica.base.BaseModel;
import com.jassica.jassica.bean.NewProductBean;
import com.jassica.jassica.net.BaseObserver;
import com.jassica.jassica.net.HttpUtils;
import com.jassica.jassica.net.ResultCallBack;
import com.jassica.jassica.net.RxUtils;

import java.util.HashMap;

import io.reactivex.disposables.Disposable;

public class NewProductModel extends BaseModel {

    public void getNewProductData(HashMap<String,String> map,
                                  final ResultCallBack<NewProductBean> resultCallBack) {
        Api navigationApi = HttpUtils.getInstance().getApiserver(Api.NAVIGATION_URL, Api.class);
        navigationApi.getNewProductData(map)
                .compose(RxUtils.<NewProductBean>rxObserableSchedulerHelper())
                .subscribe(
                new BaseObserver<NewProductBean>() {
                    @Override
                    public void onNext(NewProductBean classifyBean) {
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
