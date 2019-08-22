package com.example.api_task.features.show.presenter;

import com.example.api_task.features.show.model.ApiShowData;
import com.example.api_task.features.show.model.ShowResponse;
import com.example.api_task.features.show.view.ShowWishList;

import java.util.ArrayList;

public class PresenterImpl implements Presenter {

    private ShowWishList showWishList;
    private ApiShowData apiShowData;
    private String accessToken ;



    public PresenterImpl(ShowWishList showWishList) {
        this.showWishList = showWishList;
    }

    public void getItems(String accessToken) {
        this.accessToken = accessToken;
        apiShowData = new ApiShowData(this , accessToken);
        apiShowData.exceute();

    }


    @Override
    public void OnSuccess(ArrayList<ShowResponse.Item> items) {
        showWishList.OnGettingItems(items);
    }

    @Override
    public void OnFailureCredentials() {
        showWishList.OnFailure();
    }
}
