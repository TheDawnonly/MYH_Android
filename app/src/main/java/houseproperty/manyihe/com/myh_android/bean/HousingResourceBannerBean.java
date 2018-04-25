package houseproperty.manyihe.com.myh_android.bean;

import java.util.List;

/**
 * Created by Mr.周 on 2018/4/12.
 */

public class HousingResourceBannerBean {


    /**
     * resultBean : {"code":"0","message":"OK","object":[{"id":1,"userId":null,"title":null,"subTitle":null,"layout":null,"measure":null,"floor":null,"address":null,"downPrice":null,"averagePrice":null,"price":null,"towards":null,"imgId":null,"layImg":null,"mainImg":null,"state":null,"type":null,"feature":null,"explains":null,"createTime":null,"updateTime":null,"isVisible":null,"houseType":null,"elevator":null,"equity":null,"fitment":null,"afforest":null,"houseTimes":null,"bannerImg":"https://myhtest.oss-cn-beijing.aliyuncs.com/BANNER/banner%20yudaozhuangy.jpg","page":null,"baseImgList":null,"layoutImgList":null,"imgMap":null},{"id":18,"userId":null,"title":null,"subTitle":null,"layout":null,"measure":null,"floor":null,"address":null,"downPrice":null,"averagePrice":null,"price":null,"towards":null,"imgId":null,"layImg":null,"mainImg":null,"state":null,"type":null,"feature":null,"explains":null,"createTime":null,"updateTime":null,"isVisible":null,"houseType":null,"elevator":null,"equity":null,"fitment":null,"afforest":null,"houseTimes":null,"bannerImg":"https://myhtest.oss-cn-beijing.aliyuncs.com/BANNER/banner%20bixingguiyuan.jpg","page":null,"baseImgList":null,"layoutImgList":null,"imgMap":null},{"id":28,"userId":null,"title":null,"subTitle":null,"layout":null,"measure":null,"floor":null,"address":null,"downPrice":null,"averagePrice":null,"price":null,"towards":null,"imgId":null,"layImg":null,"mainImg":null,"state":null,"type":null,"feature":null,"explains":null,"createTime":null,"updateTime":null,"isVisible":null,"houseType":null,"elevator":null,"equity":null,"fitment":null,"afforest":null,"houseTimes":null,"bannerImg":"https://myhtest.oss-cn-beijing.aliyuncs.com/BANNER/banner%20rongchuang.jpg","page":null,"baseImgList":null,"layoutImgList":null,"imgMap":null}],"sessionId":null}
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
         * object : [{"id":1,"userId":null,"title":null,"subTitle":null,"layout":null,"measure":null,"floor":null,"address":null,"downPrice":null,"averagePrice":null,"price":null,"towards":null,"imgId":null,"layImg":null,"mainImg":null,"state":null,"type":null,"feature":null,"explains":null,"createTime":null,"updateTime":null,"isVisible":null,"houseType":null,"elevator":null,"equity":null,"fitment":null,"afforest":null,"houseTimes":null,"bannerImg":"https://myhtest.oss-cn-beijing.aliyuncs.com/BANNER/banner%20yudaozhuangy.jpg","page":null,"baseImgList":null,"layoutImgList":null,"imgMap":null},{"id":18,"userId":null,"title":null,"subTitle":null,"layout":null,"measure":null,"floor":null,"address":null,"downPrice":null,"averagePrice":null,"price":null,"towards":null,"imgId":null,"layImg":null,"mainImg":null,"state":null,"type":null,"feature":null,"explains":null,"createTime":null,"updateTime":null,"isVisible":null,"houseType":null,"elevator":null,"equity":null,"fitment":null,"afforest":null,"houseTimes":null,"bannerImg":"https://myhtest.oss-cn-beijing.aliyuncs.com/BANNER/banner%20bixingguiyuan.jpg","page":null,"baseImgList":null,"layoutImgList":null,"imgMap":null},{"id":28,"userId":null,"title":null,"subTitle":null,"layout":null,"measure":null,"floor":null,"address":null,"downPrice":null,"averagePrice":null,"price":null,"towards":null,"imgId":null,"layImg":null,"mainImg":null,"state":null,"type":null,"feature":null,"explains":null,"createTime":null,"updateTime":null,"isVisible":null,"houseType":null,"elevator":null,"equity":null,"fitment":null,"afforest":null,"houseTimes":null,"bannerImg":"https://myhtest.oss-cn-beijing.aliyuncs.com/BANNER/banner%20rongchuang.jpg","page":null,"baseImgList":null,"layoutImgList":null,"imgMap":null}]
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
             * title : null
             * subTitle : null
             * layout : null
             * measure : null
             * floor : null
             * address : null
             * downPrice : null
             * averagePrice : null
             * price : null
             * towards : null
             * imgId : null
             * layImg : null
             * mainImg : null
             * state : null
             * type : null
             * feature : null
             * explains : null
             * createTime : null
             * updateTime : null
             * isVisible : null
             * houseType : null
             * elevator : null
             * equity : null
             * fitment : null
             * afforest : null
             * houseTimes : null
             * bannerImg : https://myhtest.oss-cn-beijing.aliyuncs.com/BANNER/banner%20yudaozhuangy.jpg
             * page : null
             * baseImgList : null
             * layoutImgList : null
             * imgMap : null
             */

