package com.example.healthspace3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class begin extends AppCompatActivity {
    private Button heartbutton, microbutton, anbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin);
        initializeUI();

        heartbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(begin.this, weather.class));
            }
        });
        microbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(begin.this, heartbeat.class));
            }
        });
        anbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(begin.this, microphone.class));
            }
        });

    }
    public void initializeUI(){

        heartbutton = (Button) findViewById(R.id.button3);
        microbutton = (Button) findViewById(R.id.button2);
        anbutton = (Button) findViewById(R.id.button);


    }

}


