package houseproperty.manyihe.com.myh_android.model;

import android.util.Log;

import com.google.gson.Gson;
import com.vise.xsnow.http.ViseHttp;
import com.vise.xsnow.http.callback.ACallback;

import java.util.HashMap;
import java.util.Map;

import houseproperty.manyihe.com.myh_android.bean.LoginBean;
import houseproperty.manyihe.com.myh_android.bean.RegisterBean;
import houseproperty.manyihe.com.myh_android.utils.MD5Utils;

/**
 * Created by Mr.周 on 2018/4/18.
 */

public class RegisterModel implements IRegisterModel {


    @Override
    public void getRegister(final callBackSuccessRegisterBean registerBean, String mobile, String valiCode, String password) {
        Map<String, String> map = new HashMap<>();
        if (password != null && !password.equals("")){
            String md5PassWord = MD5Utils.encryptMD5(password);
            map.put("mobile", mobile);
            map.put("password", md5PassWord);
            map.put("password2", md5PassWord);
            map.put("valiCode", valiCode);
        }


        Gson gson = new Gson();
        String Json = gson.toJson(map);
        ViseHttp.POST("register")
                .tag("请求Tag，为防止内存泄露，必须设置，在onDestroy中调用cancelTag时使用")
                .setJson(Json)
                .request(new ACallback<RegisterBean>() {


                    @Override
                    public void onSuccess(RegisterBean data) {
                        registerBean.RegisterBean(data);
                        Log.d("RegisterModel", "======" + data.getResultBean().getMessage());
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
