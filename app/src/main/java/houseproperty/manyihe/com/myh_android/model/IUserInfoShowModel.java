package houseproperty.manyihe.com.myh_android.model;

import houseproperty.manyihe.com.myh_android.bean.UserInfoShowBean;

/**
 * Created by Mr.周 on 2018/4/18.
 */

public interface IUserInfoShowModel {
    void getUserInfo(callBackSuccessUserInfoBean infoBean, int userId);

    interface callBackSuccessUserInfoBean {
        void UserInfo(UserInfoShowBean infoShowBean);

    }
}
