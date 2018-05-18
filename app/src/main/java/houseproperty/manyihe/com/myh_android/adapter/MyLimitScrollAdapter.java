package houseproperty.manyihe.com.myh_android.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import houseproperty.manyihe.com.myh_android.R;
import houseproperty.manyihe.com.myh_android.utils.LimitScrollerView;

public class MyLimitScrollAdapter implements LimitScrollerView.LimitScrollAdapter {
    private Context context;
    private List<String> datas;

    public void setDatas(List<String> datas, LimitScrollerView limitScroll, Context context) {
        this.datas = datas;
        this.context = context;
    }

    @Override
    public int getCount() {
        return datas == null ? 0 : datas.size();
    }

    @Override
    public View getView(int index) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.limit_scroller_item, null, false);
        ImageView iv_icon = (ImageView) itemView.findViewById(R.id.iv_icon);
        TextView tv_text = (TextView) itemView.findViewById(R.id.tv_text);

        //绑定数据
        for (int i = 0; i < datas.size(); i++) {
            tv_text.setText(datas + ""+i);
        }

        return itemView;
    }
}
