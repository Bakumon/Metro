package me.bakumon.metro.business.metro.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.amap.api.maps.AMap;

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
    private AMap aMap;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_metro;
    }

    @Override
    protected void onInit(@Nullable Bundle savedInstanceState) {
        binding = getDataBinding();
        binding.mapView.onCreate(savedInstanceState);
        initMap();
    }

    private void initMap() {
        if (aMap == null) {
            aMap = binding.mapView.getMap();
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        binding.mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        binding.mapView.onPause();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        binding.mapView.onLowMemory();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        binding.mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding.mapView.onDestroy();
    }
}
