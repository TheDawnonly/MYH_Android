package houseproperty.manyihe.com.myh_android.model;

import android.util.Log;

import com.google.gson.Gson;
import com.vise.xsnow.http.ViseHttp;
import com.vise.xsnow.http.callback.ACallback;

import java.util.HashMap;
import java.util.Map;

import houseproperty.manyihe.com.myh_android.bean.LayInfoBean;

/**
 * Created by Mr.周 on 2018/4/20.
 */

public class LayInfoModel implements ILayInfoModel {
    @Override
    public void getLayInfoBean(final callBackSuccessLayInfoBean infoBean, int houseId) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("houseId", houseId);
        Gson gson = new Gson();
        String toJson = gson.toJson(map);
        ViseHttp.POST("viewLayInfo")
                .tag("")
                .setJson(toJson)
                .request(new ACallback<LayInfoBean>() {
                    @Override
                    public void onSuccess(LayInfoBean data) {
                        infoBean.LayInfo(data);
                    }

                    @Override
                    public void onFail(int errCode, String errMsg) {
                        Log.d("LayInfoModel onFail", "errCode=====" + errMsg);
                        Log.d("LayInfoModel onFail", "errMsg=====" + errMsg);
                    }
                });

    }
}
