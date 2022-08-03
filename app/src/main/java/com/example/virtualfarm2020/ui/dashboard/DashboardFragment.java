package com.example.virtualfarm2020.ui.dashboard;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.virtualfarm2020.R;
import com.example.virtualfarm2020.databinding.FragmentDashboardBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    private DatabaseReference mDatabase= FirebaseDatabase.getInstance().getReference().child("UsersData/System101");
    private String waterLevelTxt, TemperatureStsTxt, HumidityStsTxt,NutrientStsTxt, WaterTempStsTxt,phStsTxt;
    private  TextView waterLevelSts, TemperatureSts, HumiditySts,TDSSts, WaterTempSts,phSts;
    private Button atmosphereControlBtn, tankControlBtn;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Activity activity = getActivity();

        final TextView textView = binding.textDashboard;
        TemperatureSts = binding.idTempStsValue;
        HumiditySts = binding.idHumidityStsValue;
        TDSSts = binding.idWaterTDSStsValue;
        WaterTempSts = binding.idWaterTempStsValue;
        waterLevelSts = binding.idWaterLevelStsValue;
        phSts = binding.idWaterPHStsValue;
        atmosphereControlBtn = binding.AtmosphereFragmentBtn;
        tankControlBtn = binding.TankFragmentBtn;

        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

               String TemperatureStsTxt1 = snapshot.child("/Monitor/TempC").getValue().toString();
                textView.setText(TemperatureStsTxt1);

                TemperatureStsTxt = snapshot.child("/Monitor/TempC").getValue().toString();
                HumidityStsTxt =  snapshot.child("/Monitor/HumC").getValue().toString();
                NutrientStsTxt = snapshot.child("/Monitor/TdsC").getValue().toString();
                WaterTempStsTxt = snapshot.child("/Monitor/WaterTmpC").getValue().toString();
                phStsTxt = snapshot.child("/Monitor/pHC").getValue().toString();

                TemperatureSts.setText(TemperatureStsTxt + " °C");
                HumiditySts.setText(HumidityStsTxt+" RH");
                TDSSts.setText(NutrientStsTxt+ " ppm");
                WaterTempSts.setText(WaterTempStsTxt+ " °C");
                phSts.setText(phStsTxt);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // calling on cancelled method when we receive
                // any error or we are not able to get the data.

                Toast.makeText(activity,"Fail to get data!",Toast.LENGTH_SHORT).show();
            }
        });

        
        //dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}