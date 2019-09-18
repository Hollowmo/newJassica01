package com.jassica.jassica.bean;

public class ExchangeBean {

    /**
     * wx : 0.233
     * unionPay : 0.23499654
     * aliPay : 0.23832
     * originalCountryLogo : http://app.newinterface.jescard.com/img/country_logo/taiguo.png
     * targetCountryLogo : http://app.newinterface.jescard.com/img/country_logo/China.png
     * time : 2019-09-09 09:00:00
     */

    private double wx;
    private double unionPay;
    private double aliPay;
    private String originalCountryLogo;
    private String targetCountryLogo;
    private String time;

    public double getWx() {
        return wx;
    }

    public void setWx(double wx) {
        this.wx = wx;
    }

    public double getUnionPay() {
        return unionPay;
    }

    public void setUnionPay(double unionPay) {
        this.unionPay = unionPay;
    }

    public double getAliPay() {
        return aliPay;
    }

    public void setAliPay(double aliPay) {
        this.aliPay = aliPay;
    }

    public String getOriginalCountryLogo() {
        return originalCountryLogo;
    }

    public void setOriginalCountryLogo(String originalCountryLogo) {
        this.originalCountryLogo = originalCountryLogo;
    }

    public String getTargetCountryLogo() {
        return targetCountryLogo;
    }

    public void setTargetCountryLogo(String targetCountryLogo) {
        this.targetCountryLogo = targetCountryLogo;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
