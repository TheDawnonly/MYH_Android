package houseproperty.manyihe.com.myh_android.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
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
    private WebView webView;
    private ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN); //显示状态栏
        setContentView(R.layout.activity_message_details);
        MainActivity.MIUISetStatusBarLightMode(this, true);
        MainActivity.FlymeSetStatusBarLightMode(getWindow(), true);
        webView = findViewById(R.id.message_web);
    }

    @Override
    public void createPresenter() {
        Bundle extras = getIntent().getExtras();
        id = extras.getInt("floorId");
        presenter = new MessageDetailsPresenter(this);
        presenter.ShowData(id);
    }

    @Override
    public void showData(MessageDetailsBean MessageBean) {
        String htmlUrl = MessageBean.getResultBean().getObject().getHtmlUrl();
        Log.d("MessageDetailsActivity", "==========" + htmlUrl);
        //WebView加载本地资源
//        webView.loadUrl("file:///android_asset/example.html");
        //WebView加载web资源
        webView.loadUrl("http://m.manyihefc.com/#/Counter");
        //覆盖WebView默认通过第三方或者是系统浏览器打开网页的行为，使得网页可以在WebView中打开
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //返回值是true的时候是控制网页在WebView中去打开，如果为false调用系统浏览器或第三方浏览器打开
                view.loadUrl(url);
                return true;
            }
            //WebViewClient帮助WebView去处理一些页面控制和请求通知
        });
        //启用支持Javascript
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        //WebView加载页面优先使用缓存加载
        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        //页面加载
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                //newProgress   1-100之间的整数
                if (newProgress == 100) {
                    //页面加载完成，关闭ProgressDialog
                    closeDialog();
                } else {
                    //网页正在加载，打开ProgressDialog
                    openDialog(newProgress);
                }
            }

            private void openDialog(int newProgress) {
                if (dialog == null) {
                    dialog = new ProgressDialog(MessageDetailsActivity.this);
                    dialog.setTitle("正在加载");
                    dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                    dialog.setProgress(newProgress);
                    dialog.setCancelable(true);
                    dialog.show();
                } else {
                    dialog.setProgress(newProgress);
                }
            }

            private void closeDialog() {
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                    dialog = null;
                }
            }
        });
    }

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            if (webView.canGoBack()) {
//                webView.goBack();   //返回上一页面
//                return true;
//            } else {
//                System.exit(0);     //退出程序
//            }
//
//        }
//        return super.onKeyDown(keyCode, event);
//    }
}
