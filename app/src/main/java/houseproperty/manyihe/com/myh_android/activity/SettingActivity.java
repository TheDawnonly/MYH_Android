package houseproperty.manyihe.com.myh_android.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import houseproperty.manyihe.com.myh_android.R;

public class SettingActivity extends BaseActivity {

    private ImageView settingBack;
    private RelativeLayout setting1;
    private RelativeLayout setting2;
    private RelativeLayout setting3;
    private RelativeLayout setting4;
    private RelativeLayout setting5;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        MainActivity.MIUISetStatusBarLightMode(this, true);
        MainActivity.FlymeSetStatusBarLightMode(getWindow(), true);
        initView();
        settingBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setting5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp = getSharedPreferences("config", MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.clear();
                editor.commit();
                String name = sp.getString("name", "");
                finish();
            }
        });

    }

    @Override
    public void createPresenter() {

    }

    private void initView() {
        settingBack = (ImageView) findViewById(R.id.setting_back);
        setting1 = (RelativeLayout) findViewById(R.id.setting1);
        setting2 = (RelativeLayout) findViewById(R.id.setting2);
        setting3 = (RelativeLayout) findViewById(R.id.setting3);
        setting4 = (RelativeLayout) findViewById(R.id.setting4);
        setting5 = (RelativeLayout) findViewById(R.id.setting5);
    }
}
