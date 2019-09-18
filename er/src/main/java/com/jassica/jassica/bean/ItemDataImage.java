package com.jassica.jassica.bean;

public class ItemDataImage {

    /**
     * image : image/50/5f/505f1cc1ad26ad5ebb0620fa5e544ac9.jpg
     * type : sales
     * data :
     * text :
     * goodsData :
     * imageUrl : https://upload.dev.kingpower-cn.com/image/50/5f/505f1cc1ad26ad5ebb0620fa5e544ac9.jpg
     */

    private String image;
    private String type;
    private String data;
    private String text;
    private String goodsData;
    private String imageUrl;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getGoodsData() {
        return goodsData;
    }

    public void setGoodsData(String goodsData) {
        this.goodsData = goodsData;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "ItemDataImage{" +
                "image='" + image + '\'' +
                ", type='" + type + '\'' +
                ", data='" + data + '\'' +
                ", text='" + text + '\'' +
                ", goodsData='" + goodsData + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
