package com.jassica.jassica.mvp.view;

import com.jassica.jassica.base.BaseView;
import com.jassica.jassica.bean.ClassifyBean;
import com.jassica.jassica.bean.TimeZoneBean;

public interface TimeZongView extends BaseView {
    void getTimeZongDatas(TimeZoneBean bean);
}
