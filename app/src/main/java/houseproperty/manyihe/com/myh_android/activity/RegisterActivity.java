package houseproperty.manyihe.com.myh_android.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.sdsmdg.tastytoast.TastyToast;

import houseproperty.manyihe.com.myh_android.R;
import houseproperty.manyihe.com.myh_android.bean.RegisterBean;
import houseproperty.manyihe.com.myh_android.bean.VailCodeBean;
import houseproperty.manyihe.com.myh_android.presenter.RegisterPresenter;
import houseproperty.manyihe.com.myh_android.presenter.VailCodePresenter;
import houseproperty.manyihe.com.myh_android.utils.CountDownTimerUtils;
import houseproperty.manyihe.com.myh_android.utils.RadioButtonIsBoolean;
import houseproperty.manyihe.com.myh_android.utils.PhoneNumIsBoolean;
import houseproperty.manyihe.com.myh_android.view.IRegisterBeanView;
import houseproperty.manyihe.com.myh_android.view.IVailCodeBeanView;

public class RegisterActivity extends BaseActivity<RegisterPresenter> implements IRegisterBeanView, IVailCodeBeanView {
    private String mobile, valiCode, password;
    private EditText mobileEt, valiCodeEt, passwordEt;
    private RadioButtonIsBoolean globalValue = new RadioButtonIsBoolean();
    private RadioButton radioButton;
    private Button register_btnNo, register_btnYes;
    private TextView valiCodeBtn;
    private VailCodePresenter vailCodePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        MainActivity.MIUISetStatusBarLightMode(this, true);
        MainActivity.FlymeSetStatusBarLightMode(getWindow(), true);
        mobileEt = findViewById(R.id.register_mobile);
        valiCodeEt = findViewById(R.id.register_valiCode);
        passwordEt = findViewById(R.id.register_password);
        register_btnNo = findViewById(R.id.register_btnNo);
        radioButton = findViewById(R.id.radio);
        register_btnYes = findViewById(R.id.register_btnYes);
        valiCodeBtn = findViewById(R.id.register_valiCode_Btn);
        findViewById(R.id.register_loginBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                finish();
            }
        });
        valiCodeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = mobileEt.getText().toString();
                if (s != null && !s.equals("")) {
                    boolean isMobile = PhoneNumIsBoolean.isMobile(s);
                    if (isMobile == true) {
                        vailCodePresenter.showVailCode(s, "regist");
                        TastyToast.makeText(getApplicationContext(), "验证码已发送", TastyToast.LENGTH_SHORT, TastyToast.SUCCESS);
                        CountDownTimerUtils utils = new CountDownTimerUtils(valiCodeBtn, 60000, 1000);
                        utils.start();
                    } else {
                        TastyToast.makeText(getApplicationContext(), "手机号有误", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                    }
                } else {
                    TastyToast.makeText(getApplicationContext(), "请输入手机号", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                    return;
                }


            }
        });
        findViewById(R.id.register_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isCheck = globalValue.isCheck();
                if (isCheck) {
                    if (v == radioButton) radioButton.setChecked(false);
                    register_btnYes.setVisibility(View.GONE);
                    register_btnNo.setVisibility(View.VISIBLE);
                } else {
                    if (v == radioButton) radioButton.setChecked(true);
                    register_btnYes.setVisibility(View.VISIBLE);
                    register_btnNo.setVisibility(View.GONE);
                    register_btnYes.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (mobileEt.getText().toString() != null && !mobileEt.getText().toString().equals("")) {
                                mobile = mobileEt.getText().toString();
                                boolean isMobile = PhoneNumIsBoolean.isMobile(mobile);
                                if (isMobile == false) {
                                    TastyToast.makeText(getApplicationContext(), "手机号有误", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                                    return;
                                }
                            } else {
                                TastyToast.makeText(getApplicationContext(), "请输入手机号", TastyToast.LENGTH_SHORT, TastyToast.WARNING);
                                return;
                            }

                            if (valiCodeEt.getText().toString() != null && !valiCodeEt.getText().toString().equals("")) {
                                valiCode = valiCodeEt.getText().toString();
                            } else {
                                TastyToast.makeText(getApplicationContext(), "请输入验证码", TastyToast.LENGTH_SHORT, TastyToast.WARNING);
                                return;
                            }
                            if (passwordEt.getText().toString() != null && !passwordEt.getText().toString().equals("")) {
                                if (passwordEt.getText().toString().length() < 6) {
                                    TastyToast.makeText(getApplicationContext(), "密码长度最少6位哦", TastyToast.LENGTH_SHORT, TastyToast.WARNING);
                                    return;
                                } else {
                                    password = passwordEt.getText().toString();
                                }

                            } else {
                                TastyToast.makeText(getApplicationContext(), "请输入密码", TastyToast.LENGTH_SHORT, TastyToast.WARNING);
                                return;
                            }
                            presenter.showRegister(mobile, valiCode, password);
                        }
                    });
                }
                globalValue.setCheck(!isCheck);
            }
        });
        valiCodeEt.setInputType(InputType.TYPE_CLASS_NUMBER);
        mobileEt.setInputType(InputType.TYPE_CLASS_NUMBER);
    }


    @Override
    public void createPresenter() {
        presenter = new RegisterPresenter(this);
        vailCodePresenter = new VailCodePresenter(this);
    }

    //注册
    @Override
    public void getShowRegister(RegisterBean registerBean) {
        if (registerBean.getResultBean().getCode().equals("0")) {
            TastyToast.makeText(getApplicationContext(), registerBean.getResultBean().getMessage(), TastyToast.LENGTH_SHORT, TastyToast.SUCCESS);
            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            finish();
        } else {
            TastyToast.makeText(getApplicationContext(), registerBean.getResultBean().getMessage(), TastyToast.LENGTH_SHORT, TastyToast.WARNING);
        }
        Log.d("RegisterActivity", "==========" + registerBean.getResultBean().getMessage());
    }

    //获取验证码
    @Override
    public void getShowVailCode(VailCodeBean vailCodeBean) {
        if (!vailCodeBean.getResultBean().getCode().equals("0")) {
            TastyToast.makeText(getApplicationContext(), vailCodeBean.getResultBean().getMessage(), TastyToast.LENGTH_SHORT, TastyToast.WARNING);
        }

    }
}
