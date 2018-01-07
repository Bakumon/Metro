package me.bakumon.metro.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import me.bakumon.metro.R;

/**
 * 1.ViewDataBinding 封装
 * 2.显示隐藏动画
 *
 * @author Bakumon
 * @date 2018/1/6
 */

public abstract class BaseFragment extends Fragment {

    private ViewDataBinding dataBinding;
    private View rootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        dataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        rootView = dataBinding.getRoot();
        onInit();
        return rootView;
    }

    /**
     * 子类必须实现，用于创建 view
     *
     * @return 布局文件 Id
     */
    @LayoutRes
    protected abstract int getLayoutId();

    /**
     * 开始的方法
     */
    protected abstract void onInit();

    /**
     * 获取 ViewDataBinding
     *
     * @param <T> BaseFragment#getLayoutId() 布局创建的 ViewDataBinding
     *            如 R.layout.fragment_demo 会创建出 FragmentDemoBinding.java
     * @return T
     */
    protected <T extends ViewDataBinding> T getDataBinding() {
        return (T) dataBinding;
    }

    /**
     * fragment 将要显示时调用
     */
    public void willBeDisplayed() {
        // Do what you want here, for example animate the content
        if (rootView != null) {
            Animation fadeIn = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_in);
            rootView.startAnimation(fadeIn);
        }
    }

    /**
     * fragment 将要隐藏时调用
     */
    public void willBeHidden() {
        if (rootView != null) {
            Animation fadeOut = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_out);
            rootView.startAnimation(fadeOut);
        }
    }
}
