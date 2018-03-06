package com.polstech.library.androidarchsamples.network.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by prashant.pol on 3/6/2018.
 */

public interface SchedulerProvider {
    public Scheduler io();
    public Scheduler ui();
}
