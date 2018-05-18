package houseproperty.manyihe.com.myh_android.model;

import android.util.Log;

import com.google.gson.Gson;
import com.vise.xsnow.http.ViseHttp;
import com.vise.xsnow.http.callback.ACallback;

import java.util.HashMap;
import java.util.Map;

import houseproperty.manyihe.com.myh_android.bean.InsertHouseCommBean;

/**
 * Created by Mr.周 on 2018/4/18.
 */

public class InsertHouseCommModel implements IInsertHouseCommModel {



    @Override
    public void showComm(callBackSuccessInsertCommBean bean, int userId, int houseId, String comment, int score, int pageNum, int pageSize) {
        Map<Object, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("houseId", houseId);
        map.put("comment", comment);
        map.put("score", score);
        map.put("pageNum", pageNum);
        map.put("pageSize", pageSize);
        Gson gson = new Gson();
        String Json = gson.toJson(map);
        ViseHttp.POST("insertHouseComm")
                .tag("")
                .setJson(Json)
                .request(new ACallback<InsertHouseCommBean>() {


                    @Override
                    public void onSuccess(InsertHouseCommBean data) {

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
