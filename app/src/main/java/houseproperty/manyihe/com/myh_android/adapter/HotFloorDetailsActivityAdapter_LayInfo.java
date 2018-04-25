package houseproperty.manyihe.com.myh_android.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import houseproperty.manyihe.com.myh_android.R;
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
    public void onBindViewHolder(MyViewHolder holder, int position) {
        if (layList != null) {
            Uri uri = Uri.parse(layList.get(position).getImgA());
            holder.simpleDraweeView.setImageURI(uri);
            holder.explains_tv.setText(layList.get(position).getExplains());
            holder.avgPrice_tv.setText(layList.get(position).getAvgPrice() + "万/套");
            holder.feature_tv.setText(layList.get(position).getFeature());
        }

    }

    @Override
    public int getItemCount() {
        return layList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView explains_tv, avgPrice_tv, feature_tv;
        SimpleDraweeView simpleDraweeView;

        public MyViewHolder(View itemView) {
            super(itemView);
            simpleDraweeView = itemView.findViewById(R.id.hot_floor_details_adapter_sdv_lay_img);
            explains_tv = itemView.findViewById(R.id.hot_floor_details_adapter_explains);
            avgPrice_tv = itemView.findViewById(R.id.hot_floor_details_adapter_avg_price);
            feature_tv = itemView.findViewById(R.id.hot_floor_details_adapter_feature);
        }
    }
}
