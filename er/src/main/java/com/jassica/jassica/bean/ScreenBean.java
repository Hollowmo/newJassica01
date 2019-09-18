package com.jassica.jassica.bean;

import java.util.List;

public class ScreenBean {
    /**
     * code : 200
     * datas : {"promotionMap":{"monthPromotion":"特价","coupon":"券","isGift":"赠品"},"categoryMap1":[{"categoryId":181,"categoryName":"333","parentId":0,"display":"inline-block"},{"categoryId":29,"categoryName":"食品特产","parentId":0,"display":"inline-block"},{"categoryId":30,"categoryName":"粮油调味","parentId":0,"display":"inline-block"},{"categoryId":154,"categoryName":"咖啡冲饮","parentId":0,"display":"inline-block"},{"categoryId":24,"categoryName":"美容护肤","parentId":0,"display":"inline-block"},{"categoryId":27,"categoryName":"居家日用","parentId":0,"display":"inline-block"},{"categoryId":26,"categoryName":"滋补保健","parentId":0,"display":"inline-block"},{"categoryId":31,"categoryName":"服装鞋包","parentId":0,"display":"inline-block"}],"brandMap":[{"brandId":7,"brandName":"8 MIRACLES","brandEnglish":"8 MIRACLES","brandInitial":"8","brandImage":"","appBrandImage":"","brandImageSrc":"https://public.dev.kingpower-cn.com/img/default_image.png","storeId":0,"brandSort":0,"isRecommend":0,"applyState":1,"showType":0,"pcThemeImage":null,"pcThemeImageSrc":null,"appThemeImage":null,"appThemeImageSrc":null,"recommendSort":null,"isLocal":1,"specialType":"normal","brandCode":null,"brandState":1,"recommendSortApp":null,"isRecommendApp":0,"appThemeOperate":null,"pcThemeOperate":null},{"brandId":9,"brandName":"BioSkin","brandEnglish":"BioSkin","brandInitial":"B","brandImage":"","appBrandImage":"","brandImageSrc":"https://public.dev.kingpower-cn.com/img/default_image.png","storeId":0,"brandSort":0,"isRecommend":0,"applyState":1,"showType":0,"pcThemeImage":null,"pcThemeImageSrc":null,"appThemeImage":null,"appThemeImageSrc":null,"recommendSort":null,"isLocal":1,"specialType":"normal","brandCode":null,"brandState":1,"recommendSortApp":null,"isRecommendApp":0,"appThemeOperate":null,"pcThemeOperate":null},{"brandId":10,"brandName":"Fruit King","brandEnglish":"Fruit King","brandInitial":"F","brandImage":"","appBrandImage":"","brandImageSrc":"https://public.dev.kingpower-cn.com/img/default_image.png","storeId":0,"brandSort":0,"isRecommend":0,"applyState":1,"showType":0,"pcThemeImage":null,"pcThemeImageSrc":null,"appThemeImage":null,"appThemeImageSrc":null,"recommendSort":null,"isLocal":1,"specialType":"normal","brandCode":null,"brandState":1,"recommendSortApp":null,"isRecommendApp":0,"appThemeOperate":null,"pcThemeOperate":null},{"brandId":11,"brandName":"Fruit land","brandEnglish":"Fruit land","brandInitial":"F","brandImage":"","appBrandImage":"","brandImageSrc":"https://public.dev.kingpower-cn.com/img/default_image.png","storeId":0,"brandSort":0,"isRecommend":0,"applyState":1,"showType":0,"pcThemeImage":null,"pcThemeImageSrc":null,"appThemeImage":null,"appThemeImageSrc":null,"recommendSort":null,"isLocal":1,"specialType":"normal","brandCode":null,"brandState":1,"recommendSortApp":null,"isRecommendApp":0,"appThemeOperate":null,"pcThemeOperate":null},{"brandId":12,"brandName":"Gold Elephant","brandEnglish":"Gold Elephant","brandInitial":"G","brandImage":"","appBrandImage":"","brandImageSrc":"https://public.dev.kingpower-cn.com/img/default_image.png","storeId":0,"brandSort":0,"isRecommend":0,"applyState":1,"showType":0,"pcThemeImage":null,"pcThemeImageSrc":null,"appThemeImage":null,"appThemeImageSrc":null,"recommendSort":null,"isLocal":1,"specialType":"normal","brandCode":null,"brandState":1,"recommendSortApp":null,"isRecommendApp":0,"appThemeOperate":null,"pcThemeOperate":null},{"brandId":13,"brandName":"KING POW ROLL","brandEnglish":"KING POW ROLL","brandInitial":"K","brandImage":"","appBrandImage":"","brandImageSrc":"https://public.dev.kingpower-cn.com/img/default_image.png","storeId":0,"brandSort":0,"isRecommend":0,"applyState":1,"showType":0,"pcThemeImage":null,"pcThemeImageSrc":null,"appThemeImage":null,"appThemeImageSrc":null,"recommendSort":null,"isLocal":1,"specialType":"normal","brandCode":null,"brandState":1,"recommendSortApp":null,"isRecommendApp":0,"appThemeOperate":null,"pcThemeOperate":null},{"brandId":14,"brandName":"KING POWER","brandEnglish":"KING POWER","brandInitial":"K","brandImage":"","appBrandImage":"","brandImageSrc":"https://public.dev.kingpower-cn.com/img/default_image.png","storeId":0,"brandSort":0,"isRecommend":0,"applyState":1,"showType":0,"pcThemeImage":null,"pcThemeImageSrc":null,"appThemeImage":null,"appThemeImageSrc":null,"recommendSort":null,"isLocal":1,"specialType":"normal","brandCode":null,"brandState":1,"recommendSortApp":null,"isRecommendApp":0,"appThemeOperate":null,"pcThemeOperate":null},{"brandId":15,"brandName":"Masita","brandEnglish":"Masita","brandInitial":"M","brandImage":"","appBrandImage":"","brandImageSrc":"https://public.dev.kingpower-cn.com/img/default_image.png","storeId":0,"brandSort":0,"isRecommend":0,"applyState":1,"showType":0,"pcThemeImage":null,"pcThemeImageSrc":null,"appThemeImage":null,"appThemeImageSrc":null,"recommendSort":null,"isLocal":1,"specialType":"normal","brandCode":null,"brandState":1,"recommendSortApp":null,"isRecommendApp":0,"appThemeOperate":null,"pcThemeOperate":null}],"genderMap":{"WOMEN":"女","UNISEXKIDS":"男女孩通用","MEN":"男","BOYS":"男孩","GIRLS":"女孩","UNISEX":"男女通用"}}
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
         * promotionMap : {"monthPromotion":"特价","coupon":"券","isGift":"赠品"}
         * categoryMap1 : [{"categoryId":181,"categoryName":"333","parentId":0,"display":"inline-block"},{"categoryId":29,"categoryName":"食品特产","parentId":0,"display":"inline-block"},{"categoryId":30,"categoryName":"粮油调味","parentId":0,"display":"inline-block"},{"categoryId":154,"categoryName":"咖啡冲饮","parentId":0,"display":"inline-block"},{"categoryId":24,"categoryName":"美容护肤","parentId":0,"display":"inline-block"},{"categoryId":27,"categoryName":"居家日用","parentId":0,"display":"inline-block"},{"categoryId":26,"categoryName":"滋补保健","parentId":0,"display":"inline-block"},{"categoryId":31,"categoryName":"服装鞋包","parentId":0,"display":"inline-block"}]
         * brandMap : [{"brandId":7,"brandName":"8 MIRACLES","brandEnglish":"8 MIRACLES","brandInitial":"8","brandImage":"","appBrandImage":"","brandImageSrc":"https://public.dev.kingpower-cn.com/img/default_image.png","storeId":0,"brandSort":0,"isRecommend":0,"applyState":1,"showType":0,"pcThemeImage":null,"pcThemeImageSrc":null,"appThemeImage":null,"appThemeImageSrc":null,"recommendSort":null,"isLocal":1,"specialType":"normal","brandCode":null,"brandState":1,"recommendSortApp":null,"isRecommendApp":0,"appThemeOperate":null,"pcThemeOperate":null},{"brandId":9,"brandName":"BioSkin","brandEnglish":"BioSkin","brandInitial":"B","brandImage":"","appBrandImage":"","brandImageSrc":"https://public.dev.kingpower-cn.com/img/default_image.png","storeId":0,"brandSort":0,"isRecommend":0,"applyState":1,"showType":0,"pcThemeImage":null,"pcThemeImageSrc":null,"appThemeImage":null,"appThemeImageSrc":null,"recommendSort":null,"isLocal":1,"specialType":"normal","brandCode":null,"brandState":1,"recommendSortApp":null,"isRecommendApp":0,"appThemeOperate":null,"pcThemeOperate":null},{"brandId":10,"brandName":"Fruit King","brandEnglish":"Fruit King","brandInitial":"F","brandImage":"","appBrandImage":"","brandImageSrc":"https://public.dev.kingpower-cn.com/img/default_image.png","storeId":0,"brandSort":0,"isRecommend":0,"applyState":1,"showType":0,"pcThemeImage":null,"pcThemeImageSrc":null,"appThemeImage":null,"appThemeImageSrc":null,"recommendSort":null,"isLocal":1,"specialType":"normal","brandCode":null,"brandState":1,"recommendSortApp":null,"isRecommendApp":0,"appThemeOperate":null,"pcThemeOperate":null},{"brandId":11,"brandName":"Fruit land","brandEnglish":"Fruit land","brandInitial":"F","brandImage":"","appBrandImage":"","brandImageSrc":"https://public.dev.kingpower-cn.com/img/default_image.png","storeId":0,"brandSort":0,"isRecommend":0,"applyState":1,"showType":0,"pcThemeImage":null,"pcThemeImageSrc":null,"appThemeImage":null,"appThemeImageSrc":null,"recommendSort":null,"isLocal":1,"specialType":"normal","brandCode":null,"brandState":1,"recommendSortApp":null,"isRecommendApp":0,"appThemeOperate":null,"pcThemeOperate":null},{"brandId":12,"brandName":"Gold Elephant","brandEnglish":"Gold Elephant","brandInitial":"G","brandImage":"","appBrandImage":"","brandImageSrc":"https://public.dev.kingpower-cn.com/img/default_image.png","storeId":0,"brandSort":0,"isRecommend":0,"applyState":1,"showType":0,"pcThemeImage":null,"pcThemeImageSrc":null,"appThemeImage":null,"appThemeImageSrc":null,"recommendSort":null,"isLocal":1,"specialType":"normal","brandCode":null,"brandState":1,"recommendSortApp":null,"isRecommendApp":0,"appThemeOperate":null,"pcThemeOperate":null},{"brandId":13,"brandName":"KING POW ROLL","brandEnglish":"KING POW ROLL","brandInitial":"K","brandImage":"","appBrandImage":"","brandImageSrc":"https://public.dev.kingpower-cn.com/img/default_image.png","storeId":0,"brandSort":0,"isRecommend":0,"applyState":1,"showType":0,"pcThemeImage":null,"pcThemeImageSrc":null,"appThemeImage":null,"appThemeImageSrc":null,"recommendSort":null,"isLocal":1,"specialType":"normal","brandCode":null,"brandState":1,"recommendSortApp":null,"isRecommendApp":0,"appThemeOperate":null,"pcThemeOperate":null},{"brandId":14,"brandName":"KING POWER","brandEnglish":"KING POWER","brandInitial":"K","brandImage":"","appBrandImage":"","brandImageSrc":"https://public.dev.kingpower-cn.com/img/default_image.png","storeId":0,"brandSort":0,"isRecommend":0,"applyState":1,"showType":0,"pcThemeImage":null,"pcThemeImageSrc":null,"appThemeImage":null,"appThemeImageSrc":null,"recommendSort":null,"isLocal":1,"specialType":"normal","brandCode":null,"brandState":1,"recommendSortApp":null,"isRecommendApp":0,"appThemeOperate":null,"pcThemeOperate":null},{"brandId":15,"brandName":"Masita","brandEnglish":"Masita","brandInitial":"M","brandImage":"","appBrandImage":"","brandImageSrc":"https://public.dev.kingpower-cn.com/img/default_image.png","storeId":0,"brandSort":0,"isRecommend":0,"applyState":1,"showType":0,"pcThemeImage":null,"pcThemeImageSrc":null,"appThemeImage":null,"appThemeImageSrc":null,"recommendSort":null,"isLocal":1,"specialType":"normal","brandCode":null,"brandState":1,"recommendSortApp":null,"isRecommendApp":0,"appThemeOperate":null,"pcThemeOperate":null}]
         * genderMap : {"WOMEN":"女","UNISEXKIDS":"男女孩通用","MEN":"男","BOYS":"男孩","GIRLS":"女孩","UNISEX":"男女通用"}
         */

