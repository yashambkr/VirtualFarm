package com.example.virtualfarm2020;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class GraphActivity extends AppCompatActivity {
    LineChart lineChart;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference myref;
    LineDataSet lineDataSet= new LineDataSet(null, null);
    ArrayList<ILineDataSet> iLineDataSets= new ArrayList<>();
    LineData lineData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        //when change button clicked
        Button btn = findViewById(R.id.pHButton);
        btn.setOnClickListener(v -> pHChange());

        //line chart
        lineChart=findViewById(R.id.pHLineChart);
        firebaseDatabase= FirebaseDatabase.getInstance();
        myref=firebaseDatabase.getReference().child("Sensor");
        readData();

    }

    private void readData() {
        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<Entry> dataVal= new ArrayList<>();
                if(snapshot.hasChildren()){
//                    DataPoint dp= snapshot.child("pH").getValue(DataPoint.class);
//                    dataVal.add(new Entry(Objects.requireNonNull(dp).getTs(), dp.getpH()));
                    float ph= Float.parseFloat(String.valueOf(snapshot.child("pH").getValue()));
                    //String currentTime = new SimpleDateFormat("HH:mm a", Locale.getDefault()).format(new Date());
                    float ts= System.currentTimeMillis()/(1000*360);
                    dataVal.add(new Entry(ts,ph));
                    showChart(dataVal);
                }else{
                    lineChart.clear();
                    lineChart.invalidate();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getBaseContext(), "Failed to load", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showChart(ArrayList<Entry> dataVal) {
        lineDataSet.setValues(dataVal);
        lineDataSet.setLabel("pH");
       // iLineDataSets.clear();
        iLineDataSets.add(lineDataSet);
        lineData= new LineData(iLineDataSets);
        lineChart.clear();
        lineChart.setData(lineData);
        lineChart.invalidate();
    }

    //pHChange sets the new pH
    //TODO
    private void pHChange() {
        float pH = Float.parseFloat(String.valueOf(R.id.pHChangeValue));
    }


}