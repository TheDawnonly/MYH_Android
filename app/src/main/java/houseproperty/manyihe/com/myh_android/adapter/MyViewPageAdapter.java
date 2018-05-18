package houseproperty.manyihe.com.myh_android.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;


public class MyViewPageAdapter extends FragmentPagerAdapter {

    private List<Fragment> list;
    private List<String> strList = new ArrayList<>();

    public MyViewPageAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        strList.add("一手房源");
        strList.add("最新楼盘");
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return strList.get(position);
    }
}
