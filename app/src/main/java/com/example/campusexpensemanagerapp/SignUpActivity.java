//package com.example.campusexpensemanagerapp;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//
//
//public class SignUpActivity extends AppCompatActivity {
//    private EditText emailEditText, passwordEditText, confirmPasswordEditText;
//    private Button signUpButton;
//    private TextView goToSignIn;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sign_up);
//
//        emailEditText = findViewById(R.id.emailEditText);
//        passwordEditText = findViewById(R.id.passwordEditText);
//        confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText);
//        signUpButton = findViewById(R.id.signUpButton);
//        goToSignIn = findViewById(R.id.goToSignIn);
//
//        signUpButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String email = emailEditText.getText().toString().trim();
//                String password = passwordEditText.getText().toString().trim();
//                String confirmPassword = confirmPasswordEditText.getText().toString().trim();
//
//                if (validateSignUp(email, password, confirmPassword)) {
//                    // Here you would typically save the user to a database
//                    Toast.makeText(SignUpActivity.this, "Sign Up Successful", Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(SignUpActivity.this, SignInActivity.class));
//                }
//            }
//        });
//
//        goToSignIn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(SignUpActivity.this, SignInActivity.class));
//            }
//        });
//    }
//
//    private boolean validateSignUp(String email, String password, String confirmPassword) {
//        if (email.isEmpty()) {
//            emailEditText.setError("Email is required");
//            return false;
//        }
//        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
//            emailEditText.setError("Enter a valid email");
//            return false;
//        }
//        if (password.isEmpty()) {
//            passwordEditText.setError("Password is required");
//            return false;
//        }
//        if (password.length() < 6) {
//            passwordEditText.setError("Password must be at least 6 characters");
//            return false;
//        }
//        if (!password.equals(confirmPassword)) {
//            confirmPasswordEditText.setError("Passwords don't match");
//            return false;
//        }
//        return true;
//    }
//}
