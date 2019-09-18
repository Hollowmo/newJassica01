package com.jassica.jassica.net;

import com.jassica.jassica.Database.DbBean;

import java.util.List;

/**
 * Created by Lenovo on 2019/3/24.
 */

public interface CallBack {
    void OnSuccess(List<DbBean> bean);
    void OnFail(String str);

}
