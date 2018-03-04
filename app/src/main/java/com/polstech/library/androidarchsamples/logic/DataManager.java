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
    List<Product> inSaleProductList;
    List<Product> soldOutProductList;

    public Observable<List<String>> getQuoteList() {
        return Observable.fromCallable(() -> {
            if(quotes == null) {
                quotes = new ArrayList<>();
                for (int i = 1; i < 10; i++) {
                    quotes.add("Quote Number " + i);
                }
            }
            Thread.sleep(2000);
            return quotes;
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
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
