package houseproperty.manyihe.com.myh_android.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.astuetz.PagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import houseproperty.manyihe.com.myh_android.R;
import houseproperty.manyihe.com.myh_android.adapter.MyViewPageAdapter;
import houseproperty.manyihe.com.myh_android.fragment.HomeFragment;
import houseproperty.manyihe.com.myh_android.fragment.HotHouseFragment;
import houseproperty.manyihe.com.myh_android.fragment.NewHouseFragment;

public class RecordActivity extends BaseActivity {
    private ViewPager pager;
    private List<String> list;
    private PagerSlidingTabStrip pagerTabStrip;
    private List<Fragment> fragmentList = new ArrayList<>();
    NewHouseFragment newHouseFragment = new NewHouseFragment();
    HotHouseFragment hotHouseFragment = new HotHouseFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        MainActivity.MIUISetStatusBarLightMode(this, true);
        MainActivity.FlymeSetStatusBarLightMode(getWindow(), true);
        /*初始化界面*/
        initViews();
        /*Tab与ViewPager绑定*/
        fragmentList.add(newHouseFragment);
        fragmentList.add(hotHouseFragment);
        /*设置Adapter*/
        pager.setAdapter(new MyViewPageAdapter(getSupportFragmentManager(), fragmentList));
        pagerTabStrip.setViewPager(pager);
    }

    /*初始化界面*/
    private void initViews() {
        pager = findViewById(R.id.recode_view_pager);
        pagerTabStrip = findViewById(R.id.recode_view_tabs);
        findViewById(R.id.record_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    public void createPresenter() {

    }
}
