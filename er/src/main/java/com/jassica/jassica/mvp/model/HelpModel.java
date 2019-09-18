package com.jassica.jassica.mvp.model;

import com.jassica.jassica.api.Api;
import com.jassica.jassica.base.BaseModel;
import com.jassica.jassica.bean.ClassifyBean;
import com.jassica.jassica.bean.HelpContentBean;
import com.jassica.jassica.net.BaseObserver;
import com.jassica.jassica.net.HttpUtils;
import com.jassica.jassica.net.ResultCallBack;
import com.jassica.jassica.net.RxUtils;

import java.util.Map;

import io.reactivex.disposables.Disposable;

public class HelpModel extends BaseModel {
    public void getData(final ResultCallBack<HelpContentBean> resultCallBack) {
        Api navigationApi = HttpUtils.getInstance().getApiserver(Api.HELPCONTENT_URL, Api.class);
        navigationApi.getHelpContent().compose(RxUtils.<HelpContentBean>rxObserableSchedulerHelper()).subscribe(
                new BaseObserver<HelpContentBean>() {
                    @Override
                    public void onNext(HelpContentBean classifyBean) {
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
