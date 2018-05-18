package houseproperty.manyihe.com.myh_android.model;

import houseproperty.manyihe.com.myh_android.bean.FindPassWordBean;

/**
 * Created by Mr.周 on 2018/4/18.
 */

public interface IFindPassModel {
    void getPass(callBackSuccessFindPassBean passBean, String mobile, String password, String valiCode);

    interface callBackSuccessFindPassBean {
        void FindPass(FindPassWordBean passWordBean);

    }
}
