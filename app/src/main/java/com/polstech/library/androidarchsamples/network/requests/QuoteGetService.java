package com.polstech.library.androidarchsamples.network.requests;

import com.polstech.library.androidarchsamples.model.responses.QuoteListResponse;
import com.polstech.library.androidarchsamples.network.ApiService;
import com.polstech.library.androidarchsamples.network.RetrofitFactory;
import com.polstech.library.androidarchsamples.network.schedulers.SchedulerProvider;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;

/**
 * Created by prashant.pol on 3/6/2018.
 */

public class QuoteGetService extends ApiService {

    public QuoteGetService(RetrofitFactory retrofitFactory, SchedulerProvider schedulerProvider) {
        super(retrofitFactory, schedulerProvider);
    }

    public Observable<QuoteListResponse> getQuotes() {
        Retrofit retrofit = retrofitFactory.getRetrofit();
        IQuoteGet quoteGet = retrofit.create(IQuoteGet.class);

        return quoteGet.getQuoteList()
                .doOnSubscribe(disposable -> isLoading = true)
                .doOnTerminate(() -> isLoading = false)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui());
    }
}
