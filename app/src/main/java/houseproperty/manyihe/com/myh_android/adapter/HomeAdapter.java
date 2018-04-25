package houseproperty.manyihe.com.myh_android.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.youth.banner.Banner;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import houseproperty.manyihe.com.myh_android.R;
import houseproperty.manyihe.com.myh_android.bean.HousingResourceBannerBean;
import houseproperty.manyihe.com.myh_android.bean.HousingResourceHotFloorBean;
import houseproperty.manyihe.com.myh_android.utils.BannerImageLoader;

/**
 * Created by Mr.周 on 2017/11/12.
 */

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_ONE = 1;
    public static final int TYPE_TWO = 2;
    public static final int TYPE_THREE = 3;
    public static final int TYPE_FOUR = 4;
    public static final int TYPE_FIVE = 5;
    public static final int TYPE_SIX = 6;
    public static final int TYPE_SEVEN = 7;
    private Context context;
    private List<HousingResourceHotFloorBean.ResultBeanBean.ObjectBean.ListBean> hotList;
    private List<HousingResourceBannerBean.ResultBeanBean.ObjectBean> bannerList;



    public HomeAdapter(Context context, List<HousingResourceHotFloorBean.ResultBeanBean.ObjectBean.ListBean> hotList, List<HousingResourceBannerBean.ResultBeanBean.ObjectBean> bannerList) {
        this.context = context;
        this.hotList = hotList;
        this.bannerList = bannerList;
        Log.d("HomeAdapter====", "bannerList==="+bannerList.size());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            View view = View.inflate(context, R.layout.header, null);
            MyHeaderHolder holderH = new MyHeaderHolder(view);
            return holderH;
        } else if (viewType == TYPE_ONE) {
            View view1 = View.inflate(context, R.layout.my_one_type, null);
            MyViewHolder1 holder1 = new MyViewHolder1(view1);
            return holder1;
        } else if (viewType == TYPE_TWO) {
            View view2 = View.inflate(context, R.layout.my_two_type, null);
            MyViewHolder2 holder2 = new MyViewHolder2(view2);
            return holder2;
        } else if (viewType == TYPE_THREE) {
            View view3 = View.inflate(context, R.layout.my_three_type, null);
            MyViewHolder3 holder3 = new MyViewHolder3(view3);
            return holder3;
        } else if (viewType == TYPE_FOUR) {
            View view4 = View.inflate(context, R.layout.my_four_type, null);
            MyViewHolder4 holder4 = new MyViewHolder4(view4);
            return holder4;
        } else if (viewType == TYPE_FIVE) {
            View view5 = View.inflate(context, R.layout.my_five_type, null);
            MyViewHolder5 holder5 = new MyViewHolder5(view5);
            return holder5;
        } else if (viewType == TYPE_SIX) {
            View view6 = View.inflate(context, R.layout.my_six_type, null);
            MyViewHolder6 holder6 = new MyViewHolder6(view6);
            return holder6;
        } else {
            View view7 = View.inflate(context, R.layout.my_seven_type, null);
            MyViewHolder7 holder7 = new MyViewHolder7(view7);
            return holder7;
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyHeaderHolder) {
            MyHeaderHolder viewHolder = (MyHeaderHolder) holder;
            List<String> imgList = new ArrayList<>();
            if (bannerList != null) {
                for (int i = 0; i < bannerList.size(); i++) {
                    imgList.add(bannerList.get(i).getBannerImg());
                }
            }

            viewHolder.banner.setImageLoader(new BannerImageLoader());
            viewHolder.banner.setImages(imgList);
            viewHolder.banner.setBannerAnimation(Transformer.Default);
            viewHolder.banner.start();
        }
        if (holder instanceof MyViewHolder1) {
            MyViewHolder1 viewHolder = (MyViewHolder1) holder;
            viewHolder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "更多", Toast.LENGTH_SHORT).show();
                }
            });
