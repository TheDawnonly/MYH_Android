package houseproperty.manyihe.com.myh_android.model;


import android.util.Log;

import com.google.gson.Gson;
import com.vise.xsnow.http.ViseHttp;
import com.vise.xsnow.http.callback.ACallback;

import java.util.HashMap;
import java.util.Map;

import houseproperty.manyihe.com.myh_android.bean.HouseInfoBean;

/**
 * Created by Mr.周 on 2018/3/14.
 */

public class HousingResourceModelTypeNew implements IModelHousingResourceTypeNew {

    @Override
    public void getHotFloor(final callBackSuccessFloorBean floorBean, int pageNum, int pageSize) {
        Map<String, Integer> hotM = new HashMap<String, Integer>();
        hotM.put("pageNum", pageNum);
        hotM.put("pageSize", pageSize);
        hotM.put("type", 1);
        Gson gson = new Gson();
        String hotJson = gson.toJson(hotM);
        ViseHttp.POST("viewHouseInfo")
                .tag("请求Tag，为防止内存泄露，必须设置，在onDestroy中调用cancelTag时使用")
                .setJson(hotJson)
                .request(new ACallback<HouseInfoBean>() {
                    @Override
                    public void onSuccess(HouseInfoBean data) {
                        floorBean.HousingResourceHotFloorBean(data);
                    }

                    @Override
                    public void onFail(int errCode, String errMsg) {
                        //请求失败，errCode为错误码，errMsg为错误描述
                        Log.d("onFail=====", "====" + errMsg);
                        Log.d("onFail=====", "=====" + errCode);
                    }
                });
    }
}
