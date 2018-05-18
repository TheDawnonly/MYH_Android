package houseproperty.manyihe.com.myh_android.presenter;

import java.lang.ref.WeakReference;

import houseproperty.manyihe.com.myh_android.bean.AgentByHouse;
import houseproperty.manyihe.com.myh_android.bean.InsertHouseCommBean;
import houseproperty.manyihe.com.myh_android.model.AgentByHouseModel;
import houseproperty.manyihe.com.myh_android.model.IAgentByHouseModel;
import houseproperty.manyihe.com.myh_android.model.IInsertHouseCommModel;
import houseproperty.manyihe.com.myh_android.model.InsertHouseCommModel;
import houseproperty.manyihe.com.myh_android.view.IAgentByHouseView;
import houseproperty.manyihe.com.myh_android.view.IInsertHouseCommView;

public class InsertHouseCommPresenter implements IPresenter<IInsertHouseCommView> {

    IInsertHouseCommModel commModel;
    WeakReference<IInsertHouseCommView> mRefView;

    public InsertHouseCommPresenter(IInsertHouseCommView view) {
        this.commModel = new InsertHouseCommModel();
        attach(view);
    }

    @Override
    public void attach(IInsertHouseCommView view) {
        mRefView = new WeakReference<IInsertHouseCommView>(view);
    }

    @Override
    public void detach() {
        mRefView.clear();
    }

    public void showAgentByHousePresenter(int userId, int houseId, String comment, int score, int pageNum, int pageSize) {
        commModel.showComm(new IInsertHouseCommModel.callBackSuccessInsertCommBean() {
            @Override
            public void getComm(InsertHouseCommBean commBean) {
                mRefView.get().showInsertCommView(commBean);
            }
        }, userId, houseId, comment, score, pageNum, pageSize);
    }
}
