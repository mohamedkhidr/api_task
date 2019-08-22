package com.example.api_task.login.presenter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
// checking network status

public class Network {
    private Context context ;


    public Network(Context context) {
        this.context = context;
    }

    //check Network connectivity
    public boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) this.context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }
}
