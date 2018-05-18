package houseproperty.manyihe.com.myh_android.bean;

public class UpLoadImageBean {

    /**
     * resultBean : {"code":"0","message":"ok","object":"https://oss_safrerwsfsa-123456789.jpg","sessionId":null}
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
         * object : https://oss_safrerwsfsa-123456789.jpg
         * sessionId : null
         */

        private String code;
        private String message;
        private String object;
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

        public String getObject() {
            return object;
        }

        public void setObject(String object) {
            this.object = object;
        }

        public Object getSessionId() {
            return sessionId;
        }

        public void setSessionId(Object sessionId) {
            this.sessionId = sessionId;
        }
    }
}
