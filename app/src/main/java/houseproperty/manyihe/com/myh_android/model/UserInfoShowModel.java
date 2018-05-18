package houseproperty.manyihe.com.myh_android.model;

import android.util.Log;

import com.google.gson.Gson;
import com.vise.xsnow.http.ViseHttp;
import com.vise.xsnow.http.callback.ACallback;

import java.util.HashMap;
import java.util.Map;

import houseproperty.manyihe.com.myh_android.bean.UserInfoShowBean;


/**
 * Created by Mr.周 on 2018/4/18.
 */

public class UserInfoShowModel implements IUserInfoShowModel {

    @Override
    public void getUserInfo(final callBackSuccessUserInfoBean infoBean, int userId) {
        Map<String, Integer> map = new HashMap<>();
        map.put("id", userId);
        Gson gson = new Gson();
        String Json = gson.toJson(map);
        ViseHttp.POST("selectUser")
                .tag("")
                .setJson(Json)
                .request(new ACallback<UserInfoShowBean>() {


                    @Override
                    public void onSuccess(UserInfoShowBean data) {
                        infoBean.UserInfo(data);
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
