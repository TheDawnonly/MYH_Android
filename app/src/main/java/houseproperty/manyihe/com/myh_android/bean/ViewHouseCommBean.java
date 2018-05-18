package houseproperty.manyihe.com.myh_android.bean;

import java.util.List;

public class ViewHouseCommBean {

    /**
     * resultBean : {"code":"0","message":"OK","object":{"pageNum":1,"pageSize":10,"size":7,"startRow":1,"endRow":7,"total":18,"pages":2,"list":[{"id":3,"userId":1,"houseId":1,"comment":"呀呀这是测试","commentTime":1525242858000,"headUrl":"asdf","mobile":"131****0980","timeStr":"2018-05-02 14:34:18","score":80,"page":null,"replyList":[{"reId":1,"ruserId":2,"commId":3,"commReply":"我是回复","replyType":1,"createTime":1525671847000,"rTimeStr":"2018-05-07 13:44:07","rMobile":"131****0980","rHeadUrl":"sdf"},{"reId":2,"ruserId":3,"commId":3,"commReply":"我是回复啊","replyType":1,"createTime":1525678119000,"rTimeStr":"2018-05-07 15:28:39","rMobile":"132****6523","rHeadUrl":"wer"},{"reId":3,"ruserId":1,"commId":3,"commReply":"我回复","replyType":1,"createTime":1525831913000,"rTimeStr":"2018-05-09 10:11:53","rMobile":"131****0980","rHeadUrl":"sdf"},{"reId":4,"ruserId":1,"commId":3,"commReply":"我是回复哈哈","replyType":1,"createTime":1525832873000,"rTimeStr":"2018-05-09 10:27:53","rMobile":"131****0980","rHeadUrl":"\r\nhttps://myhtest.oss-cn-beijing.aliyuncs.com/%E7%94%A8%E6%88%B7%E9%BB%98%E8%AE%A4%E5%A4%B4%E5%83%8F/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20180420174312.png"}]},{"id":4,"userId":1,"houseId":1,"comment":"呀呀这测试","commentTime":1524820981000,"headUrl":null,"mobile":"","timeStr":"2018-04-27 17:23:01","score":80,"page":null,"replyList":[{"reId":null,"ruserId":null,"commId":null,"commReply":null,"replyType":null,"createTime":null,"rTimeStr":null,"rMobile":"","rHeadUrl":null}]},{"id":7,"userId":24,"houseId":1,"comment":"很棒的小区","commentTime":1525425594000,"headUrl":null,"mobile":"","timeStr":"2018-05-04 17:19:54","score":100,"page":null,"replyList":[{"reId":null,"ruserId":null,"commId":null,"commReply":null,"replyType":null,"createTime":null,"rTimeStr":null,"rMobile":"","rHeadUrl":null}]},{"id":8,"userId":24,"houseId":1,"comment":"很不错的小区","commentTime":1525426355000,"headUrl":null,"mobile":"","timeStr":"2018-05-04 17:32:35","score":100,"page":null,"replyList":[{"reId":null,"ruserId":null,"commId":null,"commReply":null,"replyType":null,"createTime":null,"rTimeStr":null,"rMobile":"","rHeadUrl":null}]},{"id":9,"userId":24,"houseId":1,"comment":"很不错的房子","commentTime":1525426416000,"headUrl":null,"mobile":"","timeStr":"2018-05-04 17:33:36","score":100,"page":null,"replyList":[{"reId":null,"ruserId":null,"commId":null,"commReply":null,"replyType":null,"createTime":null,"rTimeStr":null,"rMobile":"","rHeadUrl":null}]},{"id":10,"userId":24,"houseId":1,"comment":"3333333333333333333","commentTime":1525426457000,"headUrl":null,"mobile":"","timeStr":"2018-05-04 17:34:17","score":100,"page":null,"replyList":[{"reId":null,"ruserId":null,"commId":null,"commReply":null,"replyType":null,"createTime":null,"rTimeStr":null,"rMobile":"","rHeadUrl":null}]},{"id":11,"userId":24,"houseId":1,"comment":"不错的小区 超喜欢！ 准备来一套","commentTime":1525426508000,"headUrl":null,"mobile":"","timeStr":"2018-05-04 17:35:08","score":100,"page":null,"replyList":[{"reId":null,"ruserId":null,"commId":null,"commReply":null,"replyType":null,"createTime":null,"rTimeStr":null,"rMobile":"","rHeadUrl":null}]}],"firstPage":1,"prePage":0,"nextPage":2,"lastPage":2,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":8,"navigatepageNums":[1,2]},"sessionId":null}
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
         * object : {"pageNum":1,"pageSize":10,"size":7,"startRow":1,"endRow":7,"total":18,"pages":2,"list":[{"id":3,"userId":1,"houseId":1,"comment":"呀呀这是测试","commentTime":1525242858000,"headUrl":"asdf","mobile":"131****0980","timeStr":"2018-05-02 14:34:18","score":80,"page":null,"replyList":[{"reId":1,"ruserId":2,"commId":3,"commReply":"我是回复","replyType":1,"createTime":1525671847000,"rTimeStr":"2018-05-07 13:44:07","rMobile":"131****0980","rHeadUrl":"sdf"},{"reId":2,"ruserId":3,"commId":3,"commReply":"我是回复啊","replyType":1,"createTime":1525678119000,"rTimeStr":"2018-05-07 15:28:39","rMobile":"132****6523","rHeadUrl":"wer"},{"reId":3,"ruserId":1,"commId":3,"commReply":"我回复","replyType":1,"createTime":1525831913000,"rTimeStr":"2018-05-09 10:11:53","rMobile":"131****0980","rHeadUrl":"sdf"},{"reId":4,"ruserId":1,"commId":3,"commReply":"我是回复哈哈","replyType":1,"createTime":1525832873000,"rTimeStr":"2018-05-09 10:27:53","rMobile":"131****0980","rHeadUrl":"\r\nhttps://myhtest.oss-cn-beijing.aliyuncs.com/%E7%94%A8%E6%88%B7%E9%BB%98%E8%AE%A4%E5%A4%B4%E5%83%8F/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20180420174312.png"}]},{"id":4,"userId":1,"houseId":1,"comment":"呀呀这测试","commentTime":1524820981000,"headUrl":null,"mobile":"","timeStr":"2018-04-27 17:23:01","score":80,"page":null,"replyList":[{"reId":null,"ruserId":null,"commId":null,"commReply":null,"replyType":null,"createTime":null,"rTimeStr":null,"rMobile":"","rHeadUrl":null}]},{"id":7,"userId":24,"houseId":1,"comment":"很棒的小区","commentTime":1525425594000,"headUrl":null,"mobile":"","timeStr":"2018-05-04 17:19:54","score":100,"page":null,"replyList":[{"reId":null,"ruserId":null,"commId":null,"commReply":null,"replyType":null,"createTime":null,"rTimeStr":null,"rMobile":"","rHeadUrl":null}]},{"id":8,"userId":24,"houseId":1,"comment":"很不错的小区","commentTime":1525426355000,"headUrl":null,"mobile":"","timeStr":"2018-05-04 17:32:35","score":100,"page":null,"replyList":[{"reId":null,"ruserId":null,"commId":null,"commReply":null,"replyType":null,"createTime":null,"rTimeStr":null,"rMobile":"","rHeadUrl":null}]},{"id":9,"userId":24,"houseId":1,"comment":"很不错的房子","commentTime":1525426416000,"headUrl":null,"mobile":"","timeStr":"2018-05-04 17:33:36","score":100,"page":null,"replyList":[{"reId":null,"ruserId":null,"commId":null,"commReply":null,"replyType":null,"createTime":null,"rTimeStr":null,"rMobile":"","rHeadUrl":null}]},{"id":10,"userId":24,"houseId":1,"comment":"3333333333333333333","commentTime":1525426457000,"headUrl":null,"mobile":"","timeStr":"2018-05-04 17:34:17","score":100,"page":null,"replyList":[{"reId":null,"ruserId":null,"commId":null,"commReply":null,"replyType":null,"createTime":null,"rTimeStr":null,"rMobile":"","rHeadUrl":null}]},{"id":11,"userId":24,"houseId":1,"comment":"不错的小区 超喜欢！ 准备来一套","commentTime":1525426508000,"headUrl":null,"mobile":"","timeStr":"2018-05-04 17:35:08","score":100,"page":null,"replyList":[{"reId":null,"ruserId":null,"commId":null,"commReply":null,"replyType":null,"createTime":null,"rTimeStr":null,"rMobile":"","rHeadUrl":null}]}],"firstPage":1,"prePage":0,"nextPage":2,"lastPage":2,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":8,"navigatepageNums":[1,2]}
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
             * size : 7
             * startRow : 1
             * endRow : 7
             * total : 18
             * pages : 2
             * list : [{"id":3,"userId":1,"houseId":1,"comment":"呀呀这是测试","commentTime":1525242858000,"headUrl":"asdf","mobile":"131****0980","timeStr":"2018-05-02 14:34:18","score":80,"page":null,"replyList":[{"reId":1,"ruserId":2,"commId":3,"commReply":"我是回复","replyType":1,"createTime":1525671847000,"rTimeStr":"2018-05-07 13:44:07","rMobile":"131****0980","rHeadUrl":"sdf"},{"reId":2,"ruserId":3,"commId":3,"commReply":"我是回复啊","replyType":1,"createTime":1525678119000,"rTimeStr":"2018-05-07 15:28:39","rMobile":"132****6523","rHeadUrl":"wer"},{"reId":3,"ruserId":1,"commId":3,"commReply":"我回复","replyType":1,"createTime":1525831913000,"rTimeStr":"2018-05-09 10:11:53","rMobile":"131****0980","rHeadUrl":"sdf"},{"reId":4,"ruserId":1,"commId":3,"commReply":"我是回复哈哈","replyType":1,"createTime":1525832873000,"rTimeStr":"2018-05-09 10:27:53","rMobile":"131****0980","rHeadUrl":"\r\nhttps://myhtest.oss-cn-beijing.aliyuncs.com/%E7%94%A8%E6%88%B7%E9%BB%98%E8%AE%A4%E5%A4%B4%E5%83%8F/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20180420174312.png"}]},{"id":4,"userId":1,"houseId":1,"comment":"呀呀这测试","commentTime":1524820981000,"headUrl":null,"mobile":"","timeStr":"2018-04-27 17:23:01","score":80,"page":null,"replyList":[{"reId":null,"ruserId":null,"commId":null,"commReply":null,"replyType":null,"createTime":null,"rTimeStr":null,"rMobile":"","rHeadUrl":null}]},{"id":7,"userId":24,"houseId":1,"comment":"很棒的小区","commentTime":1525425594000,"headUrl":null,"mobile":"","timeStr":"2018-05-04 17:19:54","score":100,"page":null,"replyList":[{"reId":null,"ruserId":null,"commId":null,"commReply":null,"replyType":null,"createTime":null,"rTimeStr":null,"rMobile":"","rHeadUrl":null}]},{"id":8,"userId":24,"houseId":1,"comment":"很不错的小区","commentTime":1525426355000,"headUrl":null,"mobile":"","timeStr":"2018-05-04 17:32:35","score":100,"page":null,"replyList":[{"reId":null,"ruserId":null,"commId":null,"commReply":null,"replyType":null,"createTime":null,"rTimeStr":null,"rMobile":"","rHeadUrl":null}]},{"id":9,"userId":24,"houseId":1,"comment":"很不错的房子","commentTime":1525426416000,"headUrl":null,"mobile":"","timeStr":"2018-05-04 17:33:36","score":100,"page":null,"replyList":[{"reId":null,"ruserId":null,"commId":null,"commReply":null,"replyType":null,"createTime":null,"rTimeStr":null,"rMobile":"","rHeadUrl":null}]},{"id":10,"userId":24,"houseId":1,"comment":"3333333333333333333","commentTime":1525426457000,"headUrl":null,"mobile":"","timeStr":"2018-05-04 17:34:17","score":100,"page":null,"replyList":[{"reId":null,"ruserId":null,"commId":null,"commReply":null,"replyType":null,"createTime":null,"rTimeStr":null,"rMobile":"","rHeadUrl":null}]},{"id":11,"userId":24,"houseId":1,"comment":"不错的小区 超喜欢！ 准备来一套","commentTime":1525426508000,"headUrl":null,"mobile":"","timeStr":"2018-05-04 17:35:08","score":100,"page":null,"replyList":[{"reId":null,"ruserId":null,"commId":null,"commReply":null,"replyType":null,"createTime":null,"rTimeStr":null,"rMobile":"","rHeadUrl":null}]}]
             * firstPage : 1
             * prePage : 0
             * nextPage : 2
             * lastPage : 2
             * isFirstPage : true
             * isLastPage : false
             * hasPreviousPage : false
             * hasNextPage : true
             * navigatePages : 8
             * navigatepageNums : [1,2]
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
                 * commentTime : 1525242858000
                 * headUrl : asdf
                 * mobile : 131****0980
                 * timeStr : 2018-05-02 14:34:18
                 * score : 80
                 * page : null
                 * replyList : [{"reId":1,"ruserId":2,"commId":3,"commReply":"我是回复","replyType":1,"createTime":1525671847000,"rTimeStr":"2018-05-07 13:44:07","rMobile":"131****0980","rHeadUrl":"sdf"},{"reId":2,"ruserId":3,"commId":3,"commReply":"我是回复啊","replyType":1,"createTime":1525678119000,"rTimeStr":"2018-05-07 15:28:39","rMobile":"132****6523","rHeadUrl":"wer"},{"reId":3,"ruserId":1,"commId":3,"commReply":"我回复","replyType":1,"createTime":1525831913000,"rTimeStr":"2018-05-09 10:11:53","rMobile":"131****0980","rHeadUrl":"sdf"},{"reId":4,"ruserId":1,"commId":3,"commReply":"我是回复哈哈","replyType":1,"createTime":1525832873000,"rTimeStr":"2018-05-09 10:27:53","rMobile":"131****0980","rHeadUrl":"\r\nhttps://myhtest.oss-cn-beijing.aliyuncs.com/%E7%94%A8%E6%88%B7%E9%BB%98%E8%AE%A4%E5%A4%B4%E5%83%8F/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20180420174312.png"}]
                 */

