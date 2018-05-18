package houseproperty.manyihe.com.myh_android.model;

import android.util.Log;

import com.google.gson.Gson;
import com.vise.xsnow.http.ViseHttp;
import com.vise.xsnow.http.callback.ACallback;

import java.util.HashMap;
import java.util.Map;

import houseproperty.manyihe.com.myh_android.bean.LoginBean;
import houseproperty.manyihe.com.myh_android.bean.VailCodeBean;

/**
 * Created by Mr.周 on 2018/4/18.
 */

public class VailCodeModel implements IVailCodeModel {

    @Override
    public void getVailCode(final callBackSuccessVailCode successVailCode, String mobile, String type) {
        Map<String, String> map = new HashMap<>();
        map.put("mobile", mobile);
        map.put("type", type);
        Gson gson = new Gson();
        String Json = gson.toJson(map);
        ViseHttp.POST("getValiCode")
                .tag("请求Tag，为防止内存泄露，必须设置，在onDestroy中调用cancelTag时使用")
                .setJson(Json)
                .request(new ACallback<VailCodeBean>() {


                    @Override
                    public void onSuccess(VailCodeBean data) {
                        successVailCode.vailCodeBean(data);
                        Log.d("LoginModel", "======" + data.getResultBean().getMessage());
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
