package com.example.virtualfarm2020;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainDashboard extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dashboard);
//        if(SaveSharedPreference.getUserName(MainDashboard.this).length() == 0)
//        {
//            // call Login Activity
//            Intent intent= new Intent(getBaseContext(),LoginPage.class);
//            startActivity(intent);
//        }
//        else
//        {
//            // Stay at the current activity.
//        }

    }

    public void openScreen(View view) {
        Intent i = new Intent(this, GraphActivity.class);
        startActivity(i);
    }

    //exit app after back press two times
    private static final int TIME_INTERVAL = 2000; // # milliseconds, desired time passed between two back presses.
    private long mBackPressed;
    Toast backToast;

    @Override
    public void onBackPressed() {
        if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis()) {
            backToast.cancel();
            super.onBackPressed();
            finishAffinity();
        }
        else {
            backToast = Toast.makeText(this, "Tap back button in order to exit", Toast.LENGTH_SHORT);
            backToast.show();
        }
        mBackPressed = System.currentTimeMillis();
    }

}