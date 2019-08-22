package com.example.api_task.features.remove.presenter;

import com.example.api_task.features.remove.model.ApiRemoveItem;
import com.example.api_task.features.remove.view.RemoveItem;

public class PresenterImpl implements Presenter {
    private RemoveItem removeItem;
    private ApiRemoveItem apiRemoveItem;
    private int itemId;
    private String accessToken ;



    public PresenterImpl(RemoveItem removeItem) {
        this.removeItem = removeItem;
    }

    public void removeItem(String accessToken , int itemId) {
        this.accessToken = accessToken;
        this.itemId = itemId;
        apiRemoveItem = new ApiRemoveItem(this , accessToken , itemId);
        apiRemoveItem.exceute();

    }


    @Override
    public void OnSuccess(String result) {
        removeItem.OnComplete(result);
    }

    @Override
    public void OnFailureCredentials(String message) {
        removeItem.OnComplete(message);
    }
}
