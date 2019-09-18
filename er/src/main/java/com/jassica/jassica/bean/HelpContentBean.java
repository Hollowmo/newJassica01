package com.jassica.jassica.bean;

import java.util.List;

public class HelpContentBean {

    /**
     * code : 200
     * datas : {"dataList":[{"articleId":121,"title":"联系客服","categoryId":11,"url":null,"content":"","createTime":"2019-08-02 12:09:09","allowDelete":1,"sort":1,"categoryTitle":""},{"articleId":122,"title":"退款说明","categoryId":11,"url":null,"content":"","createTime":"2019-08-02 12:09:23","allowDelete":1,"sort":2,"categoryTitle":""},{"articleId":123,"title":"退换货流程","categoryId":11,"url":null,"content":"","createTime":"2019-08-02 12:09:40","allowDelete":1,"sort":3,"categoryTitle":""},{"articleId":124,"title":"退换货政策","categoryId":11,"url":null,"content":"","createTime":"2019-08-02 12:09:51","allowDelete":1,"sort":4,"categoryTitle":""}]}
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
        private List<DataListBean> dataList;

        public List<DataListBean> getDataList() {
            return dataList;
        }

        public void setDataList(List<DataListBean> dataList) {
            this.dataList = dataList;
        }

        public static class DataListBean {
            /**
             * articleId : 121
             * title : 联系客服
             * categoryId : 11
             * url : null
             * content :
             * createTime : 2019-08-02 12:09:09
             * allowDelete : 1
             * sort : 1
             * categoryTitle :
             */

            private int articleId;
            private String title;
            private int categoryId;
            private Object url;
            private String content;
            private String createTime;
            private int allowDelete;
            private int sort;
            private String categoryTitle;

            public int getArticleId() {
                return articleId;
            }

            public void setArticleId(int articleId) {
                this.articleId = articleId;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(int categoryId) {
                this.categoryId = categoryId;
            }

            public Object getUrl() {
                return url;
            }

            public void setUrl(Object url) {
                this.url = url;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public int getAllowDelete() {
                return allowDelete;
            }

            public void setAllowDelete(int allowDelete) {
                this.allowDelete = allowDelete;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public String getCategoryTitle() {
                return categoryTitle;
            }

            public void setCategoryTitle(String categoryTitle) {
                this.categoryTitle = categoryTitle;
            }
        }
    }
}
