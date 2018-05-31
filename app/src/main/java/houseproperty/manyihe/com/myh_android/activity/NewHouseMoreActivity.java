package houseproperty.manyihe.com.myh_android.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.footer.LoadingView;

import java.util.List;

import houseproperty.manyihe.com.myh_android.R;
import houseproperty.manyihe.com.myh_android.adapter.NewHouseFloorAdapter;
import houseproperty.manyihe.com.myh_android.bean.HouseInfoBean;
import houseproperty.manyihe.com.myh_android.presenter.HousingResourcePresenterTypeNew;
import houseproperty.manyihe.com.myh_android.utils.ToastUtil;
import houseproperty.manyihe.com.myh_android.view.IHousingResourceViewTypeNew;

public class NewHouseMoreActivity extends BaseActivity<HousingResourcePresenterTypeNew> implements IHousingResourceViewTypeNew {
    private int pageNum = 1, pageSize = 10;
    private RecyclerView firstHouseRv;
    private NewHouseFloorAdapter newHouseFloorAdapter;
    private List<HouseInfoBean.ResultBeanBean.ObjectBean.ListBean> newHouseMoreList;
    private TwinklingRefreshLayout refreshLayout;
    private boolean aBoolean = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_house_more);
        MainActivity.MIUISetStatusBarLightMode(this, true);
        MainActivity.FlymeSetStatusBarLightMode(getWindow(), true);
        firstHouseRv = findViewById(R.id.first_house_more_rv);
        refreshLayout = findViewById(R.id.new_houseMore_trl);
        findViewById(R.id.new_floor_more_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void createPresenter() {
        presenter = new HousingResourcePresenterTypeNew(this);
        presenter.ShowData(pageNum, pageSize);
    }

    @Override
    public void showResourceHotFloorTypeNew(final HouseInfoBean hotData) {
        List<HouseInfoBean.ResultBeanBean.ObjectBean.ListBean> list = hotData.getResultBean().getObject().getList();
        if (aBoolean == true) {
            newHouseMoreList.addAll(list);
            newHouseFloorAdapter.notifyDataSetChanged();
        } else {
            newHouseMoreList = hotData.getResultBean().getObject().getList();
        }
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
        LoadingView loadingView = new LoadingView(this);
        refreshLayout.setBottomView(loadingView);
        refreshLayout.setEnableRefresh(false);
        refreshLayout.setEnableOverScroll(false);
        refreshLayout.setAutoLoadMore(true);
        //上拉加载更多
        refreshLayout.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onLoadMore(final TwinklingRefreshLayout refreshLayout) {
                aBoolean = true;
                if (pageNum < hotData.getResultBean().getObject().getLastPage()) {
                    pageNum++;
                    presenter.ShowData(pageNum, pageSize);
                    //隐藏加载动画
                    refreshLayout.finishLoadmore();

                } else {
                    ToastUtil.getToast(NewHouseMoreActivity.this, "已加载完");
                    //隐藏加载动画
                    refreshLayout.finishLoadmore();
                }
            }
        });
    }
}
