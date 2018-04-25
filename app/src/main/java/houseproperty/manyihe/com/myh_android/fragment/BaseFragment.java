package houseproperty.manyihe.com.myh_android.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yatoooon.screenadaptation.ScreenAdapterTools;

import houseproperty.manyihe.com.myh_android.presenter.IPresenter;


/**
 * Created by Mr.周 on 2018/3/19.
 */

public abstract class BaseFragment<T extends IPresenter> extends Fragment {
    T presenter;
    View view;
    protected Activity mActivity;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getContext(), intLayout(), null);

        createPresenter();
        ScreenAdapterTools.getInstance().loadView((ViewGroup) view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
    }

    public abstract int intLayout();

    public abstract View initView();

    public abstract void createPresenter();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detach();
        }
    }

}
