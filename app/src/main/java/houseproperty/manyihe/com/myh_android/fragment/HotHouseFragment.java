package houseproperty.manyihe.com.myh_android.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.List;

import houseproperty.manyihe.com.myh_android.R;
import houseproperty.manyihe.com.myh_android.activity.AgentMoreActivity;
import houseproperty.manyihe.com.myh_android.activity.HotFloorMoreActivity;
import houseproperty.manyihe.com.myh_android.adapter.RecordOneHouseAdapter;
import houseproperty.manyihe.com.myh_android.adapter.RecordOneHouseAdapter0;
import houseproperty.manyihe.com.myh_android.bean.BroseRecordBean;
import houseproperty.manyihe.com.myh_android.bean.HouseInfoBean;
import houseproperty.manyihe.com.myh_android.presenter.HousingResourcePresenterTypeHot;
import houseproperty.manyihe.com.myh_android.presenter.ViewBroseRecordPresenter;
import houseproperty.manyihe.com.myh_android.view.IBroseRecordView;
import houseproperty.manyihe.com.myh_android.view.IHousingResourceViewTypeHot;

public class HotHouseFragment extends BaseFragment<ViewBroseRecordPresenter> implements IBroseRecordView, IHousingResourceViewTypeHot {

    private SharedPreferences sp;
    private RelativeLayout noDataRl;
    private RecyclerView yesDataRv, oneHouseRv;
    private List<HouseInfoBean.ResultBeanBean.ObjectBean.ListBean> oneHouseList;
    private LinearLayoutManager manager, manager0;
    private List<BroseRecordBean.ResultBeanBean.ObjectBean> recordList;

    @Override
    public int intLayout() {
        return R.layout.hot_tab_layout;
    }

    @Override
    public View initView() {
        noDataRl = view.findViewById(R.id.hot_house_record_NoData);
        yesDataRv = view.findViewById(R.id.hot_house_record_rv);
        oneHouseRv = view.findViewById(R.id.one_hot_house_rv);
        view.findViewById(R.id.btn_tab_layout_more_hot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), HotFloorMoreActivity.class));
            }
        });
        view.findViewById(R.id.hot_house_tab_Agent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), AgentMoreActivity.class));
            }
        });
        return view;
    }

    @Override
    public void createPresenter() {
        //获取SP
        sp = getActivity().getSharedPreferences("config", getActivity().MODE_PRIVATE);
        String code = sp.getString("code", "");
        if (code.equals("0")) {
            int id = sp.getInt("id", 0);
            presenter = new ViewBroseRecordPresenter(this);
            presenter.showViewBroseRecordPresenter(id, 0);
        } else {
            presenter = new ViewBroseRecordPresenter(this);
            presenter.showViewBroseRecordPresenter(null, 0);
        }

        HousingResourcePresenterTypeHot typeNew = new HousingResourcePresenterTypeHot(this);
        typeNew.ShowData(1, 2);
    }

    @Override
    public void showRecordView(BroseRecordBean recordBean) {
        if (recordBean.getResultBean().getCode().equals("1")) {
            noDataRl.setVisibility(View.VISIBLE);
            yesDataRv.setVisibility(View.GONE);
        } else {
            noDataRl.setVisibility(View.GONE);
            yesDataRv.setVisibility(View.VISIBLE);
        }
        recordList = recordBean.getResultBean().getObject();
        manager0 = new LinearLayoutManager(getContext());
        //设置启用平滑滚动条
        manager0.setSmoothScrollbarEnabled(true);
        //设置自自动测量功能
        manager0.setAutoMeasureEnabled(true);
        yesDataRv.setLayoutManager(manager0);
        //具有固定大小
        yesDataRv.setHasFixedSize(true);
        yesDataRv.setNestedScrollingEnabled(false);
        RecordOneHouseAdapter0 adapter0 = new RecordOneHouseAdapter0(getContext(), recordList);
        yesDataRv.setAdapter(adapter0);
    }

    @Override
    public void showResourceHotFloor(HouseInfoBean hotData) {
        oneHouseList = hotData.getResultBean().getObject().getList();
        manager = new LinearLayoutManager(getContext());
        //设置启用平滑滚动条
        manager.setSmoothScrollbarEnabled(true);
        //设置自自动测量功能
        manager.setAutoMeasureEnabled(true);
        oneHouseRv.setLayoutManager(manager);
        //具有固定大小
        oneHouseRv.setHasFixedSize(true);
        oneHouseRv.setNestedScrollingEnabled(false);
        RecordOneHouseAdapter adapter = new RecordOneHouseAdapter(getContext(), oneHouseList);
        oneHouseRv.setAdapter(adapter);
    }
}
