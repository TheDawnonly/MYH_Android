package houseproperty.manyihe.com.myh_android.model;


import houseproperty.manyihe.com.myh_android.bean.HouseInfoBean;

/**
 * Created by Mr.周 on 2018/3/14.
 */

public interface IModelHousingResource {
    void getHotFloor(callBackSuccessFloorBean floorBean, int pageNum, int pageSize);

    interface callBackSuccessFloorBean {
        void HousingResourceHotFloorBean(HouseInfoBean housingResource);

    }
}