//            HotFloorAdapter adapter = new HotFloorAdapter(context, hotList);
//            LinearLayoutManager manager = new LinearLayoutManager(context);
//            viewHolder.recyclerView.setLayoutManager(manager);
//            viewHolder.recyclerView.setNestedScrollingEnabled(false);
//            viewHolder.recyclerView.setAdapter(adapter);
        }
        if (holder instanceof MyViewHolder2) {
            MyViewHolder2 viewHolder = (MyViewHolder2) holder;
            viewHolder.tv.setText("22222222222222222222222222222222");
        }
        if (holder instanceof MyViewHolder3) {
            MyViewHolder3 viewHolder = (MyViewHolder3) holder;
            viewHolder.tv.setText("33333333333333333333333333333333333");
        }
        if (holder instanceof MyViewHolder4) {
            MyViewHolder4 viewHolder = (MyViewHolder4) holder;
            viewHolder.tv.setText("4444444444444444444444444444444444");
        }
        if (holder instanceof MyViewHolder5) {
            MyViewHolder5 viewHolder = (MyViewHolder5) holder;
            viewHolder.tv.setText("5555555555555555555555555555555555555555");
        }
        if (holder instanceof MyViewHolder6) {
            MyViewHolder6 viewHolder = (MyViewHolder6) holder;
            viewHolder.tv.setText("6666666666666666666666666666666666");
        }
        if (holder instanceof MyViewHolder7) {
            MyViewHolder7 viewHolder = (MyViewHolder7) holder;
            viewHolder.tv.setText("777777777777777777777777777777777777777");
        }

    }

    @Override
    public int getItemCount() {
        return 8;
        // return list == null ? 0 : list.size()+1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;
        } else if (position == 1) {
            return TYPE_ONE;
        } else if (position == 2) {
            return TYPE_TWO;
        } else if (position == 3) {
            return TYPE_THREE;
        } else if (position == 4) {
            return TYPE_FOUR;
        } else if (position == 5) {
            return TYPE_FIVE;
        } else if (position == 6) {
            return TYPE_SIX;
        } else {
            return TYPE_SEVEN;
        }
    }

    class MyHeaderHolder extends RecyclerView.ViewHolder {
        Banner banner;

        //该够造方法接受的itemView参数 就是item布局的view对象
        public MyHeaderHolder(View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.head_banner);
        }
    }

    class MyViewHolder1 extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        Button button;

        //该够造方法接受的itemView参数 就是item布局的view对象
        public MyViewHolder1(View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.my_one_type_btnMore);
            recyclerView = itemView.findViewById(R.id.my_one_type_rv);
        }
    }


    class MyViewHolder2 extends RecyclerView.ViewHolder {
        TextView tv;
        ImageView iv;

        //该够造方法接受的itemView参数 就是item布局的view对象
        public MyViewHolder2(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.two_tv);
        }
    }

    class MyViewHolder3 extends RecyclerView.ViewHolder {
        TextView tv;
        ImageView iv;

        //该够造方法接受的itemView参数 就是item布局的view对象
        public MyViewHolder3(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.three_tv);
            iv = (ImageView) itemView.findViewById(R.id.adapter_three_img);
        }
    }

    class MyViewHolder4 extends RecyclerView.ViewHolder {
        TextView tv;
        ImageView iv;

        //该够造方法接受的itemView参数 就是item布局的view对象
        public MyViewHolder4(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.four_tv);
        }
    }

    class MyViewHolder5 extends RecyclerView.ViewHolder {
        TextView tv;
        ImageView iv;

        //该够造方法接受的itemView参数 就是item布局的view对象
        public MyViewHolder5(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.five_tv);
        }
    }

    class MyViewHolder6 extends RecyclerView.ViewHolder {
        TextView tv;
        ImageView iv;

        //该够造方法接受的itemView参数 就是item布局的view对象
        public MyViewHolder6(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.six_tv);
        }
    }

    class MyViewHolder7 extends RecyclerView.ViewHolder {
        TextView tv;
        ImageView iv;

        //该够造方法接受的itemView参数 就是item布局的view对象
        public MyViewHolder7(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.seven_tv);
        }
    }
}
