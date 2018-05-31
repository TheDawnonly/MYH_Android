package houseproperty.manyihe.com.myh_android.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.transform.Pivot;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;
import com.youth.banner.Banner;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import houseproperty.manyihe.com.myh_android.R;
import houseproperty.manyihe.com.myh_android.adapter.AgentByHouseAdapter;
import houseproperty.manyihe.com.myh_android.adapter.HotFloorDetailsActivityAdapter;
import houseproperty.manyihe.com.myh_android.adapter.HotFloorDetailsActivityAdapter_LayInfo;
import houseproperty.manyihe.com.myh_android.adapter.NewFloorDetailsActivityAdapter;
import houseproperty.manyihe.com.myh_android.adapter.NewHouseFloorAdapter;
import houseproperty.manyihe.com.myh_android.adapter.ViewHouseCommAdapter;
import houseproperty.manyihe.com.myh_android.bean.AgentByHouse;
import houseproperty.manyihe.com.myh_android.bean.HouseInfoBean;
import houseproperty.manyihe.com.myh_android.bean.LayInfoBean;
import houseproperty.manyihe.com.myh_android.bean.ViewHouseCommBean;
import houseproperty.manyihe.com.myh_android.presenter.AgentByHousePresenter;
import houseproperty.manyihe.com.myh_android.presenter.HousingResourcePresenterTypeNew;
import houseproperty.manyihe.com.myh_android.presenter.NewFloorDetailsPresenter;
import houseproperty.manyihe.com.myh_android.presenter.ViewHouseCommPresenter;
import houseproperty.manyihe.com.myh_android.utils.BannerImageLoader;
import houseproperty.manyihe.com.myh_android.utils.HotFloorDetailsBannerImageLoader;
import houseproperty.manyihe.com.myh_android.utils.ToastUtil;
import houseproperty.manyihe.com.myh_android.view.IAgentByHouseView;
import houseproperty.manyihe.com.myh_android.view.IHousingResourceViewTypeNew;
import houseproperty.manyihe.com.myh_android.view.INewFloorDetailsView;
import houseproperty.manyihe.com.myh_android.view.IViewHouseCommView;

public class NewHouseFloorDetailsActivity extends BaseActivity<NewFloorDetailsPresenter> implements INewFloorDetailsView, IAgentByHouseView, IViewHouseCommView, IHousingResourceViewTypeNew {

