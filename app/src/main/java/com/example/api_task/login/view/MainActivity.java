package com.example.api_task.login.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.api_task.R;
import com.example.api_task.features.show.view.ShowWishListِActivity;
import com.example.api_task.login.presenter.Network;
import com.example.api_task.login.presenter.LoginPresenterImpl;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Validator.ValidationListener , MainInterface {
    @NotEmpty
    @Email
    private EditText emailEditText;
    @NotEmpty
    @Password
    private EditText passEditText;
    private ProgressDialog dialog;
    private Network network;
    private LoginPresenterImpl loginPresenterImpl;
    private String email ;
    private String password ;
    private Validator validator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailEditText = (EditText) findViewById(R.id.email);
        passEditText = (EditText) findViewById(R.id.passText);
        network = new Network(this);
        loginPresenterImpl = new LoginPresenterImpl(this);
        // fields validator
        validator = new Validator(this);
        validator.setValidationListener(this);

    }

    public void OnSignin(View view) {

        boolean networkStatus = network.isNetworkConnected();
        if (networkStatus) {
            validator.validate();
        } else {
            Toast.makeText(this, "Check internet connectivity", Toast.LENGTH_SHORT).show();
        }

    }

    // login completed
    @Override
    public void OnSigninAuthenticationComplete(String token , String name ) {
        dialog.dismiss();
        Intent intent = new Intent(this , ShowWishListِActivity.class);
        intent.putExtra("accessToken" , token);
        intent.putExtra("email" , email);
        startActivity(intent);

    }
    // wrong email or password
    @Override
    public void showWrongCredentialsHint() {
        dialog.dismiss();
        Toast.makeText(this , "Wrong email or password" , Toast.LENGTH_SHORT).show();
    }

    // validator callbacks
    @Override
    public void onValidationSucceeded() {
        dialog = ProgressDialog.show(this, "Loading"
                , "Please wait", true);
        email = emailEditText.getText().toString();
        password = passEditText.getText().toString();
        loginPresenterImpl.signin(email, password);
    }


        @Override
        public void onValidationFailed(List<ValidationError> errors) {
            for (ValidationError error : errors) {
                View view = error.getView();
                String message = error.getCollatedErrorMessage(this);

                // Display error messages ;)
                if (view instanceof EditText) {
                    ((EditText) view).setError(message);
                } else {
                    Toast.makeText(this, message, Toast.LENGTH_LONG).show();
                }
            }
        }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // goi home
            Intent startMain = new Intent(Intent.ACTION_MAIN);
            startMain.addCategory(Intent.CATEGORY_HOME);
            startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(startMain);


    }
}

