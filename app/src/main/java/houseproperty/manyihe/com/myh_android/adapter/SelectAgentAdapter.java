package houseproperty.manyihe.com.myh_android.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import houseproperty.manyihe.com.myh_android.R;
import houseproperty.manyihe.com.myh_android.activity.AgentDetailsActivity;
import houseproperty.manyihe.com.myh_android.bean.selectAgentBean;


/**
 * Created by Mr.周 on 2018/4/19.
 */

public class SelectAgentAdapter extends RecyclerView.Adapter<SelectAgentAdapter.MyViewHolder> {
    private Context context;
    private List<selectAgentBean.ResultBeanBean.ObjectBean.ListBean> agentList;

    public SelectAgentAdapter(Context context, List<selectAgentBean.ResultBeanBean.ObjectBean.ListBean> agentList) {
        this.context = context;
        this.agentList = agentList;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.select_agent_adapter, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Uri uri = Uri.parse(agentList.get(position).getAgentImg());
        holder.imgAgent.setImageURI(uri);
        holder.name.setText(agentList.get(position).getName());
        holder.project.setText(agentList.get(position).getProject());
        holder.address.setText(agentList.get(position).getStore());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AgentDetailsActivity.class);
                intent.putExtra("agentId", agentList.get(position).getId());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return agentList == null ? 0 : agentList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView imgAgent;
        TextView name, project, address;

        public MyViewHolder(View itemView) {
            super(itemView);
            imgAgent = itemView.findViewById(R.id.agent_sdv);
            name = itemView.findViewById(R.id.agent_name);
            project = itemView.findViewById(R.id.agent_project);
            address = itemView.findViewById(R.id.agent_address);
        }
    }
}
