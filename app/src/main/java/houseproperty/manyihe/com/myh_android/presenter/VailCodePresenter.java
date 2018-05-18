package houseproperty.manyihe.com.myh_android.presenter;

import java.lang.ref.WeakReference;

import houseproperty.manyihe.com.myh_android.bean.LoginBean;
import houseproperty.manyihe.com.myh_android.bean.VailCodeBean;
import houseproperty.manyihe.com.myh_android.model.ILoginModel;
import houseproperty.manyihe.com.myh_android.model.IVailCodeModel;
import houseproperty.manyihe.com.myh_android.model.LoginModel;
import houseproperty.manyihe.com.myh_android.model.VailCodeModel;
import houseproperty.manyihe.com.myh_android.view.ILoginBeanView;
import houseproperty.manyihe.com.myh_android.view.IVailCodeBeanView;

/**
 * Created by Mr.周 on 2018/4/18.
 * 首页banner轮播图
 */

public class VailCodePresenter implements IPresenter<IVailCodeBeanView> {
    IVailCodeModel model;
    WeakReference<IVailCodeBeanView> mRefView;

    public VailCodePresenter(IVailCodeBeanView vailCodeBeanView) {
        this.model = new VailCodeModel();
        attach(vailCodeBeanView);
    }

    @Override
    public void attach(IVailCodeBeanView view) {
        mRefView = new WeakReference<IVailCodeBeanView>(view);
    }

    @Override
    public void detach() {
        mRefView.clear();
    }

    public void showVailCode(String mobile, String type) {
        model.getVailCode(new IVailCodeModel.callBackSuccessVailCode() {
            @Override
            public void vailCodeBean(VailCodeBean vailCodeBean) {
                mRefView.get().getShowVailCode(vailCodeBean);
            }
        }, mobile, type);
    }
}
