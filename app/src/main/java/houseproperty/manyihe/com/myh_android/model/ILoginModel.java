package houseproperty.manyihe.com.myh_android.model;

import houseproperty.manyihe.com.myh_android.bean.LoginBean;

/**
 * Created by Mr.周 on 2018/4/18.
 */

public interface ILoginModel {
    void getLogin(callBackSuccessLoginBean loginBean, String mobile, String password);

    interface callBackSuccessLoginBean {
        void LoginBean(LoginBean loginBean);

    }
}
