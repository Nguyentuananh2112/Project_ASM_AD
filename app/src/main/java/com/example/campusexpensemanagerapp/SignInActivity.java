package com.example.campusexpensemanagerapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SignInActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        EditText editUserName, editPassword;

        Button btnLogin;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        editUserName = findViewById(R.id.emailEditText);
        editPassword = findViewById(R.id.passwordEditText);
        btnLogin = findViewById(R.id.signInButton);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = editUserName.getText().toString().trim();
                String Password = editPassword.getText().toString().trim();
                if (TextUtils.isEmpty(user) || TextUtils.isEmpty(Password)){
                    Toast.makeText(SignInActivity.this, "Username and password is not empty",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                if (user.equals("admin") && Password.equals("123")){
                    // Thanh cong
                    // chuyen sang page Dashboard
                    Intent intent = new Intent(SignInActivity.this, DashboardActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    // false
                    Toast.makeText(SignInActivity.this, "Account Invalid", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
    }
}
