package houseproperty.manyihe.com.myh_android.presenter;

import java.lang.ref.WeakReference;

import houseproperty.manyihe.com.myh_android.bean.HouseInfoBean;
import houseproperty.manyihe.com.myh_android.model.HotFloorDetailsModel;
import houseproperty.manyihe.com.myh_android.model.IHotFloorDetailsM;
import houseproperty.manyihe.com.myh_android.model.INewFloorDetailsM;
import houseproperty.manyihe.com.myh_android.model.NewFloorDetailsModel;
import houseproperty.manyihe.com.myh_android.view.IHotFloorDetailsView;
import houseproperty.manyihe.com.myh_android.view.INewFloorDetailsView;

/**
 * Created by Mr.周 on 2018/4/18.
 */

public class NewFloorDetailsPresenter implements IPresenter<INewFloorDetailsView> {
    INewFloorDetailsM newFloorDetailsM;
    WeakReference<INewFloorDetailsView> mRefView;

    public NewFloorDetailsPresenter(INewFloorDetailsView newFloorDetailsView) {
        this.newFloorDetailsM = new NewFloorDetailsModel();
        attach(newFloorDetailsView);
    }

    @Override
    public void attach(INewFloorDetailsView view) {
        mRefView = new WeakReference<INewFloorDetailsView>(view);
    }

    @Override
    public void detach() {
        mRefView.clear();
    }

    public void showNewFloorDetails(int id, int userId) {
        newFloorDetailsM.getNewFloorDetails(new INewFloorDetailsM.callBackSuccessNewFloorDetailsBean() {
            @Override
            public void HousingResourceNewFloorBean(HouseInfoBean housingResource) {
                mRefView.get().getNewFloorShow(housingResource);
            }
        }, id, userId);
    }
}
