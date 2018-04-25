package houseproperty.manyihe.com.myh_android.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.TextView;

import com.youth.banner.Banner;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import houseproperty.manyihe.com.myh_android.R;
import houseproperty.manyihe.com.myh_android.bean.MessageDetailsBean;
import houseproperty.manyihe.com.myh_android.presenter.MessageDetailsPresenter;
import houseproperty.manyihe.com.myh_android.utils.BannerImageLoader;
import houseproperty.manyihe.com.myh_android.utils.HotFloorDetailsBannerImageLoader;
import houseproperty.manyihe.com.myh_android.view.IMessageDetailsView;

public class MessageDetailsActivity extends BaseActivity<MessageDetailsPresenter> implements IMessageDetailsView {

    private int id;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN); //显示状态栏
        setContentView(R.layout.activity_message_details);
        textView = findViewById(R.id.message_details_tv);
        MainActivity.MIUISetStatusBarLightMode(this, true);
        MainActivity.FlymeSetStatusBarLightMode(getWindow(), true);
    }

    @Override
    public void createPresenter() {
        Bundle extras = getIntent().getExtras();
        id = extras.getInt("messageID");
        presenter = new MessageDetailsPresenter(this);
        presenter.ShowData(id);
    }

    @Override
    public void showData(MessageDetailsBean MessageBean) {

    }
}
