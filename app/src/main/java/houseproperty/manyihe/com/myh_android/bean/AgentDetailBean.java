package houseproperty.manyihe.com.myh_android.bean;

public class AgentDetailBean {

    /**
     * resultBean : {"code":"0","message":"OK","object":{"id":1,"name":"敖凤强","mobile":"18730494984","area":"河北","project":"滦平","tag":"客户好评","store":"河北店","watchTimes":100,"dealCount":55,"score":0,"createTime":1523503722000,"agentLevel":"1","agentImg":"https://myhtest.oss-cn-beijing.aliyuncs.com/%E7%BB%8F%E7%BA%AA%E4%BA%BA%E5%A4%B4%E5%83%8F/%E6%89%BF%E5%BE%B7%E5%8C%BA%E5%9F%9F%E7%85%A7%E7%89%87/1.png","page":null},"sessionId":null}
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
         * object : {"id":1,"name":"敖凤强","mobile":"18730494984","area":"河北","project":"滦平","tag":"客户好评","store":"河北店","watchTimes":100,"dealCount":55,"score":0,"createTime":1523503722000,"agentLevel":"1","agentImg":"https://myhtest.oss-cn-beijing.aliyuncs.com/%E7%BB%8F%E7%BA%AA%E4%BA%BA%E5%A4%B4%E5%83%8F/%E6%89%BF%E5%BE%B7%E5%8C%BA%E5%9F%9F%E7%85%A7%E7%89%87/1.png","page":null}
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
             * id : 1
             * name : 敖凤强
             * mobile : 18730494984
             * area : 河北
             * project : 滦平
             * tag : 客户好评
             * store : 河北店
             * watchTimes : 100
             * dealCount : 55
             * score : 0
             * createTime : 1523503722000
             * agentLevel : 1
             * agentImg : https://myhtest.oss-cn-beijing.aliyuncs.com/%E7%BB%8F%E7%BA%AA%E4%BA%BA%E5%A4%B4%E5%83%8F/%E6%89%BF%E5%BE%B7%E5%8C%BA%E5%9F%9F%E7%85%A7%E7%89%87/1.png
             * page : null
             */

            private int id;
            private String name;
            private String mobile;
            private String area;
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
