package com.jassica.jassica.api;

import com.jassica.jassica.bean.ClassifyBean;
import com.jassica.jassica.bean.ForNextBean;
import com.jassica.jassica.bean.ForgetSubmitBean;
import com.jassica.jassica.bean.GenverifiCodeBean;
import com.jassica.jassica.bean.HelpContentBean;
import com.jassica.jassica.bean.HomeBannerBean;
import com.jassica.jassica.bean.LoginBean;
import com.jassica.jassica.bean.NewHotBean;
import com.jassica.jassica.bean.NewProductBean;
import com.jassica.jassica.bean.PhoneBean;
import com.jassica.jassica.bean.PriceBean;
import com.jassica.jassica.bean.PwdLoginBean;
import com.jassica.jassica.bean.RegisterBean;
import com.jassica.jassica.bean.ScreenBean;
import com.jassica.jassica.bean.SerachBean;
import com.jassica.jassica.bean.ThemeImageBean;
import com.jassica.jassica.bean.TimeZoneBean;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface Api {
    String NAVIGATION_URL = "https://api.dev.kingpower-cn.com/";

    //分类
    @GET("category/list")
    Observable<ClassifyBean> getClassify();

    //首页banner轮播图
    String BANNER_URL = "https://api.dev.kingpower-cn.com";
    @POST("/")
    Observable<HomeBannerBean> getBanner();

    //获取验证码图片
    @GET("/captcha/makecaptchakey")
    Observable<GenverifiCodeBean> getVerifiCode();

    //注册
    @POST("/loginconnect/mobile/register")
    @FormUrlEncoded
    Observable<LoginBean> getRegisterData(@FieldMap Map<String, Object> map);

    //下一步
    @POST("/loginconnect/mobile/registerFirst")
    @FormUrlEncoded
    Observable<RegisterBean> getLoginNextData(@FieldMap Map<String, Object> map);

    //手机获取验证码
//    https://api.staging.taihaitao.com/loginconnect/smscode/send?mobile=16619950997&captchaKey=6afb58d6f969829f01ae7a002a3e7a6f&captchaVal=en83&sendType=1
    @GET("/loginconnect/smscode/send?")
    Observable<RegisterBean> getLogin2Data(@QueryMap Map<String, Object> map);

    //普通登陸
    @POST("/login")
    @FormUrlEncoded
    Observable<PwdLoginBean> getPwdLoginData(@FieldMap Map<String, Object> map);

    //手机号登陸
    @POST("/loginconnect/mobile/login")
    @FormUrlEncoded
    Observable<PhoneBean> getPhoneLoginData(@FieldMap Map<String, Object> map);

    //重置密码
    @POST("/loginconnect/mobile/registerFirst")
    @FormUrlEncoded
    Observable<ForNextBean> getforgetNextData(@FieldMap Map<String, Object> map);

    //重置密码提交
    @POST("/loginconnect/smscode/send")
    @FormUrlEncoded
    Observable<ForgetSubmitBean> getforgetSubmitData(@FieldMap Map<String, Object> map);

    //帮助中心
    String HELPCONTENT_URL = "https://api.dev.kingpower-cn.com/";
    @GET("/get/helpCenterArticleList")
    Observable<HelpContentBean> getHelpContent();

    //开屏广告
    @GET("coopen/list/app")
    Observable<ThemeImageBean> getThemeImage();

    //搜索框
    @GET("/search/default/keyword")
    Observable<SerachBean> getSerachData();

    //全部商品 热销
    @GET("/search")
    Observable<NewHotBean> getHotData(@QueryMap HashMap<String,String> map);

    //全部商品 价格
    @GET("/search")
    Observable<PriceBean> getPriceData(@QueryMap HashMap<String,String> map);

    //全部商品 新品
    String VERSION = "version";
    String DEVICEID = "deviceId";
    String PAGESIZE = "pageSize";
    String SORT = "sort";
    String PAGE = "page";

    @GET("/search")
    Observable<NewProductBean> getNewProductData(@QueryMap HashMap<String,String> map);

    //全部商品筛选列表框
    @GET("/goodsSeachCondition")
    Observable<ScreenBean> getScreenData();

    //首页限时折扣更多
    @GET("/discountSearch")
    Observable<TimeZoneBean> getTimeZongData();
}
