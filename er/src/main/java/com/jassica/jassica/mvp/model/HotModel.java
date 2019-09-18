package com.jassica.jassica.mvp.model;

import com.jassica.jassica.api.Api;
import com.jassica.jassica.base.BaseModel;
import com.jassica.jassica.bean.NewHotBean;
import com.jassica.jassica.net.BaseObserver;
import com.jassica.jassica.net.HttpUtils;
import com.jassica.jassica.net.ResultCallBack;
import com.jassica.jassica.net.RxUtils;

import java.util.HashMap;

import io.reactivex.disposables.Disposable;

public class HotModel extends BaseModel {

    public void getData(HashMap<String,String> map,final ResultCallBack<NewHotBean> resultCallBack) {
        Api navigationApi = HttpUtils.getInstance().getApiserver(Api.NAVIGATION_URL, Api.class);
        navigationApi.getHotData(map).compose(RxUtils.<NewHotBean>rxObserableSchedulerHelper()).subscribe(
                new BaseObserver<NewHotBean>() {
                    @Override
                    public void onNext(NewHotBean classifyBean) {
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