        private PromotionMapBean promotionMap;
        private GenderMapBean genderMap;
        private List<CategoryMap1Bean> categoryMap1;
        private List<BrandMapBean> brandMap;

        public PromotionMapBean getPromotionMap() {
            return promotionMap;
        }

        public void setPromotionMap(PromotionMapBean promotionMap) {
            this.promotionMap = promotionMap;
        }

        public GenderMapBean getGenderMap() {
            return genderMap;
        }

        public void setGenderMap(GenderMapBean genderMap) {
            this.genderMap = genderMap;
        }

        public List<CategoryMap1Bean> getCategoryMap1() {
            return categoryMap1;
        }

        public void setCategoryMap1(List<CategoryMap1Bean> categoryMap1) {
            this.categoryMap1 = categoryMap1;
        }

        public List<BrandMapBean> getBrandMap() {
            return brandMap;
        }

        public void setBrandMap(List<BrandMapBean> brandMap) {
            this.brandMap = brandMap;
        }

        public static class PromotionMapBean {
            /**
             * monthPromotion : 特价
             * coupon : 券
             * isGift : 赠品
             */

            private String monthPromotion;
            private String coupon;
            private String isGift;

            public String getMonthPromotion() {
                return monthPromotion;
            }

            public void setMonthPromotion(String monthPromotion) {
                this.monthPromotion = monthPromotion;
            }

