package houseproperty.manyihe.com.myh_android.presenter;

import java.lang.ref.WeakReference;

import houseproperty.manyihe.com.myh_android.bean.HousingResourceBannerBean;
import houseproperty.manyihe.com.myh_android.bean.LoginBean;
import houseproperty.manyihe.com.myh_android.model.HomeBannerModel;
import houseproperty.manyihe.com.myh_android.model.IHomeBanner;
import houseproperty.manyihe.com.myh_android.model.ILoginModel;
import houseproperty.manyihe.com.myh_android.model.LoginModel;
import houseproperty.manyihe.com.myh_android.view.IHomeBannerView;
import houseproperty.manyihe.com.myh_android.view.ILoginBeanView;

/**
 * Created by Mr.周 on 2018/4/18.
 * 首页banner轮播图
 */

public class LoginPresenter implements IPresenter<ILoginBeanView> {
    ILoginModel iLoginModel;
    WeakReference<ILoginBeanView> mRefView;

    public LoginPresenter(ILoginBeanView loginBeanView) {
        this.iLoginModel = new LoginModel();
        attach(loginBeanView);
    }

    @Override
    public void attach(ILoginBeanView view) {
        mRefView = new WeakReference<ILoginBeanView>(view);
    }

    @Override
    public void detach() {
        mRefView.clear();
    }

    public void showLogin(String mobile, String password) {
        iLoginModel.getLogin(new ILoginModel.callBackSuccessLoginBean() {
            @Override
            public void LoginBean(LoginBean loginBean) {
                mRefView.get().getShowLogin(loginBean);
            }
        },mobile,password);
    }
}
