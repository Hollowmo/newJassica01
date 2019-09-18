package com.jassica.jassica.bean;
/*
* 注册实体类
* */
public class LoginBean {

    /**
     * code : 200
     * datas : {"memberName":"15512211212","memberId":"60","token":"aaaa6bbbb0ccccc"}
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
         * memberName : 15512211212
         * memberId : 60
         * token : aaaa6bbbb0ccccc
         */

        private String memberName;
        private String memberId;
        private String token;

        public String getMemberName() {
            return memberName;
        }

        public void setMemberName(String memberName) {
            this.memberName = memberName;
        }

        public String getMemberId() {
            return memberId;
        }

        public void setMemberId(String memberId) {
            this.memberId = memberId;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
