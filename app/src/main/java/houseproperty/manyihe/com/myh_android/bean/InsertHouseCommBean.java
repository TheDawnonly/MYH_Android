package houseproperty.manyihe.com.myh_android.bean;

import java.util.List;

public class InsertHouseCommBean {

    /**
     * resultBean : {"code":"0","message":"OK","object":{"pageNum":1,"pageSize":10,"size":2,"startRow":1,"endRow":2,"total":2,"pages":1,"list":[{"id":3,"userId":1,"houseId":1,"comment":"呀呀这是测试","commentTime":null,"timeStr":null,"score":80,"page":null},{"id":4,"userId":1,"houseId":1,"comment":"呀呀这是测试","commentTime":1524820981000,"timeStr":"2018-04-27 17:23:01","score":80,"page":null}],"firstPage":1,"prePage":0,"nextPage":0,"lastPage":1,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1]},"sessionId":null}
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
         * object : {"pageNum":1,"pageSize":10,"size":2,"startRow":1,"endRow":2,"total":2,"pages":1,"list":[{"id":3,"userId":1,"houseId":1,"comment":"呀呀这是测试","commentTime":null,"timeStr":null,"score":80,"page":null},{"id":4,"userId":1,"houseId":1,"comment":"呀呀这是测试","commentTime":1524820981000,"timeStr":"2018-04-27 17:23:01","score":80,"page":null}],"firstPage":1,"prePage":0,"nextPage":0,"lastPage":1,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1]}
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
             * size : 2
             * startRow : 1
             * endRow : 2
             * total : 2
             * pages : 1
             * list : [{"id":3,"userId":1,"houseId":1,"comment":"呀呀这是测试","commentTime":null,"timeStr":null,"score":80,"page":null},{"id":4,"userId":1,"houseId":1,"comment":"呀呀这是测试","commentTime":1524820981000,"timeStr":"2018-04-27 17:23:01","score":80,"page":null}]
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
                 * id : 3
                 * userId : 1
                 * houseId : 1
                 * comment : 呀呀这是测试
                 * commentTime : null
                 * timeStr : null
                 * score : 80
                 * page : null
                 */

                private int id;
                private int userId;
                private int houseId;
                private String comment;
                private Object commentTime;
                private Object timeStr;
                private int score;
                private Object page;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getUserId() {
                    return userId;
                }

                public void setUserId(int userId) {
                    this.userId = userId;
                }

                public int getHouseId() {
                    return houseId;
                }

                public void setHouseId(int houseId) {
                    this.houseId = houseId;
                }

                public String getComment() {
                    return comment;
                }

                public void setComment(String comment) {
                    this.comment = comment;
                }

                public Object getCommentTime() {
                    return commentTime;
                }

                public void setCommentTime(Object commentTime) {
                    this.commentTime = commentTime;
                }

                public Object getTimeStr() {
                    return timeStr;
                }

                public void setTimeStr(Object timeStr) {
                    this.timeStr = timeStr;
                }

                public int getScore() {
                    return score;
                }

                public void setScore(int score) {
                    this.score = score;
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
