package houseproperty.manyihe.com.myh_android.model;

import android.util.Log;

import com.google.gson.Gson;
import com.vise.xsnow.http.ViseHttp;
import com.vise.xsnow.http.callback.ACallback;

import java.util.HashMap;
import java.util.Map;

import houseproperty.manyihe.com.myh_android.bean.AgentByHouse;

/**
 * Created by Mr.周 on 2018/4/18.
 */

public class AgentByHouseModel implements IAgentByHouseModel {

    @Override
    public void showAgentBy(final callBackSuccessAgentByBean bean, int houseId, String type, int pageNum, int pageSize) {
        Map<Object, Object> map = new HashMap<>();
        Map<String, Integer> pageMap = new HashMap<>();
        pageMap.put("pageNum", pageNum);
        pageMap.put("pageSize", pageSize);
        map.put("houseId", houseId);
        map.put("type", type);
        map.put("page", pageMap);
        Gson gson = new Gson();
        String Json = gson.toJson(map);
        ViseHttp.POST("viewAgentByHouseId")
                .tag("")
                .setJson(Json)
                .request(new ACallback<AgentByHouse>() {


                    @Override
                    public void onSuccess(AgentByHouse data) {
                        bean.getAgentBy(data);
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
