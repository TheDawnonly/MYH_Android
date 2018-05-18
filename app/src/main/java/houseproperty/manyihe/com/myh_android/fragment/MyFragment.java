package houseproperty.manyihe.com.myh_android.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.sdsmdg.tastytoast.TastyToast;

import houseproperty.manyihe.com.myh_android.R;
import houseproperty.manyihe.com.myh_android.activity.LoginActivity;
import houseproperty.manyihe.com.myh_android.activity.RecordActivity;
import houseproperty.manyihe.com.myh_android.activity.SettingActivity;
import houseproperty.manyihe.com.myh_android.activity.UserNameActivity;
import houseproperty.manyihe.com.myh_android.activity.selectUserActivity;


/**
 * Created by Mr.周 on 2018/3/19.
 */

public class MyFragment extends Fragment {
    private static MyFragment instance = new MyFragment();
    private TextView tvMobile, gang;
    private RadioButton recordButton;
    private ImageView userImg, userImgLogin;
    private RadioButton radioSelect;
    private ImageView setting;

    public static MyFragment newInstance() {
        return instance;
    }

    private EditText ed_word;
    private EditText ed_name;
    private Button register, enter;
    private SharedPreferences sp;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.myfragment, null);
        enter = view.findViewById(R.id.my_login);
        register = view.findViewById(R.id.my_register);
        tvMobile = view.findViewById(R.id.my_mobile);
        gang = view.findViewById(R.id.my_tv_gang);
        recordButton = view.findViewById(R.id.record);
        userImg = view.findViewById(R.id.my_img_user);
        userImgLogin = view.findViewById(R.id.my_img_user_login);
        radioSelect = view.findViewById(R.id.my_selectUser);
        setting = view.findViewById(R.id.my_setting);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //获取SP
        sp = getActivity().getSharedPreferences("config", getActivity().MODE_PRIVATE);
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
                    TastyToast.makeText(getContext(), "请先登录啦喵", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
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
        recordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), RecordActivity.class));
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        String code;
        code = sp.getString("code", "");
        if (code.equals("0")) {
            enter.setVisibility(View.GONE);
            register.setVisibility(View.GONE);
            gang.setVisibility(View.GONE);
            tvMobile.setVisibility(View.VISIBLE);
            userImg.setVisibility(View.GONE);
            userImgLogin.setVisibility(View.VISIBLE);
            String mobile = sp.getString("mobile", "");
            tvMobile.setText(mobile);
            tvMobile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getContext(), selectUserActivity.class));
                }
            });
        }else{
            enter.setVisibility(View.VISIBLE);
            register.setVisibility(View.VISIBLE);
            gang.setVisibility(View.VISIBLE);
            tvMobile.setVisibility(View.GONE);
        }
    }
}
