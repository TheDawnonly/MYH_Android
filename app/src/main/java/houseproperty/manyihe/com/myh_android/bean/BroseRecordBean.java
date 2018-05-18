package houseproperty.manyihe.com.myh_android.bean;

import java.util.List;

public class BroseRecordBean {

    /**
     * resultBean : {"code":"0","message":"OK","object":[{"id":1,"userId":null,"title":"美丽无雾霾的家","subTitle":"御道庄园","layout":"两室一厅","measure":"83.42","floor":"五层","address":"承德市围场满族蒙古族自治县御道口","downPrice":16,"averagePrice":6196,"price":51,"towards":"南北通透","imgId":"https://myhtest.oss-%29.jpg,https://myhtest.oss-cn-","layImg":"2","mainImg":"https://myhtest.oss-cupan%20%281%29.jpg","state":2,"type":0,"feature":"景观飘窗,全明格局,带阳台,南北通透,有电梯,学区房,地铁房,交通便利","explains":"两室一厅一厨一卫一阳台。\n一层两户，一栋楼有三个单元","createTime":1521531899000,"updateTime":null,"isVisible":0,"houseType":"普通住宅","elevator":"无电梯","equity":"70年","fitment":"毛胚","afforest":"35％","houseTimes":"2017","bannerImg":"https://myhtest.oss-cozhuangy.jpg","province":"河北","city":"石家庄","area":"新乐","timeStr":null,"page":null,"houseId":null,"baseImgList":null,"layoutImgList":null,"imgMap":null}],"sessionId":null}
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
         * object : [{"id":1,"userId":null,"title":"美丽无雾霾的家","subTitle":"御道庄园","layout":"两室一厅","measure":"83.42","floor":"五层","address":"承德市围场满族蒙古族自治县御道口","downPrice":16,"averagePrice":6196,"price":51,"towards":"南北通透","imgId":"https://myhtest.oss-%29.jpg,https://myhtest.oss-cn-","layImg":"2","mainImg":"https://myhtest.oss-cupan%20%281%29.jpg","state":2,"type":0,"feature":"景观飘窗,全明格局,带阳台,南北通透,有电梯,学区房,地铁房,交通便利","explains":"两室一厅一厨一卫一阳台。\n一层两户，一栋楼有三个单元","createTime":1521531899000,"updateTime":null,"isVisible":0,"houseType":"普通住宅","elevator":"无电梯","equity":"70年","fitment":"毛胚","afforest":"35％","houseTimes":"2017","bannerImg":"https://myhtest.oss-cozhuangy.jpg","province":"河北","city":"石家庄","area":"新乐","timeStr":null,"page":null,"houseId":null,"baseImgList":null,"layoutImgList":null,"imgMap":null}]
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
             * userId : null
             * title : 美丽无雾霾的家
             * subTitle : 御道庄园
             * layout : 两室一厅
             * measure : 83.42
             * floor : 五层
             * address : 承德市围场满族蒙古族自治县御道口
             * downPrice : 16
             * averagePrice : 6196
             * price : 51
             * towards : 南北通透
             * imgId : https://myhtest.oss-%29.jpg,https://myhtest.oss-cn-
             * layImg : 2
             * mainImg : https://myhtest.oss-cupan%20%281%29.jpg
             * state : 2
             * type : 0
             * feature : 景观飘窗,全明格局,带阳台,南北通透,有电梯,学区房,地铁房,交通便利
             * explains : 两室一厅一厨一卫一阳台。
             一层两户，一栋楼有三个单元
             * createTime : 1521531899000
             * updateTime : null
             * isVisible : 0
             * houseType : 普通住宅
             * elevator : 无电梯
             * equity : 70年
             * fitment : 毛胚
             * afforest : 35％
             * houseTimes : 2017
             * bannerImg : https://myhtest.oss-cozhuangy.jpg
             * province : 河北
             * city : 石家庄
             * area : 新乐
             * timeStr : null
             * page : null
             * houseId : null
             * baseImgList : null
             * layoutImgList : null
             * imgMap : null
             */

