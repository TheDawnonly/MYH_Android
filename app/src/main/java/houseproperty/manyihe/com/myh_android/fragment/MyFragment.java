package houseproperty.manyihe.com.myh_android.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.footer.LoadingView;
import com.sdsmdg.tastytoast.TastyToast;

import java.util.List;

import houseproperty.manyihe.com.myh_android.R;
import houseproperty.manyihe.com.myh_android.activity.LoginActivity;
import houseproperty.manyihe.com.myh_android.activity.ManagementActivity;
import houseproperty.manyihe.com.myh_android.activity.NewHouseMoreActivity;
import houseproperty.manyihe.com.myh_android.activity.RecordActivity;
import houseproperty.manyihe.com.myh_android.activity.SettingActivity;
import houseproperty.manyihe.com.myh_android.activity.selectUserActivity;
import houseproperty.manyihe.com.myh_android.adapter.MyFmNewHouseAdapter;
import houseproperty.manyihe.com.myh_android.bean.AgentDetailMessageBean;
import houseproperty.manyihe.com.myh_android.bean.HouseInfoBean;
import houseproperty.manyihe.com.myh_android.presenter.AgentDetailMessagePresenter;
import houseproperty.manyihe.com.myh_android.presenter.HousingResourcePresenterTypeNew;
import houseproperty.manyihe.com.myh_android.utils.ToastUtil;
import houseproperty.manyihe.com.myh_android.view.IAgentDetailMessageView;
import houseproperty.manyihe.com.myh_android.view.IHousingResourceViewTypeNew;


/**
 * Created by Mr.周 on 2018/3/19.
 */

public class MyFragment extends BaseFragment<AgentDetailMessagePresenter> implements IAgentDetailMessageView, IHousingResourceViewTypeNew {
    private static MyFragment instance = new MyFragment();
    private RecyclerView newHouseRv;
    private HousingResourcePresenterTypeNew housingResourcePresenterTypeNew;

    public static MyFragment newInstance() {
        return instance;
    }

    private TextView tvMobile, gang;
    private RadioButton recordRecord, radioSelect, radioCollection, radioManagement;
    private ImageView userImg, userImgLogin;
    private ImageView setting;
    private Integer type = 0;
    private int pageNum = 1, pageSize = 5;
    private boolean aBoolean = false;
    private EditText ed_word;
    private EditText ed_name;
    private Button register, enter;
    private SharedPreferences sp;
    private List<HouseInfoBean.ResultBeanBean.ObjectBean.ListBean> newestList;
    private MyFmNewHouseAdapter myFmNewHouseAdapter;

    @Override
    public int intLayout() {
        return R.layout.myfragment;
    }

    @Override
    public View initView() {
        enter = view.findViewById(R.id.my_login);
        register = view.findViewById(R.id.my_register);
        tvMobile = view.findViewById(R.id.my_mobile);
        gang = view.findViewById(R.id.my_tv_gang);
        recordRecord = view.findViewById(R.id.record);
        userImg = view.findViewById(R.id.my_img_user);
        userImgLogin = view.findViewById(R.id.my_img_user_login);
        radioSelect = view.findViewById(R.id.my_selectUser);
        setting = view.findViewById(R.id.my_setting);
        radioManagement = view.findViewById(R.id.houseManagement);
        radioCollection = view.findViewById(R.id.MyCollection);
        newHouseRv = view.findViewById(R.id.my_fragmentRv);
        view.findViewById(R.id.my_fragment_btnMore).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), NewHouseMoreActivity.class));
            }
        });
        return view;
    }

    @Override
    public void createPresenter() {
        //获取SP
        sp = getActivity().getSharedPreferences("config", getActivity().MODE_PRIVATE);
        presenter = new AgentDetailMessagePresenter(this);

        //推荐新房
        housingResourcePresenterTypeNew = new HousingResourcePresenterTypeNew(this);
        housingResourcePresenterTypeNew.ShowData(pageNum, pageSize);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //点击进入登录界面
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
        //点击进入登录界面
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
        //点击进入登录界面
        userImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
        //点击进入个人信息界面

        radioSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = sp.getString("code", "");
                if (code.equals("0")) {
                    startActivity(new Intent(getContext(), selectUserActivity.class));
                } else {
                    TastyToast.makeText(getContext(), "请先登录", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                }

            }
        });


        /**
         * 设置界面
         */
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), SettingActivity.class));
            }
        });

        /**
         * 浏览记录
         */
        recordRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), RecordActivity.class));
            }
        });

        radioManagement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ManagementActivity.class));
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        String code, agentImg;
        code = sp.getString("code", "");
        if (code.equals("0")) {
            enter.setVisibility(View.GONE);
            register.setVisibility(View.GONE);
            gang.setVisibility(View.GONE);
            tvMobile.setVisibility(View.VISIBLE);
            userImg.setVisibility(View.GONE);
            userImgLogin.setVisibility(View.VISIBLE);
            userImgLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getContext(), selectUserActivity.class));
                }
            });
            String mobile = sp.getString("mobile", "");
            tvMobile.setText(mobile);
            tvMobile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getContext(), selectUserActivity.class));
                }
            });
            type = sp.getInt("type", 0);
            if (type == 200) {
                int id = sp.getInt("id", 0);
                presenter.showAgentDetailMessagePresenter(id);
                radioManagement.setVisibility(View.VISIBLE);
                radioCollection.setVisibility(View.GONE);
                radioSelect.setEnabled(false);
                tvMobile.setEnabled(false);
                userImgLogin.setEnabled(false);
            }

        } else {
            enter.setVisibility(View.VISIBLE);
            register.setVisibility(View.VISIBLE);
            gang.setVisibility(View.VISIBLE);
            tvMobile.setVisibility(View.GONE);
            userImgLogin.setVisibility(View.GONE);
            userImg.setVisibility(View.VISIBLE);
            radioManagement.setVisibility(View.GONE);
            radioCollection.setVisibility(View.VISIBLE);
            radioSelect.setEnabled(true);
            tvMobile.setEnabled(true);
            userImgLogin.setEnabled(true);
        }
    }

    @Override
    public void getShowLogin(AgentDetailMessageBean detailMessageBean) {
        if (detailMessageBean.getResultBean().getCode().equals("0")){
            Glide.with(getContext()).load(detailMessageBean.getResultBean().getObject().getAgentImg()).into(userImgLogin);
        }

    }

    @Override
    public void showResourceHotFloorTypeNew(final HouseInfoBean hotData) {
        if (hotData.getResultBean().getObject() != null) {
            newestList = hotData.getResultBean().getObject().getList();
            LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
            layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            //设置启用平滑滚动条
            layoutManager.setSmoothScrollbarEnabled(true);
            //设置自自动测量功能
            layoutManager.setAutoMeasureEnabled(true);
            newHouseRv.setLayoutManager(layoutManager);
            //具有固定大小
            newHouseRv.setHasFixedSize(true);
            newHouseRv.setNestedScrollingEnabled(false);
            myFmNewHouseAdapter = new MyFmNewHouseAdapter(getContext(), newestList);
            newHouseRv.setAdapter(myFmNewHouseAdapter);
        }
    }
}
