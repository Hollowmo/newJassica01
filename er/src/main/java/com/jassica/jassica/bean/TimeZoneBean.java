package com.jassica.jassica.bean;

import java.util.List;

public class TimeZoneBean {

    /**
     * code : 200
     * datas : {"pageEntity":{"hasMore":false,"totalPage":1},"goodsTotal":1,"goodsList":[{"commonId":736,"goodsName":"规格测试商品禁用","goodsNameHighlight":"规格测试商品禁用","jingle":"","categoryId":34,"storeId":1,"brandId":7,"goodsState":1,"goodsVerify":1,"goodsStatus":2,"areaInfo":"","goodsFreight":0,"freightTemplateId":0,"batchNum0":1,"batchNum0End":0,"batchNum1":0,"batchNum1End":0,"batchNum2":0,"batchPrice0":0,"batchPrice1":0,"batchPrice2":0,"webPrice0":9,"webPrice1":9,"webPrice2":9,"webPriceMin":9,"webUsable":1,"appPrice0":9,"appPrice1":9,"appPrice2":9,"appPriceMin":9,"appUsable":1,"wechatPrice0":9,"wechatPrice1":9,"wechatPrice2":9,"wechatPriceMin":9,"wechatUsable":1,"unitName":"瓶","promotionId":129,"promotionStartTime":"2019-09-11 17:46:39","promotionEndTime":"2019-09-18 17:45:41","promotionState":1,"promotionType":1,"promotionTypeText":"限时折扣","goodsModal":4,"goodsFavorite":3,"evaluateNum":0,"goodsRate":100,"goodsSaleNum":0,"imageName":"image/2a/88/2a88f1b5b3b3a722b9d2289eecbb1bd5.jpg","imageSrc":"https://upload.dev.kingpower-cn.com/image/2a/88/2a88f1b5b3b3a722b9d2289eecbb1bd5.jpg","isGift":0,"categoryName":"芒果干","storeName":"官方店铺","isOwnShop":1,"sellerId":1,"commissionRate":0,"webCommission":0,"appCommission":0,"wechatCommission":0,"usableVoucher":0,"ordersCount":0,"commissionTotal":0,"isOnline":0,"goodsId":0,"goodsSpec":"","extendString0":"315","extendString1":"","extendString2":"","extendString3":"","extendString4":"","extendString5":"","extendString6":"","extendString7":"","extendString8":"","extendString9":"","extendInt0":0,"extendInt1":0,"extendInt2":0,"extendInt3":2,"extendInt4":20,"extendInt5":1,"extendInt6":1,"extendInt7":1,"extendInt8":124,"extendInt9":0,"extendPrice0":9,"extendPrice1":0,"extendPrice2":0,"extendPrice3":0,"extendPrice4":0,"extendPrice5":0,"extendPrice6":0,"extendPrice7":0,"extendPrice8":0,"extendPrice9":0,"extendTime0":"2019-09-11 17:46:07","extendTime1":"","extendTime2":"","extendTime3":"","extendTime4":"","extendTime5":"","extendTime6":"","extendTime7":"","extendTime8":"","extendTime9":"","goodsImageList":[{"imageId":4746,"commonId":736,"colorId":6,"imageName":"image/91/e7/91e7e4c110e6a75a7446c966a5ea839c.jpg","imageSort":0,"isDefault":1,"imageSrc":"https://upload.dev.kingpower-cn.com/image/91/e7/91e7e4c110e6a75a7446c966a5ea839c.jpg"},{"imageId":4747,"commonId":736,"colorId":10,"imageName":"image/e3/6d/e36ddd5949c3f6e4ffbc1c3def2cca7f.jpg","imageSort":0,"isDefault":1,"imageSrc":"https://upload.dev.kingpower-cn.com/image/e3/6d/e36ddd5949c3f6e4ffbc1c3def2cca7f.jpg"},{"imageId":4748,"commonId":736,"colorId":11,"imageName":"image/2a/88/2a88f1b5b3b3a722b9d2289eecbb1bd5.jpg","imageSort":0,"isDefault":1,"imageSrc":"https://upload.dev.kingpower-cn.com/image/2a/88/2a88f1b5b3b3a722b9d2289eecbb1bd5.jpg"}],"goodsList":[],"batchNumPriceVoList":[{"num":"≥1","price":"9.00"}],"kpProductType":null,"goodsStorage":0,"brandName":"8 MIRACLES","brandEnglish":"8 MIRACLES","rmbWebPrice":2.11,"rmbAppPrice":2.11,"rmbWeChatPrice":2.11,"discountRate":0,"monthSaleNum":0,"monthPromotion":false,"specialType":null}],"promotionEndTime":570964074}
     */

    private int code;
    private DatasBean datas;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DatasBean getDatas() {
        return datas;
    }

    public void setDatas(DatasBean datas) {
        this.datas = datas;
    }

