package com.orange_infinity.vkhack.web;

import com.orange_infinity.vkhack.web.endpoints.RequestsApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {

    private static final String BASE_URL = "http://46a8d6a1.ngrok.io";
    private static NetworkService instance;
    private Retrofit retrofit;

    private NetworkService() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static NetworkService getInstance() {
        if (instance == null) {
            instance = new NetworkService();
        }
        return instance;
    }

    public RequestsApi getRegistrationApi() {
        return retrofit.create(RequestsApi.class);
    }
}
