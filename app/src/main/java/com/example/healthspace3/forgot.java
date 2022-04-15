package com.example.healthspace3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class forgot extends AppCompatActivity {
private EditText resetpass;
private Button resetbutton;
private ProgressBar progressBar;
FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);
        resetpass = (EditText) findViewById(R.id.resetemail);
        resetbutton = (Button) findViewById(R.id.button6);
        auth = FirebaseAuth.getInstance();
        resetbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = resetpass.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter your email!", Toast.LENGTH_SHORT).show();
                    return;
                }

                auth.sendPasswordResetEmail(email)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(forgot.this, "Check your email!", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(forgot.this, "Fail to reset!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });


    }

}