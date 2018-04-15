package com.polstech.library.androidarchsamples.data.db;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.polstech.library.androidarchsamples.data.db.helper.DbHelper;
import com.polstech.library.androidarchsamples.data.db.helper.IDbHelper;
import com.polstech.library.androidarchsamples.di.qualifier.AppContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by prashant.pol on 4/15/2018.
 */
@Module
public class DbModule {

    @Provides
    @Singleton
    public AppDatabase providesAppDatabase(@AppContext Context context) {
        return Room.
                databaseBuilder(context, AppDatabase.class, "sample-mvvm-db")
                .build();
    }

    @Provides
    @Singleton
    public IDbHelper providesDbHelper(AppDatabase appDatabase) {
        return new DbHelper(appDatabase);
    }
}
