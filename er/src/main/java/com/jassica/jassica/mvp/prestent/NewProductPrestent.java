package com.jassica.jassica.mvp.prestent;

import com.jassica.jassica.base.BasePresenter;
import com.jassica.jassica.bean.NewProductBean;
import com.jassica.jassica.mvp.model.NewProductModel;
import com.jassica.jassica.mvp.view.NewProductView;
import com.jassica.jassica.net.ResultCallBack;

import java.util.HashMap;

public class NewProductPrestent extends BasePresenter<NewProductView> {
    private NewProductModel mNewProductModel;

    @Override
    protected void initModel() {
        mNewProductModel = new NewProductModel();
        mModels.add(mNewProductModel);
    }
    public void getNewProduct(HashMap<String,String> map){
        mNewProductModel.getNewProductData(map,new ResultCallBack<NewProductBean>() {
            @Override
            public void onSuccess(NewProductBean bean) {
                if (bean!=null){
                    if (mMvpView!=null){
                        mMvpView.getNewProductDatas(bean);
                    }
                }
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }

}
