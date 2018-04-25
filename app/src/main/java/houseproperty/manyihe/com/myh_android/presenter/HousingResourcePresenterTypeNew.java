package houseproperty.manyihe.com.myh_android.presenter;

import java.lang.ref.WeakReference;

import houseproperty.manyihe.com.myh_android.bean.HouseInfoBean;
import houseproperty.manyihe.com.myh_android.model.HousingResourceModelTypeHot;
import houseproperty.manyihe.com.myh_android.model.HousingResourceModelTypeNew;
import houseproperty.manyihe.com.myh_android.model.IModelHousingResource;
import houseproperty.manyihe.com.myh_android.model.IModelHousingResourceTypeNew;
import houseproperty.manyihe.com.myh_android.view.IHousingResourceViewTypeHot;
import houseproperty.manyihe.com.myh_android.view.IHousingResourceViewTypeNew;


/**
 * Created by Mr.周 on 2018/3/14.
 */

public class HousingResourcePresenterTypeNew implements IPresenter<IHousingResourceViewTypeNew> {
    IModelHousingResourceTypeNew modelActivity;
    WeakReference<IHousingResourceViewTypeNew> mRefView;

    public HousingResourcePresenterTypeNew(IHousingResourceViewTypeNew iView) {
        this.modelActivity = new HousingResourceModelTypeNew();
        attach(iView);
    }

    @Override
    public void attach(IHousingResourceViewTypeNew view) {
        mRefView = new WeakReference<IHousingResourceViewTypeNew>(view);
    }

    @Override
    public void detach() {
        mRefView.clear();
    }

    public void ShowData(int pageNum, int pageSize) {
        modelActivity.getHotFloor(new IModelHousingResourceTypeNew.callBackSuccessFloorBean() {
            @Override
            public void HousingResourceHotFloorBean(HouseInfoBean housingResource) {
                mRefView.get().showResourceHotFloorTypeNew(housingResource);
            }
        }, pageNum, pageSize);
    }
}
