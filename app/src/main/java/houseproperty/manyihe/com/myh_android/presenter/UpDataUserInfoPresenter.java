package houseproperty.manyihe.com.myh_android.presenter;

import java.lang.ref.WeakReference;

import houseproperty.manyihe.com.myh_android.bean.UpDataUserInfoBean;
import houseproperty.manyihe.com.myh_android.model.IUpDataUserInfoModel;
import houseproperty.manyihe.com.myh_android.model.UpDataUserInfoModel;
import houseproperty.manyihe.com.myh_android.view.IUpDataUserInfoBeanView;

/**
 * Created by Mr.周 on 2018/4/18.
 * 首页banner轮播图
 */

public class UpDataUserInfoPresenter implements IPresenter<IUpDataUserInfoBeanView> {
    IUpDataUserInfoModel infoModel;
    WeakReference<IUpDataUserInfoBeanView> mRefView;

    public UpDataUserInfoPresenter(IUpDataUserInfoBeanView userInfoBeanView) {
        this.infoModel = new UpDataUserInfoModel();
        attach(userInfoBeanView);
    }

    @Override
    public void attach(IUpDataUserInfoBeanView view) {
        mRefView = new WeakReference<IUpDataUserInfoBeanView>(view);
    }

    @Override
    public void detach() {
        mRefView.clear();
    }

    public void showUpUserInfo(int id, String headUrl, String name, String email) {
        infoModel.getUpUser(new IUpDataUserInfoModel.callBackSuccessUpUserInfoBean() {
            @Override
            public void UpUser(UpDataUserInfoBean upDataUser) {
                mRefView.get().getupUser(upDataUser);
            }
        }, id, headUrl, name, email);
    }
}
