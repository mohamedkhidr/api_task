package com.example.api_task.login.model;

import android.util.Log;

import com.example.api_task.login.presenter.LoginPresenter;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiUserLogin {
    private static final String BASE_URL = "http://lensaty.net/api/account/";
    private String email ;
    private String password ;
    private String name ;
    private LoginPresenter loginPresenter;
    private String accessToken ;

    public ApiUserLogin(LoginPresenter loginPresenter, String email , String password) {
        this.loginPresenter = loginPresenter;
        this.email = email;
        this.password = password;
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


        // user credentials
        UserCredentials userCredentials = new UserCredentials(email, password);

        // api authentication service
        LoginAuthenticationRequest loginAuthenticationRequest = retrofit.create(LoginAuthenticationRequest.class);


        // start asking
        Call<AuthenticationResponse> call = loginAuthenticationRequest.getAccesToken(userCredentials);


// revceive response
        call.enqueue(new Callback<AuthenticationResponse>() {
            @Override
            public void onResponse(Call<AuthenticationResponse> call, Response<AuthenticationResponse> response) {

                int statusCode = response.code();
                if(statusCode == 200) {
                    accessToken = response.body().getResult().getAccessToken();
                    name = response.body().getResult().getProfile().getName();
                    loginPresenter.OnAccessTokenReceived(accessToken , name);
                }
                  else{
                        loginPresenter.OnWrongCredentials();
                        Log.v("msg" , "error code " + statusCode);
                }

            }

            @Override
            public void onFailure(Call<AuthenticationResponse> call, Throwable t) {
                Log.v("msg" , "error  " + t.getMessage());
            }
        });
    }
}

