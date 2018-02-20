package com.polstech.library.androidarchsamples.di;

import android.app.Application;
import android.content.Context;

import com.polstech.library.androidarchsamples.AndroidArchSampleApp;
import com.polstech.library.androidarchsamples.di.qualifier.AppContext;
import com.polstech.library.androidarchsamples.logic.DataManager;
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
    @AppContext
    public Context providesAppContext(AndroidArchSampleApp application) {
        return application.getApplicationContext();
    }

    @Provides
    @Singleton
    DataManager providesDataProvider() {
        return new DataManager();
    }


    @Provides
    public ToastUtil providesToastUtil() {
        return new ToastUtil();
    }
}
