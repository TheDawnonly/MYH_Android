package houseproperty.manyihe.com.myh_android.fragment;

import android.content.Intent;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.sunfusheng.marqueeview.MarqueeView;
import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.transform.Pivot;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;
import com.youth.banner.Banner;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import houseproperty.manyihe.com.myh_android.R;
import houseproperty.manyihe.com.myh_android.activity.AgentMoreActivity;
import houseproperty.manyihe.com.myh_android.activity.HotFloorDetailsActivity;
import houseproperty.manyihe.com.myh_android.activity.HotFloorMoreActivity;
import houseproperty.manyihe.com.myh_android.activity.MainActivity;
import houseproperty.manyihe.com.myh_android.activity.NewHouseFloorDetailsActivity;
import houseproperty.manyihe.com.myh_android.activity.NewHouseMoreActivity;
import houseproperty.manyihe.com.myh_android.activity.TwoActivity;
import houseproperty.manyihe.com.myh_android.adapter.HotFloorAdapter;
import houseproperty.manyihe.com.myh_android.adapter.NewHouseFloorAdapter;
import houseproperty.manyihe.com.myh_android.adapter.SelectAgentAdapter;
import houseproperty.manyihe.com.myh_android.bean.HomeHotActivityBean;
import houseproperty.manyihe.com.myh_android.bean.HouseInfoBean;
import houseproperty.manyihe.com.myh_android.bean.HousingResourceBannerBean;
import houseproperty.manyihe.com.myh_android.bean.selectAgentBean;
import houseproperty.manyihe.com.myh_android.presenter.HomeBannerPresenter;
import houseproperty.manyihe.com.myh_android.presenter.HomeHotActivityPresenter;
import houseproperty.manyihe.com.myh_android.presenter.HousingResourcePresenterTypeHot;
import houseproperty.manyihe.com.myh_android.presenter.HousingResourcePresenterTypeNew;
import houseproperty.manyihe.com.myh_android.presenter.SelectAgentPresenter;
import houseproperty.manyihe.com.myh_android.utils.BannerImageLoader;
import houseproperty.manyihe.com.myh_android.utils.NetWorkUtils;
import houseproperty.manyihe.com.myh_android.utils.ToastUtil;
import houseproperty.manyihe.com.myh_android.view.IHomeBannerView;
import houseproperty.manyihe.com.myh_android.view.IHomeHotActivityView;
import houseproperty.manyihe.com.myh_android.view.IHousingResourceViewTypeHot;
import houseproperty.manyihe.com.myh_android.view.IHousingResourceViewTypeNew;
import houseproperty.manyihe.com.myh_android.view.ISelectAgentView;


/**
 * Created by Mr.周 on 2018/3/19.
 * , TextView.OnEditorActionListener
 */

public class HomeFragment extends BaseFragment<HousingResourcePresenterTypeHot> implements IHousingResourceViewTypeHot, IHousingResourceViewTypeNew, ISelectAgentView, IHomeBannerView, IHomeHotActivityView {
    private static HomeFragment instance = new HomeFragment();

