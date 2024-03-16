package com.example.running;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
    ImageView imageBackSite;
    EditText inputEmail, inputPassword, inputConfirmPassword;
    LinearLayout btnRegister;
    String email, password, confirmPassword;
    FirebaseAuth mAuth;
    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(RegisterActivity.this, LoginAccountActivity.class);
            startActivity(intent);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        inputEmail = findViewById(R.id.register_email);
        inputPassword = findViewById(R.id.register_password);
        inputConfirmPassword = findViewById(R.id.register_repeat_password);
        btnRegister = findViewById(R.id.btn_register);
        mAuth = FirebaseAuth.getInstance();

        btnRegister.setOnClickListener(v -> {
            email = String.valueOf(inputEmail.getText());
            password = String.valueOf(inputPassword.getText());
            confirmPassword = String.valueOf(inputConfirmPassword.getText());
            if(TextUtils.isEmpty(email)){
                Toast.makeText(this, "Enter email", Toast.LENGTH_SHORT).show();
                return;
            }
            if(TextUtils.isEmpty(password)){
                Toast.makeText(this, "Enter password", Toast.LENGTH_SHORT).show();
                return;
            }
            if(TextUtils.isEmpty(confirmPassword)){
                Toast.makeText(this, "Enter confirm password", Toast.LENGTH_SHORT).show();
                return;
            }
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, task -> {
                        if (task.isSuccessful()) {
                            Toast.makeText(RegisterActivity.this, "Authentication created.",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(RegisterActivity.this, LoginAccountActivity.class);
                            startActivity(intent);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    });
        });


        imageBackSite = findViewById(R.id.btn_logout);
        imageBackSite.setOnClickListener(v -> {
            Intent backSite = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(backSite);
        });
    }
}