package houseproperty.manyihe.com.myh_android.bean;

import java.util.List;

/**
 * Created by Mr.周 on 2018/4/20.
 */

public class LayInfoBean {


    /**
     * resultBean : {"code":"0","message":"OK","object":[{"id":5,"houseId":1,"imgA":"https://myhtest.oss-cn-beijing.aliyuncs.com/SALES/YU%20DAO%20ZY/ydzy%20%281%29.jpg","imgB":null,"layout":"两室一厅一卫","measure":"83.42","towards":"南北通透","saleState":"2","avgPrice":"516","explains":"两室一厅一厨一卫一阳台。\n一层两户，一栋楼有三个单元，一共有5层，南北通透","feature":"景观飘窗,全明格局,带阳台,南北通透,有电梯,学区房,地铁房,交通便利","layType":"A","timeStr":"2018-05-16"},{"id":6,"houseId":1,"imgA":"https://myhtest.oss-cn-beijing.aliyuncs.com/SALES/YU%20DAO%20ZY/ydzy%20%282%29.jpg","imgB":null,"layout":"一室一厅一卫一厨","measure":"42","towards":"南北通透","saleState":"2","avgPrice":"507","explains":"一室一厅一厨一卫一阳台。\n一层两户，一栋楼有三个单元，一共有5层，南北通透","feature":"景观飘窗,全明格局,带阳台,南北通透,有电梯,学区房,地铁房,交通便利","layType":"A","timeStr":"2018-05-16"}],"sessionId":null}
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
         * object : [{"id":5,"houseId":1,"imgA":"https://myhtest.oss-cn-beijing.aliyuncs.com/SALES/YU%20DAO%20ZY/ydzy%20%281%29.jpg","imgB":null,"layout":"两室一厅一卫","measure":"83.42","towards":"南北通透","saleState":"2","avgPrice":"516","explains":"两室一厅一厨一卫一阳台。\n一层两户，一栋楼有三个单元，一共有5层，南北通透","feature":"景观飘窗,全明格局,带阳台,南北通透,有电梯,学区房,地铁房,交通便利","layType":"A","timeStr":"2018-05-16"},{"id":6,"houseId":1,"imgA":"https://myhtest.oss-cn-beijing.aliyuncs.com/SALES/YU%20DAO%20ZY/ydzy%20%282%29.jpg","imgB":null,"layout":"一室一厅一卫一厨","measure":"42","towards":"南北通透","saleState":"2","avgPrice":"507","explains":"一室一厅一厨一卫一阳台。\n一层两户，一栋楼有三个单元，一共有5层，南北通透","feature":"景观飘窗,全明格局,带阳台,南北通透,有电梯,学区房,地铁房,交通便利","layType":"A","timeStr":"2018-05-16"}]
         * sessionId : null
         */

        private String code;
        private String message;
        private Object sessionId;
        private List<ObjectBean> object;

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

        public Object getSessionId() {
            return sessionId;
        }

        public void setSessionId(Object sessionId) {
            this.sessionId = sessionId;
        }

        public List<ObjectBean> getObject() {
            return object;
        }

        public void setObject(List<ObjectBean> object) {
            this.object = object;
        }

        public static class ObjectBean {
            /**
             * id : 5
             * houseId : 1
             * imgA : https://myhtest.oss-cn-beijing.aliyuncs.com/SALES/YU%20DAO%20ZY/ydzy%20%281%29.jpg
             * imgB : null
             * layout : 两室一厅一卫
             * measure : 83.42
             * towards : 南北通透
             * saleState : 2
             * avgPrice : 516
             * explains : 两室一厅一厨一卫一阳台。
             * 一层两户，一栋楼有三个单元，一共有5层，南北通透
             * feature : 景观飘窗,全明格局,带阳台,南北通透,有电梯,学区房,地铁房,交通便利
             * layType : A
             * timeStr : 2018-05-16
             */

            private int id;
            private int houseId;
            private String imgA;
            private Object imgB;
            private String layout;
            private String measure;
            private String towards;
            private String saleState;
            private String avgPrice;
            private String explains;
            private String feature;
            private String layType;
            private String timeStr;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getHouseId() {
                return houseId;
            }

            public void setHouseId(int houseId) {
                this.houseId = houseId;
            }

            public String getImgA() {
                return imgA;
            }

            public void setImgA(String imgA) {
                this.imgA = imgA;
            }

            public Object getImgB() {
                return imgB;
            }

            public void setImgB(Object imgB) {
                this.imgB = imgB;
            }

            public String getLayout() {
                return layout;
            }

            public void setLayout(String layout) {
                this.layout = layout;
            }

            public String getMeasure() {
                return measure;
            }

            public void setMeasure(String measure) {
                this.measure = measure;
            }

            public String getTowards() {
                return towards;
            }

            public void setTowards(String towards) {
                this.towards = towards;
            }

            public String getSaleState() {
                return saleState;
            }

            public void setSaleState(String saleState) {
                this.saleState = saleState;
            }

            public String getAvgPrice() {
                return avgPrice;
            }

            public void setAvgPrice(String avgPrice) {
                this.avgPrice = avgPrice;
            }

            public String getExplains() {
                return explains;
            }

            public void setExplains(String explains) {
                this.explains = explains;
            }

            public String getFeature() {
                return feature;
            }

            public void setFeature(String feature) {
                this.feature = feature;
            }

            public String getLayType() {
                return layType;
            }

            public void setLayType(String layType) {
                this.layType = layType;
            }

            public String getTimeStr() {
                return timeStr;
            }

            public void setTimeStr(String timeStr) {
                this.timeStr = timeStr;
            }
        }
    }
}
