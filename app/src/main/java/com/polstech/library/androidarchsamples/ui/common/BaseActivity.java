package com.polstech.library.androidarchsamples.ui.common;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import dagger.android.AndroidInjection;

/**
 * Created by polprashant on 14/02/18.
 */

public abstract class BaseActivity<T extends ViewDataBinding, V extends BaseViewModel> extends AppCompatActivity {

    protected T mDataBindingUtil;
    protected V mViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setupInjection();
        super.onCreate(savedInstanceState);

        setupDataBinding();
    }

    private void setupInjection(){
        AndroidInjection.inject(this);
    }

    private void setupDataBinding() {
        mDataBindingUtil = DataBindingUtil.setContentView(this, getLayoutId());
        mViewModel = mViewModel == null ? getViewModel() : mViewModel;
        mDataBindingUtil.setVariable(getBindingVariable(), mViewModel);
    }

    abstract protected int getLayoutId();

    abstract protected V getViewModel();

    abstract protected int getBindingVariable();
}
