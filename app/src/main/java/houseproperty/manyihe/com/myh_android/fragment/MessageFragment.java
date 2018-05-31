package houseproperty.manyihe.com.myh_android.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.footer.LoadingView;
import com.lcodecore.tkrefreshlayout.header.SinaRefreshView;
import com.lcodecore.tkrefreshlayout.header.bezierlayout.BezierLayout;
import com.sdsmdg.tastytoast.TastyToast;

import java.util.List;

import houseproperty.manyihe.com.myh_android.R;
import houseproperty.manyihe.com.myh_android.activity.HotFloorMoreActivity;
import houseproperty.manyihe.com.myh_android.adapter.messageAdapter;
import houseproperty.manyihe.com.myh_android.bean.HouseInfoBean;
import houseproperty.manyihe.com.myh_android.bean.MessageBean;
import houseproperty.manyihe.com.myh_android.presenter.MessagePresenter;
import houseproperty.manyihe.com.myh_android.utils.NetWorkUtils;
import houseproperty.manyihe.com.myh_android.utils.ToastUtil;
import houseproperty.manyihe.com.myh_android.view.IMessageView;

/**
 * Created by Mr.周 on 2018/3/19.
 */

public class MessageFragment extends BaseFragment<MessagePresenter> implements IMessageView {
    private static MessageFragment instance = new MessageFragment();
    private RecyclerView recyclerView;
    public List<MessageBean.ResultBeanBean.ObjectBean.ListBean> dataList;
    public List<MessageBean.ResultBeanBean.ObjectBean.ListBean> dataListNew;
    private LinearLayoutManager manager;
    private int pageNum = 1, pageSize = 10;
    private TwinklingRefreshLayout refreshLayout;
    private messageAdapter adapter;
    private boolean aBoolean = false;

    public static MessageFragment newInstance() {
        return instance;
    }

    @Override
    public void showData(final MessageBean messageBean) {
        List<MessageBean.ResultBeanBean.ObjectBean.ListBean> list = messageBean.getResultBean().getObject().getList();
        if (aBoolean == true) {
            dataList.addAll(list);
            adapter.notifyDataSetChanged();
        } else {
            dataList = messageBean.getResultBean().getObject().getList();
        }
        adapter = new messageAdapter(getContext(), dataList);
        manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        LoadingView loadingView = new LoadingView(getContext());
        refreshLayout.setBottomView(loadingView);
        SinaRefreshView headerView = new SinaRefreshView(getContext());
        refreshLayout.setHeaderView(headerView);
        refreshLayout.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(final TwinklingRefreshLayout refreshLayout) {
                if (pageNum < messageBean.getResultBean().getObject().getLastPage()) {
                    pageNum++;
                    presenter.ShowData(pageNum, pageSize);
                    if (messageBean.getResultBean().getCode().equals("0")) {
                        refreshLayout.finishRefreshing();
                    }

                } else {
                    ToastUtil.getToast(getContext(), "已是最新楼讯");
                    refreshLayout.finishRefreshing();
                }

            }

            @Override
            public void onLoadMore(final TwinklingRefreshLayout refreshLayout) {
                aBoolean = true;
                if (pageNum < messageBean.getResultBean().getObject().getLastPage()) {
                    pageNum++;
                    presenter.ShowData(pageNum, pageSize);
                    if (messageBean.getResultBean().getCode().equals("0")) {
                        //隐藏加载动画
                        refreshLayout.finishLoadmore();
                    }
                } else {
                    ToastUtil.getToast(getContext(), "已加载完");
                    refreshLayout.finishLoadmore();
                }
            }
        });

    }

    @Override
    public int intLayout() {
        return R.layout.message_fragment;
    }

    @Override
    public View initView() {
        recyclerView = view.findViewById(R.id.message_rv);
        refreshLayout = view.findViewById(R.id.message_twink);
        recyclerView.setNestedScrollingEnabled(false);
        return view;
    }

    @Override
    public void createPresenter() {
        presenter = new MessagePresenter(this);
        presenter.ShowData(pageNum, pageSize);
    }
}
