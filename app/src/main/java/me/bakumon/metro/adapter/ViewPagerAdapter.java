package me.bakumon.metro.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;

import me.bakumon.metro.base.BaseFragment;
import me.bakumon.metro.business.discover.ui.DiscoverFragment;
import me.bakumon.metro.business.metro.ui.MetroFragment;
import me.bakumon.metro.business.mine.ui.MineFragment;

/**
 * 首页 ViewPager FragmentPager 适配器
 * 提供首页三个 tab 对于的 Fragment
 *
 * @author Bakumon
 * @date 2018/1/6
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<BaseFragment> fragments = new ArrayList<>();
    private BaseFragment currentFragment;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);

        fragments.clear();
        fragments.add(new MetroFragment());
        fragments.add(new DiscoverFragment());
        fragments.add(new MineFragment());
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        if (getCurrentFragment() != object) {
            currentFragment = ((BaseFragment) object);
        }
        super.setPrimaryItem(container, position, object);
    }

    /**
     * 获取当前 Fragment
     */
    public BaseFragment getCurrentFragment() {
        return currentFragment;
    }
}