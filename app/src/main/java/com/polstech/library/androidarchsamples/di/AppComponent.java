package com.polstech.library.androidarchsamples.di;

import android.app.Application;

import com.polstech.library.androidarchsamples.AndroidArchSampleApp;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by polprashant on 14/02/18.
 */
@Singleton
@Component(modules = {AndroidInjectionModule.class, ActivityBuilder.class, AppModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    abstract void inject(AndroidArchSampleApp application);
}