    @Override
    public void onResume() {
        super.onResume();
        editText.setText("");
        banner.startAutoPlay();
        networkAvailable = NetWorkUtils.isNetworkAvailable(getContext());
        if (networkAvailable && isNet == false) {
            presenter = new HousingResourcePresenterTypeHot(this);
            presenter.ShowData(pageNum, pageSize);
            HousingResourcePresenterTypeNew housingResourcePresenterTypeNew = new HousingResourcePresenterTypeNew(this);
            housingResourcePresenterTypeNew.ShowData(pageNum, pageSize);
            SelectAgentPresenter selectAgentPresenter = new SelectAgentPresenter(this);
            selectAgentPresenter.showSelectAgent(pageNum, 5);

            HomeBannerPresenter bannerPresenter = new HomeBannerPresenter(this);
            bannerPresenter.showBanner();

            //和门活动
            HomeHotActivityPresenter homeHotActivityPresenter = new HomeHotActivityPresenter(this);
            homeHotActivityPresenter.showActivityPresenter();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        banner.stopAutoPlay();
    }

    public static HomeFragment newInstance() {
        return instance;
    }

    private RecyclerView hotHouseRv, newHouseRv;
    private ImageView imageView, hotActivity1, hotActivity2;
    private LinearLayoutManager manager;
    private HotFloorAdapter hotAdapter;
    private TwinklingRefreshLayout refreshLayout;
    private Banner banner;
    private NewHouseFloorAdapter newHouseFloorAdapter;
    private DiscreteScrollView discreteScrollView;
    private MarqueeView marqueeView;


    private int pageNum = 1, pageSize = 3;
    private EditText editText;
    private List<HouseInfoBean.ResultBeanBean.ObjectBean.ListBean> hotList;
    private List<HouseInfoBean.ResultBeanBean.ObjectBean.ListBean> newHouseList;
    private List<HousingResourceBannerBean.ResultBeanBean.ObjectBean> bannerList;
    private List<selectAgentBean.ResultBeanBean.ObjectBean.ListBean> agentList;
    private NestedScrollView mScrollView;
    private boolean isNet = true;
    private boolean networkAvailable;

    @Override
    public void showResourceHotFloor(HouseInfoBean housingResource) {
        if (housingResource.getResultBean().getObject() != null) {
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

    }

    /**
     * @param hotData 最新一手房
     */

    @Override

    public void showResourceHotFloorTypeNew(HouseInfoBean hotData) {
        if (hotData.getResultBean().getObject() != null) {
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

    }

    /**
     * @param agentBean 经纪人模块
     */
    @Override
    public void selectAgentShow(selectAgentBean agentBean) {
        if (agentBean.getResultBean().getObject() != null) {
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

    }

    /**
     * 首页banner
     *
     * @param housingResourceBannerBean
     */
    @Override
    public void getShowBanner(final HousingResourceBannerBean housingResourceBannerBean) {
        List<HousingResourceBannerBean.ResultBeanBean.ObjectBean> bannerList = housingResourceBannerBean.getResultBean().getObject();
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
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                int id = housingResourceBannerBean.getResultBean().getObject().get(position).getId();
                int type = housingResourceBannerBean.getResultBean().getObject().get(position).getType();
                if (type == 0) {
                    Intent intent = new Intent(getContext(), HotFloorDetailsActivity.class);
                    intent.putExtra("houseId", id);
                    startActivity(intent);
                } else if (type == 1) {
                    Intent intent = new Intent(getContext(), NewHouseFloorDetailsActivity.class);
                    intent.putExtra("houseId", id);
                    startActivity(intent);
                }
            }
        });
    }

    /**
     * 首页活动
     *
     * @param activityBean
     */
    @Override
    public void showActivityView(HomeHotActivityBean activityBean) {
        String imgUrl1 = activityBean.getResultBean().getObject().get(0).getImgUrl();
        String imgUrl2 = activityBean.getResultBean().getObject().get(0).getImgUrl();
        Glide.with(getContext()).load(imgUrl1).into(hotActivity1);
        Glide.with(getContext()).load(imgUrl2).into(hotActivity2);
    }

    @Override
    public int intLayout() {
        return R.layout.homefragment;
    }

    @Override
    public View initView() {
        banner = view.findViewById(R.id.home_banner);
        editText = view.findViewById(R.id.home_Et);
        //editText.bringToFront();
        hotHouseRv = view.findViewById(R.id.hot_rv_hot);
        //imageView = view.findViewById(R.id.one_home);
        //热门楼盘更多
        view.findViewById(R.id.home_btnMoreHot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HotFloorMoreActivity.class);
                startActivity(intent);
            }
        });
        //最新一手房更多哦
        view.findViewById(R.id.home_btnMoreNew).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), NewHouseMoreActivity.class);
                startActivity(intent);
            }
        });
        //最新一手房recyclerview
        newHouseRv = view.findViewById(R.id.new_house_recycle);

        //refreshLayout.setOverScrollHeight(0);
        //点击输入框跳转到TwoActivity页面
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getContext(), TwoActivity.class);
                startActivity(intent);
            }
        });
        //经纪人banner
        discreteScrollView = view.findViewById(R.id.home_dis);
        //经纪人更多
        view.findViewById(R.id.agent_more).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), AgentMoreActivity.class));
            }
        });
        mScrollView = view.findViewById(R.id.scrollView);
        view.findViewById(R.id.new_house).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), NewHouseMoreActivity.class));
            }
        });
        //广告轮播
        //marqueeView = view.findViewById(R.id.marqueeView);
//        final List<String> info = new ArrayList<>();
//        info.add(" 大家好，");
//        info.add(" 欢迎大家！");
//        info.add(" manyihe");
//        info.add("满易何 ");
//        info.add(" 新房");
//        info.add(" 欢迎选购");
        //marqueeView.startWithList(info);
        // LimitScrollerView limitScroll = view.findViewById(R.id.limitScroll);
//        myLimitScrollAdapter = new MyLimitScrollAdapter();
//        myLimitScrollAdapter.setDatas(info, limitScroll, getContext());
//        limitScroll.setDataAdapter(myLimitScrollAdapter);
//        limitScroll.startScroll();
//        limitScroll.setOnItemClickListener(new LimitScrollerView.OnItemClickListener() {
//            @Override
//            public void onItemClick(Object obj) {
//                Toast.makeText(mActivity, "" + obj, Toast.LENGTH_SHORT).show();
//            }
//        });
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
        hotActivity1 = view.findViewById(R.id.home_hotActivity1);
        hotActivity2 = view.findViewById(R.id.home_hotActivity2);
        return view;


    }


    @Override
    public void createPresenter() {
        networkAvailable = NetWorkUtils.isNetworkAvailable(getContext());
        if (networkAvailable) {
            presenter = new HousingResourcePresenterTypeHot(this);
            presenter.ShowData(pageNum, pageSize);
            HousingResourcePresenterTypeNew housingResourcePresenterTypeNew = new HousingResourcePresenterTypeNew(this);
            housingResourcePresenterTypeNew.ShowData(pageNum, pageSize);
            SelectAgentPresenter selectAgentPresenter = new SelectAgentPresenter(this);
            selectAgentPresenter.showSelectAgent(pageNum, 5);

            HomeBannerPresenter bannerPresenter = new HomeBannerPresenter(this);
            bannerPresenter.showBanner();

            //和门活动
            HomeHotActivityPresenter homeHotActivityPresenter = new HomeHotActivityPresenter(this);
            homeHotActivityPresenter.showActivityPresenter();
        } else {
            isNet = false;
            ToastUtil.getToast(getContext(), "网络异常");
        }

    }
}
