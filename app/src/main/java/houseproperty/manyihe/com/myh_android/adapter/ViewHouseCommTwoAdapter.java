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
import houseproperty.manyihe.com.myh_android.bean.AgentByHouse;
import houseproperty.manyihe.com.myh_android.bean.ViewHouseCommBean;


/**
 * Created by Mr.周 on 2018/4/19.
 */

public class ViewHouseCommTwoAdapter extends RecyclerView.Adapter<ViewHouseCommTwoAdapter.MyViewHolder> {
    private Context context;
    private List<ViewHouseCommBean.ResultBeanBean.ObjectBean.ListBean> commList;

    public ViewHouseCommTwoAdapter(Context context, List<ViewHouseCommBean.ResultBeanBean.ObjectBean.ListBean> commList) {
        this.context = context;
        this.commList = commList;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_house_comm_two, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {


    }

    @Override
    public int getItemCount() {
        return commList == null ? 0 : commList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {


        public MyViewHolder(View itemView) {
            super(itemView);

        }
    }
}
