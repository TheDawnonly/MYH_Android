package houseproperty.manyihe.com.myh_android.model;

import houseproperty.manyihe.com.myh_android.bean.HouseInfoBean;

/**
 * Created by Mr.周 on 2018/4/18.
 */

public interface IHotFloorDetailsM {
    void getHotFloorDetails(callBackSuccessHotFloorDetailsBean hotFloorDetailsBean, int houseId, int userId);

    interface callBackSuccessHotFloorDetailsBean {
        void HousingResourceHotFloorBean(HouseInfoBean housingResource);

    }
}
