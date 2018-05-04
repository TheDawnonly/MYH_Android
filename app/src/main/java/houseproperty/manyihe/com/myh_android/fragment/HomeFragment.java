package houseproperty.manyihe.com.myh_android.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.transform.Pivot;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;
import com.youth.banner.Banner;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import houseproperty.manyihe.com.myh_android.R;
import houseproperty.manyihe.com.myh_android.activity.HotFloorDetailsMoreActivity;
import houseproperty.manyihe.com.myh_android.activity.MainActivity;
import houseproperty.manyihe.com.myh_android.activity.TwoActivity;
import houseproperty.manyihe.com.myh_android.adapter.HotFloorAdapter;
import houseproperty.manyihe.com.myh_android.adapter.NewHouseFloorAdapter;
import houseproperty.manyihe.com.myh_android.adapter.SelectAgentAdapter;
import houseproperty.manyihe.com.myh_android.bean.HouseInfoBean;
import houseproperty.manyihe.com.myh_android.bean.HousingResourceBannerBean;
import houseproperty.manyihe.com.myh_android.bean.selectAgentBean;
import houseproperty.manyihe.com.myh_android.presenter.HomeBannerPresenter;
import houseproperty.manyihe.com.myh_android.presenter.HousingResourcePresenterTypeHot;
import houseproperty.manyihe.com.myh_android.presenter.HousingResourcePresenterTypeNew;
import houseproperty.manyihe.com.myh_android.presenter.SelectAgentPresenter;
import houseproperty.manyihe.com.myh_android.utils.BannerImageLoader;
import houseproperty.manyihe.com.myh_android.view.IHomeBannerView;
import houseproperty.manyihe.com.myh_android.view.IHousingResourceViewTypeHot;
import houseproperty.manyihe.com.myh_android.view.IHousingResourceViewTypeNew;
import houseproperty.manyihe.com.myh_android.view.ISelectAgentView;


/**
 * Created by Mr.周 on 2018/3/19.
 * , TextView.OnEditorActionListener
 */

public class HomeFragment extends BaseFragment<HousingResourcePresenterTypeHot> implements IHousingResourceViewTypeHot, IHomeBannerView, IHousingResourceViewTypeNew, ISelectAgentView {
    private static HomeFragment instance = new HomeFragment();
    private RecyclerView hotHouseRv, newHouseRv;
    private ImageView imageView;
    private LinearLayoutManager manager;
    private HotFloorAdapter hotAdapter;
    private TwinklingRefreshLayout refreshLayout;
    private Banner banner;
    private NewHouseFloorAdapter newHouseFloorAdapter;
    private DiscreteScrollView discreteScrollView;

    public static HomeFragment newInstance() {
        return instance;
    }

    private int pageNum = 1, pageSize = 3;
    private EditText editText;
    private List<HouseInfoBean.ResultBeanBean.ObjectBean.ListBean> hotList;
    private List<HouseInfoBean.ResultBeanBean.ObjectBean.ListBean> newHouseList;
    private List<HousingResourceBannerBean.ResultBeanBean.ObjectBean> bannerList;
    private List<selectAgentBean.ResultBeanBean.ObjectBean.ListBean> agentList;

    @Override
    public void showResourceHotFloor(HouseInfoBean housingResource) {
        hotList = housingResource.getResultBean().getObject().getList();
        manager = new LinearLayoutManager(getContext());
        //设置启用平滑滚动条
        manager.setSmoothScrollbarEnabled(true);
        //设置自自动测量功能
        manager.setAutoMeasureEnabled(true);
        hotHouseRv.setLayoutManager(manager);
        //具有固定大小
        hotHouseRv.setHasFixedSize(true);
        hotHouseRv.setNestedScrollingEnabled(false);
        hotAdapter = new HotFloorAdapter(getContext(), hotList);
        hotHouseRv.setAdapter(hotAdapter);
    }


    @Override
    public void getShowBanner(HousingResourceBannerBean housingResourceBannerBean) {
        bannerList = housingResourceBannerBean.getResultBean().getObject();
        List<String> imgList = new ArrayList<>();
        if (bannerList != null) {
            for (int i = 0; i < bannerList.size(); i++) {
                imgList.add(bannerList.get(i).getBannerImg());
            }
        }
        banner.setImageLoader(new BannerImageLoader());
        banner.setImages(imgList);
        banner.setBannerAnimation(Transformer.Default);
        banner.start();
    }

