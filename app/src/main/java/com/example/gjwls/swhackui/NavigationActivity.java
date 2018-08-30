package com.example.gjwls.swhackui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class NavigationActivity extends AppCompatActivity {


    private ViewPager viewPager;
    private SlideAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        myAdapter = new SlideAdapter(this);
        viewPager.setAdapter(myAdapter);
    }
}
