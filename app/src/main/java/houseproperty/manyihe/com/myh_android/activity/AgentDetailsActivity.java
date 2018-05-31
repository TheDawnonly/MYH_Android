package houseproperty.manyihe.com.myh_android.activity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import houseproperty.manyihe.com.myh_android.R;
import houseproperty.manyihe.com.myh_android.adapter.AgentDetailsActivityAdapter;
import houseproperty.manyihe.com.myh_android.adapter.RecordOneHouseAdapter0;
import houseproperty.manyihe.com.myh_android.bean.AgentCommBean;
import houseproperty.manyihe.com.myh_android.bean.AgentDetailBean;
import houseproperty.manyihe.com.myh_android.presenter.AgentCommPresenter;
import houseproperty.manyihe.com.myh_android.presenter.AgentDetailPresenter;
import houseproperty.manyihe.com.myh_android.view.IAgentCommView;
import houseproperty.manyihe.com.myh_android.view.IAgentDetailView;

public class AgentDetailsActivity extends BaseActivity<AgentDetailPresenter> implements IAgentDetailView, IAgentCommView {

    private SimpleDraweeView agentDetailSdv;
    private TextView agentDetailNameTv, agentDetailAddressTv, agentDetailProjectTv, agentDetailDealCountTv, agentDetailWatchTimes, agentDetailScore;
    private RecyclerView agentDetailRv;
    private LinearLayoutManager manager;
    private List<AgentCommBean.ResultBeanBean.ObjectBean.ListBean> commList;
    private String agentMobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agent_details);
        MainActivity.MIUISetStatusBarLightMode(this, true);
        MainActivity.FlymeSetStatusBarLightMode(getWindow(), true);

        initView();
    }

    @Override
    public void createPresenter() {
        int agentId = getIntent().getIntExtra("agentId", 0);
        presenter = new AgentDetailPresenter(this);
        presenter.showAgentPresenter(agentId);
        AgentCommPresenter agentCommPresenter = new AgentCommPresenter(this);
        agentCommPresenter.showAgentCommPresenter(agentId, 1, 4);
    }

    /**
     * @param agentDetailBean 经纪人详情页
     */
    @Override
    public void showAgentView(AgentDetailBean agentDetailBean) {
        if (agentDetailBean.getResultBean().getObject() != null) {
            String agentImg = agentDetailBean.getResultBean().getObject().getAgentImg();
            Uri uri = Uri.parse(agentImg);
            agentDetailSdv.setImageURI(uri);
            agentDetailNameTv.setText(agentDetailBean.getResultBean().getObject().getName());
            agentDetailAddressTv.setText(agentDetailBean.getResultBean().getObject().getStore());
            agentDetailAddressTv.setText(agentDetailBean.getResultBean().getObject().getProject());
            agentDetailDealCountTv.setText(agentDetailBean.getResultBean().getObject().getDealCount() + "");
            agentDetailWatchTimes.setText(agentDetailBean.getResultBean().getObject().getWatchTimes() + "");
            agentDetailScore.setText(agentDetailBean.getResultBean().getObject().getScore() + "");
            agentMobile = agentDetailBean.getResultBean().getObject().getMobile();
        }


    }

    /**
     * 经纪人评论列表
     *
     * @param commBean
     */
    @Override
    public void showAgentCommView(AgentCommBean commBean) {
        Log.d("AgentDetailsActivity", "=========" + commBean.getResultBean().getMessage());
        if (commList != null) {
            commList = commBean.getResultBean().getObject().getList();
            Log.d("AgentDetailsActivity", "============commList.size():" + commList.size());
            manager = new LinearLayoutManager(this);
            //设置启用平滑滚动条
            manager.setSmoothScrollbarEnabled(true);
            //设置自自动测量功能
            manager.setAutoMeasureEnabled(true);
            agentDetailRv.setLayoutManager(manager);
            //具有固定大小
            agentDetailRv.setHasFixedSize(true);
            agentDetailRv.setNestedScrollingEnabled(false);
            AgentDetailsActivityAdapter adapter = new AgentDetailsActivityAdapter(this, commList);
            agentDetailRv.setAdapter(adapter);
        }
    }

    private void initView() {
        agentDetailSdv = (SimpleDraweeView) findViewById(R.id.agent_detail_sdv);
        agentDetailNameTv = (TextView) findViewById(R.id.agent_detail_nameTv);
        agentDetailAddressTv = (TextView) findViewById(R.id.agent_detail_addressTv);
        agentDetailProjectTv = (TextView) findViewById(R.id.agent_detail_projectTv);
        agentDetailDealCountTv = (TextView) findViewById(R.id.agent_detail_dealCountTv);
        agentDetailWatchTimes = (TextView) findViewById(R.id.agent_detail_watchTimes);
        agentDetailScore = (TextView) findViewById(R.id.agent_detail_score);
        agentDetailRv = (RecyclerView) findViewById(R.id.agent_detail_rv);
        findViewById(R.id.agent_detail_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        findViewById(R.id.agent_detail_PhoneBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                Uri data = Uri.parse("tel:" + agentMobile);
                intent.setData(data);
                startActivity(intent);
            }
        });
    }
}
