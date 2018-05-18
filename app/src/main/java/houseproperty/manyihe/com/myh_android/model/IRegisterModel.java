package houseproperty.manyihe.com.myh_android.model;

import houseproperty.manyihe.com.myh_android.bean.RegisterBean;

/**
 * Created by Mr.周 on 2018/4/18.
 */

public interface IRegisterModel {
    void getRegister(callBackSuccessRegisterBean registerBean, String mobile,String valiCode, String password);

    interface callBackSuccessRegisterBean {
        void RegisterBean(RegisterBean registerBean);

    }
}
