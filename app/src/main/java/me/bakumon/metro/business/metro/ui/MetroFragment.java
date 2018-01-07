package me.bakumon.metro.business.metro.ui;

import android.content.Intent;
import android.view.View;

import me.bakumon.metro.R;
import me.bakumon.metro.base.BaseFragment;
import me.bakumon.metro.databinding.FragmentMetroBinding;
import me.bakumon.metro.test.TestActivity;

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

        binding.textview.setText("跳转");

        binding.textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), TestActivity.class);
                startActivity(intent);
            }
        });
    }
}
