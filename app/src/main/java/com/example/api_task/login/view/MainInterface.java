package com.example.api_task.login.view;

public interface MainInterface {
    public void OnSigninAuthenticationComplete(String token , String name);

    public void showWrongCredentialsHint();
}
