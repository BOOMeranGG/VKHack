package com.orange_infinity.vkhack.web.endpoints;

import com.orange_infinity.vkhack.model.entity.dto.ChatUrl;
import com.orange_infinity.vkhack.model.entity.dto.ConnectData;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ChatApi {

    @POST("/")
    public Call<ChatUrl> connectChat(@Body ConnectData data);

}
