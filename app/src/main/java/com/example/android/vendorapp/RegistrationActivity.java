package com.example.android.vendorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationActivity extends AppCompatActivity {

    TextInputLayout reg_name, reg_email, reg_number, reg_pan_number, reg_password;
    Button register_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        reg_name = findViewById(R.id.reg_name);
        reg_email = findViewById(R.id.reg_email);
        reg_number = findViewById(R.id.reg_contact_number);
        reg_pan_number = findViewById(R.id.reg_pan_card);
        reg_password = findViewById(R.id.reg_password);
        register_button = findViewById(R.id.register_btn);

        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    private void registerUser() {

        final String name = reg_name.getEditText().getText().toString().trim();
        final String email = reg_email.getEditText().getText().toString().trim();
        final String phoneNumber = reg_number.getEditText().getText().toString().trim();
        final String panNumber = reg_pan_number.getEditText().getText().toString().trim();
        String password = reg_password.getEditText().getText().toString().trim();

        if(name.isEmpty()){
            reg_name.setError("Field cannot be empty");
            reg_name.requestFocus();
            return;
        } else{
            reg_name.setError(null);
            reg_name.clearFocus();
        }

        if(email.isEmpty()){
            reg_email.setError("Field cannot be empty");
            reg_email.requestFocus();
            return;
        } else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            reg_email.setError("Enter a valid email");
            reg_email.requestFocus();
            return;
        } else{
            reg_email.setError(null);
            reg_email.clearFocus();
        }

        if(phoneNumber.isEmpty()){
            reg_number.setError("Field cannot be empty");
            reg_number.requestFocus();
            return;
        } else if(phoneNumber.length() != 10){
            reg_number.setError("Phone number length is 10");
            reg_number.requestFocus();
            return;
        } else{
            reg_number.setError(null);
            reg_number.clearFocus();
        }

        Pattern pattern = Pattern.compile("[A-Z]{5}[0-9]{4}[A-Z]{1}");
        Matcher matcher = pattern .matcher(panNumber);
        if (panNumber.isEmpty()){
            reg_pan_number.setError("Field cannot be empty");
            reg_pan_number.requestFocus();
            return;
        } else if (!matcher.matches()){
            reg_pan_number.setError("Invalid Pan Card Number");
            reg_pan_number.requestFocus();
            return;
        } else{
            reg_pan_number.setError(null);
            reg_pan_number.clearFocus();
        }

        if(password.isEmpty()){
            reg_password.setError("Field cannot be empty");
            reg_password.requestFocus();
            return;
        } else{
            reg_password.setError(null);
            reg_password.clearFocus();
        }

        Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
        startActivity(intent);
//        finish();
    }
}