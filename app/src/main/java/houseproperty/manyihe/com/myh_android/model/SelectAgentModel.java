package houseproperty.manyihe.com.myh_android.model;

import android.util.Log;

import com.google.gson.Gson;
import com.vise.xsnow.http.ViseHttp;
import com.vise.xsnow.http.callback.ACallback;

import java.util.HashMap;
import java.util.Map;

import houseproperty.manyihe.com.myh_android.bean.selectAgentBean;


/**
 * Created by Mr.周 on 2018/4/18.
 */

public class SelectAgentModel implements ISelectAgentM {


    @Override
    public void getSelectAgent(final callBackSuccessSelectAgentBean agentBean, final int pageNum, final int pageSize) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Object> mapMap = new HashMap();
        map.put("pageNum", pageNum);
        map.put("pageSize", pageSize);
        mapMap.put("page", map);
        Gson gson = new Gson();
        String Json = gson.toJson(mapMap);
        ViseHttp.POST("selectAgent")
                .tag("经纪人")
                .setJson(Json)
                .request(new ACallback<selectAgentBean>() {


                    @Override
                    public void onSuccess(selectAgentBean data) {
                        agentBean.selectAgent(data);
                    }

                    @Override
                    public void onFail(int errCode, String errMsg) {
                        //请求失败，errCode为错误码，errMsg为错误描述
                        Log.d("onFail=====", "SelectAgentModel" + errMsg);
                        Log.d("onFail=====", "SelectAgentModel" + errCode);
                    }
                });
    }
}
