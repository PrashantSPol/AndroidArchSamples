package com.polstech.library.androidarchsamples.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by prashant.pol on 3/5/2018.
 */
@Singleton
public class RetrofitFactory {

    private final String BASE_URL = "https://raw.githubusercontent.com/PrashantSPol/AndroidArchSamples/master/resources/api/";

    public Retrofit getRetrofit() {

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
}
