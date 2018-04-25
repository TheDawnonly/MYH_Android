package houseproperty.manyihe.com.myh_android.presenter;

import java.lang.ref.WeakReference;

import houseproperty.manyihe.com.myh_android.bean.HousingResourceBannerBean;
import houseproperty.manyihe.com.myh_android.model.HomeBannerModel;
import houseproperty.manyihe.com.myh_android.model.IHomeBanner;
import houseproperty.manyihe.com.myh_android.view.IHomeBannerView;

/**
 * Created by Mr.周 on 2018/4/18.
 * 首页banner轮播图
 */

public class HomeBannerPresenter implements IPresenter<IHomeBannerView> {
    IHomeBanner iHomeBanner;
    WeakReference<IHomeBannerView> mRefView;

    public HomeBannerPresenter(IHomeBannerView iHomeBannerView) {
        this.iHomeBanner = new HomeBannerModel();
        attach(iHomeBannerView);
    }

    @Override
    public void attach(IHomeBannerView view) {
        mRefView = new WeakReference<IHomeBannerView>(view);
    }

    @Override
    public void detach() {
        mRefView.clear();
    }

    public void showBanner() {
        iHomeBanner.getHomeBanner(new IHomeBanner.callBackSuccessBannerBean() {
            @Override
            public void HousingResourceBannerBean(HousingResourceBannerBean housingResource) {
                mRefView.get().getShowBanner(housingResource);
            }
        });
    }
}
