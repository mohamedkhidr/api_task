package com.example.api_task.features.show.presenter;

import com.example.api_task.features.show.model.ShowResponse;

import java.util.ArrayList;

public interface Presenter {
    public void OnSuccess(ArrayList<ShowResponse.Item> items);


    public void OnFailureCredentials();
}
