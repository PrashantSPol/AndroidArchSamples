package com.polstech.library.androidarchsamples.network.quotes;

import com.polstech.library.androidarchsamples.model.responses.QuoteListResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by prashant.pol on 3/6/2018.
 */

public interface IQuoteGet {
    @GET("quotes.json")
    Observable<QuoteListResponse> getQuoteList();
}
