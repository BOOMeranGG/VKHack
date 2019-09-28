package com.orange_infinity.vkhack.web;

import android.util.Log;

import com.orange_infinity.vkhack.model.entity.dto.RegistrationDto;

import io.reactivex.rxjava3.annotations.NonNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.orange_infinity.vkhack.utils.StringUtils.MAIN_TAG;

public class WebController {

    public void registry(RegistrationDto regDto) {
        NetworkService.getInstance()
                .getRegistrationApi()
                .registration(regDto)
                .enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {
                        String responseStr = response.body();
                        Log.d(MAIN_TAG, "Connect is correct! Response: " + responseStr
                                + ", response code: " + response.code());
                    }

                    @Override
                    public void onFailure(@NonNull Call<String> call, @NonNull Throwable t) {
                        Log.d(MAIN_TAG, "Connect is incorrect ;( " + t.getLocalizedMessage());
                        t.printStackTrace();
                    }
                });
    }
}
