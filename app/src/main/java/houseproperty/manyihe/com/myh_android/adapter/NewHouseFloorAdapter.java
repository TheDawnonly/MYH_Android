package houseproperty.manyihe.com.myh_android.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import houseproperty.manyihe.com.myh_android.R;
import houseproperty.manyihe.com.myh_android.activity.NewHouseFloorDetailsActivity;
import houseproperty.manyihe.com.myh_android.bean.HouseInfoBean;

/**
 * Created by Mr.周 on 2018/4/12.
 */

public class NewHouseFloorAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<HouseInfoBean.ResultBeanBean.ObjectBean.ListBean> newList;


    public NewHouseFloorAdapter(Context context, List<HouseInfoBean.ResultBeanBean.ObjectBean.ListBean> newList) {
        this.context = context;
        this.newList = newList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = View.inflate(context, R.layout.new_house_floor, null);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (newList != null) {
            MyViewHolder viewHolder = (MyViewHolder) holder;
            viewHolder.titleTv.setText(newList.get(position).getSubTitle());
            viewHolder.priceTv.setText(newList.get(position).getPrice() + "万");
            viewHolder.addressTv.setText(newList.get(position).getAddress());
            viewHolder.measureTv.setText(newList.get(position).getMeasure() + "平方米");
            if (newList.get(position).getMainImg() != null) {
                Uri parse = Uri.parse(newList.get(position).getMainImg());
                viewHolder.imageView.setImageURI(parse);
            }

            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, NewHouseFloorDetailsActivity.class);
                    intent.putExtra("houseId", newList.get(position).getId());
                    context.startActivity(intent);
                }
            });
            String feature = newList.get(position).getFeature();
            String[] temp = null;
            temp = feature.split(",");
            viewHolder.feature1Tv.setText(temp[0]);
            viewHolder.feature2Tv.setText(temp[1]);
        }

    }

    @Override
    public int getItemCount() {
        return newList == null ? 0 : newList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView titleTv, addressTv, priceTv, measureTv,feature1Tv,feature2Tv;
        SimpleDraweeView imageView;

        //该够造方法接受的itemView参数 就是item布局的view对象
        public MyViewHolder(View itemView) {
            super(itemView);
            titleTv = itemView.findViewById(R.id.new_tv_title);
            addressTv = itemView.findViewById(R.id.new_tv_address);
            imageView = itemView.findViewById(R.id.new_sdv);
            priceTv = itemView.findViewById(R.id.new_tv_price);
            measureTv = itemView.findViewById(R.id.new_house_measureTv);
            feature1Tv = itemView.findViewById(R.id.new_house_feature1Tv);
            feature2Tv = itemView.findViewById(R.id.new_house_feature2Tv);
        }
    }
}
