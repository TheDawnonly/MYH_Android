package houseproperty.manyihe.com.myh_android.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.sunfusheng.marqueeview.MarqueeView;
import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.transform.Pivot;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import houseproperty.manyihe.com.myh_android.R;
import houseproperty.manyihe.com.myh_android.activity.HotFloorDetailsMoreActivity;
import houseproperty.manyihe.com.myh_android.activity.MainActivity;
import houseproperty.manyihe.com.myh_android.activity.NewHouseMoreActivity;
import houseproperty.manyihe.com.myh_android.activity.TwoActivity;
import houseproperty.manyihe.com.myh_android.adapter.HotFloorAdapter;
import houseproperty.manyihe.com.myh_android.adapter.MyLimitScrollAdapter;
import houseproperty.manyihe.com.myh_android.adapter.NewHouseFloorAdapter;
import houseproperty.manyihe.com.myh_android.adapter.SelectAgentAdapter;
import houseproperty.manyihe.com.myh_android.bean.HouseInfoBean;
import houseproperty.manyihe.com.myh_android.bean.HousingResourceBannerBean;
import houseproperty.manyihe.com.myh_android.bean.selectAgentBean;
import houseproperty.manyihe.com.myh_android.presenter.HomeBannerPresenter;
import houseproperty.manyihe.com.myh_android.presenter.HousingResourcePresenterTypeHot;
import houseproperty.manyihe.com.myh_android.presenter.HousingResourcePresenterTypeNew;
import houseproperty.manyihe.com.myh_android.presenter.SelectAgentPresenter;
import houseproperty.manyihe.com.myh_android.utils.LimitScrollerView;
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

    @Override
    public void onResume() {
        super.onResume();
        //editText.setText("");
        //banner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        //banner.stopAutoPlay();
    }

    public static HomeFragment newInstance() {
        return instance;
    }

    private RecyclerView hotHouseRv, newHouseRv;
    private ImageView imageView;
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
    private TextView tvSearch;
    private LinearLayout mSearchLayout;
    private NestedScrollView mScrollView;
    private boolean isExpand = false;
    private ImageView ivImg;
    private Toolbar toolbar;
    private TransitionSet mSet;
    private MyLimitScrollAdapter myLimitScrollAdapter;

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
//        banner.setImageLoader(new BannerImageLoader());
//        banner.setImages(imgList);
//        banner.setBannerAnimation(Transformer.Default);
//        banner.start();
    }

    /**
     * @param hotData 最新一手房
     */

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
//        banner = view.findViewById(R.id.home_banner);
//        editText = view.findViewById(R.id.oneF_Et);
        //editText.bringToFront();
        //banner = view.findViewById(R.id.fragment_one_banner);
        hotHouseRv = view.findViewById(R.id.hot_rv_hot);
        //imageView = view.findViewById(R.id.one_home);
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
                Intent intent = new Intent(getContext(), NewHouseMoreActivity.class);
                startActivity(intent);
            }
        });
        //最新一手房recyclerview
        newHouseRv = view.findViewById(R.id.new_house_recycle);

        //refreshLayout.setOverScrollHeight(0);
        //点击输入框跳转到TwoActivity页面
