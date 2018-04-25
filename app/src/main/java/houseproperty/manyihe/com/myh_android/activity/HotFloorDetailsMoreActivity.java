package houseproperty.manyihe.com.myh_android.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.WindowManager;

import java.util.List;

import houseproperty.manyihe.com.myh_android.R;
import houseproperty.manyihe.com.myh_android.adapter.HotFloorAdapter;
import houseproperty.manyihe.com.myh_android.bean.HouseInfoBean;
import houseproperty.manyihe.com.myh_android.presenter.HousingResourcePresenterTypeHot;
import houseproperty.manyihe.com.myh_android.view.IHousingResourceViewTypeHot;

public class HotFloorDetailsMoreActivity extends BaseActivity<HousingResourcePresenterTypeHot> implements IHousingResourceViewTypeHot {

    private RecyclerView recyclerView;
    private int pageNum=1, pageSize=10;
    List<HouseInfoBean.ResultBeanBean.ObjectBean.ListBean> hotListMore;
    private LinearLayoutManager manager;
    private HotFloorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN); //显示状态栏
        setContentView(R.layout.activity_hot_floor_details_more);
        MainActivity.MIUISetStatusBarLightMode(this, true);
        MainActivity.FlymeSetStatusBarLightMode(getWindow(), true);
        recyclerView = findViewById(R.id.hot_floor_details_more_rv);
    }

    @Override
    public void createPresenter() {
        presenter = new HousingResourcePresenterTypeHot(this);
        presenter.ShowData(pageNum, pageSize);
    }

    @Override
    public void showResourceHotFloor(HouseInfoBean hotData) {
        hotListMore = hotData.getResultBean().getObject().getList();
        manager = new LinearLayoutManager(this);
        //设置启用平滑滚动条
        manager.setSmoothScrollbarEnabled(true);
        //设置自自动测量功能
        manager.setAutoMeasureEnabled(true);
        recyclerView.setLayoutManager(manager);
        //具有固定大小
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        adapter = new HotFloorAdapter(this, hotListMore);
        recyclerView.setAdapter(adapter);
    }
}
