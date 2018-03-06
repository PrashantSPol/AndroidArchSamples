package com.polstech.library.androidarchsamples.logic;

import android.util.Log;

import com.polstech.library.androidarchsamples.R;
import com.polstech.library.androidarchsamples.model.responses.QuoteListResponse;
import com.polstech.library.androidarchsamples.network.ApiService;
import com.polstech.library.androidarchsamples.network.RetrofitFactory;
import com.polstech.library.androidarchsamples.network.requests.QuoteGetService;
import com.polstech.library.androidarchsamples.network.schedulers.SchedulerProvider;
import com.polstech.library.androidarchsamples.ui.sellingList.common.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by polprashant on 18/02/18.
 */

public class DataManager {
    List<String> quotes;
    List<Product> inSaleProductList;
    List<Product> soldOutProductList;

    private SchedulerProvider schedulerProvider;
    private RetrofitFactory retrofitFactory;

    public DataManager(RetrofitFactory retrofitFactory, SchedulerProvider schedulerProvider) {
        this.retrofitFactory = retrofitFactory;
        this.schedulerProvider = schedulerProvider;
    }

    // method to return data either cached one or remote one
    public Observable<List<String>> getQuoteList() {
        Log.i("CHECK_", "quote list is " + quotes);
        if(quotes == null) {
            return getRemoteQuoteList().doOnNext(quotes -> {
                Log.i("CHECK_", "caching quote list as " + quotes);
                this.quotes = quotes;
            });
        }

        return Observable.fromCallable(() -> {
            Log.i("CHECK_", "cached quote list is " + quotes);
            return quotes;
        }).subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui());
    }

    /*
    remote call to fetch data
     */
    private Observable<List<String>> getRemoteQuoteList() {
        return new QuoteGetService(retrofitFactory, schedulerProvider)
                .getQuotes().map(QuoteListResponse::getQuotes);
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

    public Observable<List<Product>> getInSaleProductList() {
        return Observable.fromCallable(() -> {
            if(inSaleProductList == null) {
                inSaleProductList = new ArrayList<>();
                for (int i = 1; i <= 10; i++) {
                    Product product = new Product("Product " + i, R.drawable.koala, i * 100, true);
                    inSaleProductList.add(product);
                }
            }

            return inSaleProductList;
        });
    }


    public Observable<List<Product>> getSoldOutProductList() {
        return Observable.fromCallable(() -> {
            if(soldOutProductList == null) {
                soldOutProductList = new ArrayList<>();
                for (int i = 1; i <= 10; i++) {
                    Product product = new Product("Product " + i, R.drawable.koala, i * 100, false);
                    soldOutProductList.add(product);
                }
            }

            return soldOutProductList;
        });
    }
}
