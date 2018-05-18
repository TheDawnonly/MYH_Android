package houseproperty.manyihe.com.myh_android.presenter;

import java.lang.ref.WeakReference;

import houseproperty.manyihe.com.myh_android.bean.FindPassWordBean;
import houseproperty.manyihe.com.myh_android.bean.UserInfoShowBean;
import houseproperty.manyihe.com.myh_android.model.FindPassModel;
import houseproperty.manyihe.com.myh_android.model.IFindPassModel;
import houseproperty.manyihe.com.myh_android.model.IUserInfoShowModel;
import houseproperty.manyihe.com.myh_android.model.UserInfoShowModel;
import houseproperty.manyihe.com.myh_android.view.IFindPassWordBeanView;
import houseproperty.manyihe.com.myh_android.view.IUserInfoBeanView;

/**
 * Created by Mr.周 on 2018/4/18.
 * 首页banner轮播图
 */

public class UserInfoShowPresenter implements IPresenter<IUserInfoBeanView> {
    IUserInfoShowModel showModel;
    WeakReference<IUserInfoBeanView> mRefView;

    public UserInfoShowPresenter(IUserInfoBeanView infoBeanView) {
        this.showModel = new UserInfoShowModel();
        attach(infoBeanView);
    }

    @Override
    public void attach(IUserInfoBeanView view) {
        mRefView = new WeakReference<IUserInfoBeanView>(view);
    }

    @Override
    public void detach() {
        mRefView.clear();
    }

    public void showUserInfoShow(int userId) {
        showModel.getUserInfo(new IUserInfoShowModel.callBackSuccessUserInfoBean() {
            @Override
            public void UserInfo(UserInfoShowBean infoShowBean) {
                mRefView.get().getUserInfoShow(infoShowBean);
            }
        }, userId);
    }
}
