package com.example.api_task.features.add.presenter;

import com.example.api_task.features.add.model.ApiAddItem;
import com.example.api_task.features.add.view.AddItem;

public class PresenterImpl implements Presenter {
    private AddItem addItem;
    private ApiAddItem apiAddItem;
    private int itemId;
    private String accessToken ;



    public PresenterImpl(AddItem addItem) {
        this.addItem = addItem;
    }

    public void addItem(String accessToken , int itemId) {
        this.accessToken = accessToken;
        this.itemId = itemId;
        apiAddItem = new ApiAddItem(this , accessToken , itemId);
        apiAddItem.exceute();

    }


    @Override
    public void OnSuccess(String result) {
        addItem.OnComplete(result);
    }

    @Override
    public void OnFailureCredentials(String message) {
        addItem.OnComplete(message);
    }
}
