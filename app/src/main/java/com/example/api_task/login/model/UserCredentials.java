package com.example.api_task.login.model;

import com.google.gson.annotations.SerializedName;

public class UserCredentials {
    @SerializedName("UsernameOrEmailAddress")
    private String email;
    @SerializedName("Password")
    private String password;



    public UserCredentials(String email, String password) {
        this.email = email;
        this.password = password;
    }


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
