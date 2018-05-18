package houseproperty.manyihe.com.myh_android.model;

import java.io.File;

import houseproperty.manyihe.com.myh_android.bean.UpLoadImageBean;

/**
 * Created by Mr.周 on 2018/4/18.
 */

public interface IUpLoadImageModel {
    void getImage(callBackSuccessImageBean imageBean, File file);

    interface callBackSuccessImageBean {
        void ImageBean(UpLoadImageBean loadImageBean);
    }
}
