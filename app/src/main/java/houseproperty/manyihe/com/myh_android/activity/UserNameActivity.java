package houseproperty.manyihe.com.myh_android.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sdsmdg.tastytoast.TastyToast;

import houseproperty.manyihe.com.myh_android.R;
import houseproperty.manyihe.com.myh_android.bean.UpDataUserInfoBean;
import houseproperty.manyihe.com.myh_android.presenter.UpDataUserInfoPresenter;
import houseproperty.manyihe.com.myh_android.view.IUpDataUserInfoBeanView;

public class UserNameActivity extends BaseActivity<UpDataUserInfoPresenter> implements IUpDataUserInfoBeanView {

    private Button userNameCancel;
    private Button userNameSureYes, userNameSureNo;
    private EditText userNameEt;
    private SharedPreferences sp;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_name);
        MainActivity.MIUISetStatusBarLightMode(this, true);
        MainActivity.FlymeSetStatusBarLightMode(getWindow(), true);
        initView();
        setUserInfo();
        sp = getSharedPreferences("config", MODE_PRIVATE);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.showSoftInput(userNameEt, 0);
        showSoftInputFromWindow(this, userNameEt);
    }

    /**
     * 昵称修改操作
     */
    private void setUserInfo() {

        userNameEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s != null && !s.equals("")) {
                    userNameSureYes.setVisibility(View.VISIBLE);
                    userNameSureNo.setVisibility(View.GONE);
                }
            }
        });
        userNameCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        userNameSureYes.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                name = userNameEt.getText().toString().trim();
                int id = sp.getInt("id", 0);
                if (name != null && !name.equals("")) {
                    presenter.showUpUserInfo(id, null, name, null);
                } else {
                    TastyToast.makeText(UserNameActivity.this, "输入不能为空", TastyToast.LENGTH_SHORT, TastyToast.DEFAULT);
                    return;
                }

            }
        });
    }

    /**
     * EditText获取焦点并显示软键盘
     */
    public static void showSoftInputFromWindow(Activity activity, EditText editText) {
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
        activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
    }

    @Override
    public void createPresenter() {
        presenter = new UpDataUserInfoPresenter(this);
    }

    private void initView() {
        userNameCancel = (Button) findViewById(R.id.user_name_cancel);
        userNameSureYes = (Button) findViewById(R.id.user_name_sure_yes);
        userNameSureNo = (Button) findViewById(R.id.user_name_sure_no);
        userNameEt = (EditText) findViewById(R.id.user_name_et);
    }

    @Override
    public void getupUser(UpDataUserInfoBean dataUserInfoBean) {
        if (dataUserInfoBean.getResultBean().getCode().equals("0")) {
            finish();
        }else{
            TastyToast.makeText(this, dataUserInfoBean.getResultBean().getMessage(), TastyToast.LENGTH_SHORT,TastyToast.WARNING).show();
        }


    }
}
