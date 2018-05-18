package houseproperty.manyihe.com.myh_android.presenter;

import java.lang.ref.WeakReference;

import houseproperty.manyihe.com.myh_android.bean.LoginBean;
import houseproperty.manyihe.com.myh_android.bean.RegisterBean;
import houseproperty.manyihe.com.myh_android.model.ILoginModel;
import houseproperty.manyihe.com.myh_android.model.IRegisterModel;
import houseproperty.manyihe.com.myh_android.model.LoginModel;
import houseproperty.manyihe.com.myh_android.model.RegisterModel;
import houseproperty.manyihe.com.myh_android.view.ILoginBeanView;
import houseproperty.manyihe.com.myh_android.view.IRegisterBeanView;

/**
 * Created by Mr.周 on 2018/4/18.
 * 首页banner轮播图
 */

public class RegisterPresenter implements IPresenter<IRegisterBeanView> {
    IRegisterModel model;
    WeakReference<IRegisterBeanView> mRefView;

    public RegisterPresenter(IRegisterBeanView registerBeanView) {
        this.model = new RegisterModel();
        attach(registerBeanView);
    }

    @Override
    public void attach(IRegisterBeanView view) {
        mRefView = new WeakReference<IRegisterBeanView>(view);
    }

    @Override
    public void detach() {
        mRefView.clear();
    }

    public void showRegister(String mobile, String valiCode, String password) {
        model.getRegister(new IRegisterModel.callBackSuccessRegisterBean() {
            @Override
            public void RegisterBean(RegisterBean registerBean) {
                mRefView.get().getShowRegister(registerBean);
            }
        },mobile,valiCode,password);
    }
}
