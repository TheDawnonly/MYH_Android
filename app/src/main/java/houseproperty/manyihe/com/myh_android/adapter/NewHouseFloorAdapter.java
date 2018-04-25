package houseproperty.manyihe.com.myh_android.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import houseproperty.manyihe.com.myh_android.R;
import houseproperty.manyihe.com.myh_android.activity.HotFloorDetailsActivity;
import houseproperty.manyihe.com.myh_android.activity.NewHouseFloorDetailsActivity;
import houseproperty.manyihe.com.myh_android.bean.HouseInfoBean;

/**
 * Created by Mr.周 on 2018/4/12.
 */

public class NewHouseFloorAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<HouseInfoBean.ResultBeanBean.ObjectBean.ListBean> hotList;


    public NewHouseFloorAdapter(Context context, List<HouseInfoBean.ResultBeanBean.ObjectBean.ListBean> hotList) {
        this.context = context;
        this.hotList = hotList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = View.inflate(context, R.layout.one_hot_floor, null);
        NewHouseFloorAdapter.MyViewHolder holder = new NewHouseFloorAdapter.MyViewHolder(view);
        return holder;


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        NewHouseFloorAdapter.MyViewHolder viewHolder = (NewHouseFloorAdapter.MyViewHolder) holder;
        viewHolder.title.setText(hotList.get(position).getSubTitle());
        viewHolder.price.setText(hotList.get(position).getPrice() + "万");
        viewHolder.address.setText(hotList.get(position).getAddress());
        viewHolder.measure.setText(hotList.get(position).getMeasure() + "平方米");
        viewHolder.equity.setText(hotList.get(position).getEquity());
        Uri parse = Uri.parse(hotList.get(position).getMainImg());
        viewHolder.imageView.setImageURI(parse);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, NewHouseFloorDetailsActivity.class);
                intent.putExtra("houseId", hotList.get(position).getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return hotList == null ? 0 : hotList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title, address, price, measure, equity;
        SimpleDraweeView imageView;

        //该够造方法接受的itemView参数 就是item布局的view对象
        public MyViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.hot_tv_title);
            address = itemView.findViewById(R.id.hot_tv_address);
            imageView = itemView.findViewById(R.id.hot_sdv);
            price = itemView.findViewById(R.id.hot_tv_average_price);
            measure = itemView.findViewById(R.id.hot_tv_measure);
            equity = itemView.findViewById(R.id.hot_tv_equity);
        }
    }
}
