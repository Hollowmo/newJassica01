package com.jassica.jassica.bean;

public class GenverifiCodeBean {

    /**
     * code : 200
     * datas : {"captchaKey":"0daad011b8451e6f83e77aad0fd8949a"}
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
         * captchaKey : 0daad011b8451e6f83e77aad0fd8949a
         */

        private String captchaKey;

        public String getCaptchaKey() {
            return captchaKey;
        }

        public void setCaptchaKey(String captchaKey) {
            this.captchaKey = captchaKey;
        }
    }
}
