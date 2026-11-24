package com.example.android2exam;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    EditText email, password;
    Button login;
    long backPressedTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);

        login.setEnabled(false);

        TextWatcher watcher = new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s,
                    int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s,
                    int start, int before, int count) {

                String e = email.getText().toString().trim();
                String p = password.getText().toString();

                login.setEnabled(
                    Patterns.EMAIL_ADDRESS.matcher(e).matches()
                    && p.length() >= 6
                );
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        };

        email.addTextChangedListener(watcher);
        password.addTextChangedListener(watcher);

        login.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,
                    ModeActivity.class);
            startActivity(intent);
        });

        getOnBackPressedDispatcher().addCallback(this,
                new OnBackPressedCallback(true) {

            @Override
            public void handleOnBackPressed() {

                long currentTime = SystemClock.elapsedRealtime();

                if (backPressedTime != 0 &&
                    currentTime - backPressedTime < 3000) {

                    finishAffinity();

                } else {

                    backPressedTime = currentTime;

                    Snackbar.make(
                        findViewById(R.id.main_layout),
                        "Press back again to exit",
                        3000
                    ).show();
                }
            }
        });
    }
}
