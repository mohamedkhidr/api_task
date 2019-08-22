package com.example.api_task.features.show.model;


import com.example.api_task.features.add.model.ItemId;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ShowDataRequest {
    @POST("GetMyWishlist")
    Call<ShowResponse> getItems(@Header("Authorization") String accessToken);
}