//        editText.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(mActivity, "点击了", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent();
//                intent.setClass(getContext(), TwoActivity.class);
//                startActivity(intent);
//            }
//        });
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(mActivity, "点击了", Toast.LENGTH_SHORT).show();
//            }
//        });
        //经纪人banner
        discreteScrollView = view.findViewById(R.id.home_dis);
        //经纪人更多
        view.findViewById(R.id.agent_more).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mActivity, "更多", Toast.LENGTH_SHORT).show();
            }
        });

        //搜索框动画
        tvSearch = view.findViewById(R.id.tv_search);
        //点击搜索框跳转
        tvSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), TwoActivity.class);
                startActivity(intent);
            }
        });
        mSearchLayout = view.findViewById(R.id.ll_search);
        mScrollView = view.findViewById(R.id.scrollView);
        ivImg = view.findViewById(R.id.iv_img);
        toolbar = view.findViewById(R.id.toolbar);
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), TwoActivity.class);
                startActivity(intent);
            }
        });
        //搜索框动画
        getEditTextAnimation();
        //广告轮播
        //marqueeView = view.findViewById(R.id.marqueeView);
        final List<String> info = new ArrayList<>();
        info.add(" 大家好，");
        info.add(" 欢迎大家！");
        info.add(" manyihe");
        info.add("满易何 ");
        info.add(" 新房");
        info.add(" 欢迎选购");
        //marqueeView.startWithList(info);
        LimitScrollerView limitScroll = view.findViewById(R.id.limitScroll);
        myLimitScrollAdapter = new MyLimitScrollAdapter();
        myLimitScrollAdapter.setDatas(info, limitScroll, getContext());
        limitScroll.setDataAdapter(myLimitScrollAdapter);
        limitScroll.startScroll();
        limitScroll.setOnItemClickListener(new LimitScrollerView.OnItemClickListener() {
            @Override
            public void onItemClick(Object obj) {
                Toast.makeText(mActivity, "" + obj, Toast.LENGTH_SHORT).show();
            }
        });
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

    private void getEditTextAnimation() {
        //设置toolbar初始透明度为0
        toolbar.getBackground().mutate().setAlpha(0);
        //scrollview滚动状态监听
        mScrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                //改变toolbar的透明度
                changeToolbarAlpha();
                //滚动距离>=大图高度-toolbar高度 即toolbar完全盖住大图的时候 且不是伸展状态 进行伸展操作
                if (mScrollView.getScrollY() >= ivImg.getHeight() - toolbar.getHeight() && !isExpand) {
                    expand();
                    isExpand = true;
                }
                //滚动距离<=0时 即滚动到顶部时  且当前伸展状态 进行收缩操作
                else if (mScrollView.getScrollY() <= 0 && isExpand) {
                    reduce();
                    isExpand = false;
                }
            }
        });
    }

    private void changeToolbarAlpha() {
        int scrollY = mScrollView.getScrollY();
        //快速下拉会引起瞬间scrollY<0
        if (scrollY < 0) {
            toolbar.getBackground().mutate().setAlpha(0);
            return;
        }
        //计算当前透明度比率
        float radio = Math.min(1, scrollY / (ivImg.getHeight() - toolbar.getHeight() * 1f));
        //设置透明度
        toolbar.getBackground().mutate().setAlpha((int) (radio * 0xFF));
    }


    private void expand() {
        //设置伸展状态时的布局
        tvSearch.setText("你想住在哪？");
        RelativeLayout.LayoutParams LayoutParams = (RelativeLayout.LayoutParams) mSearchLayout.getLayoutParams();
        LayoutParams.width = LayoutParams.MATCH_PARENT;
        LayoutParams.setMargins(dip2px(10), dip2px(10), dip2px(10), dip2px(10));
        mSearchLayout.setLayoutParams(LayoutParams);
        //开始动画
        beginDelayedTransition(mSearchLayout);
    }

    private void reduce() {
        //设置收缩状态时的布局
        tvSearch.setText("你想住在哪？");
        RelativeLayout.LayoutParams LayoutParams = (RelativeLayout.LayoutParams) mSearchLayout.getLayoutParams();
        LayoutParams.width = dip2px(500);
        LayoutParams.setMargins(dip2px(10), dip2px(10), dip2px(10), dip2px(10));
        mSearchLayout.setLayoutParams(LayoutParams);
        //开始动画
        beginDelayedTransition(mSearchLayout);
    }

    @SuppressLint("NewApi")
    void beginDelayedTransition(ViewGroup view) {
        mSet = new AutoTransition();
        mSet.setDuration(300);
        TransitionManager.beginDelayedTransition(view, mSet);
    }

    private int dip2px(float dpVale) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dpVale * scale + 0.5f);
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
}
