package com.example.gjwls.swhackui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.indooratlas.android.sdk.IALocation;
import com.indooratlas.android.sdk.IALocationListener;
import com.indooratlas.android.sdk.IALocationManager;
import com.indooratlas.android.sdk.IALocationRequest;

public class NavigationActivity extends AppCompatActivity {


    private ViewPager viewPager;
    private SlideAdapter myAdapter;

    private final int CODE_PERMISSIONS = 0;//...

    IALocationManager mLocationManager;

    IALocationListener mLocationListener = new IALocationListener() {
        @Override
        public void onLocationChanged(IALocation iaLocation) {
            TextView txtLoc = (TextView)findViewById(R.id.txtTitle);
            Log.e(this.getClass().getName(),String.valueOf("---------------------------------"+iaLocation.getLatitude() +","+iaLocation.getLongitude()));
            txtLoc.setText(String.valueOf(iaLocation.getLatitude() +","+iaLocation.getLongitude()+iaLocation.getFloorLevel()));
        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        mLocationManager = IALocationManager.create(this);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        myAdapter = new SlideAdapter(this);
        viewPager.setAdapter(myAdapter);
    }

    @Override
    protected void onResume(){
        super.onResume();
        mLocationManager.requestLocationUpdates(IALocationRequest.create(),mLocationListener);
    }

    @Override
    protected void onPause(){
        super.onPause();
        mLocationManager.removeLocationUpdates(mLocationListener);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        mLocationManager.destroy();
    }
}
