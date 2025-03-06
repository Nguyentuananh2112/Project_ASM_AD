package com.example.campusexpensemanagerapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

public class SignUpActivity extends AppCompatActivity {

    EditText edtUsername, edtPassword;
    Button btnRegister;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnRegister = findViewById(R.id.btnRegister);
        signUp();
    }

    private void signUp(){
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edtUsername.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();
                if (TextUtils.isEmpty(user)){
                    edtUsername.setError("Username not empty");
                    return;
                }
                if (TextUtils.isEmpty(user)){
                    edtPassword.setError("Password not empty");
                    return;
                }


                // Lưu data user vào local storage
                FileOutputStream fileOutputStream = null;
                try {
                    user += "|"; //lối chuỗi ngăn cách giữa tk và mk

                    // Context.MODE_APPEND ghi nối ngay đằng sau
                    fileOutputStream = openFileOutput("account.txt", Context.MODE_APPEND);

                    fileOutputStream.write(user.getBytes(StandardCharsets.UTF_8));
                    fileOutputStream.write(password.getBytes(StandardCharsets.UTF_8));
                    fileOutputStream.write('\n');
                    fileOutputStream.close();

                    edtUsername.setText("");
                    edtPassword.setText("");

                    // thông báo
                    Toast.makeText(SignUpActivity.this, "Successfully", Toast.LENGTH_SHORT).show();

                    // tự động chuyển về login page
                    Intent intentLogin = new Intent(SignUpActivity.this, SignInActivity.class);
                    startActivity(intentLogin);

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
