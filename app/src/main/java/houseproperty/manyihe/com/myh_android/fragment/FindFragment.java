package houseproperty.manyihe.com.myh_android.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.astuetz.PagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.List;

import houseproperty.manyihe.com.myh_android.R;
import houseproperty.manyihe.com.myh_android.adapter.FindFragmentViewPageAdapter;
import houseproperty.manyihe.com.myh_android.adapter.MyViewPageAdapter;
import houseproperty.manyihe.com.myh_android.bean.MessageBean;
import houseproperty.manyihe.com.myh_android.presenter.MessagePresenter;
import houseproperty.manyihe.com.myh_android.view.IMessageView;

/**
 * Created by Mr.周 on 2018/3/19.
 */

public class FindFragment extends BaseFragment {
    private static FindFragment instance = new FindFragment();
    private PagerSlidingTabStrip tabStrip;
    private List<Fragment> fragmentList=new ArrayList<>();
    private ViewPager viewPager;
    private NewestHouseFragment newestHouseFragment=new NewestHouseFragment();
    private AllHotHouseFragment allHotHouseFragment=new AllHotHouseFragment();

    public static FindFragment newInstance() {
        return instance;
    }


    @Override
    public int intLayout() {
        return R.layout.twofragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        /*Tab与ViewPager绑定*/
        fragmentList.add(newestHouseFragment);
        fragmentList.add(allHotHouseFragment);
        /*设置Adapter*/
        viewPager.setAdapter(new FindFragmentViewPageAdapter(getActivity().getSupportFragmentManager(), fragmentList));
        tabStrip.setViewPager(viewPager);
    }

    @Override
    public View initView() {
        tabStrip = view.findViewById(R.id.find_view_tabs);
        viewPager = view.findViewById(R.id.find_view_pager);

        return view;
    }

    @Override
    public void createPresenter() {

    }

    @Override
    public void onResume() {
        super.onResume();
        if (viewPager == null) {
            viewPager.setAdapter(new FindFragmentViewPageAdapter(getActivity().getSupportFragmentManager(), fragmentList));
            tabStrip.setViewPager(viewPager);
        }

    }
}
