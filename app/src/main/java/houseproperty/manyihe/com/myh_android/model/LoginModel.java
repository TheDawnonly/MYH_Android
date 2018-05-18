package houseproperty.manyihe.com.myh_android.model;

import android.util.Log;

import com.google.gson.Gson;
import com.vise.xsnow.http.ViseHttp;
import com.vise.xsnow.http.callback.ACallback;

import java.util.HashMap;
import java.util.Map;

import houseproperty.manyihe.com.myh_android.bean.HousingResourceBannerBean;
import houseproperty.manyihe.com.myh_android.bean.LoginBean;
import houseproperty.manyihe.com.myh_android.utils.MD5Utils;

/**
 * Created by Mr.周 on 2018/4/18.
 */

public class LoginModel implements ILoginModel {


    @Override
    public void getLogin(final callBackSuccessLoginBean loginBean, String mobile, String password) {
        Map<String, String> map = new HashMap<>();
        if (password != null && !password.equals("")){
            String md5PassWord = MD5Utils.encryptMD5(password);
            map.put("mobile", mobile);
            map.put("password", md5PassWord);
        }
        Gson gson = new Gson();
        String Json = gson.toJson(map);
        ViseHttp.POST("login")
                .tag("请求Tag，为防止内存泄露，必须设置，在onDestroy中调用cancelTag时使用")
                .setJson(Json)
                .request(new ACallback<LoginBean>() {


                    @Override
                    public void onSuccess(LoginBean data) {
                        loginBean.LoginBean(data);
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
