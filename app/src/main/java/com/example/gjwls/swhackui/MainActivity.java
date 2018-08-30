package com.example.gjwls.swhackui;

import android.Manifest;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final int CODE_PERMISSIONS = 0;//...
    private boolean egyptFlag = false, usaFlag = false, korFlag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] neededPermissions = {
                Manifest.permission.CHANGE_WIFI_STATE,
                Manifest.permission.ACCESS_WIFI_STATE,
                Manifest.permission.ACCESS_COARSE_LOCATION
        };
        ActivityCompat.requestPermissions( this, neededPermissions, CODE_PERMISSIONS );

        findViewById(R.id.one).bringToFront();
        findViewById(R.id.two).bringToFront();
        findViewById(R.id.three).bringToFront();
        findViewById(R.id.four).bringToFront();
        findViewById(R.id.five).bringToFront();
        findViewById(R.id.six).bringToFront();
        findViewById(R.id.seven).bringToFront();

        findViewById(R.id.one).setVisibility(View.INVISIBLE);
        findViewById(R.id.two).setVisibility(View.INVISIBLE);
        findViewById(R.id.three).setVisibility(View.INVISIBLE);
        findViewById(R.id.four).setVisibility(View.INVISIBLE);
        findViewById(R.id.five).setVisibility(View.INVISIBLE);
        findViewById(R.id.six).setVisibility(View.INVISIBLE);
        findViewById(R.id.seven).setVisibility(View.INVISIBLE);

        findViewById(R.id.usaButton).setOnClickListener(this);
        findViewById(R.id.koreaButton).setOnClickListener(this);
        findViewById(R.id.egyptButton).setOnClickListener(this);
        findViewById(R.id.usaButton).setOnClickListener(this);
        findViewById(R.id.usaButton).setOnClickListener(this);
        findViewById(R.id.usaButton).setOnClickListener(this);
        findViewById(R.id.usaButton).setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_start:
                Intent intent=new Intent(MainActivity.this,NavigationActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();

        if (id==R.id.egyptButton){
            if(egyptFlag) {
                findViewById(R.id.one).setVisibility(View.INVISIBLE);
                egyptFlag = false;
            }
            else {
                findViewById(R.id.one).setVisibility(View.VISIBLE);
                egyptFlag = true;
            }
        } else if(id == R.id.koreaButton){
            if(korFlag){
                findViewById(R.id.two).setVisibility(View.INVISIBLE);
                korFlag = false;
            }
            else {
                findViewById(R.id.two).setVisibility(View.VISIBLE);
                korFlag = true;
            }

        } else if (id == R.id.usaButton){
            if(usaFlag){
                findViewById(R.id.three).setVisibility(View.INVISIBLE);
                usaFlag = false;
            }

            else{
                findViewById(R.id.three).setVisibility(View.VISIBLE);
                usaFlag = true;
            }

        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        //Handle if any of the permissions are denied, in grantResults
    }
}
