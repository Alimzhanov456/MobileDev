package com.example.bookapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bookapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SplashActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        firebaseAuth = FirebaseAuth.getInstance();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                checkUser();
            }
        }, 2000);
    }

    private void checkUser() {
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if (firebaseUser == null) {
            // Пользователь не вошел в систему, перейдите к активности входа/регистрации
            startActivity(new Intent(SplashActivity.this, LoginActivity.class));
            finish();
        } else {
            DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Users");
            ref.child(firebaseUser.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    if (snapshot.exists()) {
                        String userType = snapshot.child("userType").getValue(String.class);
                        if (userType != null) {
                            if (userType.equals("user")) {
                                // Пользователь обычный, перейдите к пользовательской панели
                                startActivity(new Intent(SplashActivity.this, DashboardUserActivity.class));
                                finish();
                            } else if (userType.equals("admin")) {
                                // Пользователь администратор, перейдите к панели администратора
                                startActivity(new Intent(SplashActivity.this, DashboardAdminActivity.class));
                                finish();
                            }
                        } else {
                            // Неверный формат данных о типе пользователя
                            Toast.makeText(SplashActivity.this, "Ошибка: Неверный формат данных о типе пользователя", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        // Данные пользователя не найдены в базе данных
                        Toast.makeText(SplashActivity.this, "Ошибка: Данные пользователя не найдены", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Ошибка доступа к базе данных Firebase
                    Toast.makeText(SplashActivity.this, "Ошибка доступа к базе данных Firebase", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
