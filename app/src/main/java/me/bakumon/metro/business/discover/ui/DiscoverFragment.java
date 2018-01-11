package me.bakumon.metro.business.discover.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import me.bakumon.metro.R;
import me.bakumon.metro.base.BaseFragment;
import me.bakumon.metro.databinding.FragmentDiscoverBinding;

/**
 * 发现 fragment
 *
 * @author Bakumon
 * @date 2018/1/6
 */

public class DiscoverFragment extends BaseFragment {

    private FragmentDiscoverBinding binding;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_discover;
    }

    @Override
    protected void onInit(@Nullable Bundle savedInstanceState) {
        binding = getDataBinding();
    }
}
