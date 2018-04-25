package houseproperty.manyihe.com.myh_android.model;


import houseproperty.manyihe.com.myh_android.bean.MessageBean;

/**
 * Created by Mr.周 on 2018/3/14.
 */

public interface IMessageModel {
    public void getData(callBack success, int pageNum, int pageSize);

    public interface callBack {
        void success(MessageBean MessageBean);


    }
}
