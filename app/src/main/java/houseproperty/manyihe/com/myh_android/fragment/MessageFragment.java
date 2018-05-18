package houseproperty.manyihe.com.myh_android.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

import java.util.List;

import houseproperty.manyihe.com.myh_android.R;
import houseproperty.manyihe.com.myh_android.adapter.messageAdapter;
import houseproperty.manyihe.com.myh_android.bean.MessageBean;
import houseproperty.manyihe.com.myh_android.presenter.MessagePresenter;
import houseproperty.manyihe.com.myh_android.utils.NetWorkUtils;
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
    public int newPageNum = 1;
    private TwinklingRefreshLayout refreshLayout;
    private int pages;
    private messageAdapter adapter;

    public static MessageFragment newInstance() {
        return instance;
    }

    @Override
    public void showData(MessageBean messageBean) {
        newPageNum = messageBean.getResultBean().getObject().getPageNum();
        pages = messageBean.getResultBean().getObject().getPages();
        dataList = messageBean.getResultBean().getObject().getList();
        if (pageNum > newPageNum) {
            dataListNew = messageBean.getResultBean().getObject().getList();
            dataList = dataListNew;
        }
        adapter = new messageAdapter(getContext(), dataList);
        manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void failMsg(String msg) {

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
        refreshLayout.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(TwinklingRefreshLayout refreshLayout) {
                super.onRefresh(refreshLayout);
                if (NetWorkUtils.isNetworkAvailable(getContext())) {
                    if (pageNum == pages) {
                        Toast.makeText(getContext(), "已是最新数据", Toast.LENGTH_SHORT).show();
                        refreshLayout.finishRefreshing();
                    } else if (dataList != null) {
                        pageNum++;
                        dataList.addAll(0, dataListNew);
                        refreshLayout.finishRefreshing();
                    } else {
                        refreshLayout.finishRefreshing();
                        return;
                    }
                } else {
                    Toast.makeText(getContext(), "网络异常", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onLoadMore(TwinklingRefreshLayout refreshLayout) {
                super.onLoadMore(refreshLayout);

                refreshLayout.finishLoadmore();
            }
        });

        return view;
    }

    @Override
    public void createPresenter() {
        presenter = new MessagePresenter(this);
        presenter.ShowData(pageNum, pageSize);
    }
}