    public static class DatasBean {
        /**
         * pageEntity : {"hasMore":false,"totalPage":1}
         * goodsTotal : 1
         * goodsList : [{"commonId":736,"goodsName":"规格测试商品禁用","goodsNameHighlight":"规格测试商品禁用","jingle":"","categoryId":34,"storeId":1,"brandId":7,"goodsState":1,"goodsVerify":1,"goodsStatus":2,"areaInfo":"","goodsFreight":0,"freightTemplateId":0,"batchNum0":1,"batchNum0End":0,"batchNum1":0,"batchNum1End":0,"batchNum2":0,"batchPrice0":0,"batchPrice1":0,"batchPrice2":0,"webPrice0":9,"webPrice1":9,"webPrice2":9,"webPriceMin":9,"webUsable":1,"appPrice0":9,"appPrice1":9,"appPrice2":9,"appPriceMin":9,"appUsable":1,"wechatPrice0":9,"wechatPrice1":9,"wechatPrice2":9,"wechatPriceMin":9,"wechatUsable":1,"unitName":"瓶","promotionId":129,"promotionStartTime":"2019-09-11 17:46:39","promotionEndTime":"2019-09-18 17:45:41","promotionState":1,"promotionType":1,"promotionTypeText":"限时折扣","goodsModal":4,"goodsFavorite":3,"evaluateNum":0,"goodsRate":100,"goodsSaleNum":0,"imageName":"image/2a/88/2a88f1b5b3b3a722b9d2289eecbb1bd5.jpg","imageSrc":"https://upload.dev.kingpower-cn.com/image/2a/88/2a88f1b5b3b3a722b9d2289eecbb1bd5.jpg","isGift":0,"categoryName":"芒果干","storeName":"官方店铺","isOwnShop":1,"sellerId":1,"commissionRate":0,"webCommission":0,"appCommission":0,"wechatCommission":0,"usableVoucher":0,"ordersCount":0,"commissionTotal":0,"isOnline":0,"goodsId":0,"goodsSpec":"","extendString0":"315","extendString1":"","extendString2":"","extendString3":"","extendString4":"","extendString5":"","extendString6":"","extendString7":"","extendString8":"","extendString9":"","extendInt0":0,"extendInt1":0,"extendInt2":0,"extendInt3":2,"extendInt4":20,"extendInt5":1,"extendInt6":1,"extendInt7":1,"extendInt8":124,"extendInt9":0,"extendPrice0":9,"extendPrice1":0,"extendPrice2":0,"extendPrice3":0,"extendPrice4":0,"extendPrice5":0,"extendPrice6":0,"extendPrice7":0,"extendPrice8":0,"extendPrice9":0,"extendTime0":"2019-09-11 17:46:07","extendTime1":"","extendTime2":"","extendTime3":"","extendTime4":"","extendTime5":"","extendTime6":"","extendTime7":"","extendTime8":"","extendTime9":"","goodsImageList":[{"imageId":4746,"commonId":736,"colorId":6,"imageName":"image/91/e7/91e7e4c110e6a75a7446c966a5ea839c.jpg","imageSort":0,"isDefault":1,"imageSrc":"https://upload.dev.kingpower-cn.com/image/91/e7/91e7e4c110e6a75a7446c966a5ea839c.jpg"},{"imageId":4747,"commonId":736,"colorId":10,"imageName":"image/e3/6d/e36ddd5949c3f6e4ffbc1c3def2cca7f.jpg","imageSort":0,"isDefault":1,"imageSrc":"https://upload.dev.kingpower-cn.com/image/e3/6d/e36ddd5949c3f6e4ffbc1c3def2cca7f.jpg"},{"imageId":4748,"commonId":736,"colorId":11,"imageName":"image/2a/88/2a88f1b5b3b3a722b9d2289eecbb1bd5.jpg","imageSort":0,"isDefault":1,"imageSrc":"https://upload.dev.kingpower-cn.com/image/2a/88/2a88f1b5b3b3a722b9d2289eecbb1bd5.jpg"}],"goodsList":[],"batchNumPriceVoList":[{"num":"≥1","price":"9.00"}],"kpProductType":null,"goodsStorage":0,"brandName":"8 MIRACLES","brandEnglish":"8 MIRACLES","rmbWebPrice":2.11,"rmbAppPrice":2.11,"rmbWeChatPrice":2.11,"discountRate":0,"monthSaleNum":0,"monthPromotion":false,"specialType":null}]
         * promotionEndTime : 570964074
         */

        private PageEntityBean pageEntity;
        private int goodsTotal;
        private int promotionEndTime;
        private List<GoodsListBean> goodsList;

        public PageEntityBean getPageEntity() {
            return pageEntity;
        }

        public void setPageEntity(PageEntityBean pageEntity) {
            this.pageEntity = pageEntity;
        }

        public int getGoodsTotal() {
            return goodsTotal;
        }

        public void setGoodsTotal(int goodsTotal) {
            this.goodsTotal = goodsTotal;
        }

        public int getPromotionEndTime() {
            return promotionEndTime;
        }

        public void setPromotionEndTime(int promotionEndTime) {
            this.promotionEndTime = promotionEndTime;
        }

        public List<GoodsListBean> getGoodsList() {
            return goodsList;
        }

