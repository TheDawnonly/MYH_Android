package houseproperty.manyihe.com.myh_android.model;

import houseproperty.manyihe.com.myh_android.bean.HousingResourceHotFloorBean;

/**
 * Created by Mr.周 on 2018/4/18.
 */

public interface IHotFloorDetailsM {
    void getHotFloorDetails(callBackSuccessHotFloorDetailsBean hotFloorDetailsBean, int houseId);

    interface callBackSuccessHotFloorDetailsBean {
        void HousingResourceHotFloorBean(HousingResourceHotFloorBean housingResource);

    }
}
