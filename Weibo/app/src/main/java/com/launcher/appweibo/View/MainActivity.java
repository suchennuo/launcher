package com.launcher.appweibo.View;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.launcher.appweibo.Model.BasicActivity;
import com.launcher.appweibo.R;
import com.launcher.appweibo.SimpleService;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public class MainActivity extends BasicActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.bt_network) Button getAuth;
    @BindView(R.id.btn_home_page_canvas) Button canvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.launcher.appweibo.R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(com.launcher.appweibo.R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(com.launcher.appweibo.R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(com.launcher.appweibo.R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, com.launcher.appweibo.R.string.navigation_drawer_open, com.launcher.appweibo.R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(com.launcher.appweibo.R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @OnClick(com.launcher.appweibo.R.id.bt_network)
    public void getAuth(View view){
        Toast.makeText(this, "hehe ", Toast.LENGTH_LONG).show();

        try {
            SimpleService.main();
        }catch (IOException e){
            Log.e("MainActivity", "error: " + e);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(com.launcher.appweibo.R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(com.launcher.appweibo.R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == com.launcher.appweibo.R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == com.launcher.appweibo.R.id.nav_camera) {
            // Handle the camera action
        } else if (id == com.launcher.appweibo.R.id.nav_gallery) {

        } else if (id == com.launcher.appweibo.R.id.nav_slideshow) {

        } else if (id == com.launcher.appweibo.R.id.nav_manage) {

        } else if (id == com.launcher.appweibo.R.id.nav_share) {

        } else if (id == com.launcher.appweibo.R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(com.launcher.appweibo.R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
