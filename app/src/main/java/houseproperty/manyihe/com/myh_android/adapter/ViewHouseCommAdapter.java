package houseproperty.manyihe.com.myh_android.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.loonggg.bottomsheetpopupdialoglib.ShareBottomPopupDialog;

import java.util.List;

import houseproperty.manyihe.com.myh_android.R;
import houseproperty.manyihe.com.myh_android.activity.AgentDetailsActivity;
import houseproperty.manyihe.com.myh_android.activity.HotFloorDetailsActivity;
import houseproperty.manyihe.com.myh_android.bean.AgentByHouse;
import houseproperty.manyihe.com.myh_android.bean.InsertReplyBean;
import houseproperty.manyihe.com.myh_android.bean.ViewHouseCommBean;
import houseproperty.manyihe.com.myh_android.presenter.InsertReplyPresenter;
import houseproperty.manyihe.com.myh_android.presenter.ViewHouseCommPresenter;
import houseproperty.manyihe.com.myh_android.view.IInsertReplyHouseView;
import houseproperty.manyihe.com.myh_android.view.IViewHouseCommView;


/**
 * Created by Mr.周 on 2018/4/19.
 */

public class ViewHouseCommAdapter extends RecyclerView.Adapter<ViewHouseCommAdapter.MyViewHolder> implements IInsertReplyHouseView, IViewHouseCommView {
    private Context context;
    private List<ViewHouseCommBean.ResultBeanBean.ObjectBean.ListBean> commList;
    private InsertReplyPresenter presenter;
    private SharedPreferences sp;
    private int houseId;
    private final ViewHouseCommPresenter viewHouseCommPresenter;

    public ViewHouseCommAdapter(Context context, List<ViewHouseCommBean.ResultBeanBean.ObjectBean.ListBean> commList, int houseId) {
        this.context = context;
        this.commList = commList;
        this.houseId = houseId;
        presenter = new InsertReplyPresenter(this);
        viewHouseCommPresenter = new ViewHouseCommPresenter(this);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_house_comm, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        ViewHouseCommTwoAdapter twoAdapter;
        if (commList.get(position).getHeadUrl() != null) {
            String headUrl = commList.get(position).getHeadUrl();
            Uri uri = Uri.parse(headUrl);
            holder.viewHouseCommSDV.setImageURI(uri);
        }
        holder.nameTv.setText(commList.get(position).getMobile());
        holder.timeTv.setText(commList.get(position).getTimeStr());
        holder.contentTv.setText(commList.get(position).getComment());
        LinearLayoutManager manager = new LinearLayoutManager(context);
        holder.recyclerView.setLayoutManager(manager);
        twoAdapter = new ViewHouseCommTwoAdapter(context, commList.get(position));
        holder.recyclerView.setAdapter(twoAdapter);
        holder.recyclerView.setItemAnimator(new DefaultItemAnimator());
        holder.replyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp = context.getSharedPreferences("config", context.MODE_PRIVATE);
                String code = sp.getString("code", "");
                if (code.equals("0")) {
                    View dialogView = LayoutInflater.from(context).inflate(R.layout.dialog, null);
                    final ShareBottomPopupDialog shareBottomPopupDialog = new ShareBottomPopupDialog(context, dialogView);
                    shareBottomPopupDialog.mPopupWindow.setHeight(300);
                    final EditText editText = dialogView.findViewById(R.id.dialog_edt);
                    dialogView.findViewById(R.id.dialog_enterBtn).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String s = editText.getText().toString();
                            if (s != null && !s.equals("")) {
                                int userId = sp.getInt("id", 0);
                                int id = commList.get(position).getId();
                                presenter.showInsertReplyPresenter(userId, id, s);
                                viewHouseCommPresenter.showViewHouseCommPresenter(houseId, 1, 5);
                                shareBottomPopupDialog.dismiss();
                            }
                        }
                    });
                    shareBottomPopupDialog.showPopup(holder.linearLayout);
                } else {
                    Toast.makeText(context, "请先登录在回复哦", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

    @Override
    public int getItemCount() {
        return commList == null ? 0 : commList.size();
    }

    @Override
    public void showInsertReplyView(InsertReplyBean replyBean) {

    }

    @Override
    public void showViewHouseComm(ViewHouseCommBean houseCommBean) {

    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        SimpleDraweeView viewHouseCommSDV;
        TextView nameTv, timeTv, contentTv;
        RecyclerView recyclerView;
        Button replyBtn;
        LinearLayout linearLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            viewHouseCommSDV = itemView.findViewById(R.id.view_house_comm_sdv);
            nameTv = itemView.findViewById(R.id.view_house_comm_nameTv);
            timeTv = itemView.findViewById(R.id.view_house_comm_timeTv);
            contentTv = itemView.findViewById(R.id.view_house_comm_contentTv);
            recyclerView = itemView.findViewById(R.id.view_house_comm_Rv);
            replyBtn = itemView.findViewById(R.id.view_house_comm_Reply);
            linearLayout = itemView.findViewById(R.id.view_house_comm_Ll);
        }
    }
}
