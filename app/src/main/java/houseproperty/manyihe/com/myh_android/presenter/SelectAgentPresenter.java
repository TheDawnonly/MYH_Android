package houseproperty.manyihe.com.myh_android.presenter;

import java.lang.ref.WeakReference;

import houseproperty.manyihe.com.myh_android.bean.selectAgentBean;
import houseproperty.manyihe.com.myh_android.model.ISelectAgentM;
import houseproperty.manyihe.com.myh_android.model.SelectAgentModel;
import houseproperty.manyihe.com.myh_android.view.ISelectAgentView;

/**
 * Created by Mr.周 on 2018/4/18.
 * 首页banner轮播图
 */

public class SelectAgentPresenter implements IPresenter<ISelectAgentView> {
    ISelectAgentM selectAgentM;
    WeakReference<ISelectAgentView> mRefView;

    public SelectAgentPresenter(ISelectAgentView iHomeBannerView) {
        this.selectAgentM = new SelectAgentModel();
        attach(iHomeBannerView);
    }

    @Override
    public void attach(ISelectAgentView view) {
        mRefView = new WeakReference<ISelectAgentView>(view);
    }

    @Override
    public void detach() {
        mRefView.clear();
    }

    public void showSelectAgent(int pageNum, int pageSize) {
        selectAgentM.getSelectAgent(new ISelectAgentM.callBackSuccessSelectAgentBean() {
            @Override
            public void selectAgent(selectAgentBean agentBean) {
                mRefView.get().selectAgentShow(agentBean);
            }
        }, pageNum, pageSize);
    }
}
