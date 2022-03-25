package com.example.virtualfarm2020;

import android.os.SystemClock;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;

public class DataPoint {
    //get x axis and y axis
//    LineChart lineChart;
//    XAxis xAxis = lineChart != null ? lineChart.getXAxis() : null;

    //y axis
    float pH;
    long ts; //time in seconds

    public DataPoint(long ts, float ph){
        this.pH= ph;
        this.ts= ts;
    }

    public float getpH() {
        return pH;
    }

    public long getTs(){
        return ts;
    }
}
