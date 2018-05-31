package houseproperty.manyihe.com.myh_android.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.sdsmdg.tastytoast.TastyToast;

import houseproperty.manyihe.com.myh_android.R;
import houseproperty.manyihe.com.myh_android.bean.LoginBean;
import houseproperty.manyihe.com.myh_android.presenter.LoginPresenter;
import houseproperty.manyihe.com.myh_android.utils.PhoneNumIsBoolean;
import houseproperty.manyihe.com.myh_android.utils.RadioButtonIsBoolean;
import houseproperty.manyihe.com.myh_android.view.ILoginBeanView;

public class LoginActivity extends BaseActivity<LoginPresenter> implements ILoginBeanView {

    private Button register;
    private RadioButtonIsBoolean valueLogin = new RadioButtonIsBoolean();
    private EditText loginMobileEt, loginPasswordEt;
    private String loginMobile, loginPassword;
    private RadioButton loginRadio;
    private Button loginBtnNo, loginBtnYes;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        MainActivity.MIUISetStatusBarLightMode(this, true);
        MainActivity.FlymeSetStatusBarLightMode(getWindow(), true);
        sp = getSharedPreferences("config", LoginActivity.MODE_PRIVATE);
        initView();
        //关闭当前页面返回上层
        findViewById(R.id.login_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //忘记密码
        findViewById(R.id.find_password).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, FindPassWordActivity.class));
                finish();
            }
        });
        register = findViewById(R.id.register);
        //editText.setInputType(InputType.TYPE_CLASS_NUMBER);
        register.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
        loginRadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isCheck = valueLogin.isCheck();
                if (isCheck) {
                    if (v == loginRadio) loginRadio.setChecked(false);
                    loginBtnYes.setVisibility(View.GONE);
                    loginBtnNo.setVisibility(View.VISIBLE);
                } else {
                    if (v == loginRadio) loginRadio.setChecked(true);
                    loginBtnYes.setVisibility(View.VISIBLE);
                    loginBtnNo.setVisibility(View.GONE);
                    loginBtnYes.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (loginMobileEt.getText().toString() != null && !loginMobileEt.getText().toString().equals("")) {
                                loginMobile = loginMobileEt.getText().toString();
                                boolean mobile = PhoneNumIsBoolean.isMobile(loginMobile);
                                if (mobile == false) {
                                    TastyToast.makeText(getApplicationContext(), "手机号有误", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                                    return;
                                }
                            } else {
                                TastyToast.makeText(getApplicationContext(), "请输入手机号", TastyToast.LENGTH_SHORT, TastyToast.WARNING);
                                return;
                            }
                            if (loginPasswordEt.getText().toString() != null && !loginPasswordEt.getText().toString().equals("")) {
                                if (loginPasswordEt.getText().toString().length() < 6) {
                                    TastyToast.makeText(getApplicationContext(), "密码长度最少6位哦", TastyToast.LENGTH_SHORT, TastyToast.WARNING);
                                    return;
                                } else {
                                    loginPassword = loginPasswordEt.getText().toString();
                                }
                            }
                            presenter.showLogin(loginMobile, loginPassword);
                        }
                    });
                }
                valueLogin.setCheck(!isCheck);
            }
        });
        findViewById(R.id.agent_enterBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, AgentLoginActivity.class));
                finish();
            }
        });
    }


    @Override
    public void createPresenter() {
        presenter = new LoginPresenter(this);
    }

    @Override
    public void getShowLogin(LoginBean loginBean) {
        SharedPreferences.Editor edit = sp.edit();
        if (loginBean.getResultBean().getCode().equals("0")) {
            edit.putString("code", loginBean.getResultBean().getCode());
            edit.putString("mobile", loginBean.getResultBean().getObject().getMobile());
            edit.putString("head", loginBean.getResultBean().getObject().getHeadUrl());
            edit.putString("houseId", loginBean.getResultBean().getObject().getHouseId());
            edit.putString("name", loginBean.getResultBean().getObject().getName());
            edit.putString("password", loginBean.getResultBean().getObject().getPassword());
            edit.putInt("id", loginBean.getResultBean().getObject().getId());
            //提交edit
            edit.commit();
            finish();
        } else {
            TastyToast.makeText(getApplicationContext(), loginBean.getResultBean().getMessage(), TastyToast.LENGTH_SHORT, TastyToast.ERROR);
        }
    }

    /**
     * 找控件
     */
    private void initView() {
        loginMobileEt = (EditText) findViewById(R.id.login_mobile);
        loginPasswordEt = (EditText) findViewById(R.id.login_password);
        loginRadio = (RadioButton) findViewById(R.id.login_radio_btn);
        loginBtnNo = (Button) findViewById(R.id.login_btnNo);
        loginBtnYes = (Button) findViewById(R.id.login_btnYes);
        loginMobileEt.setInputType(InputType.TYPE_CLASS_NUMBER);
    }
}
