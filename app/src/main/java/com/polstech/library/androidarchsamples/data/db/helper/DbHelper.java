package com.polstech.library.androidarchsamples.data.db.helper;

import android.arch.lifecycle.LiveData;

import com.polstech.library.androidarchsamples.data.db.AppDatabase;
import com.polstech.library.androidarchsamples.data.db.entities.Quote;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prashant.pol on 4/15/2018.
 */

public class DbHelper implements IDbHelper {

    private AppDatabase appDatabase;

    public DbHelper(AppDatabase appDatabase) {
        this.appDatabase = appDatabase;
    }

    @Override
    public LiveData<List<String>> getQuoteList() {
        return appDatabase.quoteDao().getQuoteList();
    }

    @Override
    public void setQuoteList(List<String> quoteList) {
        List<Quote> quotes = new ArrayList<>();
        for (String q : quoteList) {
            Quote quote = new Quote();
            quote.quoteMessage = q;

            quotes.add(quote);
        }

        appDatabase.quoteDao().insertQuotes(quotes.toArray(new Quote[quoteList.size()]));
    }
}
