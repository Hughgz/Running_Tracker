package com.example.running;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.login.Login;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SettingActivity extends AppCompatActivity {
    ImageView logout;
    FirebaseAuth mAuth;
    LinearLayout status;
    TextView txtStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);

        txtStatus = findViewById(R.id.txt_status);
        status = findViewById(R.id.status_app);
        updateUI(mAuth.getCurrentUser());
        logout = findViewById(R.id.logout_setting);
        logout.setOnClickListener(v -> {
            Intent intent = new Intent(SettingActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        mAuth = FirebaseAuth.getInstance();
        status = findViewById(R.id.status_app);

        // Kiểm tra xem người dùng đã đăng nhập chưa
        updateUI(mAuth.getCurrentUser());

        status.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Nếu người dùng đã đăng nhập, thì thực hiện đăng xuất
                if (mAuth.getCurrentUser() != null) {
                    mAuth.signOut();
                    updateUI(null);
                    Toast.makeText(SettingActivity.this, "Đã đăng xuất", Toast.LENGTH_SHORT).show();
                } else {
                    // Nếu người dùng chưa đăng nhập, mở activity đăng nhập
                    startActivity(new Intent(SettingActivity.this, LoginActivity.class));
                }
            }
        });
    }

    // Cập nhật giao diện người dùng dựa trên trạng thái đăng nhập
    private void updateUI(FirebaseUser user) {
        if (user != null) {
            txtStatus.setText("Đăng xuất");
        } else {
            txtStatus.setText("Đăng nhập");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Kiểm tra xem người dùng đã đăng nhập từ trước đó không
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }
}