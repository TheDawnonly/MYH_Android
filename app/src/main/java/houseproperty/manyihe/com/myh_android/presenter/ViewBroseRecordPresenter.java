package houseproperty.manyihe.com.myh_android.presenter;

import java.lang.ref.WeakReference;

import houseproperty.manyihe.com.myh_android.bean.BroseRecordBean;
import houseproperty.manyihe.com.myh_android.bean.HouseInfoBean;
import houseproperty.manyihe.com.myh_android.model.IViewBroseRecordModel;
import houseproperty.manyihe.com.myh_android.model.ViewBroseRecordModel;
import houseproperty.manyihe.com.myh_android.view.IBroseRecordView;

public class ViewBroseRecordPresenter implements IPresenter<IBroseRecordView> {

    IViewBroseRecordModel model;
    WeakReference<IBroseRecordView> mRefView;

    public ViewBroseRecordPresenter(IBroseRecordView view) {
        this.model = new ViewBroseRecordModel();
        attach(view);
    }

    @Override
    public void attach(IBroseRecordView view) {
        mRefView = new WeakReference<IBroseRecordView>(view);
    }

    @Override
    public void detach() {
        mRefView.clear();
    }

    public void showViewBroseRecordPresenter(int id, int type) {
        model.showRecode(new IViewBroseRecordModel.callBackSuccessRecordBean() {
            @Override
            public void getRecode(BroseRecordBean bean) {
                mRefView.get().showRecordView(bean);
            }
        }, id, type);
    }
}
