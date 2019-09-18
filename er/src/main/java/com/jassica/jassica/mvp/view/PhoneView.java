package com.jassica.jassica.mvp.view;

import com.jassica.jassica.base.BaseView;
import com.jassica.jassica.bean.RegisterBean;
import com.jassica.jassica.bean.PhoneBean;

public interface PhoneView extends BaseView {
    void getPhoneLoginDatas(PhoneBean bean);

    void getPhoneLoginNoteDatas(RegisterBean bean);
}
