package com.example.api_task.features.add.presenter;

public interface Presenter {
    public void OnSuccess(String result);

    public void OnFailureCredentials(String message);
}
