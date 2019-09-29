package com.orange_infinity.vkhack.web.endpoints;

import com.orange_infinity.vkhack.model.entity.dto.ChatUrl;
import com.orange_infinity.vkhack.model.entity.dto.ConnectData;
import com.orange_infinity.vkhack.model.entity.dto.EditedData;
import com.orange_infinity.vkhack.model.entity.dto.RegistrationDto;
import com.orange_infinity.vkhack.model.entity.dto.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface RequestsApi {

    @POST("/auth/users")
    public Call<User> registration(@Body RegistrationDto registrationDto);

    @PUT("/users/edit/{id}")
    public Call<User> sendEditedData(
            @Header("Authorization") String authKey,
            @Body EditedData data,
            @Path("id") int id);
}
