package houseproperty.manyihe.com.myh_android.bean;

/**
 * Created by Mr.周 on 2018/4/10.
 */

public class MessageDetailsBean {


    /**
     * resultBean : {"code":"0","message":"OK","object":{"id":1,"floorTitle":"促销楼盘","floorPreview":"促销楼盘","floorType":"","floorWriter":"阿满","floorDate":1522044985000,"copyright":"满意何产权","imgUrl":"https://myhtest.oss-cn-beijing.aliyuncs.com/FLOOR/floor%2520%281%29%5B1%5D.jpg","content":"<p align=\"left\" style=\"text-align:center;font-family:&quot;font-size:13.3333px;background-color:#FFFFFF;\">\r\n\t<span style=\"background-color:transparent;font-family:&quot;font-size:12px;\">&nbsp;<\/span><span style=\"color:#333333;font-family:Verdana, Arial, Tahoma;font-size:16px;\">&nbsp;&nbsp; &nbsp; 想必这时节，西安的樱花都开放了吧，曾记得七年前，那时，樱花灿烂在枝头。如今family:Verdana, Arial, Tahoma;font-size:16px;\">有福的。愿你有生之年，不要错过耶稣基督。阿们<\/span>\r\n<\/p>"},"sessionId":null}
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
         * object : {"id":1,"floorTitle":"促销楼盘","floorPreview":"促销楼盘","floorType":"","floorWriter":"阿满","floorDate":1522044985000,"copyright":"满意何产权","imgUrl":"https://myhtest.oss-cn-beijing.aliyuncs.com/FLOOR/floor%2520%281%29%5B1%5D.jpg","content":"<p align=\"left\" style=\"text-align:center;font-family:&quot;font-size:13.3333px;background-color:#FFFFFF;\">\r\n\t<span style=\"background-color:transparent;font-family:&quot;font-size:12px;\">&nbsp;<\/span><span style=\"color:#333333;font-family:Verdana, Arial, Tahoma;font-size:16px;\">&nbsp;&nbsp; &nbsp; 想必这时节，西安的樱花都开放了吧，曾记得七年前，那时，樱花灿烂在枝头。如今family:Verdana, Arial, Tahoma;font-size:16px;\">有福的。愿你有生之年，不要错过耶稣基督。阿们<\/span>\r\n<\/p>"}
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
             * floorTitle : 促销楼盘
             * floorPreview : 促销楼盘
             * floorType :
             * floorWriter : 阿满
             * floorDate : 1522044985000
             * copyright : 满意何产权
             * imgUrl : https://myhtest.oss-cn-beijing.aliyuncs.com/FLOOR/floor%2520%281%29%5B1%5D.jpg
             * content : <p align="left" style="text-align:center;font-family:&quot;font-size:13.3333px;background-color:#FFFFFF;">
             * <span style="background-color:transparent;font-family:&quot;font-size:12px;">&nbsp;</span><span style="color:#333333;font-family:Verdana, Arial, Tahoma;font-size:16px;">&nbsp;&nbsp; &nbsp; 想必这时节，西安的樱花都开放了吧，曾记得七年前，那时，樱花灿烂在枝头。如今family:Verdana, Arial, Tahoma;font-size:16px;">有福的。愿你有生之年，不要错过耶稣基督。阿们</span>
             * </p>
             */

            private int id;
            private String floorTitle;
            private String floorPreview;
            private String floorType;
            private String floorWriter;
            private long floorDate;
            private String copyright;
            private String imgUrl;
            private String content;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getFloorTitle() {
                return floorTitle;
            }

            public void setFloorTitle(String floorTitle) {
                this.floorTitle = floorTitle;
            }

            public String getFloorPreview() {
                return floorPreview;
            }

            public void setFloorPreview(String floorPreview) {
                this.floorPreview = floorPreview;
            }

            public String getFloorType() {
                return floorType;
            }

            public void setFloorType(String floorType) {
                this.floorType = floorType;
            }

            public String getFloorWriter() {
                return floorWriter;
            }

            public void setFloorWriter(String floorWriter) {
                this.floorWriter = floorWriter;
            }

            public long getFloorDate() {
                return floorDate;
            }

            public void setFloorDate(long floorDate) {
                this.floorDate = floorDate;
            }

            public String getCopyright() {
                return copyright;
            }

            public void setCopyright(String copyright) {
                this.copyright = copyright;
            }

            public String getImgUrl() {
                return imgUrl;
            }

            public void setImgUrl(String imgUrl) {
                this.imgUrl = imgUrl;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }
        }
    }
}
