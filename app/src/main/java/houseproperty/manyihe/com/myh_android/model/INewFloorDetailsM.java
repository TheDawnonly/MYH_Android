package houseproperty.manyihe.com.myh_android.model;

import houseproperty.manyihe.com.myh_android.bean.HouseInfoBean;

/**
 * Created by Mr.周 on 2018/4/18.
 */

public interface INewFloorDetailsM {
    void getNewFloorDetails(callBackSuccessNewFloorDetailsBean newFloorDetailsBean, int houseId,int userId);

    interface callBackSuccessNewFloorDetailsBean {
        void HousingResourceNewFloorBean(HouseInfoBean housingResource);

    }
}
