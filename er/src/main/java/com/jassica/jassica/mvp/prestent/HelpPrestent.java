package com.jassica.jassica.mvp.prestent;

import com.jassica.jassica.base.BasePresenter;
import com.jassica.jassica.bean.ClassifyBean;
import com.jassica.jassica.bean.HelpContentBean;
import com.jassica.jassica.mvp.model.ClassifyModel;
import com.jassica.jassica.mvp.model.HelpModel;
import com.jassica.jassica.mvp.view.EmptyView;
import com.jassica.jassica.mvp.view.HelpView;
import com.jassica.jassica.net.ResultCallBack;

import java.util.Map;

public class HelpPrestent extends BasePresenter<HelpView> {
    private HelpModel helpModel;

    @Override
    protected void initModel() {
        helpModel = new HelpModel();
        mModels.add(helpModel);
    }
    public void getHelpContent(){
        helpModel.getData(new ResultCallBack<HelpContentBean>() {
            @Override
            public void onSuccess(HelpContentBean bean) {
                if (bean!=null){
                    if (mMvpView!=null){
                        mMvpView.setHelpContent(bean);
                    }
                }
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }
}
