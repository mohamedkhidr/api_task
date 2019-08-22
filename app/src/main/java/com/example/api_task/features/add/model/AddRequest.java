package com.example.api_task.features.add.model;

import android.util.Pair;

import com.example.api_task.login.model.AuthenticationResponse;
import com.example.api_task.login.model.UserCredentials;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface AddRequest {
    @POST("add")
    Call<AddResponse> addNewItem(@Header("Authorization") String accessToken , @Body ItemId itemId);
}
