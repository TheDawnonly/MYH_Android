package houseproperty.manyihe.com.myh_android.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.youth.banner.Banner;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import houseproperty.manyihe.com.myh_android.R;
import houseproperty.manyihe.com.myh_android.bean.MessageBean;
import houseproperty.manyihe.com.myh_android.activity.MessageDetailsActivity;
import houseproperty.manyihe.com.myh_android.utils.BannerImageLoader;

/**
 * Created by Mr.周 on 2018/4/8.
 */

public class messageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<MessageBean.ResultBeanBean.ObjectBean.ListBean> list;
    private List<String> imgList = new ArrayList();


    public messageAdapter(Context context, List<MessageBean.ResultBeanBean.ObjectBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view1 = View.inflate(context, R.layout.message_data_adapter, null);
            MyViewHolder holder = new MyViewHolder(view1);
            return holder;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

            MyViewHolder viewHolder = (MyViewHolder) holder;
            viewHolder.tv.setText(list.get(position).getFloorTitle());
            if (list.get(position).getImgUrl()!=null){
                Uri parse = Uri.parse(list.get(position).getImgUrl());
                viewHolder.img.setImageURI(parse);
            }

            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, MessageDetailsActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("floorId", list.get(position).getId());
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                }
            });

    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        SimpleDraweeView img;

        //该够造方法接受的itemView参数 就是item布局的view对象
        public MyViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.message_data_tv);
            img = itemView.findViewById(R.id.message_data_sdv);
        }
    }
}
