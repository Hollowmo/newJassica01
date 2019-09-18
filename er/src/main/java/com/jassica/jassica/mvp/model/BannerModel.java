package com.jassica.jassica.mvp.model;

import com.jassica.jassica.api.Api;
import com.jassica.jassica.base.BaseModel;
import com.jassica.jassica.bean.HomeBannerBean;
import com.jassica.jassica.net.BaseObserver;
import com.jassica.jassica.net.HttpUtils;
import com.jassica.jassica.net.ResultCallBack;
import com.jassica.jassica.net.RxUtils;

import io.reactivex.disposables.Disposable;

public class BannerModel extends BaseModel {
    public void getBanner(final ResultCallBack<HomeBannerBean> resultCallBack) {
        Api apiserver = HttpUtils.getInstance().getApiserver(Api.BANNER_URL, Api.class);
        apiserver.getBanner().compose(RxUtils.<HomeBannerBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<HomeBannerBean>() {
                    @Override//你打degug看看这个里面有没有数据
                    public void onNext(HomeBannerBean homeBannerBean) {

                        if (homeBannerBean != null) {
                            resultCallBack.onSuccess(homeBannerBean);
                        } else {
                            resultCallBack.onFail("错误");
                        }
                    }

                    @Override
                    public void error(String msg) {
                        resultCallBack.onFail(msg);
                    }

                    @Override
                    protected void subscribe(Disposable d) {
                        addDisposable(d);
                    }
                });
    }

    /*public void gettop(final ResultCallBack<HomeTopBean> resultCallBack) {
        HomeApi apiserver = HttpUtils.getInstance().getApiserver(HomeApi.RvUrl, HomeApi.class);
        apiserver.getHomeTop().compose(RxUtils.<HomeTopBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<HomeTopBean>() {
                    @Override
                    public void onNext(HomeTopBean homeTopBean) {

                        if (homeTopBean != null) {
                            resultCallBack.onSuccess(homeTopBean);
                        } else {
                            resultCallBack.onFail("错误");
                        }
                    }

                    @Override
                    public void error(String msg) {
                        resultCallBack.onFail(msg);
                    }

                    @Override
                    protected void subscribe(Disposable d) {
                        addDisposable(d);
                    }
                });


    }*/
}
