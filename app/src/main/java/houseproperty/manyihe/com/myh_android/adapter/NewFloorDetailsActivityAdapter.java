package houseproperty.manyihe.com.myh_android.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.sdsmdg.tastytoast.TastyToast;

import java.util.List;

import houseproperty.manyihe.com.myh_android.R;
import houseproperty.manyihe.com.myh_android.bean.HouseInfoBean;

/**
 * Created by Mr.周 on 2018/4/19.
 */

public class NewFloorDetailsActivityAdapter extends RecyclerView.Adapter<NewFloorDetailsActivityAdapter.MyViewHolder> {
    private Context context;
    private List<HouseInfoBean.ResultBeanBean.ObjectBean.ListBean> newDetails;

    public NewFloorDetailsActivityAdapter(Context context, List<HouseInfoBean.ResultBeanBean.ObjectBean.ListBean> newDetails) {
        this.context = context;
        this.newDetails = newDetails;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.new_floor_details_adapter, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.title.setText(newDetails.get(position).getSubTitle());
        holder.average_price.setText(newDetails.get(position).getAveragePrice() + "元/m²");
        holder.measureTv.setText(newDetails.get(position).getMeasure());
        holder.address.setText(newDetails.get(position).getAddress());
        holder.average_price.setText(newDetails.get(position).getAveragePrice() + "元/m²");
        holder.floor.setText(newDetails.get(position).getFloor());
        holder.elevator.setText(newDetails.get(position).getElevator());
        holder.towards.setText(newDetails.get(position).getTowards());
        holder.house_type.setText(newDetails.get(position).getHouseType());
        holder.layout_tv.setText(newDetails.get(position).getLayout());
        holder.measureArea.setText(newDetails.get(position).getMeasure() + "/m²");
        int state = newDetails.get(position).getState();
        if (state == 1) {
            holder.state_two.setText("售馨");
        } else {
            holder.state_two.setText("在售");
        }
        holder.afforest.setText(newDetails.get(position).getAfforest());
        holder.fitment.setText(newDetails.get(position).getFitment());
        holder.equity.setText(newDetails.get(position).getEquity());
        holder.house_times.setText(newDetails.get(position).getHouseTimes());
        String feature = newDetails.get(position).getFeature();
        String[] temp = null;
        temp = feature.split(",");
        holder.feature1.setText(temp[0]);
        holder.feature2.setText(temp[1]);
        holder.feature3.setText(temp[2]);
    }

    @Override
    public int getItemCount() {
        return newDetails.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title, average_price, measureTv, measureArea, address, floor, elevator, towards, house_type, layout_tv, state_two, afforest, fitment, equity, house_times, feature1, feature2, feature3;
        private Button visBtn;

        public MyViewHolder(View itemView) {
            super(itemView);
            //标题
            title = itemView.findViewById(R.id.new_floor_details_adapter_title);
            //住宅
            average_price = itemView.findViewById(R.id.new_floor_details_adapter_average_price);
            //户型面积
            measureTv = itemView.findViewById(R.id.new_floor_details_adapter_measure);
            //地址
            address = itemView.findViewById(R.id.new_floor_details_adapter_address);
            //优惠房价
            average_price = itemView.findViewById(R.id.new_floor_details_adapter_average_price_two);
            //楼层
            floor = itemView.findViewById(R.id.new_floor_details_adapter_floor);
            //电梯情况
            elevator = itemView.findViewById(R.id.new_floor_details_adapter_elevator);
            //朝向
            towards = itemView.findViewById(R.id.new_floor_details_adapter_towards);
            //房屋类型
            house_type = itemView.findViewById(R.id.new_floor_details_adapter_house_type);
            //户型
            layout_tv = itemView.findViewById(R.id.new_floor_details_adapter_layout);
            //面积
            measureArea = itemView.findViewById(R.id.new_floor_details_adapter_measure_two);
            //工程进度
            state_two = itemView.findViewById(R.id.new_floor_details_adapter_state_two);
            //绿化率
            afforest = itemView.findViewById(R.id.new_floor_details_adapter_afforest);
            //装修情况
            fitment = itemView.findViewById(R.id.new_floor_details_adapter_fitment);
            //产权
            equity = itemView.findViewById(R.id.new_floor_details_adapter_equity);
            //建筑年代
            house_times = itemView.findViewById(R.id.new_floor_details_adapter_house_times);
            //特点
            feature1 = itemView.findViewById(R.id.feature1);
            feature2 = itemView.findViewById(R.id.feature2);
            feature3 = itemView.findViewById(R.id.feature3);
            //户型标题
            visBtn = itemView.findViewById(R.id.lay_visBtn);
            //地址点击事件
            itemView.findViewById(R.id.address_click).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TastyToast.makeText(context, "点击了", TastyToast.LENGTH_SHORT, TastyToast.SUCCESS);
                }
            });
        }
    }
}