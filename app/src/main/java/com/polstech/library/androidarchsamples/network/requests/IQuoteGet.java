package com.polstech.library.androidarchsamples.network.requests;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by prashant.pol on 3/6/2018.
 */

public interface IQuoteGet {
    @GET("quotes.json")
    Observable<List<String>> getQuoteList();
}
