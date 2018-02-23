package com.polstech.library.androidarchsamples.logic;

import com.polstech.library.androidarchsamples.R;
import com.polstech.library.androidarchsamples.ui.sellingList.common.Product;

import java.util.ArrayList;
import java.util.List;

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
    List<Product> productList;

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

    public Observable<List<Product>> getInSaleProductList() {
        return Observable.fromCallable(() -> {
            if(productList == null) {
                productList = new ArrayList<>();
                for (int i = 1; i <= 10; i++) {
                    Product product = new Product("Product " + i, R.drawable.koala, i * 100, true);
                    productList.add(product);
                }
            }

            return productList;
        });
    }


    public Observable<List<Product>> getSoldOutProductList() {
        return Observable.fromCallable(() -> {
            if(productList == null) {
                productList = new ArrayList<>();
                for (int i = 1; i <= 10; i++) {
                    Product product = new Product("Product " + i, R.drawable.koala, i * 100, false);
                    productList.add(product);
                }
            }

            return productList;
        });
    }
}
