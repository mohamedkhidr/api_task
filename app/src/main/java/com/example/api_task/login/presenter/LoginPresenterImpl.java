package com.example.api_task.login.presenter;

import android.util.Log;

import com.example.api_task.login.model.ApiUserLogin;
import com.example.api_task.login.view.MainInterface;

public class LoginPresenterImpl implements LoginPresenter {
    private MainInterface mainInterface ;
    private ApiUserLogin apiUserLogin;
    private String email;
    private String password ;


    public LoginPresenterImpl(MainInterface mainInterface) {
        this.mainInterface = mainInterface;
    }

    public void signin(String email , String password) {
        this.email = email;
        this.password = password;
        apiUserLogin = new ApiUserLogin(this , email , password);
        apiUserLogin.exceute();

    }

    @Override
    public void OnAccessTokenReceived(String accessToken , String name ) {
        mainInterface.OnSigninAuthenticationComplete(accessToken , name);
    }

    @Override
    public void OnWrongCredentials() {
        mainInterface.showWrongCredentialsHint();
    }
}
