package com.example.virtualfarm2020;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class MainDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dashboard);


        //Welcome Notification

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "virtual_farm")

                .setContentTitle("Welcome")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);


    }

   /*

    public void openScreen(View view){
        Intent i = new Intent(this, GraphActivity.class);
        startActivity(i);
    }
*/
    




}