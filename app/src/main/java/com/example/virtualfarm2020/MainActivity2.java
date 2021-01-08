package com.example.virtualfarm2020;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity2 extends AppCompatActivity {

    DatabaseReference mydb;
    TextView temp, hum, mois;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        temp = (TextView) findViewById(R.id.temp);
        hum = (TextView) findViewById(R.id.hum);
        mois = (TextView) findViewById(R.id.mois);
        mydb = FirebaseDatabase.getInstance().getReference().child("Sensor");
        try {

            mydb.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    String tempdata = dataSnapshot.child("temp").getValue().toString();
                    String humdata = dataSnapshot.child("hum").getValue().toString();
                    String moisdata = dataSnapshot.child("mois").getValue().toString();
                    String tubedata = moisdata + '%';
                    temp.setText(tempdata);
                    hum.setText(humdata);
                    mois.setText(tubedata);


                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value

                }
            });
        } catch (Exception e) {


        }
    }
}