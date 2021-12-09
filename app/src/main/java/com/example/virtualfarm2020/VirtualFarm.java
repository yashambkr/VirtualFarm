package com.example.virtualfarm2020;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


public class VirtualFarm extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void openActivity2(View view) {
        displayToast(getString(R.string.welcome_message));
        Intent intent = new Intent(VirtualFarm.this, HomeScreen.class);
        startActivity(intent);
    }

}