        public void setGoodsList(List<GoodsListBean> goodsList) {
            this.goodsList = goodsList;
        }

        public static class PageEntityBean {
            /**
             * hasMore : false
             * totalPage : 1
             */

            private boolean hasMore;
            private int totalPage;

            public boolean isHasMore() {
                return hasMore;
            }

            public void setHasMore(boolean hasMore) {
                this.hasMore = hasMore;
            }

            public int getTotalPage() {
                return totalPage;
            }

            public void setTotalPage(int totalPage) {
                this.totalPage = totalPage;
            }
        }

        public static class GoodsListBean {
            /**
             * commonId : 736
             * goodsName : 规格测试商品禁用
             * goodsNameHighlight : 规格测试商品禁用
             * jingle :
             * categoryId : 34
             * storeId : 1
             * brandId : 7
             * goodsState : 1
             * goodsVerify : 1
             * goodsStatus : 2
             * areaInfo :
             * goodsFreight : 0
             * freightTemplateId : 0
             * batchNum0 : 1
             * batchNum0End : 0
             * batchNum1 : 0
             * batchNum1End : 0
             * batchNum2 : 0
             * batchPrice0 : 0
             * batchPrice1 : 0
             * batchPrice2 : 0
             * webPrice0 : 9
             * webPrice1 : 9
             * webPrice2 : 9
             * webPriceMin : 9
             * webUsable : 1
             * appPrice0 : 9
             * appPrice1 : 9
             * appPrice2 : 9
             * appPriceMin : 9
             * appUsable : 1
             * wechatPrice0 : 9
             * wechatPrice1 : 9
             * wechatPrice2 : 9
             * wechatPriceMin : 9
             * wechatUsable : 1
             * unitName : 瓶
             * promotionId : 129
             * promotionStartTime : 2019-09-11 17:46:39
             * promotionEndTime : 2019-09-18 17:45:41
             * promotionState : 1
             * promotionType : 1
             * promotionTypeText : 限时折扣
             * goodsModal : 4
             * goodsFavorite : 3
             * evaluateNum : 0
             * goodsRate : 100
             * goodsSaleNum : 0
             * imageName : image/2a/88/2a88f1b5b3b3a722b9d2289eecbb1bd5.jpg
             * imageSrc : https://upload.dev.kingpower-cn.com/image/2a/88/2a88f1b5b3b3a722b9d2289eecbb1bd5.jpg
             * isGift : 0
             * categoryName : 芒果干
             * storeName : 官方店铺
             * isOwnShop : 1
             * sellerId : 1
             * commissionRate : 0
             * webCommission : 0
             * appCommission : 0
             * wechatCommission : 0
             * usableVoucher : 0
             * ordersCount : 0
             * commissionTotal : 0
             * isOnline : 0
             * goodsId : 0
             * goodsSpec :
             * extendString0 : 315
             * extendString1 :
             * extendString2 :
             * extendString3 :
             * extendString4 :
             * extendString5 :
             * extendString6 :
             * extendString7 :
             * extendString8 :
             * extendString9 :
             * extendInt0 : 0
             * extendInt1 : 0
             * extendInt2 : 0
             * extendInt3 : 2
             * extendInt4 : 20
             * extendInt5 : 1
             * extendInt6 : 1
             * extendInt7 : 1
             * extendInt8 : 124
             * extendInt9 : 0
             * extendPrice0 : 9
             * extendPrice1 : 0
             * extendPrice2 : 0
             * extendPrice3 : 0
             * extendPrice4 : 0
             * extendPrice5 : 0
             * extendPrice6 : 0
             * extendPrice7 : 0
             * extendPrice8 : 0
             * extendPrice9 : 0
             * extendTime0 : 2019-09-11 17:46:07
             * extendTime1 :
             * extendTime2 :
             * extendTime3 :
             * extendTime4 :
             * extendTime5 :
             * extendTime6 :
             * extendTime7 :
             * extendTime8 :
             * extendTime9 :
             * goodsImageList : [{"imageId":4746,"commonId":736,"colorId":6,"imageName":"image/91/e7/91e7e4c110e6a75a7446c966a5ea839c.jpg","imageSort":0,"isDefault":1,"imageSrc":"https://upload.dev.kingpower-cn.com/image/91/e7/91e7e4c110e6a75a7446c966a5ea839c.jpg"},{"imageId":4747,"commonId":736,"colorId":10,"imageName":"image/e3/6d/e36ddd5949c3f6e4ffbc1c3def2cca7f.jpg","imageSort":0,"isDefault":1,"imageSrc":"https://upload.dev.kingpower-cn.com/image/e3/6d/e36ddd5949c3f6e4ffbc1c3def2cca7f.jpg"},{"imageId":4748,"commonId":736,"colorId":11,"imageName":"image/2a/88/2a88f1b5b3b3a722b9d2289eecbb1bd5.jpg","imageSort":0,"isDefault":1,"imageSrc":"https://upload.dev.kingpower-cn.com/image/2a/88/2a88f1b5b3b3a722b9d2289eecbb1bd5.jpg"}]
             * goodsList : []
             * batchNumPriceVoList : [{"num":"≥1","price":"9.00"}]
             * kpProductType : null
             * goodsStorage : 0
             * brandName : 8 MIRACLES
             * brandEnglish : 8 MIRACLES
             * rmbWebPrice : 2.11
             * rmbAppPrice : 2.11
             * rmbWeChatPrice : 2.11
             * discountRate : 0
             * monthSaleNum : 0
             * monthPromotion : false
             * specialType : null
             */