                private int id;
                private int userId;
                private int houseId;
                private String comment;
                private long commentTime;
                private String headUrl;
                private String mobile;
                private String timeStr;
                private int score;
                private Object page;
                private List<ReplyListBean> replyList;

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

                public long getCommentTime() {
                    return commentTime;
                }

                public void setCommentTime(long commentTime) {
                    this.commentTime = commentTime;
                }

                public String getHeadUrl() {
                    return headUrl;
                }

                public void setHeadUrl(String headUrl) {
                    this.headUrl = headUrl;
                }

                public String getMobile() {
                    return mobile;
                }

                public void setMobile(String mobile) {
                    this.mobile = mobile;
                }

                public String getTimeStr() {
                    return timeStr;
                }

                public void setTimeStr(String timeStr) {
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

                public List<ReplyListBean> getReplyList() {
                    return replyList;
                }

                public void setReplyList(List<ReplyListBean> replyList) {
                    this.replyList = replyList;
                }

                public static class ReplyListBean {
                    /**
                     * reId : 1
                     * ruserId : 2
                     * commId : 3
                     * commReply : 我是回复
                     * replyType : 1
                     * createTime : 1525671847000
                     * rTimeStr : 2018-05-07 13:44:07
                     * rMobile : 131****0980
                     * rHeadUrl : sdf
                     */

                    private int reId;
                    private int ruserId;
                    private int commId;
                    private String commReply;
                    private int replyType;
                    private long createTime;
                    private String rTimeStr;
                    private String rMobile;
                    private String rHeadUrl;

                    public int getReId() {
                        return reId;
                    }

                    public void setReId(int reId) {
                        this.reId = reId;
                    }

                    public int getRuserId() {
                        return ruserId;
                    }

                    public void setRuserId(int ruserId) {
                        this.ruserId = ruserId;
                    }

                    public int getCommId() {
                        return commId;
                    }

                    public void setCommId(int commId) {
                        this.commId = commId;
                    }

                    public String getCommReply() {
                        return commReply;
                    }

                    public void setCommReply(String commReply) {
                        this.commReply = commReply;
                    }

                    public int getReplyType() {
                        return replyType;
                    }

                    public void setReplyType(int replyType) {
                        this.replyType = replyType;
                    }

                    public long getCreateTime() {
                        return createTime;
                    }

                    public void setCreateTime(long createTime) {
                        this.createTime = createTime;
                    }

                    public String getRTimeStr() {
                        return rTimeStr;
                    }

                    public void setRTimeStr(String rTimeStr) {
                        this.rTimeStr = rTimeStr;
                    }

                    public String getRMobile() {
                        return rMobile;
                    }

                    public void setRMobile(String rMobile) {
                        this.rMobile = rMobile;
                    }

                    public String getRHeadUrl() {
                        return rHeadUrl;
                    }

                    public void setRHeadUrl(String rHeadUrl) {
                        this.rHeadUrl = rHeadUrl;
                    }
                }
            }
        }
    }
}