    private int houseId, userId;
    private TextView textView;
    private List<HouseInfoBean.ResultBeanBean.ObjectBean.ListBean> newDetails;
    private Banner banner;
    private RecyclerView recyclerView;
    private String[] split;
    private LinearLayoutManager manager, manager2;
    private NewFloorDetailsActivityAdapter adapter;
    private List<AgentByHouse.ResultBeanBean.ObjectBean.ListBean> agentList;
    private List<ViewHouseCommBean.ResultBeanBean.ObjectBean.ListBean> ViewHouseCommList;
    private SharedPreferences sp;
    private DiscreteScrollView dis;
    private RecyclerView houseCommRv;
    private RecyclerView newProposalRv;
    private Button moreCommBtn;
    private int pageNum=1;
    private ViewHouseCommPresenter viewHouseCommPresenter;
    private boolean aBoolean = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN); //显示状态栏
        setContentView(R.layout.activity_new_floor_details);
        MainActivity.MIUISetStatusBarLightMode(this, true);
        MainActivity.FlymeSetStatusBarLightMode(getWindow(), true);
        initView();
    }

    private void initView() {
        banner = findViewById(R.id.new_floor_details_banner);
        recyclerView = findViewById(R.id.new_floor_details_rv);
        dis = findViewById(R.id.new_floor_floor_detail_dis);
        houseCommRv = findViewById(R.id.new_ViewHouseComm);
        newProposalRv = findViewById(R.id.new_floor_details_newRv);
        findViewById(R.id.new_floor_details_newMoreBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewHouseFloorDetailsActivity.this, NewHouseMoreActivity.class);
                startActivity(intent);
            }
        });
        ImageView back = findViewById(R.id.new_floor_details_back);
        back.bringToFront();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        findViewById(R.id.activity_newHouseMoreBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NewHouseFloorDetailsActivity.this, AgentMoreActivity.class));
            }
        });
        findViewById(R.id.new_floor_details_PhoneBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                Uri data = Uri.parse("tel:" + "400-068-1359");
                intent.setData(data);
                startActivity(intent);
            }
        });
        moreCommBtn = findViewById(R.id.new_floor_details_moreComm);
    }

    @Override
    public void createPresenter() {
        houseId = getIntent().getIntExtra("houseId", 0);
        sp = getSharedPreferences("config", MODE_PRIVATE);
        userId = sp.getInt("id", 0);
        presenter = new NewFloorDetailsPresenter(this);
        presenter.showNewFloorDetails(houseId, userId);
        AgentByHousePresenter agentByHousePresenter = new AgentByHousePresenter(this);
        agentByHousePresenter.showAgentByHousePresenter(houseId, "3", 1, 5);

        viewHouseCommPresenter = new ViewHouseCommPresenter(this);
        viewHouseCommPresenter.showViewHouseCommPresenter(houseId, 1, 5);

        HousingResourcePresenterTypeNew housingResourcePresenterTypeNew = new HousingResourcePresenterTypeNew(this);
        housingResourcePresenterTypeNew.ShowData(1, 3);
    }

    @Override
    public void getNewFloorShow(HouseInfoBean houseInfoBean) {
        if (houseInfoBean.getResultBean().getObject() != null) {
            newDetails = houseInfoBean.getResultBean().getObject().getList();
            getBannerData();
            manager = new LinearLayoutManager(this);
            //设置启用平滑滚动条
            manager.setSmoothScrollbarEnabled(true);
            //设置自自动测量功能
            manager.setAutoMeasureEnabled(true);
            recyclerView.setLayoutManager(manager);
            //具有固定大小
            recyclerView.setHasFixedSize(true);
            recyclerView.setNestedScrollingEnabled(false);
            adapter = new NewFloorDetailsActivityAdapter(this, newDetails);
            recyclerView.setAdapter(adapter);
        }

    }

    /**
     * 获取banner数据
     */
    private void getBannerData() {
        final List<String> imgList = new ArrayList<>();
        for (int i = 0; i < newDetails.size(); i++) {
            split = newDetails.get(i).getImgId().split(",");
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

    }

    @Override
    public void showAgentByHouseView(AgentByHouse agentByHouse) {
        agentList = agentByHouse.getResultBean().getObject().getList();
        //discreteScrollView.setOffscreenItems(10);
        dis.setItemTransformer(new ScaleTransformer.Builder()
                .setMaxScale(1.2f)
                .setMinScale(0.7f)
                .setPivotX(Pivot.X.CENTER) // CENTER is a default one
                .setPivotY(Pivot.Y.BOTTOM) // CENTER is a default one
                .build());

        dis.setAdapter(new AgentByHouseAdapter(NewHouseFloorDetailsActivity.this, agentList));
    }

    /**
     * 用户评论
     *
     * @param houseCommBean
     */
    @Override
    public void showViewHouseComm(final ViewHouseCommBean houseCommBean) {
        if (houseCommBean.getResultBean().getObject() != null) {
            moreCommBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (pageNum < houseCommBean.getResultBean().getObject().getLastPage()) {
                        pageNum++;
                        viewHouseCommPresenter.showViewHouseCommPresenter(houseId, pageNum, 5);
                        List<ViewHouseCommBean.ResultBeanBean.ObjectBean.ListBean> list = houseCommBean.getResultBean().getObject().getList();
                        ViewHouseCommList.addAll(list);
                        aBoolean = false;
                    } else {
                        ToastUtil.getToast(NewHouseFloorDetailsActivity.this, "已加载全部");
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
            houseCommRv.setLayoutManager(manager2);
            houseCommRv.setHasFixedSize(true);
            houseCommRv.setNestedScrollingEnabled(false);
            ViewHouseCommAdapter commAdapter = new ViewHouseCommAdapter(NewHouseFloorDetailsActivity.this, ViewHouseCommList,houseId);
            houseCommRv.setAdapter(commAdapter);
        }
    }

    /**
     * 推荐一手房
     *
     * @param hotData
     */
    public void showResourceHotFloorTypeNew(HouseInfoBean hotData) {
        newDetails = hotData.getResultBean().getObject().getList();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //设置启用平滑滚动条
        layoutManager.setSmoothScrollbarEnabled(true);
        //设置自自动测量功能
        layoutManager.setAutoMeasureEnabled(true);
        newProposalRv.setLayoutManager(layoutManager);
        //具有固定大小
        newProposalRv.setHasFixedSize(true);
        newProposalRv.setNestedScrollingEnabled(false);
        NewHouseFloorAdapter newHouseFloorAdapter = new NewHouseFloorAdapter(this, newDetails);
        newProposalRv.setAdapter(newHouseFloorAdapter);
    }

    /**
     * 户型图
     */
//    @Override
//    public void getShowLayInfo(LayInfoBean infoBean) {
//        layList = infoBean.getResultBean().getObject();
//        manager2 = new LinearLayoutManager(this);
//        //设置启用平滑滚动条
//        manager2.setSmoothScrollbarEnabled(true);
//        //设置自自动测量功能
//        manager2.setAutoMeasureEnabled(true);
//        recyclerView2.setLayoutManager(manager2);
//        recyclerView2.setHasFixedSize(true);
//        recyclerView2.setNestedScrollingEnabled(false);
//        adapter2 = new HotFloorDetailsActivityAdapter_LayInfo(this, layList);
//        recyclerView2.setAdapter(adapter2);
//    }
    @Override
    protected void onResume() {
        super.onResume();
        banner.startAutoPlay();
    }

    @Override
    protected void onStop() {
        super.onStop();
        banner.stopAutoPlay();
    }
}
