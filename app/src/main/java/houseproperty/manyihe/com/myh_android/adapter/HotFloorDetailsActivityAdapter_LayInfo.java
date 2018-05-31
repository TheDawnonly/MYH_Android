package houseproperty.manyihe.com.myh_android.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import houseproperty.manyihe.com.myh_android.R;
import houseproperty.manyihe.com.myh_android.activity.ImgClickActivity;
import houseproperty.manyihe.com.myh_android.bean.LayInfoBean;

/**
 * Created by Mr.周 on 2018/4/19.
 */

public class HotFloorDetailsActivityAdapter_LayInfo extends RecyclerView.Adapter<HotFloorDetailsActivityAdapter_LayInfo.MyViewHolder> {
    private Context context;
    List<LayInfoBean.ResultBeanBean.ObjectBean> layList;

    public HotFloorDetailsActivityAdapter_LayInfo(Context context, List<LayInfoBean.ResultBeanBean.ObjectBean> layList) {
        this.context = context;
        this.layList = layList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.hot_floor_details_adapter_lay_info, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        if (layList != null) {
            Uri uri = Uri.parse(layList.get(position).getImgA());
            holder.simpleDraweeView.setImageURI(uri);
            holder.simpleDraweeView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String imgA = layList.get(position).getImgA();
                    Intent intent = new Intent(context, ImgClickActivity.class);
                    intent.putExtra("uri", imgA);
                    context.startActivity(intent);
                }
            });
            holder.layout_tv.setText(layList.get(position).getLayout());
            holder.avgPrice_tv.setText(layList.get(position).getAvgPrice() + "万/套");
            holder.typeTv.bringToFront();
            holder.typeTv.setText(layList.get(position).getLayType() + "户型");
            holder.towardsTv.setText(layList.get(position).getTowards());
            holder.measureTv.setText(layList.get(position).getMeasure() + "m²");
            String feature = layList.get(position).getFeature();
            String[] temp = null;
            temp = feature.split(",");
            if (temp.length >= 3) {
                holder.feature3.setVisibility(View.VISIBLE);
                holder.feature1.setText(temp[0]);
                holder.feature2.setText(temp[1]);
                holder.feature3.setText(temp[2]);
            } else if (temp.length < 3) {
                holder.feature1.setText(temp[0]);
                holder.feature2.setText(temp[1]);
                holder.feature3.setVisibility(View.GONE);
            }
            String saleState = layList.get(position).getSaleState();
            if (saleState.equals("2")) {
                holder.onSale.setVisibility(View.VISIBLE);
                holder.sellOut.setVisibility(View.GONE);
            } else {
                holder.onSale.setVisibility(View.GONE);
                holder.sellOut.setVisibility(View.VISIBLE);
            }
            holder.timeTv.setText(layList.get(position).getTimeStr());
        }

    }

    @Override
    public int getItemCount() {
        return layList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView layout_tv, avgPrice_tv, typeTv, towardsTv, measureTv, feature1, feature2, feature3, timeTv;
        Button onSale, sellOut;
        SimpleDraweeView simpleDraweeView;

        public MyViewHolder(View itemView) {
            super(itemView);
            simpleDraweeView = itemView.findViewById(R.id.hot_floor_details_adapter_sdv_lay_img);
            layout_tv = itemView.findViewById(R.id.hot_floor_details_adapter_lay_info_layout);
            avgPrice_tv = itemView.findViewById(R.id.hot_floor_details_adapter_avg_price);
            typeTv = itemView.findViewById(R.id.hot_floor_details_adapter_lay_info_typeTv);
            towardsTv = itemView.findViewById(R.id.hot_floor_details_adapter_lay_info_towards);
            onSale = itemView.findViewById(R.id.hot_floor_details_adapter_lay_info_onStateBtn);
            sellOut = itemView.findViewById(R.id.hot_floor_details_adapter_lay_info_offStateBtn);
            measureTv = itemView.findViewById(R.id.hot_floor_details_adapter_lay_info_measure);
            feature1 = itemView.findViewById(R.id.hot_floor_details_adapter_lay_info_feature1);
            feature2 = itemView.findViewById(R.id.hot_floor_details_adapter_lay_info_feature2);
            feature3 = itemView.findViewById(R.id.hot_floor_details_adapter_lay_info_feature3);
            timeTv = itemView.findViewById(R.id.hot_floor_details_adapter_lay_info_time);
        }
    }
}
