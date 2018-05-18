package houseproperty.manyihe.com.myh_android.presenter;

import java.lang.ref.WeakReference;

import houseproperty.manyihe.com.myh_android.bean.AgentByHouse;
import houseproperty.manyihe.com.myh_android.bean.AgentDetailBean;
import houseproperty.manyihe.com.myh_android.model.AgentByHouseModel;
import houseproperty.manyihe.com.myh_android.model.AgentDetailModel;
import houseproperty.manyihe.com.myh_android.model.IAgentByHouseModel;
import houseproperty.manyihe.com.myh_android.model.IAgentDetailModel;
import houseproperty.manyihe.com.myh_android.view.IAgentByHouseView;
import houseproperty.manyihe.com.myh_android.view.IAgentDetailView;

public class AgentByHousePresenter implements IPresenter<IAgentByHouseView> {

    IAgentByHouseModel byHouseModel;
    WeakReference<IAgentByHouseView> mRefView;

    public AgentByHousePresenter(IAgentByHouseView view) {
        this.byHouseModel = new AgentByHouseModel();
        attach(view);
    }

    @Override
    public void attach(IAgentByHouseView view) {
        mRefView = new WeakReference<IAgentByHouseView>(view);
    }

    @Override
    public void detach() {
        mRefView.clear();
    }

    public void showAgentByHousePresenter(int houseId, String type, int pageNum, int pageSize) {
        byHouseModel.showAgentBy(new IAgentByHouseModel.callBackSuccessAgentByBean() {
            @Override
            public void getAgentBy(AgentByHouse agentByHouse) {
                mRefView.get().showAgentByHouseView(agentByHouse);
            }
        }, houseId, type, pageNum, pageSize);
    }
}
