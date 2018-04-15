package com.polstech.library.androidarchsamples.data.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.polstech.library.androidarchsamples.data.db.entities.Quote;

import java.util.List;

/**
 * Created by prashant.pol on 4/15/2018.
 */
@Dao
public interface QuoteDao {

    @Query("SELECT quote_message FROM tab_quote;")
    public LiveData<List<String>> getQuoteList();

    @Insert
    public void insertQuotes(Quote... quoteList);
}
