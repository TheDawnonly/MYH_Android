package houseproperty.manyihe.com.myh_android.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.transform.Pivot;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;
import com.youth.banner.Banner;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import houseproperty.manyihe.com.myh_android.R;
import houseproperty.manyihe.com.myh_android.adapter.AgentByHouseAdapter;
import houseproperty.manyihe.com.myh_android.adapter.HotFloorDetailsActivityAdapter;
import houseproperty.manyihe.com.myh_android.adapter.HotFloorDetailsActivityAdapter_LayInfo;
import houseproperty.manyihe.com.myh_android.adapter.RecordOneHouseAdapter;
import houseproperty.manyihe.com.myh_android.adapter.ViewHouseCommAdapter;
import houseproperty.manyihe.com.myh_android.bean.AgentByHouse;
import houseproperty.manyihe.com.myh_android.bean.HouseInfoBean;
import houseproperty.manyihe.com.myh_android.bean.LayInfoBean;
import houseproperty.manyihe.com.myh_android.bean.ViewHouseCommBean;
import houseproperty.manyihe.com.myh_android.presenter.AgentByHousePresenter;
import houseproperty.manyihe.com.myh_android.presenter.HotFloorDetailsPresenter;
import houseproperty.manyihe.com.myh_android.presenter.HousingResourcePresenterTypeHot;
import houseproperty.manyihe.com.myh_android.presenter.LayInfoPresenter;
import houseproperty.manyihe.com.myh_android.presenter.ViewHouseCommPresenter;
import houseproperty.manyihe.com.myh_android.utils.BannerImageLoader;
import houseproperty.manyihe.com.myh_android.utils.ToastUtil;
import houseproperty.manyihe.com.myh_android.view.IAgentByHouseView;
import houseproperty.manyihe.com.myh_android.view.IHotFloorDetailsView;
import houseproperty.manyihe.com.myh_android.view.IHousingResourceViewTypeHot;
import houseproperty.manyihe.com.myh_android.view.ILayInfoView;
import houseproperty.manyihe.com.myh_android.view.IViewHouseCommView;

public class HotFloorDetailsActivity extends BaseActivity<HotFloorDetailsPresenter> implements IHotFloorDetailsView, ILayInfoView, IAgentByHouseView, IViewHouseCommView, IHousingResourceViewTypeHot {

