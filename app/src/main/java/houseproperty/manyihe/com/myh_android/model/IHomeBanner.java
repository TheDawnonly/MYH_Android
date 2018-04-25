package houseproperty.manyihe.com.myh_android.model;

import houseproperty.manyihe.com.myh_android.bean.HousingResourceBannerBean;

/**
 * Created by Mr.周 on 2018/4/18.
 */

public interface IHomeBanner {
    void getHomeBanner(callBackSuccessBannerBean floorBean);

    interface callBackSuccessBannerBean {
        void HousingResourceBannerBean(HousingResourceBannerBean housingResource);

    }
}
