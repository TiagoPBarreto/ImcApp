package com.projeto.imcapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.projeto.imcapp.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    SharedPreferences preferences;
    public static final String MyPREFERENCES = "MyPrefs";
    public static final String Email = "emailKey";
    public static final String Senha = "senhaKey";
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(binding.edLoginEmail.getText().toString())) {
                    Toast.makeText(LoginActivity.this, "Necessario informar o email", Toast.LENGTH_SHORT).show();

                } else if (TextUtils.isEmpty(binding.edLoginSenha.getText().toString())) {
                    Toast.makeText(LoginActivity.this, "Necessario informar a senha", Toast.LENGTH_SHORT).show();
                } else {
                    loginSharedPreferences();
                }
            }
        });


        binding.tvCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    public void loginSharedPreferences() {

        preferences = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
        String stringSenha = preferences.getString(Senha, null);
        String stringEmail = preferences.getString(Email, null);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(stringEmail, stringSenha);
        if (stringEmail.equals("emailKey") && stringSenha.equals("senhaKey")) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Dados incorretos", Toast.LENGTH_SHORT).show();
        }
    }
}