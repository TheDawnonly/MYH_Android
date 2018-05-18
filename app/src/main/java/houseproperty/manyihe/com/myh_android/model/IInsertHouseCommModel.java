package houseproperty.manyihe.com.myh_android.model;

import houseproperty.manyihe.com.myh_android.bean.InsertHouseCommBean;

public interface IInsertHouseCommModel {
    void showComm(callBackSuccessInsertCommBean bean, int userId, int houseId, String comment, int score, int pageNum, int pageSize);

    interface callBackSuccessInsertCommBean {
        void getComm(InsertHouseCommBean commBean);

    }
}
