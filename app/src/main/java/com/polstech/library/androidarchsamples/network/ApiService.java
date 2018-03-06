package com.polstech.library.androidarchsamples.network;

import com.polstech.library.androidarchsamples.network.schedulers.SchedulerProvider;

import io.reactivex.Observable;

/**
 * Created by prashant.pol on 3/6/2018.
 */

public class ApiService {
    protected RetrofitFactory retrofitFactory;
    protected SchedulerProvider schedulerProvider;
    protected boolean isLoading;

    public ApiService() {
    }

    public ApiService(RetrofitFactory retrofitFactory, SchedulerProvider schedulerProvider) {
        this.retrofitFactory = retrofitFactory;
        this.schedulerProvider = schedulerProvider;
    }

    public boolean isLoading() {
        return isLoading;
    }
}
