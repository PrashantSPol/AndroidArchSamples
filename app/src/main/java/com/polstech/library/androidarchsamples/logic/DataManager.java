package com.polstech.library.androidarchsamples.logic;

import android.util.Log;

import com.polstech.library.androidarchsamples.R;
import com.polstech.library.androidarchsamples.data.CacheHelper;
import com.polstech.library.androidarchsamples.data.CacheHelperImpl;
import com.polstech.library.androidarchsamples.model.responses.QuoteListResponse;
import com.polstech.library.androidarchsamples.model.responses.SellingResponse;
import com.polstech.library.androidarchsamples.network.RetrofitFactory;
import com.polstech.library.androidarchsamples.network.quotes.QuoteGetService;
import com.polstech.library.androidarchsamples.network.schedulers.SchedulerProvider;
import com.polstech.library.androidarchsamples.network.selling.SellingService;
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

    /*
    returns product list which are in sell
     */
    public Observable<List<Product>> getInSaleProductList() {
        List<Product> inSalProductList = cacheHelper.getInSaleProducts();
        if (inSalProductList == null) {
            return getRemoteInSaleProductList()
                    .doOnNext(inSaleProductList -> cacheHelper.setInSaleProducts(inSaleProductList));
        }
        return Observable.fromCallable(() -> {
            return inSalProductList;
        });
    }

    /*
    fetch in sale products remotely
     */
    private Observable<List<Product>> getRemoteInSaleProductList() {
        return new SellingService(retrofitFactory, schedulerProvider)
                .getInSaleProducts()
                .map(SellingResponse::getProducts);
    }

    /*
    returns list of sold out products
     */
    public Observable<List<Product>> getSoldOutProductList() {
        List<Product> soldOutProductList = cacheHelper.getSoldOutProducts();

        if(soldOutProductList == null) {
            return getRemoteSoldOutProductList();
        }

        return Observable.fromCallable(() -> {
            return soldOutProductList;
        });
    }

    /*
    fetch list remotely
     */
    private Observable<List<Product>> getRemoteSoldOutProductList() {
        return new SellingService(retrofitFactory, schedulerProvider)
                .getSoldOutProducts()
                .map(SellingResponse::getProducts);
    }
}
