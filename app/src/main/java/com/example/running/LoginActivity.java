package com.example.running;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    LinearLayout loginAccount;
    TextView register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        loginAccount = findViewById(R.id.btn_login_account);
        register = findViewById(R.id.register);
        loginAccount.setOnClickListener(v -> {
            Intent intentLoginAccount = new Intent(LoginActivity.this, LoginAccountActivity.class);
            startActivity(intentLoginAccount);
        });
        register.setOnClickListener(v -> {
            Intent intentRegister = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intentRegister);
        });
    }
}