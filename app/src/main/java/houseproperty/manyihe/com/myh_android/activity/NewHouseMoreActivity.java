package houseproperty.manyihe.com.myh_android.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import houseproperty.manyihe.com.myh_android.R;
import houseproperty.manyihe.com.myh_android.adapter.NewHouseFloorAdapter;
import houseproperty.manyihe.com.myh_android.bean.HouseInfoBean;
import houseproperty.manyihe.com.myh_android.presenter.HousingResourcePresenterTypeNew;
import houseproperty.manyihe.com.myh_android.view.IHousingResourceViewTypeNew;

public class NewHouseMoreActivity extends BaseActivity<HousingResourcePresenterTypeNew> implements IHousingResourceViewTypeNew {
    private int pageNum = 1, pageSize = 10;
    private RecyclerView firstHouseRv;
    private NewHouseFloorAdapter newHouseFloorAdapter;
    private List<HouseInfoBean.ResultBeanBean.ObjectBean.ListBean> newHouseMoreList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_house_more);
        MainActivity.MIUISetStatusBarLightMode(this, true);
        MainActivity.FlymeSetStatusBarLightMode(getWindow(), true);
        firstHouseRv = findViewById(R.id.first_house_more_rv);
    }

    @Override
    public void createPresenter() {
        presenter = new HousingResourcePresenterTypeNew(this);
        presenter.ShowData(pageNum, pageSize);
    }

    @Override
    public void showResourceHotFloorTypeNew(HouseInfoBean hotData) {
        newHouseMoreList = hotData.getResultBean().getObject().getList();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //设置启用平滑滚动条
        layoutManager.setSmoothScrollbarEnabled(true);
        //设置自自动测量功能
        layoutManager.setAutoMeasureEnabled(true);
        firstHouseRv.setLayoutManager(layoutManager);
        //具有固定大小
        firstHouseRv.setHasFixedSize(true);
        firstHouseRv.setNestedScrollingEnabled(false);
        newHouseFloorAdapter = new NewHouseFloorAdapter(this, newHouseMoreList);
        firstHouseRv.setAdapter(newHouseFloorAdapter);
    }
}
