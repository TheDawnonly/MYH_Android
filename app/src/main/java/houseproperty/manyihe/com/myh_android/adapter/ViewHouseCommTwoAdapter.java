package houseproperty.manyihe.com.myh_android.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    private ViewHouseCommBean.ResultBeanBean.ObjectBean.ListBean commBean;
    private List<ViewHouseCommBean.ResultBeanBean.ObjectBean.ListBean.ReplyListBean> replyList;
    //private List<ViewHouseCommBean.ResultBeanBean.ObjectBean.ListBean.ReplyListBean> replyListAll = new ArrayList<>();

    public ViewHouseCommTwoAdapter(Context context, ViewHouseCommBean.ResultBeanBean.ObjectBean.ListBean commBean) {
        this.context = context;
        this.commBean = commBean;
        replyList = commBean.getReplyList();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_house_comm_two, null);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        if (replyList.get(position).getRHeadUrl() != null) {
            Uri uri = Uri.parse(replyList.get(position).getRHeadUrl());
            holder.sdvImg.setImageURI(uri);
        }
        holder.timeTv.setText(replyList.get(position).getRTimeStr());
        holder.nameTv2_1.setText(replyList.get(position).getRMobile());
        holder.contentTv2.setText(replyList.get(position).getCommReply());
        holder.nameTv2_2.setText(commBean.getMobile());

    }

//    public void addData(int position, String s) {
////      在list中添加数据，并通知条目加入一条
//        sp = context.getSharedPreferences("config", context.MODE_PRIVATE);
//        String mobile = sp.getString("mobile", "");
//        String sMobile = mobile.substring(0, 3) + "****" + mobile.substring(7, 11);
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date curDate = new Date(System.currentTimeMillis());
//        String strTime = formatter.format(curDate);
//        commBean.setRTimeStr(strTime);
//        commBean.setRMobile(sMobile);
//        commBean.setCommReply(s);
//        if (commBean != null) {
//            replyList.add(position, commBean);
//        }
//
//        //添加动画
//        notifyItemInserted(position);
//    }

    @Override
    public int getItemCount() {
        return replyList == null ? 0 : replyList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView timeTv, nameTv2_1, nameTv2_2, contentTv2;
        SimpleDraweeView sdvImg;

        public MyViewHolder(View itemView) {
            super(itemView);
            sdvImg = itemView.findViewById(R.id.view_house_comm_sdv2);
            timeTv = itemView.findViewById(R.id.view_house_comm_timeTv2);
            nameTv2_1 = itemView.findViewById(R.id.view_house_comm_nameTv2_1);
            nameTv2_2 = itemView.findViewById(R.id.view_house_comm_nameTv2_2);
            contentTv2 = itemView.findViewById(R.id.view_house_comm_contentTv2);
        }
    }
}