            private int id;
            private Object userId;
            private String title;
            private String subTitle;
            private String layout;
            private String measure;
            private String floor;
            private String address;
            private double downPrice;
            private int averagePrice;
            private int price;
            private String towards;
            private String imgId;
            private String layImg;
            private String mainImg;
            private int state;
            private int type;
            private String feature;
            private String explains;
            private long createTime;
            private Object updateTime;
            private int isVisible;
            private String houseType;
            private String elevator;
            private String equity;
            private String fitment;
            private String afforest;
            private String houseTimes;
            private String bannerImg;
            private String province;
            private String city;
            private String area;
            private Object timeStr;
            private Object page;
            private Object houseId;
            private Object baseImgList;
            private Object layoutImgList;
            private Object imgMap;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public Object getUserId() {
                return userId;
            }

            public void setUserId(Object userId) {
                this.userId = userId;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getSubTitle() {
                return subTitle;
            }

            public void setSubTitle(String subTitle) {
                this.subTitle = subTitle;
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

            public String getFloor() {
                return floor;
            }

            public void setFloor(String floor) {
                this.floor = floor;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public double getDownPrice() {
                return downPrice;
            }

            public void setDownPrice(double downPrice) {
                this.downPrice = downPrice;
            }

            public int getAveragePrice() {
                return averagePrice;
            }

            public void setAveragePrice(int averagePrice) {
                this.averagePrice = averagePrice;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public String getTowards() {
                return towards;
            }

            public void setTowards(String towards) {
                this.towards = towards;
            }

            public String getImgId() {
                return imgId;
            }

            public void setImgId(String imgId) {
                this.imgId = imgId;
            }

            public String getLayImg() {
                return layImg;
            }

            public void setLayImg(String layImg) {
                this.layImg = layImg;
            }

            public String getMainImg() {
                return mainImg;
            }

            public void setMainImg(String mainImg) {
                this.mainImg = mainImg;
            }

            public int getState() {
                return state;
            }

            public void setState(int state) {
                this.state = state;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getFeature() {
                return feature;
            }

            public void setFeature(String feature) {
                this.feature = feature;
            }

            public String getExplains() {
                return explains;
            }

            public void setExplains(String explains) {
                this.explains = explains;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public Object getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(Object updateTime) {
                this.updateTime = updateTime;
            }

            public int getIsVisible() {
                return isVisible;
            }

            public void setIsVisible(int isVisible) {
                this.isVisible = isVisible;
            }

            public String getHouseType() {
                return houseType;
            }

            public void setHouseType(String houseType) {
                this.houseType = houseType;
            }

            public String getElevator() {
                return elevator;
            }

            public void setElevator(String elevator) {
                this.elevator = elevator;
            }

            public String getEquity() {
                return equity;
            }

            public void setEquity(String equity) {
                this.equity = equity;
            }

            public String getFitment() {
                return fitment;
            }

            public void setFitment(String fitment) {
                this.fitment = fitment;
            }

            public String getAfforest() {
                return afforest;
            }

            public void setAfforest(String afforest) {
                this.afforest = afforest;
            }

            public String getHouseTimes() {
                return houseTimes;
            }

            public void setHouseTimes(String houseTimes) {
                this.houseTimes = houseTimes;
            }

            public String getBannerImg() {
                return bannerImg;
            }

            public void setBannerImg(String bannerImg) {
                this.bannerImg = bannerImg;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public Object getTimeStr() {
                return timeStr;
            }

            public void setTimeStr(Object timeStr) {
                this.timeStr = timeStr;
            }

            public Object getPage() {
                return page;
            }

            public void setPage(Object page) {
                this.page = page;
            }

            public Object getHouseId() {
                return houseId;
            }

            public void setHouseId(Object houseId) {
                this.houseId = houseId;
            }

            public Object getBaseImgList() {
                return baseImgList;
            }

            public void setBaseImgList(Object baseImgList) {
                this.baseImgList = baseImgList;
            }

            public Object getLayoutImgList() {
                return layoutImgList;
            }

            public void setLayoutImgList(Object layoutImgList) {
                this.layoutImgList = layoutImgList;
            }

            public Object getImgMap() {
                return imgMap;
            }

            public void setImgMap(Object imgMap) {
                this.imgMap = imgMap;
            }
        }
    }
}
