package com.jassica.jassica.bean;
/*
 * 注册下一步实体类
 * 获取手机验证码实体类
 * */
public class RegisterBean {
    /**
     * code : 200
     * datas : {"authCodeValidTime":10,"authCodeResendTime":60}
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
         * authCodeValidTime : 10
         * authCodeResendTime : 60
         */
        private String error;
        private int authCodeValidTime;
        private int authCodeResendTime;

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }
        public int getAuthCodeValidTime() {
            return authCodeValidTime;
        }

        public void setAuthCodeValidTime(int authCodeValidTime) {
            this.authCodeValidTime = authCodeValidTime;
        }

        public int getAuthCodeResendTime() {
            return authCodeResendTime;
        }

        public void setAuthCodeResendTime(int authCodeResendTime) {
            this.authCodeResendTime = authCodeResendTime;
        }
    }
}
