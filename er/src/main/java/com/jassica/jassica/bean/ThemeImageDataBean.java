package com.jassica.jassica.bean;
/*
* 开屏
* */
public class ThemeImageDataBean {

    /**
     * linkText :
     * linkType : url
     * linkValue : www.baidu.com
     * themeImage : image/09/7c/097c0ecc421a6dd1ab72c20b5568676b.jpg
     * themeImageUrl : https://upload.dev.kingpower-cn.com/image/09/7c/097c0ecc421a6dd1ab72c20b5568676b.jpg
     */

    private String linkText;
    private String linkType;
    private String linkValue;
    private String themeImage;
    private String themeImageUrl;

    public String getLinkText() {
        return linkText;
    }

    public void setLinkText(String linkText) {
        this.linkText = linkText;
    }

    public String getLinkType() {
        return linkType;
    }

    public void setLinkType(String linkType) {
        this.linkType = linkType;
    }

    public String getLinkValue() {
        return linkValue;
    }

    public void setLinkValue(String linkValue) {
        this.linkValue = linkValue;
    }

    public String getThemeImage() {
        return themeImage;
    }

    public void setThemeImage(String themeImage) {
        this.themeImage = themeImage;
    }

    public String getThemeImageUrl() {
        return themeImageUrl;
    }

    public void setThemeImageUrl(String themeImageUrl) {
        this.themeImageUrl = themeImageUrl;
    }
}
