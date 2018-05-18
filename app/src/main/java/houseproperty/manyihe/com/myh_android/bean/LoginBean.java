package houseproperty.manyihe.com.myh_android.bean;

public class LoginBean {

    /**
     * resultBean : {"code":"0","message":"ok","object":{"id":1,"name":"李东伟","password":"","mobile":"13131190980","createTime":1521112030000,"roleId":null,"headUrl":"\r\nhttps://myhtest.oss-cn-beijing.aliyuncs.com/%E7%94%A8%E6%88%B7%E9%BB%98%E8%AE%A4%E5%A4%B4%E5%83%8F/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20180420174312.png","uuid":null,"houseId":"11,12SDFsdfSDFsdfSDFsdfSDFsdfSDFsdfSDFsdf","agentIds":null,"houseIds":null,"email":null},"sessionId":"54B6F65C73E9B6E6954C82554B008326"}
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
         * message : ok
         * object : {"id":1,"name":"李东伟","password":"","mobile":"13131190980","createTime":1521112030000,"roleId":null,"headUrl":"\r\nhttps://myhtest.oss-cn-beijing.aliyuncs.com/%E7%94%A8%E6%88%B7%E9%BB%98%E8%AE%A4%E5%A4%B4%E5%83%8F/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20180420174312.png","uuid":null,"houseId":"11,12SDFsdfSDFsdfSDFsdfSDFsdfSDFsdfSDFsdf","agentIds":null,"houseIds":null,"email":null}
         * sessionId : 54B6F65C73E9B6E6954C82554B008326
         */

        private String code;
        private String message;
        private ObjectBean object;
        private String sessionId;

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

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public static class ObjectBean {
            /**
             * id : 1
             * name : 李东伟
             * password :
             * mobile : 13131190980
             * createTime : 1521112030000
             * roleId : null
             * headUrl :
             https://myhtest.oss-cn-beijing.aliyuncs.com/%E7%94%A8%E6%88%B7%E9%BB%98%E8%AE%A4%E5%A4%B4%E5%83%8F/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20180420174312.png
             * uuid : null
             * houseId : 11,12SDFsdfSDFsdfSDFsdfSDFsdfSDFsdfSDFsdf
             * agentIds : null
             * houseIds : null
             * email : null
             */

            private int id;
            private String name;
            private String password;
            private String mobile;
            private long createTime;
            private Object roleId;
            private String headUrl;
            private Object uuid;
            private String houseId;
            private Object agentIds;
            private Object houseIds;
            private Object email;

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

            public Object getUuid() {
                return uuid;
            }

            public void setUuid(Object uuid) {
                this.uuid = uuid;
            }

            public String getHouseId() {
                return houseId;
            }

            public void setHouseId(String houseId) {
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

            public Object getEmail() {
                return email;
            }

            public void setEmail(Object email) {
                this.email = email;
            }
        }
    }
}
