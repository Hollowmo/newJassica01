package com.jassica.jassica.mvp.prestent;

import com.jassica.jassica.base.BasePresenter;
import com.jassica.jassica.bean.ClassifyBean;
import com.jassica.jassica.bean.TimeZoneBean;
import com.jassica.jassica.mvp.model.ClassifyModel;
import com.jassica.jassica.mvp.model.TimeZongModel;
import com.jassica.jassica.mvp.view.EmptyView;
import com.jassica.jassica.mvp.view.TimeZongView;
import com.jassica.jassica.net.ResultCallBack;

public class TimeZongPrestent extends BasePresenter<TimeZongView> {
    private TimeZongModel mTimeZongModel;

    @Override
    protected void initModel() {
        mTimeZongModel = new TimeZongModel();
        mModels.add(mTimeZongModel);
    }
    public void getTimeZong(){
        mTimeZongModel.getData(new ResultCallBack<TimeZoneBean>() {
            @Override
            public void onSuccess(TimeZoneBean bean) {
                if (bean!=null){
                    if (mMvpView!=null){
                        mMvpView.getTimeZongDatas(bean);
                    }
                }
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }
}
