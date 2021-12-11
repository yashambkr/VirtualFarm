package com.example.virtualfarm2020;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class LoginPage extends AppCompatActivity {
    DatabaseReference databaseReference;
    EditText systemId, user,passwordE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        systemId = findViewById(R.id.sys_id);
        user = findViewById(R.id.Username);
        passwordE = findViewById(R.id.password);
        Button loginbtn = (Button) findViewById(R.id.SigninBtn);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("System1");
        loginbtn.setOnClickListener(view -> {
            try{
                databaseReference.addValueEventListener(new ValueEventListener(){

                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String sysID = Objects.requireNonNull(snapshot.child("SystemId").getValue()).toString();
                        String userID = Objects.requireNonNull(snapshot.child("UserId").getValue()).toString();
                        String pass = Objects.requireNonNull(snapshot.child("Password").getValue()).toString();

                        String sysId = systemId.getText().toString();
                        String userId = user.getText().toString();
                        String password = passwordE.getText().toString();

                        if(sysID.equals(sysId) && userID.equals(userId) && pass.equals(password)){
                            Toast.makeText(getApplicationContext(), "LoginSuccess",Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Failed",Toast.LENGTH_LONG).show();

                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }catch (Exception e){
                Toast.makeText(getApplicationContext(), "Success",Toast.LENGTH_LONG).show();
            }
        });


    }
}