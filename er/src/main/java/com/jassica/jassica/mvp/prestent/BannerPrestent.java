package com.jassica.jassica.mvp.prestent;

import com.jassica.jassica.base.BasePresenter;
import com.jassica.jassica.bean.HomeBannerBean;
import com.jassica.jassica.mvp.model.BannerModel;
import com.jassica.jassica.mvp.view.BannerView;
import com.jassica.jassica.net.ResultCallBack;

public class BannerPrestent extends BasePresenter<BannerView> {
    private BannerModel bannerModel;

    @Override
    protected void initModel() {
        bannerModel = new BannerModel();
        mModels.add(bannerModel);
    }

    public void getBanner() {
        bannerModel.getBanner(new ResultCallBack<HomeBannerBean>() {
            @Override
            public void onSuccess(HomeBannerBean bean) {
                if (bean!=null){
                    if (mMvpView!=null){
                        mMvpView.setBanner(bean);
                    }
                }
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }

 /*   public void gettop() {
        bannerModel.gettop(new ResultCallBack<HomeTopBean>() {
            @Override
            public void onSuccess(HomeTopBean bean) {
                if (bean!=null){
                    if (mMvpView!=null){
                        mMvpView.setTop(bean);
                    }
                }
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }*/
}
