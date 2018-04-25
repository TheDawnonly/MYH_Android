package houseproperty.manyihe.com.myh_android.model;

import android.util.Log;

import com.google.gson.Gson;
import com.vise.xsnow.http.ViseHttp;
import com.vise.xsnow.http.callback.ACallback;

import java.util.HashMap;
import java.util.Map;

import houseproperty.manyihe.com.myh_android.bean.HousingResourceHotFloorBean;

/**
 * Created by Mr.周 on 2018/4/18.
 */

public class HotFloorDetailsModel implements IHotFloorDetailsM {
    @Override
    public void getHotFloorDetails(final callBackSuccessHotFloorDetailsBean hotFloorDetailsBean, int houseId) {
        Map<String, Integer> map = new HashMap<>();
        map.put("houseId", houseId);
        Gson gson = new Gson();
        String hotJson = gson.toJson(map);
        ViseHttp.POST("viewHouseInfo")
                .tag("")
                .setJson(hotJson)
                .request(new ACallback<HousingResourceHotFloorBean>() {
                    @Override
                    public void onSuccess(HousingResourceHotFloorBean data) {
                        hotFloorDetailsBean.HousingResourceHotFloorBean(data);
                    }

                    @Override
                    public void onFail(int errCode, String errMsg) {

                    }
                });
    }
}
