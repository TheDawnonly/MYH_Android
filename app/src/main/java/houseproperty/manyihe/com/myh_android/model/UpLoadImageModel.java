package houseproperty.manyihe.com.myh_android.model;

import android.util.Log;

import com.google.gson.Gson;
import com.vise.xsnow.http.ViseHttp;
import com.vise.xsnow.http.callback.ACallback;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import houseproperty.manyihe.com.myh_android.bean.LoginBean;
import houseproperty.manyihe.com.myh_android.bean.UpLoadImageBean;
import houseproperty.manyihe.com.myh_android.utils.ApiService;
import houseproperty.manyihe.com.myh_android.utils.MD5Utils;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Multipart;

/**
 * Created by Mr.周 on 2018/4/18.
 */

public class UpLoadImageModel implements IUpLoadImageModel {
    @Override
    public void getImage(final callBackSuccessImageBean imageBean, File file) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://192.168.0.111:8080/myh_web/viewHouseInfo")
                .build();
        ApiService service = retrofit.create(ApiService.class);
        String path = file.getPath();
        File fileImg = new File(path);//访问手机端的文件资源，保证手机端sdcdrd中必须有这个文件
        RequestBody requestFile =
                RequestBody.create(MediaType.parse("multipart/form-data"), file);

        MultipartBody.Part body = MultipartBody.Part.createFormData("aFile", file.getName(), requestFile);

        String descriptionString = "This is a description";
        RequestBody description =
                RequestBody.create(MediaType.parse("multipart/form-data"), descriptionString);

        Call<UpLoadImageBean> call = service.upload(description, body);
        call.enqueue(new Callback<UpLoadImageBean>() {
            @Override
            public void onResponse(Call<UpLoadImageBean> call,
                                   Response<UpLoadImageBean> response) {
            }

            @Override
            public void onFailure(Call<UpLoadImageBean> call, Throwable t) {
                t.printStackTrace();

            }
        });
    }
}
