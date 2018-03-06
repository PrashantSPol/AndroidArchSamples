package com.polstech.library.androidarchsamples.network.schedulers;

import android.app.ActivityManager;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by prashant.pol on 3/6/2018.
 */

public class AppSchedulerProvider implements SchedulerProvider {
    @Override
    public Scheduler io() {
        return Schedulers.io();
    }

    @Override
    public Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }
}