            public String getCoupon() {
                return coupon;
            }

            public void setCoupon(String coupon) {
                this.coupon = coupon;
            }

            public String getIsGift() {
                return isGift;
            }

            public void setIsGift(String isGift) {
                this.isGift = isGift;
            }
        }

        public static class GenderMapBean {
            /**
             * WOMEN : 女
             * UNISEXKIDS : 男女孩通用
             * MEN : 男
             * BOYS : 男孩
             * GIRLS : 女孩
             * UNISEX : 男女通用
             */

            private String WOMEN;
            private String UNISEXKIDS;
            private String MEN;
            private String BOYS;
            private String GIRLS;
            private String UNISEX;

            public String getWOMEN() {
                return WOMEN;
            }

            public void setWOMEN(String WOMEN) {
                this.WOMEN = WOMEN;
            }

            public String getUNISEXKIDS() {
                return UNISEXKIDS;
            }

            public void setUNISEXKIDS(String UNISEXKIDS) {
                this.UNISEXKIDS = UNISEXKIDS;
            }

            public String getMEN() {
                return MEN;
            }

            public void setMEN(String MEN) {
                this.MEN = MEN;
            }

            public String getBOYS() {
                return BOYS;
            }

            public void setBOYS(String BOYS) {
                this.BOYS = BOYS;
            }

