package com.example.healthspace3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class weather extends AppCompatActivity {
    private TextView textViewsecond, textViewthird;
    private DatabaseReference datarefsecond;
    private Button buttonsec;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        buttonsec = findViewById(R.id.button1);
        textViewsecond = findViewById(R.id.textView);
        textViewthird= (TextView) findViewById(R.id.textView3);

        datarefsecond = FirebaseDatabase.getInstance().getReference().child("HealthSpace").child("Weather");
        buttonsec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datarefsecond.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        if (snapshot.exists()) {
                            String Humidity = snapshot.child("Humidity").getValue().toString();
                            String Temperatutre = snapshot.child("Temperature").getValue().toString();
                            textViewthird.setText(Temperatutre);
                            textViewsecond.setText(Humidity);

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {


                    }
                });
            }
        });





    }



}
