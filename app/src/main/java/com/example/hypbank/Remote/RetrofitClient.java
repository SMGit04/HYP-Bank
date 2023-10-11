package com.example.hypbank.Remote;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit;

    public static Retrofit getRetrofit() {
        // https://banksimulator.azurewebsites.net/api/
        // http://10.0.2.2:5175/api/
        if (retrofit == null)
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://banksimulator.azurewebsites.net/api/")
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        return retrofit;

        // TODO: Configure baseURL to work with a real device
    }
}
