package com.example.api_task.login.presenter;

public interface LoginPresenter {
    public void OnAccessTokenReceived(String accessToken , String name);
    public void OnWrongCredentials();
}
