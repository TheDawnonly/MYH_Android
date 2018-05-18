package houseproperty.manyihe.com.myh_android.presenter;

import java.lang.ref.WeakReference;

import houseproperty.manyihe.com.myh_android.bean.FindPassWordBean;
import houseproperty.manyihe.com.myh_android.bean.LoginBean;
import houseproperty.manyihe.com.myh_android.model.FindPassModel;
import houseproperty.manyihe.com.myh_android.model.IFindPassModel;
import houseproperty.manyihe.com.myh_android.model.ILoginModel;
import houseproperty.manyihe.com.myh_android.view.IFindPassWordBeanView;
import houseproperty.manyihe.com.myh_android.view.ILoginBeanView;

/**
 * Created by Mr.周 on 2018/4/18.
 * 首页banner轮播图
 */

public class FindPassPresenter implements IPresenter<IFindPassWordBeanView> {
    IFindPassModel passModel;
    WeakReference<IFindPassWordBeanView> mRefView;

    public FindPassPresenter(IFindPassWordBeanView wordBeanView) {
        this.passModel = new FindPassModel();
        attach(wordBeanView);
    }

    @Override
    public void attach(IFindPassWordBeanView view) {
        mRefView = new WeakReference<IFindPassWordBeanView>(view);
    }

    @Override
    public void detach() {
        mRefView.clear();
    }

    public void showFindPass(String mobile, String password, String valiCode) {
        passModel.getPass(new IFindPassModel.callBackSuccessFindPassBean() {
            @Override
            public void FindPass(FindPassWordBean passWordBean) {
                mRefView.get().getShowPass(passWordBean);
            }
        }, mobile, password, valiCode);
    }
}
