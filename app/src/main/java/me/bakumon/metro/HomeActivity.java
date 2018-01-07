package me.bakumon.metro;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;

import java.util.ArrayList;

import me.bakumon.metro.adapter.ViewPagerAdapter;
import me.bakumon.metro.base.BaseActivity;
import me.bakumon.metro.base.BaseFragment;
import me.bakumon.metro.databinding.ActivityHomeBinding;

/**
 * @author Bakumon
 * @date 2018/1/6
 */
public class HomeActivity extends BaseActivity implements AHBottomNavigation.OnTabSelectedListener {

    private ActivityHomeBinding binding;
    private ViewPagerAdapter adapter;
    private BaseFragment currentFragment;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected boolean setRootViewPadding() {
        return false;
    }

    @Override
    protected void onInit() {
        binding = getDataBinding();
        setupBottomNavigation();
        setupViewPager();
    }

    @Override
    public boolean isSupportSwipeBack() {
        return false;
    }

    private void setupBottomNavigation() {
        AHBottomNavigationItem tab1 = new AHBottomNavigationItem(getResources().getString(R.string.tab_local), R.drawable.ic_tab_local);
        AHBottomNavigationItem tab2 = new AHBottomNavigationItem(getResources().getString(R.string.tab_discover), R.drawable.ic_tab_discover);
        AHBottomNavigationItem tab3 = new AHBottomNavigationItem(getResources().getString(R.string.tab_mine), R.drawable.ic_tab_mine);

        ArrayList<AHBottomNavigationItem> bottomNavigationItems = new ArrayList<>();
        bottomNavigationItems.add(tab1);
        bottomNavigationItems.add(tab2);
        bottomNavigationItems.add(tab3);

        binding.bottomNavigation.addItems(bottomNavigationItems);
        binding.bottomNavigation.setAccentColor(getResources().getColor(R.color.colorAccent));
        binding.bottomNavigation.setOnTabSelectedListener(this);
        binding.bottomNavigation.setTranslucentNavigationEnabled(true);

        // 隐藏 tab 的文字
//        binding.bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_HIDE);
    }

    private void setupViewPager() {
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        binding.viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onTabSelected(int position, boolean wasSelected) {
        if (wasSelected) {
            return false;
        }

        if (currentFragment == null) {
            currentFragment = adapter.getCurrentFragment();
        }
        if (currentFragment != null) {
            currentFragment.willBeHidden();
        }

        binding.viewPager.setCurrentItem(position, false);
        currentFragment = adapter.getCurrentFragment();
        if (currentFragment != null) {
            currentFragment.willBeDisplayed();
        }
        return true;
    }
}