            private int commonId;
            private String goodsName;
            private String goodsNameHighlight;
            private String jingle;
            private int categoryId;
            private int storeId;
            private int brandId;
            private int goodsState;
            private int goodsVerify;
            private int goodsStatus;
            private String areaInfo;
            private int goodsFreight;
            private int freightTemplateId;
            private int batchNum0;
            private int batchNum0End;
            private int batchNum1;
            private int batchNum1End;
            private int batchNum2;
            private int batchPrice0;
            private int batchPrice1;
            private int batchPrice2;
            private int webPrice0;
            private int webPrice1;
            private int webPrice2;
            private int webPriceMin;
            private int webUsable;
            private int appPrice0;
            private int appPrice1;
            private int appPrice2;
            private int appPriceMin;
            private int appUsable;
            private int wechatPrice0;
            private int wechatPrice1;
            private int wechatPrice2;
            private int wechatPriceMin;
            private int wechatUsable;
            private String unitName;
            private int promotionId;
            private String promotionStartTime;
            private String promotionEndTime;
            private int promotionState;
            private int promotionType;
            private String promotionTypeText;
            private int goodsModal;
            private int goodsFavorite;
            private int evaluateNum;
            private int goodsRate;
            private int goodsSaleNum;
            private String imageName;
            private String imageSrc;
            private int isGift;
            private String categoryName;
            private String storeName;
            private int isOwnShop;
            private int sellerId;
            private int commissionRate;
            private int webCommission;
            private int appCommission;
            private int wechatCommission;
            private int usableVoucher;
            private int ordersCount;
            private int commissionTotal;
            private int isOnline;
            private int goodsId;
            private String goodsSpec;
            private String extendString0;
            private String extendString1;
            private String extendString2;
            private String extendString3;
            private String extendString4;
            private String extendString5;
            private String extendString6;
            private String extendString7;
            private String extendString8;
            private String extendString9;
            private int extendInt0;
            private int extendInt1;
            private int extendInt2;
            private int extendInt3;
            private int extendInt4;
            private int extendInt5;
            private int extendInt6;
            private int extendInt7;
            private int extendInt8;
            private int extendInt9;
            private int extendPrice0;
            private int extendPrice1;
            private int extendPrice2;
            private int extendPrice3;
            private int extendPrice4;
            private int extendPrice5;
            private int extendPrice6;
            private int extendPrice7;
            private int extendPrice8;
            private int extendPrice9;
            private String extendTime0;
            private String extendTime1;
            private String extendTime2;
            private String extendTime3;
            private String extendTime4;
            private String extendTime5;
            private String extendTime6;
            private String extendTime7;
            private String extendTime8;
            private String extendTime9;
            private Object kpProductType;
            private int goodsStorage;
            private String brandName;
            private String brandEnglish;
            private double rmbWebPrice;
            private double rmbAppPrice;
            private double rmbWeChatPrice;
            private int discountRate;
            private int monthSaleNum;
            private boolean monthPromotion;
            private Object specialType;
            private List<GoodsImageListBean> goodsImageList;
            private List<?> goodsList;
            private List<BatchNumPriceVoListBean> batchNumPriceVoList;

            public int getCommonId() {
                return commonId;
            }

            public void setCommonId(int commonId) {
                this.commonId = commonId;
            }

            public String getGoodsName() {
                return goodsName;
            }

            public void setGoodsName(String goodsName) {
                this.goodsName = goodsName;
            }

            public String getGoodsNameHighlight() {
                return goodsNameHighlight;
            }

            public void setGoodsNameHighlight(String goodsNameHighlight) {
                this.goodsNameHighlight = goodsNameHighlight;
            }

            public String getJingle() {
                return jingle;
            }

            public void setJingle(String jingle) {
                this.jingle = jingle;
            }

            public int getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(int categoryId) {
                this.categoryId = categoryId;
            }

            public int getStoreId() {
                return storeId;
            }

            public void setStoreId(int storeId) {
                this.storeId = storeId;
            }

            public int getBrandId() {
                return brandId;
            }

            public void setBrandId(int brandId) {
                this.brandId = brandId;
            }

            public int getGoodsState() {
                return goodsState;
            }

            public void setGoodsState(int goodsState) {
                this.goodsState = goodsState;
            }

            public int getGoodsVerify() {
                return goodsVerify;
            }

            public void setGoodsVerify(int goodsVerify) {
                this.goodsVerify = goodsVerify;
            }

            public int getGoodsStatus() {
                return goodsStatus;
            }

            public void setGoodsStatus(int goodsStatus) {
                this.goodsStatus = goodsStatus;
            }

