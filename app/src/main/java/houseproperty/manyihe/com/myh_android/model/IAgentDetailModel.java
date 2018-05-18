package houseproperty.manyihe.com.myh_android.model;


import houseproperty.manyihe.com.myh_android.bean.AgentDetailBean;

public interface IAgentDetailModel {
    void showAgent(callBackSuccessAgentDetailBean bean, int id);

    interface callBackSuccessAgentDetailBean {
        void getAgentDetail(AgentDetailBean agentDetailBean);

    }
}