            public String getGIRLS() {
                return GIRLS;
            }

            public void setGIRLS(String GIRLS) {
                this.GIRLS = GIRLS;
            }

            public String getUNISEX() {
                return UNISEX;
            }

            public void setUNISEX(String UNISEX) {
                this.UNISEX = UNISEX;
            }
        }

        public static class CategoryMap1Bean {
            /**
             * categoryId : 181
             * categoryName : 333
             * parentId : 0
             * display : inline-block
             */

            private int categoryId;
            private String categoryName;
            private int parentId;
            private String display;

            public int getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(int categoryId) {
                this.categoryId = categoryId;
            }

            public String getCategoryName() {
                return categoryName;
            }

            public void setCategoryName(String categoryName) {
                this.categoryName = categoryName;
            }

            public int getParentId() {
                return parentId;
            }

            public void setParentId(int parentId) {
                this.parentId = parentId;
            }

            public String getDisplay() {
                return display;
            }

            public void setDisplay(String display) {
                this.display = display;
            }
        }

        public static class BrandMapBean {
            /**
             * brandId : 7
             * brandName : 8 MIRACLES
             * brandEnglish : 8 MIRACLES
             * brandInitial : 8
             * brandImage :
             * appBrandImage :
             * brandImageSrc : https://public.dev.kingpower-cn.com/img/default_image.png
             * storeId : 0
             * brandSort : 0
             * isRecommend : 0
             * applyState : 1
             * showType : 0
             * pcThemeImage : null
             * pcThemeImageSrc : null
             * appThemeImage : null
             * appThemeImageSrc : null
             * recommendSort : null
             * isLocal : 1
             * specialType : normal
             * brandCode : null
             * brandState : 1
             * recommendSortApp : null
             * isRecommendApp : 0
             * appThemeOperate : null
             * pcThemeOperate : null
             */

