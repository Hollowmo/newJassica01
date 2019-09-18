package com.jassica.jassica.bean;

public class PhoneBean {
    /**
     * code : 200
     * datas : {"memberName":"tht_000315663761","memberId":4,"token":"2b147fd4341842f690ecdfa0cc8c863e"}
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
         * memberName : tht_000315663761
         * memberId : 4
         * token : 2b147fd4341842f690ecdfa0cc8c863e
         */

        private String memberName;
        private int memberId;
        private String error;
        private String token;

        public String getMemberName() {
            return memberName;
        }

        public void setMemberName(String memberName) {
            this.memberName = memberName;
        }
        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }

        public int getMemberId() {
            return memberId;
        }

        public void setMemberId(int memberId) {
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
