package com.polstech.library.androidarchsamples.logic;

import android.util.Log;

import com.polstech.library.androidarchsamples.R;
import com.polstech.library.androidarchsamples.data.CacheHelper;
import com.polstech.library.androidarchsamples.data.CacheHelperImpl;
import com.polstech.library.androidarchsamples.model.responses.QuoteListResponse;
import com.polstech.library.androidarchsamples.network.RetrofitFactory;
import com.polstech.library.androidarchsamples.network.quotes.QuoteGetService;
import com.polstech.library.androidarchsamples.network.schedulers.SchedulerProvider;
import com.polstech.library.androidarchsamples.ui.sellingList.common.Product;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Observable;

/**
 * Created by polprashant on 18/02/18.
 */

public class DataManager {
    List<Product> inSaleProductList;
    List<Product> soldOutProductList;

    private SchedulerProvider schedulerProvider;
    private RetrofitFactory retrofitFactory;
    private CacheHelper cacheHelper;

    public DataManager(RetrofitFactory retrofitFactory, SchedulerProvider schedulerProvider) {
        this.retrofitFactory = retrofitFactory;
        this.schedulerProvider = schedulerProvider;
        this.cacheHelper = new CacheHelperImpl();
    }

    // method to return data either cached one or remote one
    public Observable<List<String>> getQuoteList() {
        List<String> quotes = getCachedQuoteList();

        if(quotes == null) {
            return getRemoteQuoteList().map(quoteList -> {
                cacheHelper.setQuoteList(quoteList);
                return cacheHelper.getQuoteList();
            });
        }

        return Observable.fromCallable(() -> {
            return quotes;
        }).subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui());
    }

    /*
    return cached quote list
     */
    private List<String> getCachedQuoteList() {
        return cacheHelper.getQuoteList();
    }

    /*
    remote call to fetch data
     */
    private Observable<List<String>> getRemoteQuoteList() {
        return new QuoteGetService(retrofitFactory, schedulerProvider)
                .getQuotes().map(QuoteListResponse::getQuotes);
    }

    /*
    Method to add data into cache
     */
    public Completable addQuote(String quote) {
        return getQuoteList().map(quoteList -> quoteList.add(quote)).ignoreElements();
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
