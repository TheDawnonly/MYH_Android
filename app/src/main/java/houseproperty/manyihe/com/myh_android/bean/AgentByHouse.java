package houseproperty.manyihe.com.myh_android.bean;

import java.util.List;

public class AgentByHouse {

    /**
     * resultBean : {"code":"0","message":"OK","object":{"pageNum":1,"pageSize":10,"size":1,"startRow":1,"endRow":1,"total":1,"pages":1,"list":[{"id":1,"name":"敖凤强","mobile":"18730494984","area":"河北","city":null,"detailArea":null,"project":"滦平","tag":"客户好评","store":"河北店","watchTimes":205,"dealCount":114,"score":100,"createTime":1523503722000,"agentLevel":"\r\na0","agentImg":"https://myhtest.oss-cn-%89%87/1.png","page":null}],"firstPage":1,"prePage":0,"nextPage":0,"lastPage":1,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1]},"sessionId":null}
     */

    private ResultBeanBean resultBean;

    public ResultBeanBean getResultBean() {
        return resultBean;
    }

    public void setResultBean(ResultBeanBean resultBean) {
        this.resultBean = resultBean;
    }

    public static class ResultBeanBean {
        /**
         * code : 0
         * message : OK
         * object : {"pageNum":1,"pageSize":10,"size":1,"startRow":1,"endRow":1,"total":1,"pages":1,"list":[{"id":1,"name":"敖凤强","mobile":"18730494984","area":"河北","city":null,"detailArea":null,"project":"滦平","tag":"客户好评","store":"河北店","watchTimes":205,"dealCount":114,"score":100,"createTime":1523503722000,"agentLevel":"\r\na0","agentImg":"https://myhtest.oss-cn-%89%87/1.png","page":null}],"firstPage":1,"prePage":0,"nextPage":0,"lastPage":1,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1]}
         * sessionId : null
         */

        private String code;
        private String message;
        private ObjectBean object;
        private Object sessionId;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public ObjectBean getObject() {
            return object;
        }

        public void setObject(ObjectBean object) {
            this.object = object;
        }

        public Object getSessionId() {
            return sessionId;
        }

        public void setSessionId(Object sessionId) {
            this.sessionId = sessionId;
        }

        public static class ObjectBean {
            /**
             * pageNum : 1
             * pageSize : 10
             * size : 1
             * startRow : 1
             * endRow : 1
             * total : 1
             * pages : 1
             * list : [{"id":1,"name":"敖凤强","mobile":"18730494984","area":"河北","city":null,"detailArea":null,"project":"滦平","tag":"客户好评","store":"河北店","watchTimes":205,"dealCount":114,"score":100,"createTime":1523503722000,"agentLevel":"\r\na0","agentImg":"https://myhtest.oss-cn-%89%87/1.png","page":null}]
             * firstPage : 1
             * prePage : 0
             * nextPage : 0
             * lastPage : 1
             * isFirstPage : true
             * isLastPage : true
             * hasPreviousPage : false
             * hasNextPage : false
             * navigatePages : 8
             * navigatepageNums : [1]
             */

            private int pageNum;
            private int pageSize;
            private int size;
            private int startRow;
            private int endRow;
            private int total;
            private int pages;
            private int firstPage;
            private int prePage;
            private int nextPage;
            private int lastPage;
            private boolean isFirstPage;
            private boolean isLastPage;
            private boolean hasPreviousPage;
            private boolean hasNextPage;
            private int navigatePages;
            private List<ListBean> list;
            private List<Integer> navigatepageNums;

            public int getPageNum() {
                return pageNum;
            }

            public void setPageNum(int pageNum) {
                this.pageNum = pageNum;
            }

            public int getPageSize() {
                return pageSize;
            }

