package houseproperty.manyihe.com.myh_android.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.yatoooon.screenadaptation.ScreenAdapterTools;

import houseproperty.manyihe.com.myh_android.R;
import houseproperty.manyihe.com.myh_android.bean.MessageBean;
import houseproperty.manyihe.com.myh_android.presenter.MessagePresenter;
import houseproperty.manyihe.com.myh_android.view.IMessageView;


public class TwoActivity extends BaseActivity<MessagePresenter> implements IMessageView, TextView.OnEditorActionListener {

    private EditText editText;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_two);
        //屏幕适配
        ScreenAdapterTools.getInstance().loadView((ViewGroup) getWindow().getDecorView());
        editText = findViewById(R.id.mEt);
        textView = findViewById(R.id.act_two_tv);
        editText.setOnEditorActionListener(this);
        showSoftInputFromWindow(this, editText);
        //状态栏透明加黑色字体
        MainActivity.FlymeSetStatusBarLightMode(getWindow(), true);
        MainActivity.MIUISetStatusBarLightMode(this, true);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
//        Gson gson = new Gson();
//        Map<String, Integer> hotM = new HashMap<>();
//        hotM.put("pageNum", 1);
//        hotM.put("pageSize", 10);
//        hotM.put("type", 1);
//        String hotJson = gson.toJson(hotM);
//        ViseHttp.POST("viewHouseInfo")
//                .tag("12131313")
//                .setJson(hotJson)
//                .request(new ACallback<HousingResourceHotFloorBean>() {
//                    @Override
//                    public void onSuccess(HousingResourceHotFloorBean data) {
//
//                    }
//
//                    @Override
//                    public void onFail(int errCode, String errMsg) {
//                        Log.d("TwoActivity", "======"+errCode);
//                        Log.d("TwoActivity", "======"+errMsg);
//                    }
//                });
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

    }


    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            // 当按了搜索之后关闭软键盘
            ((InputMethodManager) editText.getContext().getSystemService(
                    Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(
                    TwoActivity.this.getCurrentFocus().getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
            return true;
        }
        return false;
    }

    //隐藏软键盘的方法。
    public static Boolean hideInputMethod(Context context, View v) {
        InputMethodManager imm = (InputMethodManager) context
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            return imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
        return false;
    }

    //判断当前点击屏幕的地方是否是软键盘
    public static boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] leftTop = {0, 0};
            v.getLocationInWindow(leftTop);
            int left = leftTop[0], top = leftTop[1], bottom = top + v.getHeight(), right = left
                    + v.getWidth();
            if (event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom) {
                // 保留点击EditText的事件
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    //事件分发机制
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideInput(v, ev)) {
                if (hideInputMethod(this, v)) {
                    //return true; //隐藏键盘时，其他控件不响应点击事件==》注释则不拦截点击事件
                }
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public void showData(MessageBean MessageBean) {

    }

    @Override
    public void failMsg(String msg) {

    }
}
