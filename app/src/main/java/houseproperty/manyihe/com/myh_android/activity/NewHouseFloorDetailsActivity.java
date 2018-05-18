package houseproperty.manyihe.com.myh_android.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import houseproperty.manyihe.com.myh_android.R;
import houseproperty.manyihe.com.myh_android.adapter.HotFloorDetailsActivityAdapter;
import houseproperty.manyihe.com.myh_android.adapter.HotFloorDetailsActivityAdapter_LayInfo;
import houseproperty.manyihe.com.myh_android.adapter.NewFloorDetailsActivityAdapter;
import houseproperty.manyihe.com.myh_android.bean.HouseInfoBean;
import houseproperty.manyihe.com.myh_android.bean.LayInfoBean;
import houseproperty.manyihe.com.myh_android.presenter.NewFloorDetailsPresenter;
import houseproperty.manyihe.com.myh_android.utils.HotFloorDetailsBannerImageLoader;
import houseproperty.manyihe.com.myh_android.view.INewFloorDetailsView;

public class NewHouseFloorDetailsActivity extends BaseActivity<NewFloorDetailsPresenter> implements INewFloorDetailsView {

    private int houseId,userId;
    private TextView textView;
    private List<HouseInfoBean.ResultBeanBean.ObjectBean.ListBean> newDetails;
    private Banner banner;
    private RecyclerView recyclerView;
    private String[] split;
    private LinearLayoutManager manager, manager2;
    private NewFloorDetailsActivityAdapter adapter;
    private List<LayInfoBean.ResultBeanBean.ObjectBean> layList;
    private SharedPreferences sp;

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
        ImageView back = findViewById(R.id.new_floor_details_back);
        back.bringToFront();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void createPresenter() {
        houseId = getIntent().getIntExtra("houseId", 0);
        sp = getSharedPreferences("config", MODE_PRIVATE);
        userId = sp.getInt("id", 0);
        presenter = new NewFloorDetailsPresenter(this);
        presenter.showNewFloorDetails(houseId,userId);
    }

    @Override
    public void getNewFloorShow(HouseInfoBean houseInfoBean) {
        if (houseInfoBean.getResultBean().getObject()!=null){
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
        List<String> imgList = new ArrayList<>();
        for (int i = 0; i < newDetails.size(); i++) {
            split = newDetails.get(i).getImgId().split(",");
        }
        for (int j = 0; j < split.length; j++) {
            imgList.add(split[j]);
        }
        banner.setImageLoader(new HotFloorDetailsBannerImageLoader());
        banner.setImages(imgList);
        banner.start();
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Toast.makeText(NewHouseFloorDetailsActivity.this, "点击了" + position, Toast.LENGTH_SHORT).show();
            }
        });
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
