package houseproperty.manyihe.com.myh_android.presenter;

import android.util.Log;

import java.lang.ref.WeakReference;

import houseproperty.manyihe.com.myh_android.bean.MessageDetailsBean;
import houseproperty.manyihe.com.myh_android.model.IMessageDetailsModel;
import houseproperty.manyihe.com.myh_android.model.MessageDetailsModel;
import houseproperty.manyihe.com.myh_android.view.IMessageDetailsView;


/**
 * Created by Mr.周 on 2018/3/14.
 */

public class MessageDetailsPresenter implements IPresenter<IMessageDetailsView> {
    IMessageDetailsModel messageModel;
    WeakReference<IMessageDetailsView> mRefView;

    public MessageDetailsPresenter(IMessageDetailsView iView) {
        this.messageModel = new MessageDetailsModel();
        attach(iView);
    }

    @Override
    public void attach(IMessageDetailsView view) {
        mRefView = new WeakReference<IMessageDetailsView>(view);
    }

    @Override
    public void detach() {
        mRefView.clear();
    }

    public void ShowData(int floorId) {
        messageModel.getData(new IMessageDetailsModel.callBack() {
            @Override
            public void success(MessageDetailsBean MessageBean) {
                mRefView.get().showData(MessageBean);
            }
        }, floorId);
    }
}
