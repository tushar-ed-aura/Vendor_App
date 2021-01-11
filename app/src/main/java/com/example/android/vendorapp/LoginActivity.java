package com.example.android.vendorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    Button login;
    TextInputLayout login_email, login_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = findViewById(R.id.login_btn);
        login_email = findViewById(R.id.logIn_email);
        login_password = findViewById(R.id.logIn_password);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });
    }

    private void loginUser() {
        final String email = login_email.getEditText().getText().toString().trim();
        String password = login_password.getEditText().getText().toString().trim();

        if (email.isEmpty()) {
            login_email.setError("Field cannot be empty");
            login_email.requestFocus();
            return;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            login_email.setError("Enter a valid email");
            login_email.requestFocus();
            return;
        } else {
            login_email.setError(null);
            login_email.clearFocus();
        }

        if (password.isEmpty()) {
            login_password.setError("Field cannot be empty");
            login_password.requestFocus();
            return;
        } else{
            login_password.setError(null);
            login_password.clearFocus();
        }

        Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
        startActivity(intent);
//                finish();
    }
}