package com.example.virtualfarm2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CheckSystem extends AppCompatActivity {
    private TextInputEditText sysIdEdt;
    public String sysIdTxt;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("UsersData/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_system);

        sysIdEdt = findViewById(R.id.idSysemEdt);
        Button checkSysBtn = findViewById(R.id.idCheckSysBtn);

         sysIdTxt = sysIdEdt.getText().toString();
        checkSysBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* myRef.child(sysIdTxt+"/").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (!task.isSuccessful()) {
                            Toast.makeText(CheckSystem.this,"Error getting data",Toast.LENGTH_LONG);
                            Log.e("firebase", "Error getting data", task.getException());
                        }
                        else {
                            Toast.makeText(CheckSystem.this, String.valueOf(task.getResult().getValue()),Toast.LENGTH_LONG);
                            Log.d("firebase", String.valueOf(task.getResult().getValue()));

                        }
                    }
                });*/


                myRef.child(sysIdTxt).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            Toast.makeText(CheckSystem.this, "True", Toast.LENGTH_LONG);
                            Log.d("firebase", "Child Exist");
                            Intent intent = new Intent(CheckSystem.this,Dashboard.class);
                            startActivity(intent);

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Log.d("firebase", "Child Exist error: " + error);
                    }
                });

            }
        });


    }
}