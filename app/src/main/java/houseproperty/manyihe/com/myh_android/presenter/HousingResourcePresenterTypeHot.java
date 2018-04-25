package houseproperty.manyihe.com.myh_android.presenter;

import java.lang.ref.WeakReference;

import houseproperty.manyihe.com.myh_android.bean.HouseInfoBean;
import houseproperty.manyihe.com.myh_android.model.IModelHousingResource;
import houseproperty.manyihe.com.myh_android.model.HousingResourceModelTypeHot;
import houseproperty.manyihe.com.myh_android.view.IHousingResourceViewTypeHot;


/**
 * Created by Mr.周 on 2018/3/14.
 */

public class HousingResourcePresenterTypeHot implements IPresenter<IHousingResourceViewTypeHot> {
    IModelHousingResource modelActivity;
    WeakReference<IHousingResourceViewTypeHot> mRefView;

    public HousingResourcePresenterTypeHot(IHousingResourceViewTypeHot iView) {
        this.modelActivity = new HousingResourceModelTypeHot();
        attach(iView);
    }

    @Override
    public void attach(IHousingResourceViewTypeHot view) {
        mRefView = new WeakReference<IHousingResourceViewTypeHot>(view);
    }

    @Override
    public void detach() {
        mRefView.clear();
    }

    public void ShowData(int pageNum, int pageSize) {
        modelActivity.getHotFloor(new IModelHousingResource.callBackSuccessFloorBean() {
            @Override
            public void HousingResourceHotFloorBean(HouseInfoBean housingResource) {
                mRefView.get().showResourceHotFloor(housingResource);
            }
        }, pageNum, pageSize);
    }
}
