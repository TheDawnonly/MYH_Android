package houseproperty.manyihe.com.myh_android.model;


import houseproperty.manyihe.com.myh_android.bean.MessageDetailsBean;

/**
 * Created by Mr.周 on 2018/3/14.
 */

public interface IMessageDetailsModel {
    public void getData(callBack success, int floorId);

    public interface callBack {
        void success(MessageDetailsBean MessageBean);


    }
}
