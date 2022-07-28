package com.example.virtualfarm2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class DataGraph extends AppCompatActivity {
    private DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child("UsersData/System101/SensorData");

    GraphView graphView;
    LineGraphSeries series;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_graph);

        graphView = findViewById(R.id.pHLineChart);
        series = new LineGraphSeries();
        graphView.addSeries(series);


    }

    @Override
    protected void onStart() {
        super.onStart();
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot snapshot) {
                DataPoint[] dp = new DataPoint[(int) snapshot.getChildrenCount()];
                int index = 0;
                 for(DataSnapshot myDataSnapshot : snapshot.getChildren()){
                     PointValue pointValue = myDataSnapshot.getValue(PointValue.class);
                     dp[index] = new DataPoint(pointValue.getxValue(),pointValue.getyValue());
                     index++;
                 }
                 series.resetData(dp);
            }

            @Override
            public void onCancelled( DatabaseError error) {

            }
        });
    }
}