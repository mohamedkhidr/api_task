package com.example.api_task.login.model;




import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginAuthenticationRequest {
    @POST("Authenticate")
    Call<AuthenticationResponse> getAccesToken(@Body UserCredentials userCredentials);
}
