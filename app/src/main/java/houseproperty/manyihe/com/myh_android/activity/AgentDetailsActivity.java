package houseproperty.manyihe.com.myh_android.activity;


import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import houseproperty.manyihe.com.myh_android.R;
import houseproperty.manyihe.com.myh_android.bean.AgentDetailBean;
import houseproperty.manyihe.com.myh_android.presenter.AgentDetailPresenter;
import houseproperty.manyihe.com.myh_android.view.IAgentDetailView;

public class AgentDetailsActivity extends BaseActivity<AgentDetailPresenter> implements IAgentDetailView {

    private SimpleDraweeView agentDetailSdv;
    private TextView agentDetailNameTv;
    private TextView agentDetailAddressTv;
    private TextView agentDetailProjectTv;
    private TextView agentDetailDealCountTv;
    private TextView agentDetailWatchTimes;
    private TextView agentDetailScore;
    private RecyclerView agentDetailRv;

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
    }

    /**
     * @param agentDetailBean 经纪人详情页
     */
    @Override
    public void showAgentView(AgentDetailBean agentDetailBean) {
        String agentImg = agentDetailBean.getResultBean().getObject().getAgentImg();
        Uri uri = Uri.parse(agentImg);
        agentDetailSdv.setImageURI(uri);
        agentDetailNameTv.setText(agentDetailBean.getResultBean().getObject().getName());
        agentDetailAddressTv.setText(agentDetailBean.getResultBean().getObject().getStore());
        agentDetailAddressTv.setText(agentDetailBean.getResultBean().getObject().getProject());
        agentDetailDealCountTv.setText(agentDetailBean.getResultBean().getObject().getDealCount() + "");
        agentDetailWatchTimes.setText(agentDetailBean.getResultBean().getObject().getWatchTimes() + "");
        agentDetailScore.setText(agentDetailBean.getResultBean().getObject().getScore()+"");

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
    }
}
