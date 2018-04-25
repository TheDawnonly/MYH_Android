package houseproperty.manyihe.com.myh_android.model;

import android.util.Log;

import com.vise.xsnow.http.ViseHttp;
import com.vise.xsnow.http.callback.ACallback;

import houseproperty.manyihe.com.myh_android.bean.HousingResourceBannerBean;

/**
 * Created by Mr.周 on 2018/4/18.
 */

public class HomeBannerModel implements IHomeBanner {


    @Override
    public void getHomeBanner(final callBackSuccessBannerBean floorBean) {
        ViseHttp.POST("viewBannerImgs")
                .tag("请求Tag，为防止内存泄露，必须设置，在onDestroy中调用cancelTag时使用")
                .request(new ACallback<HousingResourceBannerBean>() {


                    @Override
                    public void onSuccess(HousingResourceBannerBean data) {
                        floorBean.HousingResourceBannerBean(data);
                    }

                    @Override
                    public void onFail(int errCode, String errMsg) {
                        //请求失败，errCode为错误码，errMsg为错误描述
                        Log.d("onFail=====", "HousingResourceBannerBean" + errMsg);
                        Log.d("onFail=====", "HousingResourceBannerBean" + errCode);
                    }
                });
    }
}
