package houseproperty.manyihe.com.myh_android.bean;

import java.util.List;

/**
 * Created by Mr.周 on 2018/4/20.
 */

public class LayInfoBean {

    /**
     * resultBean : {"code":"0","message":"OK","object":[{"id":1,"houseId":1,"imgA":"https://myhtest.oss-cn-beijing.aliyuncs.com/image2.jpg","imgB":null,"layout":"三室两厅两卫","measure":"99.8","towards":"南北通透","saleState":"2","avgPrice":"500","explains":"描述介绍啊手动阀手动阀手动阀手动阀阿斯顿发射点发射点发生","feature":"带阳台,全明格局"},{"id":2,"houseId":1,"imgA":"https://myhtest.oss-cn-beijing.aliyuncs.com/image2.jpg","imgB":null,"layout":"三室两厅两卫","measure":"91.3","towards":"南北通透","saleState":"2","avgPrice":"300","explains":"发的规划风格化法国生","feature":"带阳台,全明格局"}],"sessionId":null}
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
         * object : [{"id":1,"houseId":1,"imgA":"https://myhtest.oss-cn-beijing.aliyuncs.com/image2.jpg","imgB":null,"layout":"三室两厅两卫","measure":"99.8","towards":"南北通透","saleState":"2","avgPrice":"500","explains":"描述介绍啊手动阀手动阀手动阀手动阀阿斯顿发射点发射点发生","feature":"带阳台,全明格局"},{"id":2,"houseId":1,"imgA":"https://myhtest.oss-cn-beijing.aliyuncs.com/image2.jpg","imgB":null,"layout":"三室两厅两卫","measure":"91.3","towards":"南北通透","saleState":"2","avgPrice":"300","explains":"发的规划风格化法国生","feature":"带阳台,全明格局"}]
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
             * id : 1
             * houseId : 1
             * imgA : https://myhtest.oss-cn-beijing.aliyuncs.com/image2.jpg
             * imgB : null
             * layout : 三室两厅两卫
             * measure : 99.8
             * towards : 南北通透
             * saleState : 2
             * avgPrice : 500
             * explains : 描述介绍啊手动阀手动阀手动阀手动阀阿斯顿发射点发射点发生
             * feature : 带阳台,全明格局
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
        }
    }
}
