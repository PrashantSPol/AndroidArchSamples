package com.polstech.library.androidarchsamples.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.polstech.library.androidarchsamples.data.db.dao.QuoteDao;
import com.polstech.library.androidarchsamples.data.db.entities.Quote;

/**
 * Created by prashant.pol on 4/15/2018.
 */
@Database(entities = {Quote.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract QuoteDao quoteDao();
}
