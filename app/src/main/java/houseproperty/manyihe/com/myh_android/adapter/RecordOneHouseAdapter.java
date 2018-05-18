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
import houseproperty.manyihe.com.myh_android.activity.HotFloorDetailsActivity;
import houseproperty.manyihe.com.myh_android.activity.NewHouseFloorDetailsActivity;
import houseproperty.manyihe.com.myh_android.bean.HouseInfoBean;

/**
 * Created by Mr.周 on 2018/4/12.
 */

public class RecordOneHouseAdapter extends RecyclerView.Adapter<RecordOneHouseAdapter.MyViewHolder> {
    private Context context;
    private List<HouseInfoBean.ResultBeanBean.ObjectBean.ListBean> oneHouseList;


    public RecordOneHouseAdapter(Context context, List<HouseInfoBean.ResultBeanBean.ObjectBean.ListBean> oneHouseList) {
        this.context = context;
        this.oneHouseList = oneHouseList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = View.inflate(context, R.layout.record_one_house_adapter, null);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;


    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        if (oneHouseList.size() != 0) {
            String mainImg = oneHouseList.get(position).getMainImg();
            Uri uri = Uri.parse(mainImg);
            holder.sdvImg.setImageURI(uri);
            holder.titleTv.setText(oneHouseList.get(position).getTitle());
            holder.addressTv.setText(oneHouseList.get(position).getAddress());
            holder.layoutTv.setText(oneHouseList.get(position).getLayout());
            holder.measureTv.setText(oneHouseList.get(position).getMeasure() + "/m²");
            String feature = oneHouseList.get(position).getFeature();
            String[] temp = null;
            temp = feature.split(",");
            holder.featureTv1.setText(temp[0]);
            holder.featureTv2.setText(temp[1]);
            holder.priceTv.setText(oneHouseList.get(position).getPrice() + "万");
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int id = oneHouseList.get(position).getId();
                    Log.d("RecordOneHouseAdapter", "==============" + "id:" + id);
                    Intent intent = new Intent(context, NewHouseFloorDetailsActivity.class);
                    intent.putExtra("houseId", id);
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return oneHouseList == null ? 0 : oneHouseList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView sdvImg;
        TextView titleTv, addressTv, layoutTv, measureTv, featureTv1, featureTv2, priceTv;

        //该够造方法接受的itemView参数 就是item布局的view对象
        public MyViewHolder(View itemView) {
            super(itemView);
            //图片
            sdvImg = itemView.findViewById(R.id.record_one_house_sdv);
            //标题
            titleTv = itemView.findViewById(R.id.record_one_house_titleTv);
            //地址
            addressTv = itemView.findViewById(R.id.record_one_house_addressTv);
            //三室一厅...........
            layoutTv = itemView.findViewById(R.id.record_one_house_layoutTv);
            //面积
            measureTv = itemView.findViewById(R.id.record_one_house_measureTv);
            //标签
            featureTv1 = itemView.findViewById(R.id.record_one_house_featureTv1);
            featureTv2 = itemView.findViewById(R.id.record_one_house_featureTv2);
            //价格
            priceTv = itemView.findViewById(R.id.record_one_house_priceTv);
        }
    }
}