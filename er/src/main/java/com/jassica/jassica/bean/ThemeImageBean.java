package com.jassica.jassica.bean;

import java.util.List;
/*
* 开屏图片
* */
public class ThemeImageBean {

    /**
     * code : 200
     * datas : {"coopenListRandomState":"1","coopenList":[{"useEndTime":1577462399000,"coopenTimeJson":"[{\"startTime\":\"00:00\",\"endTime\":\"23:59\"}]","useStartTime":1565020800000,"coopenId":71,"randomState":0,"dwellTime":5,"imgOperateJson":"[{\"linkValue\":\"www.baidu.com\",\"themeImage\":\"image/09/7c/097c0ecc421a6dd1ab72c20b5568676b.jpg\",\"themeImageUrl\":\"https://upload.dev.kingpower-cn.com/image/09/7c/097c0ecc421a6dd1ab72c20b5568676b.jpg\",\"linkType\":\"url\",\"linkText\":\"\"}]"}]}
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
         * coopenListRandomState : 1
         * coopenList : [{"useEndTime":1577462399000,"coopenTimeJson":"[{\"startTime\":\"00:00\",\"endTime\":\"23:59\"}]","useStartTime":1565020800000,"coopenId":71,"randomState":0,"dwellTime":5,"imgOperateJson":"[{\"linkValue\":\"www.baidu.com\",\"themeImage\":\"image/09/7c/097c0ecc421a6dd1ab72c20b5568676b.jpg\",\"themeImageUrl\":\"https://upload.dev.kingpower-cn.com/image/09/7c/097c0ecc421a6dd1ab72c20b5568676b.jpg\",\"linkType\":\"url\",\"linkText\":\"\"}]"}]
         */

        private String coopenListRandomState;
        private List<CoopenListBean> coopenList;

        public String getCoopenListRandomState() {
            return coopenListRandomState;
        }

        public void setCoopenListRandomState(String coopenListRandomState) {
            this.coopenListRandomState = coopenListRandomState;
        }

        public List<CoopenListBean> getCoopenList() {
            return coopenList;
        }

        public void setCoopenList(List<CoopenListBean> coopenList) {
            this.coopenList = coopenList;
        }

        public static class CoopenListBean {
            /**
             * useEndTime : 1577462399000
             * coopenTimeJson : [{"startTime":"00:00","endTime":"23:59"}]
             * useStartTime : 1565020800000
             * coopenId : 71
             * randomState : 0
             * dwellTime : 5
             * imgOperateJson : [{"linkValue":"www.baidu.com","themeImage":"image/09/7c/097c0ecc421a6dd1ab72c20b5568676b.jpg","themeImageUrl":"https://upload.dev.kingpower-cn.com/image/09/7c/097c0ecc421a6dd1ab72c20b5568676b.jpg","linkType":"url","linkText":""}]
             */

            private long useEndTime;
            private String coopenTimeJson;
            private long useStartTime;
            private int coopenId;
            private int randomState;
            private int dwellTime;
            private String imgOperateJson;

            public long getUseEndTime() {
                return useEndTime;
            }

            public void setUseEndTime(long useEndTime) {
                this.useEndTime = useEndTime;
            }

            public String getCoopenTimeJson() {
                return coopenTimeJson;
            }

            public void setCoopenTimeJson(String coopenTimeJson) {
                this.coopenTimeJson = coopenTimeJson;
            }

            public long getUseStartTime() {
                return useStartTime;
            }

            public void setUseStartTime(long useStartTime) {
                this.useStartTime = useStartTime;
            }

            public int getCoopenId() {
                return coopenId;
            }

            public void setCoopenId(int coopenId) {
                this.coopenId = coopenId;
            }

            public int getRandomState() {
                return randomState;
            }

            public void setRandomState(int randomState) {
                this.randomState = randomState;
            }

            public int getDwellTime() {
                return dwellTime;
            }

            public void setDwellTime(int dwellTime) {
                this.dwellTime = dwellTime;
            }

            public String getImgOperateJson() {
                return imgOperateJson;
            }

            public void setImgOperateJson(String imgOperateJson) {
                this.imgOperateJson = imgOperateJson;
            }
        }
    }
}
