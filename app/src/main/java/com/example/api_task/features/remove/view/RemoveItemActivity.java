package com.example.api_task.features.remove.view;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.api_task.R;
import com.example.api_task.features.remove.presenter.PresenterImpl;
import com.example.api_task.login.presenter.Network;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Length;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

import java.util.List;

public class RemoveItemActivity extends AppCompatActivity implements Validator.ValidationListener , RemoveItem {
    @NotEmpty
    @Length(max = 4 , min =1)
    private EditText itemEditText;
    private int itemId ;
    private Network network ;
    private Validator validator;
    private ProgressDialog dialog ;
    private PresenterImpl presenter ;
    private String accessToken ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_item);
        itemEditText = (EditText) findViewById(R.id.itemId);
        validator = new Validator(this);
        validator.setValidationListener(this);
        accessToken = getIntent().getStringExtra("accessToken");
        presenter = new PresenterImpl(this);
        network = new Network(this);
    }

    public void OnRemoveClicked(View view) {
        boolean networkStatus = network.isNetworkConnected();
        if (networkStatus) {
            validator.validate();
        } else {
            Toast.makeText(this, "Check internet connectivity", Toast.LENGTH_SHORT).show();
        }

    }
    // validator callbacks
    @Override
    public void onValidationSucceeded() {
        dialog = ProgressDialog.show(this, "Loading"
                , "Please wait", true);
        itemId = Integer.parseInt(itemEditText.getText().toString());
        presenter.removeItem(accessToken , itemId);
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
    public void OnComplete(String result) {
        dialog.dismiss();
        Toast.makeText(this , result , Toast.LENGTH_SHORT).show();
    }
}
