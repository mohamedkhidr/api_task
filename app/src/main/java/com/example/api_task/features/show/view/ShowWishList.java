package com.example.api_task.features.show.view;

import com.example.api_task.features.show.model.ShowResponse;

import java.util.ArrayList;

public interface ShowWishList {


    public void OnGettingItems(ArrayList<ShowResponse.Item> items);

    public void OnFailure();
}