            private int id;
            private Object userId;
            private Object title;
            private Object subTitle;
            private Object layout;
            private Object measure;
            private Object floor;
            private Object address;
            private Object downPrice;
            private Object averagePrice;
            private Object price;
            private Object towards;
            private Object imgId;
            private Object layImg;
            private Object mainImg;
            private Object state;
            private Object type;
            private Object feature;
            private Object explains;
            private Object createTime;
            private Object updateTime;
            private Object isVisible;
            private Object houseType;
            private Object elevator;
            private Object equity;
            private Object fitment;
            private Object afforest;
            private Object houseTimes;
            private String bannerImg;
            private Object page;
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

            public Object getTitle() {
                return title;
            }

            public void setTitle(Object title) {
                this.title = title;
            }

            public Object getSubTitle() {
                return subTitle;
            }

            public void setSubTitle(Object subTitle) {
                this.subTitle = subTitle;
            }

            public Object getLayout() {
                return layout;
            }

            public void setLayout(Object layout) {
                this.layout = layout;
            }

            public Object getMeasure() {
                return measure;
            }

            public void setMeasure(Object measure) {
                this.measure = measure;
            }

            public Object getFloor() {
                return floor;
            }

            public void setFloor(Object floor) {
                this.floor = floor;
            }

            public Object getAddress() {
                return address;
            }

            public void setAddress(Object address) {
                this.address = address;
            }

            public Object getDownPrice() {
                return downPrice;
            }

            public void setDownPrice(Object downPrice) {
                this.downPrice = downPrice;
            }

            public Object getAveragePrice() {
                return averagePrice;
            }

            public void setAveragePrice(Object averagePrice) {
                this.averagePrice = averagePrice;
            }

            public Object getPrice() {
                return price;
            }

            public void setPrice(Object price) {
                this.price = price;
            }

            public Object getTowards() {
                return towards;
            }

            public void setTowards(Object towards) {
                this.towards = towards;
            }

            public Object getImgId() {
                return imgId;
            }

            public void setImgId(Object imgId) {
                this.imgId = imgId;
            }

            public Object getLayImg() {
                return layImg;
            }

            public void setLayImg(Object layImg) {
                this.layImg = layImg;
            }

            public Object getMainImg() {
                return mainImg;
            }

            public void setMainImg(Object mainImg) {
                this.mainImg = mainImg;
            }

            public Object getState() {
                return state;
            }

            public void setState(Object state) {
                this.state = state;
            }

            public Object getType() {
                return type;
            }

            public void setType(Object type) {
                this.type = type;
            }

            public Object getFeature() {
                return feature;
            }

            public void setFeature(Object feature) {
                this.feature = feature;
            }

            public Object getExplains() {
                return explains;
            }

            public void setExplains(Object explains) {
                this.explains = explains;
            }

            public Object getCreateTime() {
                return createTime;
            }

            public void setCreateTime(Object createTime) {
                this.createTime = createTime;
            }

            public Object getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(Object updateTime) {
                this.updateTime = updateTime;
            }

            public Object getIsVisible() {
                return isVisible;
            }

            public void setIsVisible(Object isVisible) {
                this.isVisible = isVisible;
            }

            public Object getHouseType() {
                return houseType;
            }

            public void setHouseType(Object houseType) {
                this.houseType = houseType;
            }

            public Object getElevator() {
                return elevator;
            }

            public void setElevator(Object elevator) {
                this.elevator = elevator;
            }

            public Object getEquity() {
                return equity;
            }

            public void setEquity(Object equity) {
                this.equity = equity;
            }

            public Object getFitment() {
                return fitment;
            }

            public void setFitment(Object fitment) {
                this.fitment = fitment;
            }

            public Object getAfforest() {
                return afforest;
            }

            public void setAfforest(Object afforest) {
                this.afforest = afforest;
            }

            public Object getHouseTimes() {
                return houseTimes;
            }

            public void setHouseTimes(Object houseTimes) {
                this.houseTimes = houseTimes;
            }

            public String getBannerImg() {
                return bannerImg;
            }

            public void setBannerImg(String bannerImg) {
                this.bannerImg = bannerImg;
            }

            public Object getPage() {
                return page;
            }

            public void setPage(Object page) {
                this.page = page;
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
