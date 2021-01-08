package com.example.virtualfarm2020;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void openActivity2(View view) {
        displayToast(getString(R.string.welcome_message));
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(intent);
    }

}