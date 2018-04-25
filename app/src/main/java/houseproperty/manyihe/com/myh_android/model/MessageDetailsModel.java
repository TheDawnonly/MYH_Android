package houseproperty.manyihe.com.myh_android.model;


import android.util.Log;

import com.google.gson.Gson;
import com.vise.xsnow.http.ViseHttp;
import com.vise.xsnow.http.callback.ACallback;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import houseproperty.manyihe.com.myh_android.bean.MessageDetailsBean;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Mr.周 on 2018/3/14.
 */

public class MessageDetailsModel implements IMessageDetailsModel {
    @Override
    public void getData(final callBack success, int floorId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("floorId", floorId);
        Gson gson = new Gson();
        String toJson = gson.toJson(map);
        ViseHttp.POST("viewFloorDetail")
                .tag("请求Tag，为防止内存泄露，必须设置，在onDestroy中调用cancelTag时使用")
                .setJson(toJson)
                .request(new ACallback<MessageDetailsBean>() {
                    @Override
                    public void onSuccess(MessageDetailsBean data) {
                         success.success(data);
                    }

                    @Override
                    public void onFail(int errCode, String errMsg) {
                        //请求失败，errCode为错误码，errMsg为错误描述
                    }
                });

    }
}