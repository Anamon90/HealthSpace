package com.example.healthspace3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class heartbeat extends AppCompatActivity {
    private TextView textView;
    private DatabaseReference dataref;
    private Button button, buttonsecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heartbeat);
        button = (Button) findViewById(R.id.button5);
        textView = findViewById(R.id.textView2);
        buttonsecond = (Button) findViewById(R.id.button9);
        buttonsecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(heartbeat.this, begin.class));
            }
        });

        dataref = FirebaseDatabase.getInstance().getReference().child("HealthSpace").child("Pulse");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        if (snapshot.exists()) {
                            String Pulse = snapshot.child("Pulse").getValue().toString();
                            textView.setText(Pulse);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {


                    }
                });
            }
        });

    }
    public void openstart(){
        Intent intent = new Intent(this, weather.class);
    }

}


