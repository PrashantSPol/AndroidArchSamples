package com.polstech.library.androidarchsamples.data.db.helper;

import android.arch.lifecycle.LiveData;

import com.polstech.library.androidarchsamples.data.db.entities.Quote;

import java.util.List;

/**
 * Created by prashant.pol on 4/15/2018.
 */

public interface IDbHelper {

    public LiveData<List<String>> getQuoteList();
    public void setQuoteList(List<String> quoteList);
}
