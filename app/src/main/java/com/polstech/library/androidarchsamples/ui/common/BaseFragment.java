package com.polstech.library.androidarchsamples.ui.common;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dagger.android.AndroidInjection;
import dagger.android.support.AndroidSupportInjection;

/**
 * Created by prashant.pol on 2/21/2018.
 */

public abstract class BaseFragment<T extends ViewDataBinding, V extends BaseViewModel> extends Fragment{
    protected T mViewDataBinding;
    protected V mViewModel;
    protected View mRootView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setupInjection();
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        mRootView = mViewDataBinding.getRoot();

        mViewModel = mViewModel == null ? getViewModel() : mViewModel;
        mViewDataBinding.setVariable(getBindingVariable(), mViewModel);
        return mRootView;
    }

    void setupInjection() {
        AndroidSupportInjection.inject(this);
    }

    abstract protected int getLayoutId();
    abstract protected V getViewModel();
    abstract protected int getBindingVariable();
}
