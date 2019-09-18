package com.jassica.jassica.bean;

public class PwdLoginBean {

    /**
     * code : 200
     * datas : {"memberName":"tht_000215662950","memberId":3,"token":"5502e8b1d97e4f2db120b6e480f83d8a"}
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
         * memberName : tht_000215662950
         * memberId : 3
         * token : 5502e8b1d97e4f2db120b6e480f83d8a
         */
        private String error;

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }
        private String memberName;
        private int memberId;
        private String token;

        public String getMemberName() {
            return memberName;
        }

        public void setMemberName(String memberName) {
            this.memberName = memberName;
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
