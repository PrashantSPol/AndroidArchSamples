package com.polstech.library.androidarchsamples.network.requests;

import com.polstech.library.androidarchsamples.network.ApiService;
import com.polstech.library.androidarchsamples.network.RetrofitFactory;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;

/**
 * Created by prashant.pol on 3/6/2018.
 */

public class QuoteGetService extends ApiService {

    public Observable<List<String>> getQuotes() {
        Retrofit retrofit = retrofitFactory.getRetrofit();
        IQuoteGet quoteGet = retrofit.create(IQuoteGet.class);

        return quoteGet.getQuoteList()
                .doOnSubscribe(disposable -> isLoading = true)
                .doOnTerminate(() -> isLoading = false)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui());
    }
}
