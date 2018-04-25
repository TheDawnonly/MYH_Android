package houseproperty.manyihe.com.myh_android.fragment;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import houseproperty.manyihe.com.myh_android.R;
import houseproperty.manyihe.com.myh_android.bean.MessageBean;
import houseproperty.manyihe.com.myh_android.presenter.MessagePresenter;
import houseproperty.manyihe.com.myh_android.view.IMessageView;


/**
 * Created by Mr.周 on 2018/3/19.
 */

public class MyFragment extends BaseFragment<MessagePresenter> implements IMessageView, TextView.OnEditorActionListener {
    private static MyFragment instance = new MyFragment();
    private EditText ed_word;
    private EditText ed_name;

    public static MyFragment newInstance() {
        return instance;
    }



    @Override
    public int intLayout() {
        return R.layout.fourfragment;
    }

    @Override
    public View initView() {
        ed_name = view.findViewById(R.id.name);
        ed_word = view.findViewById(R.id.word);
        return null;
    }

    @Override
    public void createPresenter() {

    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            // 当按了搜索之后关闭软键盘
            ((InputMethodManager) ed_name.getContext().getSystemService(
                    Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(
                    getActivity().getCurrentFocus().getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
            ((InputMethodManager) ed_word.getContext().getSystemService(
                    Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(
                    getActivity().getCurrentFocus().getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
            return true;
        }
        return false;
    }

    @Override
    public void showData(MessageBean MessageBean) {

    }

    @Override
    public void failMsg(String msg) {

    }
}
