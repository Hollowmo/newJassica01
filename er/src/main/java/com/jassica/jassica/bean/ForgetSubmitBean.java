package com.jassica.jassica.bean;

public class ForgetSubmitBean {

    /**
     * mobile : 15501222222
     * captchaKey : db580a9b8a488048ccb573d1557e6b73
     * captchaVal : db58
     * sendType : 2
     */

    private String mobile;
    private String captchaKey;
    private String captchaVal;
    private String sendType;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCaptchaKey() {
        return captchaKey;
    }

    public void setCaptchaKey(String captchaKey) {
        this.captchaKey = captchaKey;
    }

    public String getCaptchaVal() {
        return captchaVal;
    }

    public void setCaptchaVal(String captchaVal) {
        this.captchaVal = captchaVal;
    }

    public String getSendType() {
        return sendType;
    }

    public void setSendType(String sendType) {
        this.sendType = sendType;
    }
}
