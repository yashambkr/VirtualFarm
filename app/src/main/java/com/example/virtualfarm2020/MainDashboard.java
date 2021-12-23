package com.example.virtualfarm2020;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dashboard);


    }

    public void openScreen(View view){
        Intent i = new Intent(this, GraphActivity.class);
        startActivity(i);
    }




}