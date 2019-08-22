package com.example.api_task.features.remove.model;

import com.example.api_task.features.add.model.AddResponse;
import com.example.api_task.features.add.model.ItemId;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface RemoveRequest {
    @POST("remove")
    Call<AddResponse> removeItem(@Header("Authorization") String accessToken , @Body ItemId itemId);
}
