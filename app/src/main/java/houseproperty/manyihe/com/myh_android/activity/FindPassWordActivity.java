package houseproperty.manyihe.com.myh_android.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.sdsmdg.tastytoast.TastyToast;

import houseproperty.manyihe.com.myh_android.R;
import houseproperty.manyihe.com.myh_android.bean.FindPassWordBean;
import houseproperty.manyihe.com.myh_android.bean.VailCodeBean;
import houseproperty.manyihe.com.myh_android.presenter.FindPassPresenter;
import houseproperty.manyihe.com.myh_android.presenter.VailCodePresenter;
import houseproperty.manyihe.com.myh_android.utils.CountDownTimerUtils;
import houseproperty.manyihe.com.myh_android.utils.PhoneNumIsBoolean;
import houseproperty.manyihe.com.myh_android.utils.RadioButtonIsBoolean;
import houseproperty.manyihe.com.myh_android.view.IFindPassWordBeanView;
import houseproperty.manyihe.com.myh_android.view.IVailCodeBeanView;

public class FindPassWordActivity extends BaseActivity<FindPassPresenter> implements IFindPassWordBeanView, IVailCodeBeanView {


    private ImageView findBack;
    private Button findValiCodeBtn;
    private EditText findPasswordMobile, findPasswordValiCode, findPassword;
    private String strMobile, strValiCode, strPassword;
    private RadioButton findPasswordRadio;
    private Button findPasswordBtnNo, findPasswordBtnYes;
    private RadioButtonIsBoolean valueLogin = new RadioButtonIsBoolean();
    private VailCodePresenter vailCodePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_pass_word);
        MainActivity.MIUISetStatusBarLightMode(this, true);
        MainActivity.FlymeSetStatusBarLightMode(getWindow(), true);
        initView();
        //关闭当前页面
        findBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        findPasswordRadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isCheck = valueLogin.isCheck();
                if (isCheck) {
                    if (v == findPasswordRadio) findPasswordRadio.setChecked(false);
                    findPasswordBtnYes.setVisibility(View.GONE);
                    findPasswordBtnNo.setVisibility(View.VISIBLE);
                } else {
                    if (v == findPasswordRadio) findPasswordRadio.setChecked(true);
                    findPasswordBtnYes.setVisibility(View.VISIBLE);
                    findPasswordBtnNo.setVisibility(View.GONE);
                    findPasswordBtnYes.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (findPasswordMobile.getText().toString() != null && !findPasswordMobile.getText().toString().equals("")) {
                                strMobile = findPasswordMobile.getText().toString();
                                boolean mobile = PhoneNumIsBoolean.isMobile(strMobile);
                                if (mobile == false) {
                                    TastyToast.makeText(getApplicationContext(), "手机号有误", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                                    return;
                                }
                            } else {
                                TastyToast.makeText(getApplicationContext(), "请输入手机号", TastyToast.LENGTH_SHORT, TastyToast.WARNING);
                                return;
                            }
                            if (findPasswordValiCode.getText().toString() != null && !findPasswordValiCode.getText().toString().equals("")) {
                                strValiCode = findPasswordValiCode.getText().toString();
                            } else {
                                TastyToast.makeText(getApplicationContext(), "请输入验证码", TastyToast.LENGTH_SHORT, TastyToast.WARNING);
                                return;
                            }
                            if (findPassword.getText().toString() != null && !findPassword.getText().toString().equals("")) {
                                if (findPassword.getText().toString().length() < 6) {
                                    TastyToast.makeText(getApplicationContext(), "密码长度最少6位哦", TastyToast.LENGTH_SHORT, TastyToast.WARNING);
                                    return;
                                } else {
                                    strPassword = findPassword.getText().toString();
                                }
                            }
                            presenter.showFindPass(strMobile, strPassword, strValiCode);
                        }
                    });
                }
                valueLogin.setCheck(!isCheck);
            }
        });

        findValiCodeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = findPasswordMobile.getText().toString();
                if (s != null && !s.equals("")) {
                    boolean isMobile = PhoneNumIsBoolean.isMobile(s);
                    if (isMobile == true) {
                        vailCodePresenter.showVailCode(s, "revamp");
                        CountDownTimerUtils utils = new CountDownTimerUtils(findValiCodeBtn, 60000, 1000);
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

    }

    @Override
    public void createPresenter() {
        presenter = new FindPassPresenter(this);
        vailCodePresenter = new VailCodePresenter(this);
    }

    @Override
    public void getShowPass(FindPassWordBean passWordBean) {
        if (passWordBean.getResultBean().getCode().equals("0")) {
            TastyToast.makeText(getApplicationContext(), "修改成功", TastyToast.LENGTH_SHORT, TastyToast.SUCCESS);
            startActivity(new Intent(FindPassWordActivity.this, LoginActivity.class));
            finish();
        } else {
            TastyToast.makeText(getApplicationContext(), passWordBean.getResultBean().getMessage(), TastyToast.LENGTH_SHORT, TastyToast.WARNING);
        }
    }

    @Override
    public void getShowVailCode(VailCodeBean vailCodeBean) {
        if (vailCodeBean.getResultBean().getCode().equals("0")) {
            TastyToast.makeText(getApplicationContext(), "已发送验证码", TastyToast.LENGTH_SHORT, TastyToast.SUCCESS);
        } else {
            TastyToast.makeText(getApplicationContext(), vailCodeBean.getResultBean().getMessage(), TastyToast.LENGTH_SHORT, TastyToast.WARNING);
        }
    }

    private void initView() {
        findBack = (ImageView) findViewById(R.id.find_back);
        findPasswordMobile = (EditText) findViewById(R.id.find_password_mobile);
        findValiCodeBtn = findViewById(R.id.find_password_valiCode_tv);
        findPasswordValiCode = (EditText) findViewById(R.id.find_password_valiCode);
        findPassword = (EditText) findViewById(R.id.new_password);
        findPasswordRadio = (RadioButton) findViewById(R.id.find_password_radio);
        findPasswordBtnNo = (Button) findViewById(R.id.find_password_btnNo);
        findPasswordBtnYes = (Button) findViewById(R.id.find_password_btnYes);
        findPasswordMobile.setInputType(InputType.TYPE_CLASS_NUMBER);
        findPasswordValiCode.setInputType(InputType.TYPE_CLASS_NUMBER);
    }


}
