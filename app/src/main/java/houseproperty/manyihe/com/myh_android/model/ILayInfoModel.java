package houseproperty.manyihe.com.myh_android.model;


import houseproperty.manyihe.com.myh_android.bean.LayInfoBean;

/**
 * Created by Mr.周 on 2018/4/20.
 */

public interface ILayInfoModel {
    void getLayInfoBean(callBackSuccessLayInfoBean infoBean,int houseId);

    interface callBackSuccessLayInfoBean {
        void LayInfo(LayInfoBean infoBean);

    }
}
