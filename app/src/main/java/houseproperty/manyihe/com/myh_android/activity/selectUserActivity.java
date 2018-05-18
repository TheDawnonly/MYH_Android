package houseproperty.manyihe.com.myh_android.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sdsmdg.tastytoast.TastyToast;

import java.io.File;

import houseproperty.manyihe.com.myh_android.R;
import houseproperty.manyihe.com.myh_android.bean.UserInfoShowBean;
import houseproperty.manyihe.com.myh_android.presenter.UserInfoShowPresenter;
import houseproperty.manyihe.com.myh_android.view.IUserInfoBeanView;

public class selectUserActivity extends BaseActivity<UserInfoShowPresenter> implements IUserInfoBeanView {

    private RelativeLayout headRl, headName, headEmail, headPassword;
    private Button headRlBtn, headNameBtn, headEmailBtn, headPasswordBtn;
    private static final int TAKE_PHOTO_REQUEST_TWO = 444;
    private static final int TAKE_PHOTO_REQUEST_THREE = 555;

    private Uri imageUri;
    private TextView getName, getMobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_user);
        MainActivity.MIUISetStatusBarLightMode(this, true);
        MainActivity.FlymeSetStatusBarLightMode(getWindow(), true);
        initView();
        onClick();
    }

    @Override
    public void createPresenter() {
        presenter = new UserInfoShowPresenter(this);
        SharedPreferences sp;
        sp = getSharedPreferences("config", MODE_PRIVATE);
        int id = sp.getInt("id", 0);
        presenter.showUserInfoShow(id);
    }

    @Override
    public void getUserInfoShow(UserInfoShowBean infoShowBean) {
        getName.setText(infoShowBean.getResultBean().getObject().getName());
        getMobile.setText(infoShowBean.getResultBean().getObject().getMobile());
    }

    /**
     * 点击事件
     */
    private void onClick() {
        headRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickImageFromAlbum2();
            }
        });
        headName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(selectUserActivity.this, UserNameActivity.class));
                finish();
            }
        });
        headEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TastyToast.makeText(selectUserActivity.this, "点击了", TastyToast.LENGTH_SHORT, TastyToast.SUCCESS);
            }
        });
        headPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TastyToast.makeText(selectUserActivity.this, "点击了", TastyToast.LENGTH_SHORT, TastyToast.SUCCESS);
            }
        });
        headRlBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        headNameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        headEmailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        headPasswordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(selectUserActivity.this, FindPassWordActivity.class));
            }
        });
    }


    public void pickImageFromAlbum2() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_PICK);
        intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, 222);

    }

    private void initView() {
        headRl = (RelativeLayout) findViewById(R.id.head_rl);
        headName = (RelativeLayout) findViewById(R.id.head_name);
        headEmail = (RelativeLayout) findViewById(R.id.head_email);
        headPassword = (RelativeLayout) findViewById(R.id.head_password);
        headRlBtn = (Button) findViewById(R.id.head_rl_btn);
        headNameBtn = (Button) findViewById(R.id.head_name_btn);
        headEmailBtn = (Button) findViewById(R.id.head_email_btn);
        headPasswordBtn = (Button) findViewById(R.id.head_password_btn);
        getName = findViewById(R.id.get_name);
        getMobile = findViewById(R.id.get_mobile);
        findViewById(R.id.select_user_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        switch (requestCode) {
            case 222:
                if (resultCode == RESULT_CANCELED) {
                    TastyToast.makeText(getApplicationContext(), "取消从相册选择", TastyToast.LENGTH_SHORT, TastyToast.INFO);
                    return;
                }

                try {
                    imageUri = data.getData();
                    Uri selectedImage = data.getData();
                    String[] filePathColumn = {MediaStore.Images.Media.DATA};
                    Cursor cursor = this.getContentResolver().query(selectedImage,
                            filePathColumn, null, null, null);
                    cursor.moveToFirst();
                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    //picturePath就是图片在储存卡所在的位置
                    String picturePath = cursor.getString(columnIndex);
                    Log.d("selectUserActivity", "=========" + picturePath);
                    File file = new File(picturePath);
                    cursor.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case TAKE_PHOTO_REQUEST_TWO:
                if (resultCode == RESULT_CANCELED) {
                    delteImageUri(selectUserActivity.this, imageUri);
                    return;
                }

                break;
            case TAKE_PHOTO_REQUEST_THREE:
                if (resultCode == RESULT_CANCELED) {
                    TastyToast.makeText(getApplicationContext(), "取消从相册选择", TastyToast.LENGTH_SHORT, TastyToast.INFO);
                    return;
                }
                break;
            default:
                break;

        }


    }

    public static void delteImageUri(Context context, Uri uri) {
        context.getContentResolver().delete(uri, null, null);

    }
}
