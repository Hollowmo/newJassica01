package com.jassica.jassica.mvp.view;

import com.jassica.jassica.base.BaseView;
import com.jassica.jassica.bean.NewHotBean;

public interface HotView extends BaseView {
    void getHotDatas(NewHotBean bean);
}
