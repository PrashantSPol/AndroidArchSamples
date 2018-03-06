package com.polstech.library.androidarchsamples.network.selling;

import com.polstech.library.androidarchsamples.model.responses.SellingResponse;
import com.polstech.library.androidarchsamples.network.ApiService;
import com.polstech.library.androidarchsamples.network.RetrofitFactory;
import com.polstech.library.androidarchsamples.network.schedulers.SchedulerProvider;
import com.polstech.library.androidarchsamples.ui.sellingList.common.Product;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by prashant.pol on 3/6/2018.
 */

public class SellingService extends ApiService {
    private boolean isInSellLoading;
    private boolean isSoldOutLoading;

    public SellingService(RetrofitFactory retrofitFactory, SchedulerProvider schedulerProvider) {
        super(retrofitFactory, schedulerProvider);
    }

    public Observable<SellingResponse> getInSaleProducts() {
        ISellingGet sellingGet = retrofitFactory
                .getRetrofit()
                .create(ISellingGet.class);

        return sellingGet.getInSellProducts()
                .doOnSubscribe(disposable -> isInSellLoading = true)
                .doOnTerminate(() -> isSoldOutLoading = false)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui());
    }

    public Observable<SellingResponse> getSoldOutProducts() {
        ISellingGet sellingGet = retrofitFactory
                .getRetrofit()
                .create(ISellingGet.class);

        return sellingGet.getSoldOutProducts()
                .doOnSubscribe(disposable -> isSoldOutLoading = true)
                .doOnTerminate(() -> isSoldOutLoading = false)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui());
    }
}
