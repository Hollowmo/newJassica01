package com.jassica.jassica.mvp.prestent;

import com.jassica.jassica.base.BasePresenter;
import com.jassica.jassica.bean.ClassifyBean;
import com.jassica.jassica.mvp.model.ClassifyModel;
import com.jassica.jassica.mvp.view.ClassifyView;
import com.jassica.jassica.net.ResultCallBack;

public class ClassifyPrestent extends BasePresenter<ClassifyView> {
    private ClassifyModel mClassifyModel;

    @Override
    protected void initModel() {
        mClassifyModel = new ClassifyModel();
        mModels.add(mClassifyModel);
    }
    public void getNavigation(){
        mClassifyModel.getData(new ResultCallBack<ClassifyBean>() {
            @Override
            public void onSuccess(ClassifyBean bean) {
                if (bean!=null){
                    if (mMvpView!=null){
                        mMvpView.getDatas(bean);
                    }
                }
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }
}
