package com.polstech.library.androidarchsamples.di;

import android.app.Application;
import android.content.Context;

import com.polstech.library.androidarchsamples.data.db.helper.DbHelper;
import com.polstech.library.androidarchsamples.data.db.helper.IDbHelper;
import com.polstech.library.androidarchsamples.di.qualifier.AppContext;
import com.polstech.library.androidarchsamples.logic.DataManager;
import com.polstech.library.androidarchsamples.network.RetrofitFactory;
import com.polstech.library.androidarchsamples.network.schedulers.AppSchedulerProvider;
import com.polstech.library.androidarchsamples.network.schedulers.SchedulerProvider;
import com.polstech.library.androidarchsamples.util.ToastUtil;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by polprashant on 14/02/18.
 */
@Module
public class AppModule {

    @Provides
    @Singleton
    public @AppContext Context providesAppContext(Application application) {
        return application.getApplicationContext();
    }

    @Provides
    @Singleton
    DataManager providesDataProvider(RetrofitFactory retrofitFactory, SchedulerProvider schedulerProvider, IDbHelper dbHelper) {
        return new DataManager(retrofitFactory, schedulerProvider, dbHelper);
    }


    @Provides
    @Singleton
    public ToastUtil providesToastUtil(@AppContext Context context) {
        return new ToastUtil(context);
    }

    @Provides
    @Singleton
    public RetrofitFactory getRetrofitFactory() {
        return new RetrofitFactory();
    }

    @Provides
    @Singleton
    public SchedulerProvider getSchedulerProvider() {
        return new AppSchedulerProvider();
    }
}
