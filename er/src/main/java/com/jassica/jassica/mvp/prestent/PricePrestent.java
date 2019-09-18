package com.jassica.jassica.mvp.prestent;

import com.jassica.jassica.base.BasePresenter;
import com.jassica.jassica.bean.PriceBean;
import com.jassica.jassica.mvp.model.PriceModel;
import com.jassica.jassica.mvp.view.PriceView;
import com.jassica.jassica.net.ResultCallBack;

import java.util.HashMap;

public class PricePrestent extends BasePresenter<PriceView> {
    private PriceModel mPriceModel;

    @Override
    protected void initModel() {
        mPriceModel = new PriceModel();
        mModels.add(mPriceModel);
    }
    public void getPrice(HashMap<String,String> map){

        mPriceModel.PriceData(map,new ResultCallBack<PriceBean>() {
            @Override
            public void onSuccess(PriceBean bean) {
                if (bean!=null){
                    if (mMvpView!=null){
                        mMvpView.getPriceDatas(bean);
                    }
                }
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }

}
