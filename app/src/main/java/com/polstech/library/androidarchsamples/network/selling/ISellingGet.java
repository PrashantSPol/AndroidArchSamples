package com.polstech.library.androidarchsamples.network.selling;

import com.polstech.library.androidarchsamples.model.responses.SellingResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by prashant.pol on 3/6/2018.
 */

public interface ISellingGet {
    @GET("selling_sell.json")
    Observable<SellingResponse> getInSellProducts();

    @GET("selling_sold.json")
    Observable<SellingResponse> getSoldOutProducts();
}
