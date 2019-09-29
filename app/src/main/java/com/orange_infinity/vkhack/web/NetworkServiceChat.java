package com.orange_infinity.vkhack.web;

import com.orange_infinity.vkhack.web.endpoints.ChatApi;
import com.orange_infinity.vkhack.web.endpoints.RequestsApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkServiceChat {

    private static final String BASE_URL = "http://99aa95f9.ngrok.io";
    private static NetworkServiceChat instance;
    private Retrofit retrofit;

    private NetworkServiceChat() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static NetworkServiceChat getInstance() {
        if (instance == null) {
            instance = new NetworkServiceChat();
        }
        return instance;
    }

    public ChatApi getConnectChatApi() {
        return retrofit.create(ChatApi.class);
    }

}