            public String getAreaInfo() {
                return areaInfo;
            }

            public void setAreaInfo(String areaInfo) {
                this.areaInfo = areaInfo;
            }

            public int getGoodsFreight() {
                return goodsFreight;
            }

            public void setGoodsFreight(int goodsFreight) {
                this.goodsFreight = goodsFreight;
            }

            public int getFreightTemplateId() {
                return freightTemplateId;
            }

            public void setFreightTemplateId(int freightTemplateId) {
                this.freightTemplateId = freightTemplateId;
            }

            public int getBatchNum0() {
                return batchNum0;
            }

            public void setBatchNum0(int batchNum0) {
                this.batchNum0 = batchNum0;
            }

            public int getBatchNum0End() {
                return batchNum0End;
            }

            public void setBatchNum0End(int batchNum0End) {
                this.batchNum0End = batchNum0End;
            }

            public int getBatchNum1() {
                return batchNum1;
            }

            public void setBatchNum1(int batchNum1) {
                this.batchNum1 = batchNum1;
            }

            public int getBatchNum1End() {
                return batchNum1End;
            }

            public void setBatchNum1End(int batchNum1End) {
                this.batchNum1End = batchNum1End;
            }

            public int getBatchNum2() {
                return batchNum2;
            }

            public void setBatchNum2(int batchNum2) {
                this.batchNum2 = batchNum2;
            }

            public int getBatchPrice0() {
                return batchPrice0;
            }

            public void setBatchPrice0(int batchPrice0) {
                this.batchPrice0 = batchPrice0;
            }

            public int getBatchPrice1() {
                return batchPrice1;
            }

            public void setBatchPrice1(int batchPrice1) {
                this.batchPrice1 = batchPrice1;
            }

            public int getBatchPrice2() {
                return batchPrice2;
            }

            public void setBatchPrice2(int batchPrice2) {
                this.batchPrice2 = batchPrice2;
            }

            public int getWebPrice0() {
                return webPrice0;
            }

            public void setWebPrice0(int webPrice0) {
                this.webPrice0 = webPrice0;
            }

            public int getWebPrice1() {
                return webPrice1;
            }

            public void setWebPrice1(int webPrice1) {
                this.webPrice1 = webPrice1;
            }

            public int getWebPrice2() {
                return webPrice2;
            }

            public void setWebPrice2(int webPrice2) {
                this.webPrice2 = webPrice2;
            }

            public int getWebPriceMin() {
                return webPriceMin;
            }

            public void setWebPriceMin(int webPriceMin) {
                this.webPriceMin = webPriceMin;
            }

            public int getWebUsable() {
                return webUsable;
            }

            public void setWebUsable(int webUsable) {
                this.webUsable = webUsable;
            }

            public int getAppPrice0() {
                return appPrice0;
            }

            public void setAppPrice0(int appPrice0) {
                this.appPrice0 = appPrice0;
            }

            public int getAppPrice1() {
                return appPrice1;
            }

            public void setAppPrice1(int appPrice1) {
                this.appPrice1 = appPrice1;
            }

            public int getAppPrice2() {
                return appPrice2;
            }

            public void setAppPrice2(int appPrice2) {
                this.appPrice2 = appPrice2;
            }

            public int getAppPriceMin() {
                return appPriceMin;
            }

            public void setAppPriceMin(int appPriceMin) {
                this.appPriceMin = appPriceMin;
            }

            public int getAppUsable() {
                return appUsable;
            }

            public void setAppUsable(int appUsable) {
                this.appUsable = appUsable;
            }

            public int getWechatPrice0() {
                return wechatPrice0;
            }

            public void setWechatPrice0(int wechatPrice0) {
                this.wechatPrice0 = wechatPrice0;
            }

            public int getWechatPrice1() {
                return wechatPrice1;
            }

            public void setWechatPrice1(int wechatPrice1) {
                this.wechatPrice1 = wechatPrice1;
            }

            public int getWechatPrice2() {
                return wechatPrice2;
            }

            public void setWechatPrice2(int wechatPrice2) {
                this.wechatPrice2 = wechatPrice2;
            }

            public int getWechatPriceMin() {
                return wechatPriceMin;
            }

            public void setWechatPriceMin(int wechatPriceMin) {
                this.wechatPriceMin = wechatPriceMin;
            }

            public int getWechatUsable() {
                return wechatUsable;
            }

            public void setWechatUsable(int wechatUsable) {
                this.wechatUsable = wechatUsable;
            }

            public String getUnitName() {
                return unitName;
            }

            public void setUnitName(String unitName) {
                this.unitName = unitName;
            }

            public int getPromotionId() {
                return promotionId;
            }

            public void setPromotionId(int promotionId) {
                this.promotionId = promotionId;
            }

            public String getPromotionStartTime() {
                return promotionStartTime;
            }

            public void setPromotionStartTime(String promotionStartTime) {
                this.promotionStartTime = promotionStartTime;
            }

            public String getPromotionEndTime() {
                return promotionEndTime;
            }

