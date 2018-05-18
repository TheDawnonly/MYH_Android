package houseproperty.manyihe.com.myh_android.model;

import android.util.Log;

import com.google.gson.Gson;
import com.vise.xsnow.http.ViseHttp;
import com.vise.xsnow.http.callback.ACallback;

import java.util.HashMap;
import java.util.Map;

import houseproperty.manyihe.com.myh_android.bean.AgentDetailBean;

/**
 * Created by Mr.周 on 2018/4/18.
 */

public class AgentDetailModel implements IAgentDetailModel {

    @Override
    public void showAgent(final callBackSuccessAgentDetailBean bean, int id) {
        Map<String, Integer> map = new HashMap<>();
        map.put("agentId", id);
        Gson gson = new Gson();
        String Json = gson.toJson(map);
        ViseHttp.POST("viewAgentDetail")
                .tag("")
                .setJson(Json)
                .request(new ACallback<AgentDetailBean>() {


                    @Override
                    public void onSuccess(AgentDetailBean data) {
                        bean.getAgentDetail(data);
                    }

                    @Override
                    public void onFail(int errCode, String errMsg) {
                        //请求失败，errCode为错误码，errMsg为错误描述
                        Log.d("onFail=====", "LoginModel" + errMsg);
                        Log.d("onFail=====", "LoginModel" + errCode);
                    }
                });
    }
}
