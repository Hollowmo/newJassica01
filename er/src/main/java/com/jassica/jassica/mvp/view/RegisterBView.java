package com.jassica.jassica.mvp.view;

import com.jassica.jassica.base.BaseView;
import com.jassica.jassica.bean.RegisterBean;
import com.jassica.jassica.bean.LoginBean;

public interface RegisterBView extends BaseView {
    void getLogin2Datas(RegisterBean bean);

    void getRegisterDatas(LoginBean bean);
}