    private int houseId, userId;
    private List<HouseInfoBean.ResultBeanBean.ObjectBean.ListBean> hotDetails;
    private RecyclerView recyclerView, recyclerView2;
    private LinearLayoutManager manager, manager2, managerHot;
    private HotFloorDetailsActivityAdapter adapter;
    private HotFloorDetailsActivityAdapter_LayInfo adapter2;
    private List<LayInfoBean.ResultBeanBean.ObjectBean> layList;
    //private ImageView ivImg;
    private SimpleDraweeView sdvImg;
    private String[] split;
    private NestedScrollView mScrollView;
    private DiscreteScrollView agentDis;
    private List<AgentByHouse.ResultBeanBean.ObjectBean.ListBean> agentL;
    private RecyclerView viewHouseCommRv;
    private List<ViewHouseCommBean.ResultBeanBean.ObjectBean.ListBean> ViewHouseCommList;
    private SharedPreferences sp;
    private RecyclerView hotRv;
    private List<HouseInfoBean.ResultBeanBean.ObjectBean.ListBean> hotList;
    private Banner banner;
    private ViewHouseCommPresenter viewHouseCommPresenter;
    private Button commMore;
    private int pageNum = 1;
    private boolean aBoolean = true, isaBoolean = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN); //显示状态栏
        setContentView(R.layout.activity_hot_floor_details);
        MainActivity.MIUISetStatusBarLightMode(this, true);
        MainActivity.FlymeSetStatusBarLightMode(getWindow(), true);
        initView();
    }

    private void initView() {
        recyclerView = findViewById(R.id.hot_floor_details_rv);
        recyclerView2 = findViewById(R.id.hot_floor_details_lay_info);
        mScrollView = findViewById(R.id.hot_floor_details_sv);
        viewHouseCommRv = findViewById(R.id.ViewHouseComm);
        banner = findViewById(R.id.hot_floor_details_banner);
        ImageView imageView = findViewById(R.id.hot_floor_details_back);
        imageView.bringToFront();
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        agentDis = findViewById(R.id.hot_floor_floor_detail_dis);
        hotRv = findViewById(R.id.hot_floor_details_hotRv);
        findViewById(R.id.hot_floor_details_hotMoreBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HotFloorDetailsActivity.this, HotFloorMoreActivity.class));
            }
        });
        findViewById(R.id.activity_hotMoreBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HotFloorDetailsActivity.this, AgentMoreActivity.class));
            }
        });
        findViewById(R.id.hot_floor_details_PhoneBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                Uri data = Uri.parse("tel:" + "400-068-1359");
                intent.setData(data);
                startActivity(intent);
            }
        });
        findViewById(R.id.hot_floor_floor_detail_write).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HotFloorDetailsActivity.this, WriteCommentActivity.class);
                intent.putExtra("houseId", houseId);
                startActivity(intent);
            }
        });
        commMore = findViewById(R.id.hot_floor_details_MoreComm);
    }

    @Override
    public void createPresenter() {
        houseId = getIntent().getIntExtra("houseId", 0);
        sp = getSharedPreferences("config", MODE_PRIVATE);
        userId = sp.getInt("id", 0);
        presenter = new HotFloorDetailsPresenter(this);
        presenter.showHotFloorDetails(houseId, userId);
        LayInfoPresenter layInfoPresenter = new LayInfoPresenter(this);
        layInfoPresenter.showLayInfo(houseId);
        AgentByHousePresenter agentByHousePresenter = new AgentByHousePresenter(this);
        agentByHousePresenter.showAgentByHousePresenter(houseId, "3", 1, 5);
        viewHouseCommPresenter = new ViewHouseCommPresenter(this);
        viewHouseCommPresenter.showViewHouseCommPresenter(houseId, 1, 5);
        HousingResourcePresenterTypeHot housingResourcePresenterTypeHot = new HousingResourcePresenterTypeHot(this);
        housingResourcePresenterTypeHot.ShowData(1, 3);
    }

    @Override
    public void getHotFloorShow(HouseInfoBean houseInfoBean) {
        if (houseInfoBean.getResultBean().getObject() != null) {
            hotDetails = houseInfoBean.getResultBean().getObject().getList();
            final List<String> imgList = new ArrayList<>();
            for (int i = 0; i < hotDetails.size(); i++) {
                split = hotDetails.get(i).getImgId().split(",");
            }
            for (int j = 0; j < split.length; j++) {
                imgList.add(split[j]);
            }
            if (imgList != null) {
                banner.setImageLoader(new BannerImageLoader());
                banner.setImages(imgList);
                banner.setBannerAnimation(Transformer.Default);
                banner.start();
            }
            manager = new LinearLayoutManager(this);
            //设置启用平滑滚动条
            manager.setSmoothScrollbarEnabled(true);
            //设置自自动测量功能
            manager.setAutoMeasureEnabled(true);
            recyclerView.setLayoutManager(manager);
            //具有固定大小
            recyclerView.setHasFixedSize(true);
            recyclerView.setNestedScrollingEnabled(false);
            adapter = new HotFloorDetailsActivityAdapter(this, hotDetails);
            recyclerView.setAdapter(adapter);
        }

    }

    /**
     * 户型图
     *
     * @param infoBean
     */
    @Override
    public void getShowLayInfo(LayInfoBean infoBean) {
        layList = infoBean.getResultBean().getObject();
        manager2 = new LinearLayoutManager(this);
        //设置启用平滑滚动条
        manager2.setSmoothScrollbarEnabled(true);
        //设置自自动测量功能
        manager2.setAutoMeasureEnabled(true);
        recyclerView2.setLayoutManager(manager2);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setNestedScrollingEnabled(false);
        adapter2 = new HotFloorDetailsActivityAdapter_LayInfo(this, layList);
        recyclerView2.setAdapter(adapter2);
    }

    /**
     * 经纪人模块
     */
    @Override
    public void showAgentByHouseView(AgentByHouse agentByHouse) {
        agentL = agentByHouse.getResultBean().getObject().getList();
        //discreteScrollView.setOffscreenItems(10);
        agentDis.setItemTransformer(new ScaleTransformer.Builder()
                .setMaxScale(1.2f)
                .setMinScale(0.7f)
                .setPivotX(Pivot.X.CENTER) // CENTER is a default one
                .setPivotY(Pivot.Y.BOTTOM) // CENTER is a default one
                .build());

        agentDis.setAdapter(new AgentByHouseAdapter(HotFloorDetailsActivity.this, agentL));
    }

    /**
     * 用户评论展示
     *
     * @param houseCommBean
     */
    @Override
    public void showViewHouseComm(final ViewHouseCommBean houseCommBean) {
        isaBoolean = false;
        if (houseCommBean.getResultBean().getObject() != null) {
            commMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (pageNum < houseCommBean.getResultBean().getObject().getLastPage()) {
                        pageNum++;
                        viewHouseCommPresenter.showViewHouseCommPresenter(houseId, pageNum, 5);
                        List<ViewHouseCommBean.ResultBeanBean.ObjectBean.ListBean> list = houseCommBean.getResultBean().getObject().getList();
                        ViewHouseCommList.addAll(list);
                        aBoolean = false;
                    } else {
                        ToastUtil.getToast(HotFloorDetailsActivity.this, "已加载全部");
                    }
                }
            });
            if (aBoolean == true) {
                ViewHouseCommList = houseCommBean.getResultBean().getObject().getList();
            }

            manager2 = new LinearLayoutManager(this);
            //设置启用平滑滚动条
            manager2.setSmoothScrollbarEnabled(true);
            //设置自自动测量功能
            manager2.setAutoMeasureEnabled(true);
            viewHouseCommRv.setLayoutManager(manager2);
            viewHouseCommRv.setHasFixedSize(true);
            viewHouseCommRv.setNestedScrollingEnabled(false);
            ViewHouseCommAdapter commAdapter = new ViewHouseCommAdapter(HotFloorDetailsActivity.this, ViewHouseCommList,houseId);
            viewHouseCommRv.setAdapter(commAdapter);
        }

    }

    @Override
    public void showResourceHotFloor(HouseInfoBean hotData) {
        hotList = hotData.getResultBean().getObject().getList();
        managerHot = new LinearLayoutManager(this);
        //设置启用平滑滚动条
        managerHot.setSmoothScrollbarEnabled(true);
        //设置自自动测量功能
        managerHot.setAutoMeasureEnabled(true);
        hotRv.setLayoutManager(managerHot);
        //具有固定大小
        hotRv.setHasFixedSize(true);
        hotRv.setNestedScrollingEnabled(false);
        RecordOneHouseAdapter adapter = new RecordOneHouseAdapter(HotFloorDetailsActivity.this, hotList);
        hotRv.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (isaBoolean == false) {
            viewHouseCommPresenter.showViewHouseCommPresenter(houseId, pageNum, 5);
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
