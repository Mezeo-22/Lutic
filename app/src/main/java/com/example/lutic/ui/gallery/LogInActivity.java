package com.example.lutic.ui.gallery;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lutic.MainActivity;
import com.example.lutic.R;

public class LogInActivity extends AppCompatActivity {

    private Button loginBtn;
    private EditText loginEt;
    private EditText passwordEt;
    private TextView warningTv;
    private TextView number;

    int attempts = 3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        loginBtn = (Button) findViewById(R.id.buttonLogin);
        loginEt = (EditText) findViewById(R.id.editTextLogin);
        passwordEt = (EditText) findViewById(R.id.editTextPassword);
        warningTv = (TextView) findViewById(R.id.textWarning);
        number = (TextView) findViewById(R.id.textNumber);
        warningTv.setText(Integer.toString(attempts));

        loginBtn.setOnClickListener(view -> {
            Login(view);
        });
    }

    public void Login(View view) {
        if (loginEt.getText().toString().equals("admin") &&
                passwordEt.getText().toString().equals("admin")) {
            Toast.makeText(getApplicationContext(), "Вход выполнен!", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(LogInActivity.this, MainActivity.class);
            startActivity(intent);
        }

        else {
            Toast.makeText(getApplicationContext(), "Неправильные данные!", Toast.LENGTH_SHORT).show();
            attempts--;

            number.setVisibility(View.VISIBLE);
            number.setText(Integer.toString(attempts));

            if (attempts == 0) {
                loginBtn.setEnabled(false);
                warningTv.setVisibility(View.VISIBLE);
                warningTv.setBackgroundColor(Color.RED);
                warningTv.setText("Вход заблокирован!!!");

            }
        }
    }
}
