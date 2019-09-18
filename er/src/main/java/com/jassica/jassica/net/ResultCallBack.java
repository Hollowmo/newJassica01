package com.jassica.jassica.net;

import com.jassica.jassica.Database.DbBean;

import java.util.List;

/**
 * @author xts
 * Created by asus on 2019/4/2.
 */

public interface ResultCallBack<T> {
    void onSuccess(T bean);
    void onFail(String msg);

}
