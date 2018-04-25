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
import houseproperty.manyihe.com.myh_android.bean.HousingResourceHotFloorBean;

/**
 * Created by Mr.周 on 2018/4/19.
 */

public class HotFloorDetailsActivityAdapter extends RecyclerView.Adapter<HotFloorDetailsActivityAdapter.MyViewHolder> {
    private Context context;
    private List<HousingResourceHotFloorBean.ResultBeanBean.ObjectBean.ListBean> hotDetails;

    public HotFloorDetailsActivityAdapter(Context context, List<HousingResourceHotFloorBean.ResultBeanBean.ObjectBean.ListBean> hotDetails) {
        this.context = context;
        this.hotDetails = hotDetails;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.hot_floor_details_adapter, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.title.setText(hotDetails.get(position).getSubTitle());
        holder.average_price.setText(hotDetails.get(position).getAveragePrice() + "元/m²");
        holder.measure.setText(hotDetails.get(position).getMeasure());
        holder.address.setText(hotDetails.get(position).getAddress());
        holder.average_price.setText(hotDetails.get(position).getAveragePrice() + "元/m²");
        holder.floor.setText(hotDetails.get(position).getFloor());
        holder.elevator.setText(hotDetails.get(position).getElevator());
        holder.towards.setText(hotDetails.get(position).getTowards());
        holder.house_type.setText(hotDetails.get(position).getHouseType());
        holder.layout_tv.setText(hotDetails.get(position).getLayout());
        holder.measure.setText(hotDetails.get(position).getMeasure());
        int state = hotDetails.get(position).getState();
        if (state == 1) {
            holder.state_two.setText("售馨");
        } else {
            holder.state_two.setText("在售");
        }
        holder.afforest.setText(hotDetails.get(position).getAfforest());
        holder.fitment.setText(hotDetails.get(position).getFitment());
        holder.equity.setText(hotDetails.get(position).getEquity());
        holder.house_times.setText(hotDetails.get(position).getHouseTimes());
    }

    @Override
    public int getItemCount() {
        return hotDetails.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title, average_price, measure, address, floor, elevator, towards, house_type, layout_tv, state_two, afforest, fitment, equity, house_times;

        public MyViewHolder(View itemView) {
            super(itemView);
            //标题
            title = itemView.findViewById(R.id.hot_floor_details_adapter_title);
            //住宅
            average_price = itemView.findViewById(R.id.hot_floor_details_adapter_average_price);
            //户型面积
            measure = itemView.findViewById(R.id.hot_floor_details_adapter_measure);
            //地址
            address = itemView.findViewById(R.id.hot_floor_details_adapter_address);
            //优惠房价
            average_price = itemView.findViewById(R.id.hot_floor_details_adapter_average_price_two);
            //楼层
            floor = itemView.findViewById(R.id.hot_floor_details_adapter_floor);
            //电梯情况
            elevator = itemView.findViewById(R.id.hot_floor_details_adapter_elevator);
            //朝向
            towards = itemView.findViewById(R.id.hot_floor_details_adapter_towards);
            //房屋类型
            house_type = itemView.findViewById(R.id.hot_floor_details_adapter_house_type);
            //户型
            layout_tv = itemView.findViewById(R.id.hot_floor_details_adapter_layout);
            //面积
            measure = itemView.findViewById(R.id.hot_floor_details_adapter_measure_two);
            //工程进度
            state_two = itemView.findViewById(R.id.hot_floor_details_adapter_state_two);
            //绿化率
            afforest = itemView.findViewById(R.id.hot_floor_details_adapter_afforest);
            //装修情况
            fitment = itemView.findViewById(R.id.hot_floor_details_adapter_fitment);
            //产权
            equity = itemView.findViewById(R.id.hot_floor_details_adapter_equity);
            //建筑年代
            house_times = itemView.findViewById(R.id.hot_floor_details_adapter_house_times);
        }
    }
}