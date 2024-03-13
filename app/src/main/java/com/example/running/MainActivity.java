package com.example.running;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity{
    ImageView loginUser;
    LinearLayout home;
    LinearLayout profile;
    LinearLayout notification;
    LinearLayout setting;
    LinearLayout btnRun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        loginUser = findViewById(R.id.img_user);
        home = findViewById(R.id.home);
        profile = findViewById(R.id.profile);
        notification = findViewById(R.id.notification);
        setting = findViewById(R.id.setting);
        btnRun = findViewById(R.id.running);
        loginUser.setOnClickListener(v -> {
            Intent intentLogin = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intentLogin);
        });
        home.setOnClickListener(v -> {
            Intent intentLogin = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intentLogin);
        });
        profile.setOnClickListener(v -> {
            Intent intentLogin = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intentLogin);
        });
        notification.setOnClickListener(v -> {
            Intent intentLogin = new Intent(MainActivity.this, NotificationActivity.class);
            startActivity(intentLogin);
        });
        setting.setOnClickListener(v -> {
            Intent intentLogin = new Intent(MainActivity.this, SettingActivity.class);
            startActivity(intentLogin);
        });
        btnRun.setOnClickListener(v -> {
            Intent intentLogin = new Intent(MainActivity.this, MapActivity.class);
            startActivity(intentLogin);
        });
    }
}