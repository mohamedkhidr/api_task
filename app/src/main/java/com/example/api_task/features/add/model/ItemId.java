package com.example.api_task.features.add.model;

import com.google.gson.annotations.SerializedName;

public class ItemId {
    @SerializedName("ItemId")
    private int itemId;

    public int getItemId() {
        return itemId;
    }

    public ItemId(int itemId) {

        this.itemId = itemId;
    }
}
