package houseproperty.manyihe.com.myh_android.model;


import houseproperty.manyihe.com.myh_android.bean.AgentByHouse;

public interface IAgentByHouseModel {
    void showAgentBy(callBackSuccessAgentByBean bean, int houseId,String type,int pageNum,int pageSize);

    interface callBackSuccessAgentByBean {
        void getAgentBy(AgentByHouse agentByHouse);

    }
}
