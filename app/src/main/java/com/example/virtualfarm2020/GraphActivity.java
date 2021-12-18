package com.example.virtualfarm2020;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class GraphActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        //when change button clicked
        Button btn = findViewById(R.id.pHButton);
        btn.setOnClickListener(v -> pHChange());
    }

    //pHChange sets the new pH
    //TODO
    private void pHChange() {
        float pH = Float.parseFloat(String.valueOf(R.id.pHChangeValue));
    }


}