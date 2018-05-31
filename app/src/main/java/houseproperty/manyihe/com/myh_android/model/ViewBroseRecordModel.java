package houseproperty.manyihe.com.myh_android.model;

import android.util.Log;

import com.google.gson.Gson;
import com.vise.xsnow.http.ViseHttp;
import com.vise.xsnow.http.callback.ACallback;

import java.util.HashMap;
import java.util.Map;

import houseproperty.manyihe.com.myh_android.bean.BroseRecordBean;
import houseproperty.manyihe.com.myh_android.bean.HouseInfoBean;

/**
 * Created by Mr.周 on 2018/4/18.
 */

public class ViewBroseRecordModel implements IViewBroseRecordModel {

    @Override
    public void showRecode(final callBackSuccessRecordBean bean, Integer id, int type) {
        Map<String, Integer> map = new HashMap<>();
        map.put("id", id);
        map.put("type", type);
        Gson gson = new Gson();
        String Json = gson.toJson(map);
        ViseHttp.POST("viewBroseRecord")
                .tag("")
                .setJson(Json)
                .request(new ACallback<BroseRecordBean>() {


                    @Override
                    public void onSuccess(BroseRecordBean data) {
                        bean.getRecode(data);
                    }

                    @Override
                    public void onFail(int errCode, String errMsg) {
                        //请求失败，errCode为错误码，errMsg为错误描述
                        Log.d("onFail=====", "ViewBroseRecordModel" + errMsg);
                        Log.d("onFail=====", "ViewBroseRecordModel" + errCode);
                    }
                });
    }
}
