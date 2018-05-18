package houseproperty.manyihe.com.myh_android.presenter;

import java.io.File;
import java.lang.ref.WeakReference;

import houseproperty.manyihe.com.myh_android.bean.LoginBean;
import houseproperty.manyihe.com.myh_android.bean.UpLoadImageBean;
import houseproperty.manyihe.com.myh_android.model.ILoginModel;
import houseproperty.manyihe.com.myh_android.model.IUpLoadImageModel;
import houseproperty.manyihe.com.myh_android.model.UpLoadImageModel;
import houseproperty.manyihe.com.myh_android.view.ILoginBeanView;
import houseproperty.manyihe.com.myh_android.view.IUpLoadImageBeanView;

/**
 * Created by Mr.周 on 2018/4/18.
 */

public class UpLoadImagePresenter implements IPresenter<IUpLoadImageBeanView> {
    IUpLoadImageModel imageModel;
    WeakReference<IUpLoadImageBeanView> mRefView;

    public UpLoadImagePresenter(IUpLoadImageBeanView imageBeanView) {
        this.imageModel = new UpLoadImageModel();
        attach(imageBeanView);
    }

    @Override
    public void attach(IUpLoadImageBeanView view) {
        mRefView = new WeakReference<IUpLoadImageBeanView>(view);
    }

    @Override
    public void detach() {
        mRefView.clear();
    }

    public void showImage(File file) {
        imageModel.getImage(new IUpLoadImageModel.callBackSuccessImageBean() {
            @Override
            public void ImageBean(UpLoadImageBean loadImageBean) {
                mRefView.get().getShowImage(loadImageBean);
            }
        }, file);
    }
}
