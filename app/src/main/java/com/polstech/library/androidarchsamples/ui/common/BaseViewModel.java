package com.polstech.library.androidarchsamples.ui.common;

import android.arch.lifecycle.ViewModel;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by polprashant on 18/02/18.
 */

public class BaseViewModel<N> extends ViewModel {
    protected N mNavigator;
    CompositeDisposable compositeDisposable;

    public BaseViewModel() {

    }

    public void setNavigator(N navigator) {
        mNavigator = navigator;
    }

    public N getNavigator() {
        return mNavigator;
    }

    @Override
    protected void onCleared() {
        compositeDisposable.dispose();
        super.onCleared();
    }
}
