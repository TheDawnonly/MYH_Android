package houseproperty.manyihe.com.myh_android.model;

import android.util.Log;

import com.google.gson.Gson;
import com.vise.xsnow.http.ViseHttp;
import com.vise.xsnow.http.callback.ACallback;

import java.util.HashMap;
import java.util.Map;

import houseproperty.manyihe.com.myh_android.bean.FindPassWordBean;
import houseproperty.manyihe.com.myh_android.bean.UpDataUserInfoBean;
import houseproperty.manyihe.com.myh_android.utils.MD5Utils;

/**
 * Created by Mr.周 on 2018/4/18.
 */

public class UpDataUserInfoModel implements IUpDataUserInfoModel {
    @Override
    public void getUpUser(final callBackSuccessUpUserInfoBean upUserInfoBean, int id, String headUrl, String name, String email) {
        Map<Object, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("headUrl", headUrl);
        map.put("name", name);
        map.put("email", email);
        Gson gson = new Gson();
        String Json = gson.toJson(map);
        ViseHttp.POST("updateUser")
                .tag("")
                .setJson(Json)
                .request(new ACallback<UpDataUserInfoBean>() {


                    @Override
                    public void onSuccess(UpDataUserInfoBean data) {
                        upUserInfoBean.UpUser(data);
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
