package houseproperty.manyihe.com.myh_android.view;


import houseproperty.manyihe.com.myh_android.bean.MessageBean;

/**
 * Created by Mr.周 on 2018/3/14.
 */

public interface IMessageView {
    void showData(MessageBean MessageBean);

    void failMsg(String msg);
}
