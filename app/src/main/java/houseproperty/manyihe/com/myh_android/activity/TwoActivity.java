package houseproperty.manyihe.com.myh_android.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yatoooon.screenadaptation.ScreenAdapterTools;

import java.util.List;

import houseproperty.manyihe.com.myh_android.R;
import houseproperty.manyihe.com.myh_android.adapter.SelectAgentMoreAdapter;
import houseproperty.manyihe.com.myh_android.adapter.TwoActivityLikeMyHouseAdapter;
import houseproperty.manyihe.com.myh_android.bean.LikeMyhHouseBean;
import houseproperty.manyihe.com.myh_android.bean.MessageBean;
import houseproperty.manyihe.com.myh_android.presenter.LikeMyHousePresenter;
import houseproperty.manyihe.com.myh_android.presenter.MessagePresenter;
import houseproperty.manyihe.com.myh_android.view.ILikeMyHouseView;
import houseproperty.manyihe.com.myh_android.view.IMessageView;


public class TwoActivity extends BaseActivity<LikeMyHousePresenter> implements ILikeMyHouseView, TextView.OnEditorActionListener {

    private EditText editText;
    private TextView textView, noTv;
    private int pageNum = 1, pageSize = 10;
    private RelativeLayout layout;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_two);
        //屏幕适配
        //ScreenAdapterTools.getInstance().loadView((ViewGroup) getWindow().getDecorView());
        editText = findViewById(R.id.mEt);
        textView = findViewById(R.id.act_two_tv);
        layout = findViewById(R.id.two_Rl);
        noTv = findViewById(R.id.two_noTv);
        rv = findViewById(R.id.two_activityRv);
        //状态栏透明加黑色字体
        MainActivity.FlymeSetStatusBarLightMode(getWindow(), true);
        MainActivity.MIUISetStatusBarLightMode(this, true);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //输入内容后搜索
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    //showSoftInputFromWindow(TwoActivity.this, editText);
                    View view = getCurrentFocus();
                    String s = editText.getText().toString().trim();
                    if (s != null) {
                        presenter.showLikeMyHousePresenter(s, pageNum, pageSize);
                        View view1 = getCurrentFocus();
                        hideInputMethod(TwoActivity.this, view1);
                    }
                }

                return false;
            }
        });
    }

    /**
     * 搜索结果
     *
     * @param myhHouseBean
     */
    @Override
    public void showLikeMyHouseView(LikeMyhHouseBean myhHouseBean) {
        if (myhHouseBean.getResultBean().getCode().equals("0")) {
            List<LikeMyhHouseBean.ResultBeanBean.ObjectBean.ListBean> list = myhHouseBean.getResultBean().getObject().getList();
            layout.setVisibility(View.GONE);
            TwoActivityLikeMyHouseAdapter adapter = new TwoActivityLikeMyHouseAdapter(TwoActivity.this, list);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            //设置启用平滑滚动条
            layoutManager.setSmoothScrollbarEnabled(true);
            //设置自自动测量功能
            layoutManager.setAutoMeasureEnabled(true);
            rv.setLayoutManager(layoutManager);
            //具有固定大小
            rv.setHasFixedSize(true);
            rv.setNestedScrollingEnabled(false);
            rv.setAdapter(adapter);
        } else {
            layout.setVisibility(View.VISIBLE);
            noTv.setText(myhHouseBean.getResultBean().getMessage());
        }
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
        presenter = new LikeMyHousePresenter(this);
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

}
