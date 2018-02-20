package com.polstech.library.androidarchsamples.logic;

import java.util.ArrayList;
import java.util.List;


import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Flowable;
import io.reactivex.Observable;

/**
 * Created by polprashant on 18/02/18.
 */

public class DataManager {
    List<String> quotes;

    public Observable<List<String>> getQuoteList() {
        return Observable.fromCallable(() -> {
            if(quotes == null) {
                quotes = new ArrayList<>();
                for (int i = 1; i < 10; i++) {
                    quotes.add("Quote Number " + i);
                }
            }
            return quotes;
        });
    }

    public Completable addQuote(String quote) {
        return new Completable() {
            @Override
            protected void subscribeActual(CompletableObserver s) {
                quotes.add(quote);
                s.onComplete();
            }
        };
    }
}
