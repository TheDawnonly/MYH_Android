package houseproperty.manyihe.com.myh_android.presenter;

import java.lang.ref.WeakReference;

import houseproperty.manyihe.com.myh_android.bean.HousingResourceBannerBean;
import houseproperty.manyihe.com.myh_android.bean.HousingResourceHotFloorBean;
import houseproperty.manyihe.com.myh_android.model.HomeBannerModel;
import houseproperty.manyihe.com.myh_android.model.HotFloorDetailsModel;
import houseproperty.manyihe.com.myh_android.model.IHomeBanner;
import houseproperty.manyihe.com.myh_android.model.IHotFloorDetailsM;
import houseproperty.manyihe.com.myh_android.view.IHomeBannerView;
import houseproperty.manyihe.com.myh_android.view.IHotFloorDetailsView;

/**
 * Created by Mr.周 on 2018/4/18.
 * 首页banner轮播图
 */

public class HotFloorDetailsPresenter implements IPresenter<IHotFloorDetailsView> {
    IHotFloorDetailsM iHotFloorDetailsM;
    WeakReference<IHotFloorDetailsView> mRefView;

    public HotFloorDetailsPresenter(IHotFloorDetailsView iHotFloorDetailsView) {
        this.iHotFloorDetailsM = new HotFloorDetailsModel();
        attach(iHotFloorDetailsView);
    }

    @Override
    public void attach(IHotFloorDetailsView view) {
        mRefView = new WeakReference<IHotFloorDetailsView>(view);
    }

    @Override
    public void detach() {
        mRefView.clear();
    }

    public void showHotFloorDetails(int id) {
        iHotFloorDetailsM.getHotFloorDetails(new IHotFloorDetailsM.callBackSuccessHotFloorDetailsBean() {
            @Override
            public void HousingResourceHotFloorBean(HousingResourceHotFloorBean housingResource) {
                mRefView.get().getHotFloorShow(housingResource);
            }
        }, id);
    }
}
