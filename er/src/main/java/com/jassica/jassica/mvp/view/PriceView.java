package com.jassica.jassica.mvp.view;

import com.jassica.jassica.base.BaseView;
import com.jassica.jassica.bean.PriceBean;

public interface PriceView extends BaseView {
    void getPriceDatas(PriceBean bean);
}
