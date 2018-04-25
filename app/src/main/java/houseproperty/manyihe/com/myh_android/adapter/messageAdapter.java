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
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_ONE = 1;
    private Context context;
    private List<MessageBean.ResultBeanBean.ObjectBean.ListBean> list;
    private List<String> imgList = new ArrayList();


    public messageAdapter(Context context, List<MessageBean.ResultBeanBean.ObjectBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            View view = View.inflate(context, R.layout.message_banner_adapter, null);
            messageAdapter.MyHeaderHolder holderH = new messageAdapter.MyHeaderHolder(view);
            return holderH;
        } else {
            View view1 = View.inflate(context, R.layout.message_data_adapter, null);
            messageAdapter.MyViewHolder holder = new messageAdapter.MyViewHolder(view1);
            return holder;
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof messageAdapter.MyHeaderHolder) {
            messageAdapter.MyHeaderHolder viewHolder = (messageAdapter.MyHeaderHolder) holder;
            for (int i = 0; i < list.size(); i++) {
                imgList.add(list.get(i).getImgUrl());
            }
            viewHolder.banner.setImageLoader(new BannerImageLoader());
            viewHolder.banner.setImages(imgList);
            viewHolder.banner.setBannerAnimation(Transformer.Stack);
            viewHolder.banner.start();
        }
        if (holder instanceof messageAdapter.MyViewHolder) {
            messageAdapter.MyViewHolder viewHolder = (messageAdapter.MyViewHolder) holder;
            viewHolder.tv.setText(list.get(position - 1).getFloorPreview());
            Uri parse = Uri.parse(list.get(position - 1).getImgUrl());
            viewHolder.img.setImageURI(parse);
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, MessageDetailsActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("messageID", list.get(position - 1).getId());
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;
        } else {
            return TYPE_ONE;
        }
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

    class MyHeaderHolder extends RecyclerView.ViewHolder {
        Banner banner;

        //该够造方法接受的itemView参数 就是item布局的view对象
        public MyHeaderHolder(View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.message_banner);
            banner.setOnBannerListener(new OnBannerListener() {
                @Override
                public void OnBannerClick(int position) {
                    Intent intent = new Intent(context, MessageDetailsActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("messageID", list.get(position).getId());
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                }
            });
        }
    }

}
