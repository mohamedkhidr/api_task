package com.example.api_task.features.add.model;

import android.util.Log;
import android.util.Pair;

import com.example.api_task.features.add.presenter.Presenter;
import com.example.api_task.login.model.AuthenticationResponse;
import com.example.api_task.login.model.LoginAuthenticationRequest;
import com.example.api_task.login.model.UserCredentials;


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

public class ApiAddItem {
    private static final String BASE_URL = "http://lensaty.net/api/services/app/MemberWishlist/";
    private String accessToken ;
    private int itemId ;
    private Presenter presenter ;
    private String message ;



    public ApiAddItem(Presenter presenter , String accessToken , int itemId) {
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





        AddRequest addRequest = retrofit.create(AddRequest.class);


        // start asking
        Call<AddResponse> call = addRequest.addNewItem("Bearer " + accessToken, new ItemId(itemId));


// revceive response
        call.enqueue(new Callback<AddResponse>() {
            @Override
            public void onResponse(Call<AddResponse> call, Response<AddResponse> response) {

                int statusCode = response.code();
                if(statusCode == 200) {
                    message = response.body().getResult();
                    presenter.OnSuccess(message);
                    Log.v("msg", "success");
                }
                else if(statusCode == 500){
                    try {
                        JSONObject objError = new JSONObject(response.errorBody().string());
                        message = objError.getJSONObject("error").getString("message");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    presenter.OnFailureCredentials(message);
                    Log.v("msg" , "error code " + statusCode);
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
