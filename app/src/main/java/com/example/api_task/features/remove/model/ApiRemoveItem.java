package com.example.api_task.features.remove.model;

import android.util.Log;

import com.example.api_task.features.add.model.AddRequest;
import com.example.api_task.features.add.model.AddResponse;
import com.example.api_task.features.add.model.ItemId;
import com.example.api_task.features.remove.presenter.Presenter;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiRemoveItem {
    private static final String BASE_URL = "http://lensaty.net/api/services/app/MemberWishlist/";
    private String accessToken ;
    private int itemId ;
    private Presenter presenter ;
    private String message ;



    public ApiRemoveItem(Presenter presenter , String accessToken , int itemId) {
        this.presenter = presenter;
        this.accessToken = accessToken;
        this.itemId = itemId;
    }

    public void exceute() {
//
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();





        RemoveRequest removeRequest = retrofit.create(RemoveRequest.class);


        // start asking
        Call<AddResponse> call = removeRequest.removeItem("Bearer " + accessToken, new ItemId(itemId));


// revceive response
        call.enqueue(new Callback<AddResponse>() {
            @Override
            public void onResponse(Call<AddResponse> call, Response<AddResponse> response) {

                int statusCode = response.code();
                if(statusCode == 200) {
                    message = response.body().getResult();
                    presenter.OnSuccess(message);
                    Log.v("msg", "success");

                }else{
                    message = "Error while processing your request";
                    presenter.OnFailureCredentials(message);
                }

            }

            @Override
            public void onFailure(Call<AddResponse> call, Throwable t) {
                Log.v("msg" , "error  " + t.getMessage());
            }
        });
    }
}
