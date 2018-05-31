package houseproperty.manyihe.com.myh_android.model;

import houseproperty.manyihe.com.myh_android.bean.BroseRecordBean;

public interface IViewBroseRecordModel {
    void showRecode(callBackSuccessRecordBean bean, Integer id, int type);

    interface callBackSuccessRecordBean {
        void getRecode(BroseRecordBean bean);
    }
}
