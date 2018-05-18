package houseproperty.manyihe.com.myh_android.bean;

public class UserInfoShowBean {

    /**
     * resultBean : {"code":"0","message":"OK","object":{"id":18,"name":"小兰","password":"e10adc3949ba59abbe56e057f20f883e","mobile":"18201652075","createTime":1522051810000,"roleId":null,"headUrl":"https://myhtest.oss-cn-beijing.aliyuncs.com/%E7%94%A8%E6%88%B7%E9%BB%98%E8%AE%A4%E5%A4%B4%E5%83%8F/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20180420174312.png","uuid":"a7004cf2-40d3-4a22-88f4-7b32deaf0961","houseId":null,"agentIds":null,"houseIds":null,"email":"675199298@QQ.com"},"sessionId":null}
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
         * object : {"id":18,"name":"小兰","password":"e10adc3949ba59abbe56e057f20f883e","mobile":"18201652075","createTime":1522051810000,"roleId":null,"headUrl":"https://myhtest.oss-cn-beijing.aliyuncs.com/%E7%94%A8%E6%88%B7%E9%BB%98%E8%AE%A4%E5%A4%B4%E5%83%8F/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20180420174312.png","uuid":"a7004cf2-40d3-4a22-88f4-7b32deaf0961","houseId":null,"agentIds":null,"houseIds":null,"email":"675199298@QQ.com"}
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
             * id : 18
             * name : 小兰
             * password : e10adc3949ba59abbe56e057f20f883e
             * mobile : 18201652075
             * createTime : 1522051810000
             * roleId : null
             * headUrl : https://myhtest.oss-cn-beijing.aliyuncs.com/%E7%94%A8%E6%88%B7%E9%BB%98%E8%AE%A4%E5%A4%B4%E5%83%8F/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20180420174312.png
             * uuid : a7004cf2-40d3-4a22-88f4-7b32deaf0961
             * houseId : null
             * agentIds : null
             * houseIds : null
             * email : 675199298@QQ.com
             */

            private int id;
            private String name;
            private String password;
            private String mobile;
            private long createTime;
            private Object roleId;
            private String headUrl;
            private String uuid;
            private Object houseId;
            private Object agentIds;
            private Object houseIds;
            private String email;

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

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public Object getRoleId() {
                return roleId;
            }

            public void setRoleId(Object roleId) {
                this.roleId = roleId;
            }

            public String getHeadUrl() {
                return headUrl;
            }

            public void setHeadUrl(String headUrl) {
                this.headUrl = headUrl;
            }

            public String getUuid() {
                return uuid;
            }

            public void setUuid(String uuid) {
                this.uuid = uuid;
            }

            public Object getHouseId() {
                return houseId;
            }

            public void setHouseId(Object houseId) {
                this.houseId = houseId;
            }

            public Object getAgentIds() {
                return agentIds;
            }

            public void setAgentIds(Object agentIds) {
                this.agentIds = agentIds;
            }

            public Object getHouseIds() {
                return houseIds;
            }

            public void setHouseIds(Object houseIds) {
                this.houseIds = houseIds;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }
        }
    }
}
