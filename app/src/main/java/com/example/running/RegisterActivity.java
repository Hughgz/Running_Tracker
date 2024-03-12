package com.example.running;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class RegisterActivity extends AppCompatActivity {
    ImageView imageBackSite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        imageBackSite = findViewById(R.id.btn_logout);

        imageBackSite.setOnClickListener(v -> {
            Intent backSite = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(backSite);
        });
    }
}