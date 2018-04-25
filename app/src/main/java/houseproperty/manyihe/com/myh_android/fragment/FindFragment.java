package houseproperty.manyihe.com.myh_android.fragment;

import android.view.View;

import houseproperty.manyihe.com.myh_android.R;
import houseproperty.manyihe.com.myh_android.bean.MessageBean;
import houseproperty.manyihe.com.myh_android.presenter.MessagePresenter;
import houseproperty.manyihe.com.myh_android.view.IMessageView;

/**
 * Created by Mr.周 on 2018/3/19.
 */

public class FindFragment extends BaseFragment<MessagePresenter> implements IMessageView {
    private static FindFragment instance = new FindFragment();

    public static FindFragment newInstance() {
        return instance;
    }


    @Override
    public int intLayout() {
        return R.layout.twofragment;
    }

    @Override
    public View initView() {

        return null;
    }

    @Override
    public void createPresenter() {

    }

    @Override
    public void showData(MessageBean MessageBean) {

    }

    @Override
    public void failMsg(String msg) {

    }
}
