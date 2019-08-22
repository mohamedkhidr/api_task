package com.example.api_task.features.show.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.api_task.R;
import com.example.api_task.features.show.model.ShowResponse;
import com.example.api_task.features.show.presenter.PresenterImpl;
import com.example.api_task.features.add.view.AddItemActivity;
import com.example.api_task.features.remove.view.RemoveItemActivity;
import com.example.api_task.features.show.presenter.WishListAdapter;
import com.example.api_task.login.presenter.Network;
import com.example.api_task.login.view.MainActivity;
import com.mobsandgeeks.saripaar.Validator;

import java.util.ArrayList;

public class ShowWishListِActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, ShowWishList {
    private String accessToken;
    private String email;
    private Network network;
    private Validator validator;
    private ProgressDialog dialog;
    private PresenterImpl presenter;
    private WishListAdapter itemsAdapter;
    private ListView menuListView;
    private TextView emailTextView;
    private View header;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        menuListView = (ListView) findViewById(R.id.list);
        navigationView.setNavigationItemSelectedListener(this);
        accessToken = getIntent().getStringExtra("accessToken");
        email = getIntent().getStringExtra("email");
        header = navigationView.getHeaderView(0);
        emailTextView = (TextView) header.findViewById(R.id.email);
        emailTextView.setText(email);

        presenter = new PresenterImpl(this);
        network = new Network(this);
        startGettingList();

    }

    public void startGettingList() {
        boolean networkStatus = network.isNetworkConnected();
        if (networkStatus) {
            dialog = ProgressDialog.show(this, "Loading"
                    , "Please wait", true);
            presenter.getItems(accessToken);
        } else {
            Toast.makeText(this, "Check internet connectivity", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
        super.onBackPressed();
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startMain);


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.wish_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_add) {
            // add
            Intent intent = new Intent(this, AddItemActivity.class);
            intent.putExtra("accessToken", accessToken);
            startActivity(intent);

        } else if (id == R.id.nav_remove) {
            // remove
            Intent intent = new Intent(this, RemoveItemActivity.class);
            intent.putExtra("accessToken", accessToken);
            startActivity(intent);

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void OnGettingItems(ArrayList<ShowResponse.Item> items) {
        itemsAdapter = new WishListAdapter(this, items);
        menuListView.setAdapter(itemsAdapter);
        dialog.dismiss();
    }

    @Override
    public void OnFailure() {
        Toast.makeText(this, "Error occured while processing your request", Toast.LENGTH_SHORT).show();
    }

}
