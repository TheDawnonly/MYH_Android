package houseproperty.manyihe.com.myh_android.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import houseproperty.manyihe.com.myh_android.R;
import houseproperty.manyihe.com.myh_android.activity.AgentDetailsActivity;
import houseproperty.manyihe.com.myh_android.bean.AgentByHouse;
import houseproperty.manyihe.com.myh_android.bean.ViewHouseCommBean;


/**
 * Created by Mr.周 on 2018/4/19.
 */

public class ViewHouseCommAdapter extends RecyclerView.Adapter<ViewHouseCommAdapter.MyViewHolder> {
    private Context context;
    private List<ViewHouseCommBean.ResultBeanBean.ObjectBean.ListBean> commList;

    public ViewHouseCommAdapter(Context context, List<ViewHouseCommBean.ResultBeanBean.ObjectBean.ListBean> commList) {
        this.context = context;
        this.commList = commList;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_house_comm, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        if (commList.get(position).getHeadUrl() != null) {
            String headUrl = commList.get(position).getHeadUrl();
            Uri uri = Uri.parse(headUrl);
            holder.viewHouseCommSDV.setImageURI(uri);
        }
        holder.nameTv.setText(commList.get(position).getMobile());
        holder.contentTv.setText(commList.get(position).getComment());
        LinearLayoutManager manager = new LinearLayoutManager(context);
        holder.recyclerView.setLayoutManager(manager);
        ViewHouseCommTwoAdapter twoAdapter = new ViewHouseCommTwoAdapter(context, commList);
        holder.recyclerView.setAdapter(twoAdapter);
    }

    @Override
    public int getItemCount() {
        return commList == null ? 0 : commList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        SimpleDraweeView viewHouseCommSDV;
        TextView nameTv, timeTv, contentTv;
        RecyclerView recyclerView;

        public MyViewHolder(View itemView) {
            super(itemView);
            viewHouseCommSDV = itemView.findViewById(R.id.view_house_comm_sdv);
            nameTv = itemView.findViewById(R.id.view_house_comm_nameTv);
            timeTv = itemView.findViewById(R.id.view_house_comm_timeTv);
            contentTv = itemView.findViewById(R.id.view_house_comm_contentTv);
            recyclerView = itemView.findViewById(R.id.view_house_comm_Rv);
        }
    }
}
