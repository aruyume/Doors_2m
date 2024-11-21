package com.example.doors_2m;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etEmail = findViewById(R.id.et_email);
        EditText etPassword = findViewById(R.id.et_password);
        Button buttonSignIn = findViewById(R.id.btn_signIn);
        TextView tvEnter = findViewById(R.id.tv_enter);
        TextView tvWelcome = findViewById(R.id.tv_welcome);
        TextView tvDescription = findViewById(R.id.tv_description);
        TextView tvForgotPassword = findViewById(R.id.tv_forgotPassword);
        TextView tvTapHere = findViewById(R.id.tv_tapHere);

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (etEmail.getText().length() > 0 && etPassword.getText().length() > 0) {
                    buttonSignIn.setBackgroundResource(R.drawable.bg_btn_orange);
                } else {
                    buttonSignIn.setBackgroundResource(R.drawable.bg_btn_gray);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        };

        etEmail.addTextChangedListener(textWatcher);
        etPassword.addTextChangedListener(textWatcher);

        buttonSignIn.setOnClickListener(view -> {
            String userText = etEmail.getText().toString();
            String passText = etPassword.getText().toString();
            if ("admin".equals(userText) && "admin".equals(passText)) {
                Snackbar.make(view, "Вы успешно зарегистрировались", Snackbar.LENGTH_SHORT).show();
                tvWelcome.setText("Добро пожаловать, " + userText + "!");
                tvWelcome.setVisibility(View.VISIBLE);
                tvDescription.setVisibility(View.GONE);
                tvEnter.setVisibility(View.GONE);
                tvForgotPassword.setVisibility(View.GONE);
                tvTapHere.setVisibility(View.GONE);
                etEmail.setVisibility(View.GONE);
                etPassword.setVisibility(View.GONE);
                buttonSignIn.setVisibility(View.GONE);
            } else {
                Snackbar.make(view, "Неправильный логин или пароль", Snackbar.LENGTH_SHORT).show();
            }
        });
    }
}