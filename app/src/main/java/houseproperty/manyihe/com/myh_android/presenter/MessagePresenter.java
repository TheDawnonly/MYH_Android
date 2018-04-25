package houseproperty.manyihe.com.myh_android.presenter;

import java.lang.ref.WeakReference;

import houseproperty.manyihe.com.myh_android.bean.MessageBean;
import houseproperty.manyihe.com.myh_android.model.IMessageModel;
import houseproperty.manyihe.com.myh_android.model.MessageModel;
import houseproperty.manyihe.com.myh_android.view.IMessageView;


/**
 * Created by Mr.周 on 2018/3/14.
 */

public class MessagePresenter implements IPresenter<IMessageView> {
    IMessageModel messageModel;
    WeakReference<IMessageView> mRefView;

    public MessagePresenter(IMessageView iView) {
        this.messageModel = new MessageModel();
        attach(iView);
    }

    @Override
    public void attach(IMessageView view) {
        mRefView = new WeakReference<IMessageView>(view);
    }

    @Override
    public void detach() {
        mRefView.clear();
    }

    public void ShowData(int pageNum, int pageSize) {
        messageModel.getData(new IMessageModel.callBack() {
            @Override
            public void success(MessageBean MessageBean) {
                mRefView.get().showData(MessageBean);
            }

        }, pageNum, pageSize);
    }
}
