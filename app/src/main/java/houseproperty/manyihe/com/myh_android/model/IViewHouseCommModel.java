package houseproperty.manyihe.com.myh_android.model;

import houseproperty.manyihe.com.myh_android.bean.ViewHouseCommBean;

public interface IViewHouseCommModel {
    void showViewComm(callBackSuccessViewCommBean bean, int houseId, int pageNum, int pageSize);

    interface callBackSuccessViewCommBean {
        void getViewComm(ViewHouseCommBean commBean);

    }
}
