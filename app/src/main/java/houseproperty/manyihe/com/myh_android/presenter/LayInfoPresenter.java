package houseproperty.manyihe.com.myh_android.presenter;

import android.util.Log;

import java.lang.ref.WeakReference;

import houseproperty.manyihe.com.myh_android.bean.LayInfoBean;
import houseproperty.manyihe.com.myh_android.model.ILayInfoModel;
import houseproperty.manyihe.com.myh_android.model.LayInfoModel;
import houseproperty.manyihe.com.myh_android.view.ILayInfoView;

/**
 * Created by Mr.周 on 2018/4/18.
 * 首页banner轮播图
 */

public class LayInfoPresenter implements IPresenter<ILayInfoView> {
    ILayInfoModel infoModel;
    WeakReference<ILayInfoView> mRefView;

    public LayInfoPresenter(ILayInfoView infoView) {
        this.infoModel = new LayInfoModel();
        attach(infoView);
    }

    @Override
    public void attach(ILayInfoView view) {
        mRefView = new WeakReference<ILayInfoView>(view);
    }

    @Override
    public void detach() {
        mRefView.clear();
    }

    public void showLayInfo(int houseId) {
        infoModel.getLayInfoBean(new ILayInfoModel.callBackSuccessLayInfoBean() {
            @Override
            public void LayInfo(LayInfoBean infoBean) {
                mRefView.get().getShowLayInfo(infoBean);
            }
        }, houseId);
    }
}
