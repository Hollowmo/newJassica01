package com.jassica.jassica.mvp.view;

import com.jassica.jassica.base.BaseView;
import com.jassica.jassica.bean.ForNextBean;
import com.jassica.jassica.bean.RegisterBean;

public interface ForgetNextView extends BaseView {
    void getForgetNextDatas(RegisterBean bean);

    void getForNextData(RegisterBean bean);
}
