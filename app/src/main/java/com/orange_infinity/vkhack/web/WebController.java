package com.orange_infinity.vkhack.web;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.orange_infinity.vkhack.data.preferences.SessionManager;
import com.orange_infinity.vkhack.model.entity.dto.EditedData;
import com.orange_infinity.vkhack.model.entity.dto.RegistrationDto;
import com.orange_infinity.vkhack.model.entity.dto.User;

import io.reactivex.rxjava3.annotations.NonNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.orange_infinity.vkhack.utils.StringUtils.MAIN_TAG;

public class WebController {

    SessionManager sessionManager;

    public void registry(RegistrationDto regDto, final Context context) {
        NetworkService.getInstance()
                .getRegistrationApi()
                .registration(regDto)
                .enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                        User responseStr = response.body();

                        Gson gson = new GsonBuilder().setPrettyPrinting().create();

                        String json = gson.toJson(responseStr);

                        sessionManager = new SessionManager(context);

                        sessionManager.saveId(responseStr.getId());

                        Log.d(MAIN_TAG, "Connect is correct! Response: " + json
                                + ", response code: " + response.code());

                    }

                    @Override
                    public void onFailure(@NonNull Call<User> call, @NonNull Throwable t) {
                        Log.d(MAIN_TAG, "Connect is incorrect ;( " + t.getLocalizedMessage());
                        t.printStackTrace();
                    }
                });
    }

    public void send_edited_data(String authKey ,EditedData data, int id){
        NetworkService.getInstance()
                .getRegistrationApi()
                .sendEditedData(authKey ,data, id)
                .enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                        User responseStr = response.body();

                        Gson gson = new GsonBuilder().setPrettyPrinting().create();

                        String json = gson.toJson(responseStr);

                        Log.d(MAIN_TAG, "Connect is correct! Response: " + json
                                + ", response code: " + response.code());
                    }

                    @Override
                    public void onFailure(@NonNull Call<User> call, @NonNull Throwable t) {
                        Log.d(MAIN_TAG, "Connect is incorrect ;( " + t.getLocalizedMessage());
                        t.printStackTrace();
                    }
                });
    }

}