            public void setPromotionEndTime(String promotionEndTime) {
                this.promotionEndTime = promotionEndTime;
            }

            public int getPromotionState() {
                return promotionState;
            }

            public void setPromotionState(int promotionState) {
                this.promotionState = promotionState;
            }

            public int getPromotionType() {
                return promotionType;
            }

            public void setPromotionType(int promotionType) {
                this.promotionType = promotionType;
            }

            public String getPromotionTypeText() {
                return promotionTypeText;
            }

            public void setPromotionTypeText(String promotionTypeText) {
                this.promotionTypeText = promotionTypeText;
            }

            public int getGoodsModal() {
                return goodsModal;
            }

            public void setGoodsModal(int goodsModal) {
                this.goodsModal = goodsModal;
            }

            public int getGoodsFavorite() {
                return goodsFavorite;
            }

            public void setGoodsFavorite(int goodsFavorite) {
                this.goodsFavorite = goodsFavorite;
            }

            public int getEvaluateNum() {
                return evaluateNum;
            }

            public void setEvaluateNum(int evaluateNum) {
                this.evaluateNum = evaluateNum;
            }

            public int getGoodsRate() {
                return goodsRate;
            }

            public void setGoodsRate(int goodsRate) {
                this.goodsRate = goodsRate;
            }

            public int getGoodsSaleNum() {
                return goodsSaleNum;
            }

            public void setGoodsSaleNum(int goodsSaleNum) {
                this.goodsSaleNum = goodsSaleNum;
            }

            public String getImageName() {
                return imageName;
            }

            public void setImageName(String imageName) {
                this.imageName = imageName;
            }

            public String getImageSrc() {
                return imageSrc;
            }

            public void setImageSrc(String imageSrc) {
                this.imageSrc = imageSrc;
            }

            public int getIsGift() {
                return isGift;
            }

            public void setIsGift(int isGift) {
                this.isGift = isGift;
            }

            public String getCategoryName() {
                return categoryName;
            }

            public void setCategoryName(String categoryName) {
                this.categoryName = categoryName;
            }

            public String getStoreName() {
                return storeName;
            }

            public void setStoreName(String storeName) {
                this.storeName = storeName;
            }

            public int getIsOwnShop() {
                return isOwnShop;
            }

            public void setIsOwnShop(int isOwnShop) {
                this.isOwnShop = isOwnShop;
            }

            public int getSellerId() {
                return sellerId;
            }

            public void setSellerId(int sellerId) {
                this.sellerId = sellerId;
            }

            public int getCommissionRate() {
                return commissionRate;
            }

            public void setCommissionRate(int commissionRate) {
                this.commissionRate = commissionRate;
            }

            public int getWebCommission() {
                return webCommission;
            }

            public void setWebCommission(int webCommission) {
                this.webCommission = webCommission;
            }

            public int getAppCommission() {
                return appCommission;
            }

            public void setAppCommission(int appCommission) {
                this.appCommission = appCommission;
            }

            public int getWechatCommission() {
                return wechatCommission;
            }

            public void setWechatCommission(int wechatCommission) {
                this.wechatCommission = wechatCommission;
            }

            public int getUsableVoucher() {
                return usableVoucher;
            }

            public void setUsableVoucher(int usableVoucher) {
                this.usableVoucher = usableVoucher;
            }

            public int getOrdersCount() {
                return ordersCount;
            }

            public void setOrdersCount(int ordersCount) {
                this.ordersCount = ordersCount;
            }

            public int getCommissionTotal() {
                return commissionTotal;
            }

            public void setCommissionTotal(int commissionTotal) {
                this.commissionTotal = commissionTotal;
            }

            public int getIsOnline() {
                return isOnline;
            }

            public void setIsOnline(int isOnline) {
                this.isOnline = isOnline;
            }

            public int getGoodsId() {
                return goodsId;
            }

            public void setGoodsId(int goodsId) {
                this.goodsId = goodsId;
            }

            public String getGoodsSpec() {
                return goodsSpec;
            }

            public void setGoodsSpec(String goodsSpec) {
                this.goodsSpec = goodsSpec;
            }

            public String getExtendString0() {
                return extendString0;
            }

            public void setExtendString0(String extendString0) {
                this.extendString0 = extendString0;
            }

            public String getExtendString1() {
                return extendString1;
            }

            public void setExtendString1(String extendString1) {
                this.extendString1 = extendString1;
            }

            public String getExtendString2() {
                return extendString2;
            }

            public void setExtendString2(String extendString2) {
                this.extendString2 = extendString2;
            }

            public String getExtendString3() {
                return extendString3;
            }

            public void setExtendString3(String extendString3) {
                this.extendString3 = extendString3;
            }

            public String getExtendString4() {
                return extendString4;
            }

            public void setExtendString4(String extendString4) {
                this.extendString4 = extendString4;
            }

            public String getExtendString5() {
                return extendString5;
            }

            public void setExtendString5(String extendString5) {
                this.extendString5 = extendString5;
            }

            public String getExtendString6() {
                return extendString6;
            }

            public void setExtendString6(String extendString6) {
                this.extendString6 = extendString6;
            }

