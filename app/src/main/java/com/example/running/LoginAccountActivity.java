package com.example.running;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class LoginAccountActivity extends AppCompatActivity {
    ImageView imageBackSite;
    EditText email, password;
    LinearLayout btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_account);
        btn_login = findViewById(R.id.btn_login);
        email = findViewById(R.id.inputEmail);
        password = findViewById(R.id.inputPassword);
        imageBackSite = findViewById(R.id.btn_logout);


        if(email.getText().toString().equals("hieu@123") && password.getText().toString().equals("minhhieu123")){
            btn_login.setOnClickListener(v -> {
                Intent login = new Intent(LoginAccountActivity.this, MainActivity.class);
                startActivity(login);
            });
        }else{
            Toast.makeText(this, "Bạn đăng nhập sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
        }
        imageBackSite.setOnClickListener(v -> {
            Intent backSite = new Intent(LoginAccountActivity.this, LoginActivity.class);
            startActivity(backSite);
        });
    }


}