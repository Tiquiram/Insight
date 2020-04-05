package com.example.fragment_example.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitServiceOpenFDA {
    private static final String BACKEND_ENDPOINT = "https://api.fda.gov/";

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BACKEND_ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    public static <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }
}
