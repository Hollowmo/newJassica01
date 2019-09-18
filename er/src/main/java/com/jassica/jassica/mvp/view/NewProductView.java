package com.jassica.jassica.mvp.view;

import com.jassica.jassica.base.BaseView;
import com.jassica.jassica.bean.NewProductBean;

public interface NewProductView extends BaseView {
    void getNewProductDatas(NewProductBean bean);
}
