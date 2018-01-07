package me.bakumon.metro.business.mine.ui;

import me.bakumon.metro.R;
import me.bakumon.metro.base.BaseFragment;
import me.bakumon.metro.databinding.FragmentMineBinding;
import me.bakumon.metro.utils.StatusBarUtil;

/**
 * 我的 fragment
 *
 * @author Bakumon
 * @date 2018/1/6
 */

public class MineFragment extends BaseFragment {

    private FragmentMineBinding binding;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void onInit() {
        binding = getDataBinding();
        StatusBarUtil.darkMode(getActivity());
    }
}
