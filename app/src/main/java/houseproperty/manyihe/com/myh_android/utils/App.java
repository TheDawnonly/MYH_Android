package houseproperty.manyihe.com.myh_android.utils;

import android.app.Application;
import android.content.res.Configuration;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.vise.xsnow.common.ViseConfig;
import com.vise.xsnow.http.ViseHttp;
import com.yatoooon.screenadaptation.ScreenAdapterTools;

import java.io.File;

import okhttp3.Cache;

/**
 * Created by Mr.周 on 2018/3/15.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ScreenAdapterTools.init(this);
        //presco图片初始化
        Fresco.initialize(this);
        ViseHttp.init(this);
        ViseHttp.CONFIG()
                //配置请求主机地址www.manyihefc.com  192.168.0.111:8080
                .baseUrl("http://www.manyihefc.com:8080/myh_web/")
                //全局读取超时时间，单位秒
                .readTimeout(6)
                //全局写入超时时间，单位秒
                .writeTimeout(30)
                //全局连接超时时间，单位秒
                .connectTimeout(6)
                //全局请求失败重试次数
                .retryCount(30)
                //全局请求失败重试间隔时间，单位毫秒
                .retryDelayMillis(2000)
                //配置是否使用OkHttp的默认缓存
                .setHttpCache(true)
                //配置OkHttp缓存路径
                .setHttpCacheDirectory(new File(ViseHttp.getContext().getCacheDir(), ViseConfig.CACHE_HTTP_DIR))
                //配置自定义OkHttp缓存
                .httpCache(new Cache(new File(ViseHttp.getContext().getCacheDir(), ViseConfig.CACHE_HTTP_DIR), ViseConfig.CACHE_MAX_SIZE))
                //配置自定义离线缓存
                .cacheOffline(new Cache(new File(ViseHttp.getContext().getCacheDir(), ViseConfig.CACHE_HTTP_DIR), ViseConfig.CACHE_MAX_SIZE))
                //配置自定义在线缓存
                .cacheOnline(new Cache(new File(ViseHttp.getContext().getCacheDir(), ViseConfig.CACHE_HTTP_DIR), ViseConfig.CACHE_MAX_SIZE));


    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        ScreenAdapterTools.init(this);
    }
}
