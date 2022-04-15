package com.example.healthspace3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class start extends AppCompatActivity {
    private EditText useremail, userpassword;
    private Button login, noaccount;
    private TextView forgotpassword;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        mAuth = FirebaseAuth.getInstance();
        initializeUI();
        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(start.this, forgot.class));
            }
        });
        noaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(start.this, signup.class));
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUserAccount();

            }


        });
    }

    private void loginUserAccount() {
        progressBar.setVisibility(View.VISIBLE);
        String User, Password;
        User = useremail.getText().toString();
        Password = userpassword.getText().toString();
        if (TextUtils.isEmpty(User)) {
            Toast.makeText(getApplicationContext(), "Please enter email...", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(Password)) {
            Toast.makeText(getApplicationContext(), "Please enter password!", Toast.LENGTH_LONG).show();
            return;
        }
        mAuth.signInWithEmailAndPassword(User, Password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Login successful!", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(start.this, begin.class);
                            startActivity(intent);
                            progressBar.setVisibility(View.GONE);

                        } else {
                            Toast.makeText(getApplicationContext(), "Login failed! Please try again later Or Sign Up", Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                            Intent intent = new Intent(start.this, signup.class);
                            startActivity(intent);

                        }
                    }
                });
    }


    private void initializeUI() {
        useremail = findViewById(R.id.User);
        userpassword = findViewById(R.id.Password);
        login = findViewById(R.id.Login);
        forgotpassword = findViewById(R.id.forgot);
        noaccount = findViewById(R.id.noac);
        progressBar = findViewById(R.id.progressBar);
    }

}