package houseproperty.manyihe.com.myh_android.presenter;

import java.lang.ref.WeakReference;

import houseproperty.manyihe.com.myh_android.bean.AgentDetailBean;
import houseproperty.manyihe.com.myh_android.model.AgentDetailModel;
import houseproperty.manyihe.com.myh_android.model.IAgentDetailModel;
import houseproperty.manyihe.com.myh_android.view.IAgentDetailView;

public class AgentDetailPresenter implements IPresenter<IAgentDetailView> {

    IAgentDetailModel detailModel;
    WeakReference<IAgentDetailView> mRefView;

    public AgentDetailPresenter(IAgentDetailView view) {
        this.detailModel = new AgentDetailModel();
        attach(view);
    }

    @Override
    public void attach(IAgentDetailView view) {
        mRefView = new WeakReference<IAgentDetailView>(view);
    }

    @Override
    public void detach() {
        mRefView.clear();
    }

    public void showAgentPresenter(int id) {
        detailModel.showAgent(new IAgentDetailModel.callBackSuccessAgentDetailBean() {
            @Override
            public void getAgentDetail(AgentDetailBean agentDetailBean) {
                mRefView.get().showAgentView(agentDetailBean);
            }
        }, id);
    }
}
