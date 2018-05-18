package houseproperty.manyihe.com.myh_android.model;

import android.util.Log;

import com.google.gson.Gson;
import com.vise.xsnow.http.ViseHttp;
import com.vise.xsnow.http.callback.ACallback;

import java.util.HashMap;
import java.util.Map;

import houseproperty.manyihe.com.myh_android.bean.AgentByHouse;
import houseproperty.manyihe.com.myh_android.bean.ViewHouseCommBean;

/**
 * Created by Mr.周 on 2018/4/18.
 */

public class ViewHouseCommModel implements IViewHouseCommModel {

    @Override
    public void showViewComm(final callBackSuccessViewCommBean bean, int houseId, int pageNum, int pageSize) {
        Map<Object, Object> map = new HashMap<>();
        Map<String, Integer> pageMap = new HashMap<>();
        pageMap.put("pageNum", pageNum);
        pageMap.put("pageSize", pageSize);
        map.put("houseId", houseId);
        map.put("page", pageMap);
        Gson gson = new Gson();
        String Json = gson.toJson(map);
        ViseHttp.POST("viewHouseComm")
                .tag("")
                .setJson(Json)
                .request(new ACallback<ViewHouseCommBean>() {


                    @Override
                    public void onSuccess(ViewHouseCommBean data) {
                        bean.getViewComm(data);
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