            private int brandId;
            private String brandName;
            private String brandEnglish;
            private String brandInitial;
            private String brandImage;
            private String appBrandImage;
            private String brandImageSrc;
            private int storeId;
            private int brandSort;
            private int isRecommend;
            private int applyState;
            private int showType;
            private Object pcThemeImage;
            private Object pcThemeImageSrc;
            private Object appThemeImage;
            private Object appThemeImageSrc;
            private Object recommendSort;
            private int isLocal;
            private String specialType;
            private Object brandCode;
            private int brandState;
            private Object recommendSortApp;
            private int isRecommendApp;
            private Object appThemeOperate;
            private Object pcThemeOperate;

            public int getBrandId() {
                return brandId;
            }

            public void setBrandId(int brandId) {
                this.brandId = brandId;
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

            public String getBrandInitial() {
                return brandInitial;
            }

            public void setBrandInitial(String brandInitial) {
                this.brandInitial = brandInitial;
            }

            public String getBrandImage() {
                return brandImage;
            }

            public void setBrandImage(String brandImage) {
                this.brandImage = brandImage;
            }

            public String getAppBrandImage() {
                return appBrandImage;
            }

            public void setAppBrandImage(String appBrandImage) {
                this.appBrandImage = appBrandImage;
            }

            public String getBrandImageSrc() {
                return brandImageSrc;
            }

            public void setBrandImageSrc(String brandImageSrc) {
                this.brandImageSrc = brandImageSrc;
            }

            public int getStoreId() {
                return storeId;
            }

            public void setStoreId(int storeId) {
                this.storeId = storeId;
            }

            public int getBrandSort() {
                return brandSort;
            }

            public void setBrandSort(int brandSort) {
                this.brandSort = brandSort;
            }

            public int getIsRecommend() {
                return isRecommend;
            }

            public void setIsRecommend(int isRecommend) {
                this.isRecommend = isRecommend;
            }

            public int getApplyState() {
                return applyState;
            }

            public void setApplyState(int applyState) {
                this.applyState = applyState;
            }

            public int getShowType() {
                return showType;
            }

            public void setShowType(int showType) {
                this.showType = showType;
            }

            public Object getPcThemeImage() {
                return pcThemeImage;
            }

            public void setPcThemeImage(Object pcThemeImage) {
                this.pcThemeImage = pcThemeImage;
            }

            public Object getPcThemeImageSrc() {
                return pcThemeImageSrc;
            }

            public void setPcThemeImageSrc(Object pcThemeImageSrc) {
                this.pcThemeImageSrc = pcThemeImageSrc;
            }

            public Object getAppThemeImage() {
                return appThemeImage;
            }

            public void setAppThemeImage(Object appThemeImage) {
                this.appThemeImage = appThemeImage;
            }

            public Object getAppThemeImageSrc() {
                return appThemeImageSrc;
            }

            public void setAppThemeImageSrc(Object appThemeImageSrc) {
                this.appThemeImageSrc = appThemeImageSrc;
            }

            public Object getRecommendSort() {
                return recommendSort;
            }

            public void setRecommendSort(Object recommendSort) {
                this.recommendSort = recommendSort;
            }

            public int getIsLocal() {
                return isLocal;
            }

            public void setIsLocal(int isLocal) {
                this.isLocal = isLocal;
            }

            public String getSpecialType() {
                return specialType;
            }

            public void setSpecialType(String specialType) {
                this.specialType = specialType;
            }

            public Object getBrandCode() {
                return brandCode;
            }

            public void setBrandCode(Object brandCode) {
                this.brandCode = brandCode;
            }

            public int getBrandState() {
                return brandState;
            }

            public void setBrandState(int brandState) {
                this.brandState = brandState;
            }

            public Object getRecommendSortApp() {
                return recommendSortApp;
            }

            public void setRecommendSortApp(Object recommendSortApp) {
                this.recommendSortApp = recommendSortApp;
            }

            public int getIsRecommendApp() {
                return isRecommendApp;
            }

            public void setIsRecommendApp(int isRecommendApp) {
                this.isRecommendApp = isRecommendApp;
            }

            public Object getAppThemeOperate() {
                return appThemeOperate;
            }

            public void setAppThemeOperate(Object appThemeOperate) {
                this.appThemeOperate = appThemeOperate;
            }

            public Object getPcThemeOperate() {
                return pcThemeOperate;
            }

            public void setPcThemeOperate(Object pcThemeOperate) {
                this.pcThemeOperate = pcThemeOperate;
            }
        }
    }
}
