package houseproperty.manyihe.com.myh_android.model;

import houseproperty.manyihe.com.myh_android.bean.VailCodeBean;

/**
 * Created by Mr.周 on 2018/4/18.
 */

public interface IVailCodeModel {
    void getVailCode(callBackSuccessVailCode successVailCode, String mobile,String type);

    interface callBackSuccessVailCode {
        void vailCodeBean(VailCodeBean vailCodeBean);

    }
}
