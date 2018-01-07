package me.bakumon.metro.business.metro.ui;

import me.bakumon.metro.R;
import me.bakumon.metro.base.BaseFragment;
import me.bakumon.metro.databinding.FragmentMetroBinding;

/**
 * 地铁 fragment
 *
 * @author Bakumon
 * @date 2018/1/6
 */

public class MetroFragment extends BaseFragment {

    private FragmentMetroBinding binding;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_metro;
    }

    @Override
    protected void onInit() {
        binding = getDataBinding();
    }
}