            public String getExtendString7() {
                return extendString7;
            }

            public void setExtendString7(String extendString7) {
                this.extendString7 = extendString7;
            }

            public String getExtendString8() {
                return extendString8;
            }

            public void setExtendString8(String extendString8) {
                this.extendString8 = extendString8;
            }

            public String getExtendString9() {
                return extendString9;
            }

            public void setExtendString9(String extendString9) {
                this.extendString9 = extendString9;
            }

            public int getExtendInt0() {
                return extendInt0;
            }

            public void setExtendInt0(int extendInt0) {
                this.extendInt0 = extendInt0;
            }

            public int getExtendInt1() {
                return extendInt1;
            }

            public void setExtendInt1(int extendInt1) {
                this.extendInt1 = extendInt1;
            }

            public int getExtendInt2() {
                return extendInt2;
            }

            public void setExtendInt2(int extendInt2) {
                this.extendInt2 = extendInt2;
            }

            public int getExtendInt3() {
                return extendInt3;
            }

            public void setExtendInt3(int extendInt3) {
                this.extendInt3 = extendInt3;
            }

            public int getExtendInt4() {
                return extendInt4;
            }

            public void setExtendInt4(int extendInt4) {
                this.extendInt4 = extendInt4;
            }

            public int getExtendInt5() {
                return extendInt5;
            }

            public void setExtendInt5(int extendInt5) {
                this.extendInt5 = extendInt5;
            }

            public int getExtendInt6() {
                return extendInt6;
            }

            public void setExtendInt6(int extendInt6) {
                this.extendInt6 = extendInt6;
            }

            public int getExtendInt7() {
                return extendInt7;
            }

            public void setExtendInt7(int extendInt7) {
                this.extendInt7 = extendInt7;
            }

            public int getExtendInt8() {
                return extendInt8;
            }

            public void setExtendInt8(int extendInt8) {
                this.extendInt8 = extendInt8;
            }

            public int getExtendInt9() {
                return extendInt9;
            }

            public void setExtendInt9(int extendInt9) {
                this.extendInt9 = extendInt9;
            }

            public int getExtendPrice0() {
                return extendPrice0;
            }

            public void setExtendPrice0(int extendPrice0) {
                this.extendPrice0 = extendPrice0;
            }

            public int getExtendPrice1() {
                return extendPrice1;
            }

            public void setExtendPrice1(int extendPrice1) {
                this.extendPrice1 = extendPrice1;
            }

            public int getExtendPrice2() {
                return extendPrice2;
            }

            public void setExtendPrice2(int extendPrice2) {
                this.extendPrice2 = extendPrice2;
            }

            public int getExtendPrice3() {
                return extendPrice3;
            }

            public void setExtendPrice3(int extendPrice3) {
                this.extendPrice3 = extendPrice3;
            }

            public int getExtendPrice4() {
                return extendPrice4;
            }

            public void setExtendPrice4(int extendPrice4) {
                this.extendPrice4 = extendPrice4;
            }

            public int getExtendPrice5() {
                return extendPrice5;
            }

            public void setExtendPrice5(int extendPrice5) {
                this.extendPrice5 = extendPrice5;
            }

            public int getExtendPrice6() {
                return extendPrice6;
            }

            public void setExtendPrice6(int extendPrice6) {
                this.extendPrice6 = extendPrice6;
            }

            public int getExtendPrice7() {
                return extendPrice7;
            }

            public void setExtendPrice7(int extendPrice7) {
                this.extendPrice7 = extendPrice7;
            }

            public int getExtendPrice8() {
                return extendPrice8;
            }

            public void setExtendPrice8(int extendPrice8) {
                this.extendPrice8 = extendPrice8;
            }

            public int getExtendPrice9() {
                return extendPrice9;
            }

            public void setExtendPrice9(int extendPrice9) {
                this.extendPrice9 = extendPrice9;
            }

            public String getExtendTime0() {
                return extendTime0;
            }

            public void setExtendTime0(String extendTime0) {
                this.extendTime0 = extendTime0;
            }

            public String getExtendTime1() {
                return extendTime1;
            }

            public void setExtendTime1(String extendTime1) {
                this.extendTime1 = extendTime1;
            }

            public String getExtendTime2() {
                return extendTime2;
            }

            public void setExtendTime2(String extendTime2) {
                this.extendTime2 = extendTime2;
            }

            public String getExtendTime3() {
                return extendTime3;
            }

            public void setExtendTime3(String extendTime3) {
                this.extendTime3 = extendTime3;
            }

            public String getExtendTime4() {
                return extendTime4;
            }

            public void setExtendTime4(String extendTime4) {
                this.extendTime4 = extendTime4;
            }

            public String getExtendTime5() {
                return extendTime5;
            }

            public void setExtendTime5(String extendTime5) {
                this.extendTime5 = extendTime5;
            }

            public String getExtendTime6() {
                return extendTime6;
            }

            public void setExtendTime6(String extendTime6) {
                this.extendTime6 = extendTime6;
            }

            public String getExtendTime7() {
                return extendTime7;
            }

