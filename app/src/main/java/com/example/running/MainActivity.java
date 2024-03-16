package com.example.running;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity{
    ImageView loginUser;
    LinearLayout home;
    LinearLayout profile;
    LinearLayout notification;
    LinearLayout setting;
    LinearLayout btnRun;
    TextView infoUser;
    FirebaseAuth mAuth;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        infoUser = findViewById(R.id.txtChouserBn);
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        loginUser = findViewById(R.id.img_user);
        home = findViewById(R.id.home);
        profile = findViewById(R.id.profile);
        notification = findViewById(R.id.notification);
        setting = findViewById(R.id.setting);
        btnRun = findViewById(R.id.running);

        if (user != null) {
            String email = user.getEmail();
            infoUser.setText("Địa chỉ email: " + email);
        } else {
            infoUser.setText("Hello bạn");
        }
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