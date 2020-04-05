package com.example.fragment_example.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private static final String BACKEND_ENDPOINT = "http://192.168.1.6:8000/";

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BACKEND_ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    public static <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }

}