            public void setPageSize(int pageSize) {
                this.pageSize = pageSize;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public int getStartRow() {
                return startRow;
            }

            public void setStartRow(int startRow) {
                this.startRow = startRow;
            }

            public int getEndRow() {
                return endRow;
            }

            public void setEndRow(int endRow) {
                this.endRow = endRow;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public int getPages() {
                return pages;
            }

            public void setPages(int pages) {
                this.pages = pages;
            }

            public int getFirstPage() {
                return firstPage;
            }

            public void setFirstPage(int firstPage) {
                this.firstPage = firstPage;
            }

            public int getPrePage() {
                return prePage;
            }

            public void setPrePage(int prePage) {
                this.prePage = prePage;
            }

            public int getNextPage() {
                return nextPage;
            }

            public void setNextPage(int nextPage) {
                this.nextPage = nextPage;
            }

            public int getLastPage() {
                return lastPage;
            }

            public void setLastPage(int lastPage) {
                this.lastPage = lastPage;
            }

            public boolean isIsFirstPage() {
                return isFirstPage;
            }

            public void setIsFirstPage(boolean isFirstPage) {
                this.isFirstPage = isFirstPage;
            }

            public boolean isIsLastPage() {
                return isLastPage;
            }

            public void setIsLastPage(boolean isLastPage) {
                this.isLastPage = isLastPage;
            }

            public boolean isHasPreviousPage() {
                return hasPreviousPage;
            }

            public void setHasPreviousPage(boolean hasPreviousPage) {
                this.hasPreviousPage = hasPreviousPage;
            }

            public boolean isHasNextPage() {
                return hasNextPage;
            }

            public void setHasNextPage(boolean hasNextPage) {
                this.hasNextPage = hasNextPage;
            }

            public int getNavigatePages() {
                return navigatePages;
            }

            public void setNavigatePages(int navigatePages) {
                this.navigatePages = navigatePages;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public List<Integer> getNavigatepageNums() {
                return navigatepageNums;
            }

            public void setNavigatepageNums(List<Integer> navigatepageNums) {
                this.navigatepageNums = navigatepageNums;
            }

            public static class ListBean {
                /**
                 * id : 1
                 * name : 敖凤强
                 * mobile : 18730494984
                 * area : 河北
                 * city : null
                 * detailArea : null
                 * project : 滦平
                 * tag : 客户好评
                 * store : 河北店
                 * watchTimes : 205
                 * dealCount : 114
                 * score : 100
                 * createTime : 1523503722000
                 * agentLevel :
                 * a0
                 * agentImg : https://myhtest.oss-cn-%89%87/1.png
                 * page : null
                 */

                private int id;
                private String name;
                private String mobile;
                private String area;
                private Object city;
                private Object detailArea;
                private String project;
                private String tag;
                private String store;
                private int watchTimes;
                private int dealCount;
                private int score;
                private long createTime;
                private String agentLevel;
                private String agentImg;
                private Object page;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getMobile() {
                    return mobile;
                }

                public void setMobile(String mobile) {
                    this.mobile = mobile;
                }

                public String getArea() {
                    return area;
                }

                public void setArea(String area) {
                    this.area = area;
                }

                public Object getCity() {
                    return city;
                }

                public void setCity(Object city) {
                    this.city = city;
                }

                public Object getDetailArea() {
                    return detailArea;
                }

                public void setDetailArea(Object detailArea) {
                    this.detailArea = detailArea;
                }

                public String getProject() {
                    return project;
                }

                public void setProject(String project) {
                    this.project = project;
                }

                public String getTag() {
                    return tag;
                }

                public void setTag(String tag) {
                    this.tag = tag;
                }

                public String getStore() {
                    return store;
                }

                public void setStore(String store) {
                    this.store = store;
                }

                public int getWatchTimes() {
                    return watchTimes;
                }

                public void setWatchTimes(int watchTimes) {
                    this.watchTimes = watchTimes;
                }

                public int getDealCount() {
                    return dealCount;
                }

                public void setDealCount(int dealCount) {
                    this.dealCount = dealCount;
                }

                public int getScore() {
                    return score;
                }

                public void setScore(int score) {
                    this.score = score;
                }

                public long getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(long createTime) {
                    this.createTime = createTime;
                }

                public String getAgentLevel() {
                    return agentLevel;
                }

                public void setAgentLevel(String agentLevel) {
                    this.agentLevel = agentLevel;
                }

                public String getAgentImg() {
                    return agentImg;
                }

                public void setAgentImg(String agentImg) {
                    this.agentImg = agentImg;
                }

                public Object getPage() {
                    return page;
                }

                public void setPage(Object page) {
                    this.page = page;
                }
            }
        }
    }
}
