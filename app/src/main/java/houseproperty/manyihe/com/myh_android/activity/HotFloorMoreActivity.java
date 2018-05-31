package houseproperty.manyihe.com.myh_android.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.footer.LoadingView;

import java.util.List;

import houseproperty.manyihe.com.myh_android.R;
import houseproperty.manyihe.com.myh_android.adapter.HotFloorMoreAdapter;
import houseproperty.manyihe.com.myh_android.bean.HouseInfoBean;
import houseproperty.manyihe.com.myh_android.presenter.HousingResourcePresenterTypeHot;
import houseproperty.manyihe.com.myh_android.utils.ToastUtil;
import houseproperty.manyihe.com.myh_android.view.IHousingResourceViewTypeHot;

public class HotFloorMoreActivity extends BaseActivity<HousingResourcePresenterTypeHot> implements IHousingResourceViewTypeHot {

    private RecyclerView recyclerView;
    private int pageNum = 1, pageSize = 10, num = 1;
    List<HouseInfoBean.ResultBeanBean.ObjectBean.ListBean> hotListMore;
    List<HouseInfoBean.ResultBeanBean.ObjectBean.ListBean> hotListMoreAll;
    private HotFloorMoreAdapter adapter;
    private TwinklingRefreshLayout refreshLayout;
    private boolean aBoolean = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN); //显示状态栏
        setContentView(R.layout.activity_hot_floor_details_more);
        MainActivity.MIUISetStatusBarLightMode(this, true);
        MainActivity.FlymeSetStatusBarLightMode(getWindow(), true);
        recyclerView = findViewById(R.id.hot_floor_details_more_rv);
        refreshLayout = findViewById(R.id.hot_floor_details_more_trl);
        findViewById(R.id.hot_floor_details_more_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void createPresenter() {
        presenter = new HousingResourcePresenterTypeHot(this);
        presenter.ShowData(pageNum, pageSize);
    }

    @Override
    public void showResourceHotFloor(final HouseInfoBean hotData) {
        List<HouseInfoBean.ResultBeanBean.ObjectBean.ListBean> list = hotData.getResultBean().getObject().getList();
        if (aBoolean == true) {
            hotListMore.addAll(list);
            adapter.notifyDataSetChanged();
        } else {
            hotListMore = hotData.getResultBean().getObject().getList();
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //设置启用平滑滚动条
        layoutManager.setSmoothScrollbarEnabled(true);
        //设置自自动测量功能
        layoutManager.setAutoMeasureEnabled(true);
        recyclerView.setLayoutManager(layoutManager);
        //具有固定大小
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new HotFloorMoreAdapter(this, hotListMore);
        recyclerView.setAdapter(adapter);
        refreshLayout.setEnableRefresh(false);
        refreshLayout.setEnableOverScroll(false);
        refreshLayout.setAutoLoadMore(true);
        LoadingView loadingView = new LoadingView(this);
        refreshLayout.setBottomView(loadingView);
        //上拉加载更多
        refreshLayout.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onLoadMore(final TwinklingRefreshLayout refreshLayout) {
                aBoolean = true;
                if (num < hotData.getResultBean().getObject().getLastPage()) {
                    num++;
                    presenter.ShowData(num, pageSize);
                    //隐藏加载动画
                    refreshLayout.finishLoadmore();
                } else {
                    ToastUtil.getToast(HotFloorMoreActivity.this, "已加载完");
                    refreshLayout.finishLoadmore();
                }
            }
        });
    }
}