    @Override
    public void showResourceHotFloorTypeNew(HouseInfoBean hotData) {
        newHouseList = hotData.getResultBean().getObject().getList();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        //设置启用平滑滚动条
        layoutManager.setSmoothScrollbarEnabled(true);
        //设置自自动测量功能
        layoutManager.setAutoMeasureEnabled(true);
        newHouseRv.setLayoutManager(layoutManager);
        //具有固定大小
        newHouseRv.setHasFixedSize(true);
        newHouseRv.setNestedScrollingEnabled(false);
        newHouseFloorAdapter = new NewHouseFloorAdapter(getContext(), newHouseList);
        newHouseRv.setAdapter(newHouseFloorAdapter);
    }

    /**
     * @param agentBean 经纪人模块
     */
    @Override
    public void selectAgentShow(selectAgentBean agentBean) {
        agentList = agentBean.getResultBean().getObject().getList();
        //discreteScrollView.setOffscreenItems(10);
        discreteScrollView.setItemTransformer(new ScaleTransformer.Builder()
                .setMaxScale(1.2f)
                .setMinScale(0.7f)
                .setPivotX(Pivot.X.CENTER) // CENTER is a default one
                .setPivotY(Pivot.Y.BOTTOM) // CENTER is a default one
                .build());

        discreteScrollView.setAdapter(new SelectAgentAdapter(getContext(), agentList));
    }

    @Override
    public int intLayout() {
        return R.layout.homefragment;
    }

    @Override
    public View initView() {
        banner = view.findViewById(R.id.home_banner);
        editText = view.findViewById(R.id.oneF_Et);
        //banner = view.findViewById(R.id.fragment_one_banner);
        hotHouseRv = view.findViewById(R.id.hot_rv_hot);
        imageView = view.findViewById(R.id.one_home);
        //热门楼盘更多
        view.findViewById(R.id.home_btnMoreHot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HotFloorDetailsMoreActivity.class);
                startActivity(intent);
            }
        });
        //最新一手房更多哦
        view.findViewById(R.id.home_btnMoreNew).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(getContext(), NewHouseDetailsMoreActivity.class);
//                startActivity(intent);
            }
        });
        //最新一手房recyclerview
        newHouseRv = view.findViewById(R.id.new_house_recycle);

        //refreshLayout.setOverScrollHeight(0);
        //点击输入框跳转到TwoActivity页面
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mActivity, "点击了", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(getContext(), TwoActivity.class);
                startActivity(intent);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mActivity, "点击了", Toast.LENGTH_SHORT).show();
            }
        });
        //经纪人banner
        discreteScrollView = view.findViewById(R.id.home_dis);

        MainActivity.MyTouchListener myTouchListener = new MainActivity.MyTouchListener() {
            @Override
            public void onTouchEvent(MotionEvent event) {
                // 处理手势事件
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        break;
                    case MotionEvent.ACTION_MOVE:


                        break;
                    case MotionEvent.ACTION_UP:


                        break;
                }
            }
        };

        // 将myTouchListener注册到分发列表
        ((MainActivity) this.getActivity()).registerMyTouchListener(myTouchListener);
        return view;


    }

    @Override
    public void createPresenter() {
        presenter = new HousingResourcePresenterTypeHot(this);
        presenter.ShowData(pageNum, pageSize);
        HomeBannerPresenter homeBannerPresenter = new HomeBannerPresenter(this);
        homeBannerPresenter.showBanner();
        HousingResourcePresenterTypeNew housingResourcePresenterTypeNew = new HousingResourcePresenterTypeNew(this);
        housingResourcePresenterTypeNew.ShowData(pageNum, pageSize);
        SelectAgentPresenter selectAgentPresenter = new SelectAgentPresenter(this);
        selectAgentPresenter.showSelectAgent(pageNum, 5);
    }

    @Override
    public void onResume() {
        super.onResume();
        editText.setText("");
        banner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        banner.stopAutoPlay();
    }
}
