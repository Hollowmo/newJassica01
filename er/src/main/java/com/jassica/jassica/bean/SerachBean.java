package com.jassica.jassica.bean;

import java.util.List;

public class SerachBean {


    /**
     * code : 200
     * datas : {"keywordList":[{"hotId":1,"hotName":"兰芝","hotValue":"兰芝"},{"hotId":2,"hotName":"香水","hotValue":"香水"},{"hotId":3,"hotName":"娇韵诗","hotValue":"娇韵诗"},{"hotId":4,"hotName":"粉底","hotValue":"粉底"},{"hotId":5,"hotName":"腮红","hotValue":"腮红"},{"hotId":6,"hotName":"口红","hotValue":"口红"},{"hotId":7,"hotName":"阿玛尼","hotValue":"阿玛尼"},{"hotId":8,"hotName":"粉底液","hotValue":"粉底液"},{"hotId":9,"hotName":"纪梵希","hotValue":"纪梵希"},{"hotId":10,"hotName":"黛珂a","hotValue":"黛珂a"}],"historySearchList":[]}
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
        private List<KeywordListBean> keywordList;
        private List<?> historySearchList;

        public List<KeywordListBean> getKeywordList() {
            return keywordList;
        }

        public void setKeywordList(List<KeywordListBean> keywordList) {
            this.keywordList = keywordList;
        }

        public List<?> getHistorySearchList() {
            return historySearchList;
        }

        public void setHistorySearchList(List<?> historySearchList) {
            this.historySearchList = historySearchList;
        }

        public static class KeywordListBean {
            /**
             * hotId : 1
             * hotName : 兰芝
             * hotValue : 兰芝
             */

            private int hotId;
            private String hotName;
            private String hotValue;

            public int getHotId() {
                return hotId;
            }

            public void setHotId(int hotId) {
                this.hotId = hotId;
            }

            public String getHotName() {
                return hotName;
            }

            public void setHotName(String hotName) {
                this.hotName = hotName;
            }

            public String getHotValue() {
                return hotValue;
            }

            public void setHotValue(String hotValue) {
                this.hotValue = hotValue;
            }
        }
    }
}
