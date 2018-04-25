package houseproperty.manyihe.com.myh_android.model;



import com.google.gson.Gson;
import com.vise.xsnow.http.ViseHttp;
import com.vise.xsnow.http.callback.ACallback;

import java.util.HashMap;
import java.util.Map;

import houseproperty.manyihe.com.myh_android.bean.MessageBean;

/**
 * Created by Mr.周 on 2018/3/14.
 */

public class MessageModel implements IMessageModel {

    @Override
    public void getData(final callBack success, int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageNum", pageNum);
        map.put("pageSize", pageSize);
        Gson gson = new Gson();
        String toJson = gson.toJson(map);
        ViseHttp.POST("selectMyhFloor")
                .tag("请求Tag，为防止内存泄露，必须设置，在onDestroy中调用cancelTag时使用")
                .setJson(toJson)
                .request(new ACallback<MessageBean>() {


                    @Override
                    public void onSuccess(MessageBean data) {
                        success.success(data);
                    }

                    @Override
                    public void onFail(int errCode, String errMsg) {
                        //请求失败，errCode为错误码，errMsg为错误描述
                    }
                });
    }
}
