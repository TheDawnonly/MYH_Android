package houseproperty.manyihe.com.myh_android.presenter;

import java.lang.ref.WeakReference;

import houseproperty.manyihe.com.myh_android.bean.AgentByHouse;
import houseproperty.manyihe.com.myh_android.bean.ViewHouseCommBean;
import houseproperty.manyihe.com.myh_android.model.AgentByHouseModel;
import houseproperty.manyihe.com.myh_android.model.IAgentByHouseModel;
import houseproperty.manyihe.com.myh_android.model.IViewHouseCommModel;
import houseproperty.manyihe.com.myh_android.model.ViewHouseCommModel;
import houseproperty.manyihe.com.myh_android.view.IAgentByHouseView;
import houseproperty.manyihe.com.myh_android.view.IViewHouseCommView;

public class ViewHouseCommPresenter implements IPresenter<IViewHouseCommView> {

    IViewHouseCommModel commModel;
    WeakReference<IViewHouseCommView> mRefView;

    public ViewHouseCommPresenter(IViewHouseCommView view) {
        this.commModel = new ViewHouseCommModel();
        attach(view);
    }

    @Override
    public void attach(IViewHouseCommView view) {
        mRefView = new WeakReference<IViewHouseCommView>(view);
    }

    @Override
    public void detach() {
        mRefView.clear();
    }

    public void showViewHouseCommPresenter(int houseId, int pageNum, int pageSize) {
        commModel.showViewComm(new IViewHouseCommModel.callBackSuccessViewCommBean() {
            @Override
            public void getViewComm(ViewHouseCommBean commBean) {
                mRefView.get().showViewHouseComm(commBean);
            }
        }, houseId, pageNum, pageSize);
    }
}
