package com.orange_infinity.vkhack.web.endpoints;

import com.orange_infinity.vkhack.model.entity.dto.RegistrationDto;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RegistrationApi {

    @POST("/auth/users")
    public Call<String> registration(@Body RegistrationDto registrationDto);
}
