package houseproperty.manyihe.com.myh_android.model;

import houseproperty.manyihe.com.myh_android.bean.UpDataUserInfoBean;

/**
 * Created by Mr.周 on 2018/4/18.
 */

public interface IUpDataUserInfoModel {
    void getUpUser(callBackSuccessUpUserInfoBean upUserInfoBean, int id, String headUrl, String name, String email);

    interface callBackSuccessUpUserInfoBean {
        void UpUser(UpDataUserInfoBean upDataUser);
    }
}
