package houseproperty.manyihe.com.myh_android.utils;

import houseproperty.manyihe.com.myh_android.bean.Books;
import houseproperty.manyihe.com.myh_android.bean.HousingResourceHotFloorBean;
import houseproperty.manyihe.com.myh_android.bean.MessageBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Mr.周 on 2018/3/14.
 */

public interface ApiService {
    public static final String URL = "http://apiv3.yangkeduo.com/v5/newlist?page=1&size=100";
    public static final String HOTDATA = "http://192.168.0.121:8080/myh_web/";

    //@GET("newlist?page=1&size=100")
//    Observable<Books> getDataBook();
//
//    //楼讯列表
    @POST("viewHouseInfo")
    Observable<HousingResourceHotFloorBean> getData(@Query("pageNum") int pageNum, @Query("pageSize") int pageSize, @Query("type") int type);

}
