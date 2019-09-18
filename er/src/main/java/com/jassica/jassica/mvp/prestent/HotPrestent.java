package com.jassica.jassica.mvp.prestent;

import com.jassica.jassica.base.BasePresenter;
import com.jassica.jassica.bean.NewHotBean;
import com.jassica.jassica.mvp.model.HotModel;
import com.jassica.jassica.mvp.view.HotView;
import com.jassica.jassica.net.ResultCallBack;

import java.util.HashMap;

public class HotPrestent extends BasePresenter<HotView> {
    private HotModel hotModel;

    @Override
    protected void initModel() {
        hotModel = new HotModel();
        mModels.add(hotModel);
    }
    public void getHot(HashMap<String,String> map){
        hotModel.getData(map,new ResultCallBack<NewHotBean>() {
            @Override
            public void onSuccess(NewHotBean bean) {
                if (bean!=null){
                    if (mMvpView!=null){
                        mMvpView.getHotDatas(bean);
                    }
                }
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }

}
