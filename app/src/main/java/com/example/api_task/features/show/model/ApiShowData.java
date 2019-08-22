package com.example.api_task.features.show.model;

import android.util.Log;

import com.example.api_task.features.show.presenter.Presenter;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiShowData {
    private static final String BASE_URL = "http://lensaty.net/api/services/app/MemberWishlist/";
    private String accessToken ;
    private Presenter presenter ;
    private ArrayList<ShowResponse.Item> items ;




    public ApiShowData(Presenter presenter , String accessToken ) {
        this.presenter = presenter;
        this.accessToken = accessToken;

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





        ShowDataRequest showDataRequest = retrofit.create(ShowDataRequest.class);


        // start asking
        Call<ShowResponse> call = showDataRequest.getItems("Bearer " + accessToken);


// revceive response
        call.enqueue(new Callback<ShowResponse>() {
            @Override
            public void onResponse(Call<ShowResponse> call, Response<ShowResponse> response) {

                int statusCode = response.code();
                if(statusCode == 200) {
                    items = response.body().getItems() ;
                    presenter.OnSuccess(items);

                }
                else if(statusCode == 500){
                    presenter.OnFailureCredentials();
                }

            }

            @Override
            public void onFailure(Call<ShowResponse> call, Throwable t) {
                Log.v("msg" , "error  " + t.getMessage());
            }
        });
    }
}