            public void setExtendTime7(String extendTime7) {
                this.extendTime7 = extendTime7;
            }

            public String getExtendTime8() {
                return extendTime8;
            }

            public void setExtendTime8(String extendTime8) {
                this.extendTime8 = extendTime8;
            }

            public String getExtendTime9() {
                return extendTime9;
            }

            public void setExtendTime9(String extendTime9) {
                this.extendTime9 = extendTime9;
            }

            public Object getKpProductType() {
                return kpProductType;
            }

            public void setKpProductType(Object kpProductType) {
                this.kpProductType = kpProductType;
            }

            public int getGoodsStorage() {
                return goodsStorage;
            }

            public void setGoodsStorage(int goodsStorage) {
                this.goodsStorage = goodsStorage;
            }

            public String getBrandName() {
                return brandName;
            }

            public void setBrandName(String brandName) {
                this.brandName = brandName;
            }

            public String getBrandEnglish() {
                return brandEnglish;
            }

            public void setBrandEnglish(String brandEnglish) {
                this.brandEnglish = brandEnglish;
            }

            public double getRmbWebPrice() {
                return rmbWebPrice;
            }

            public void setRmbWebPrice(double rmbWebPrice) {
                this.rmbWebPrice = rmbWebPrice;
            }

            public double getRmbAppPrice() {
                return rmbAppPrice;
            }

            public void setRmbAppPrice(double rmbAppPrice) {
                this.rmbAppPrice = rmbAppPrice;
            }

            public double getRmbWeChatPrice() {
                return rmbWeChatPrice;
            }

            public void setRmbWeChatPrice(double rmbWeChatPrice) {
                this.rmbWeChatPrice = rmbWeChatPrice;
            }

            public int getDiscountRate() {
                return discountRate;
            }

            public void setDiscountRate(int discountRate) {
                this.discountRate = discountRate;
            }

            public int getMonthSaleNum() {
                return monthSaleNum;
            }

            public void setMonthSaleNum(int monthSaleNum) {
                this.monthSaleNum = monthSaleNum;
            }

            public boolean isMonthPromotion() {
                return monthPromotion;
            }

            public void setMonthPromotion(boolean monthPromotion) {
                this.monthPromotion = monthPromotion;
            }

            public Object getSpecialType() {
                return specialType;
            }

            public void setSpecialType(Object specialType) {
                this.specialType = specialType;
            }

            public List<GoodsImageListBean> getGoodsImageList() {
                return goodsImageList;
            }

            public void setGoodsImageList(List<GoodsImageListBean> goodsImageList) {
                this.goodsImageList = goodsImageList;
            }

            public List<?> getGoodsList() {
                return goodsList;
            }

            public void setGoodsList(List<?> goodsList) {
                this.goodsList = goodsList;
            }

            public List<BatchNumPriceVoListBean> getBatchNumPriceVoList() {
                return batchNumPriceVoList;
            }

            public void setBatchNumPriceVoList(List<BatchNumPriceVoListBean> batchNumPriceVoList) {
                this.batchNumPriceVoList = batchNumPriceVoList;
            }

            public static class GoodsImageListBean {
                /**
                 * imageId : 4746
                 * commonId : 736
                 * colorId : 6
                 * imageName : image/91/e7/91e7e4c110e6a75a7446c966a5ea839c.jpg
                 * imageSort : 0
                 * isDefault : 1
                 * imageSrc : https://upload.dev.kingpower-cn.com/image/91/e7/91e7e4c110e6a75a7446c966a5ea839c.jpg
                 */

                private int imageId;
                private int commonId;
                private int colorId;
                private String imageName;
                private int imageSort;
                private int isDefault;
                private String imageSrc;

                public int getImageId() {
                    return imageId;
                }

                public void setImageId(int imageId) {
                    this.imageId = imageId;
                }

                public int getCommonId() {
                    return commonId;
                }

                public void setCommonId(int commonId) {
                    this.commonId = commonId;
                }

                public int getColorId() {
                    return colorId;
                }

                public void setColorId(int colorId) {
                    this.colorId = colorId;
                }

                public String getImageName() {
                    return imageName;
                }

                public void setImageName(String imageName) {
                    this.imageName = imageName;
                }

                public int getImageSort() {
                    return imageSort;
                }

                public void setImageSort(int imageSort) {
                    this.imageSort = imageSort;
                }

                public int getIsDefault() {
                    return isDefault;
                }

                public void setIsDefault(int isDefault) {
                    this.isDefault = isDefault;
                }

                public String getImageSrc() {
                    return imageSrc;
                }

                public void setImageSrc(String imageSrc) {
                    this.imageSrc = imageSrc;
                }
            }

            public static class BatchNumPriceVoListBean {
                /**
                 * num : ≥1
                 * price : 9.00
                 */

                private String num;
                private String price;

                public String getNum() {
                    return num;
                }

                public void setNum(String num) {
                    this.num = num;
                }

                public String getPrice() {
                    return price;
                }

                public void setPrice(String price) {
                    this.price = price;
                }
            }
        }
    }
}
