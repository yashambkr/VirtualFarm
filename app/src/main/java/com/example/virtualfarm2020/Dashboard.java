package com.example.virtualfarm2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Dashboard extends CheckSystem {

    private DatabaseReference mDatabase= FirebaseDatabase.getInstance().getReference().child("UsersData/System101");
    TextView lightSts, TemperatureSts, HumiditySts,NutrientSts, WaterTempSts,phSts;
    String lightStsTxt, TemperatureStsTxt, HumidityStsTxt,NutrientStsTxt, WaterTempStsTxt,phStsTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        lightSts = findViewById(R.id.idLightStsValue);
        TemperatureSts= findViewById(R.id.idTempStsValue);
        HumiditySts= findViewById(R.id.idHumidityStsValue);
        NutrientSts= findViewById(R.id.idTdsStsValue);
        WaterTempSts= findViewById(R.id.idWaterTempStsValue);
        phSts= findViewById(R.id.isPhStsValue);

        getData();

    }
    private void getData() {

        // calling add value event listener method
        // for getting the values from database.
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                TemperatureStsTxt = snapshot.child("/Monitor/TempC").getValue().toString();

                HumidityStsTxt =  snapshot.child("/Monitor/HumC").getValue().toString();
                NutrientStsTxt = snapshot.child("/Monitor/TdsC").getValue().toString();
                WaterTempStsTxt = snapshot.child("/Monitor/WaterTmpC").getValue().toString();
                phStsTxt = snapshot.child("/Monitor/pHC").getValue().toString();

                TemperatureSts.setText(TemperatureStsTxt + " °C");
                HumiditySts.setText(HumidityStsTxt+" RH");
                NutrientSts.setText(NutrientStsTxt+ " ppm");
                WaterTempSts.setText(WaterTempStsTxt+ " °C");
                phSts.setText(phStsTxt);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // calling on cancelled method when we receive
                // any error or we are not able to get the data.
                Toast.makeText(Dashboard.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
            }
        });

    }
}