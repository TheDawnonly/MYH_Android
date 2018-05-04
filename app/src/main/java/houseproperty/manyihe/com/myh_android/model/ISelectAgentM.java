package houseproperty.manyihe.com.myh_android.model;

import houseproperty.manyihe.com.myh_android.bean.selectAgentBean;

/**
 * Created by Mr.周 on 2018/4/18.
 */

public interface ISelectAgentM {
    void getSelectAgent(callBackSuccessSelectAgentBean agentBean, int pageNum, int pageSize);

    interface callBackSuccessSelectAgentBean {
        void selectAgent(selectAgentBean agentBean);

    }
}
