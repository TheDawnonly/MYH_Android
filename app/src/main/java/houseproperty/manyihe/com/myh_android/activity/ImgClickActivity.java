package houseproperty.manyihe.com.myh_android.activity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import houseproperty.manyihe.com.myh_android.R;

public class ImgClickActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img_click);
        String uriImg = getIntent().getStringExtra("uri");
        ImageView imageView = findViewById(R.id.img_activity_img);
        Glide.with(this).load(uriImg).into(imageView);
    }

    @Override
    public void createPresenter() {

    }
}
