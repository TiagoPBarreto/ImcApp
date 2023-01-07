package com.projeto.imcapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.projeto.imcapp.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {
    private ActivityRegisterBinding binding;
    public static final String MyPREFERENCES = "MyPrefs";
    public static final String nome = "nameKey";
    public static final String sobrenome = "sobreNomeKey";
    public static final String email = "emailKey";
    public static final String senha = "senhaKey";
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        binding.btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(binding.edRegistroNome.getText().toString())) {
                    Toast.makeText(RegisterActivity.this,
                            "Necessario informar seu nome", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(binding.edregistroSobreNome.getText().toString())) {
                    Toast.makeText(RegisterActivity.this,
                            "Necessario informar seu Sobrenome", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(binding.edRegistroEmail.getText().toString())) {
                    Toast.makeText(RegisterActivity.this,
                            "Necessario informar seu email", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(binding.edRegistroSenha.getText().toString())) {
                    Toast.makeText(RegisterActivity.this,
                            "Necessario informar sua Senha", Toast.LENGTH_SHORT).show();
                } else {
                    salvarSharedPreferences();
                    Toast.makeText(RegisterActivity.this, "Cadastro salvo com sucesso!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            }
        });

        binding.tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void salvarSharedPreferences() {

        String nome = binding.edRegistroNome.getText().toString();
        String sobreNome = binding.edregistroSobreNome.getText().toString();
        String email = binding.edRegistroEmail.getText().toString();
        String senha = binding.edRegistroSenha.getText().toString();

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(nome, nome);
        editor.putString(sobreNome, sobreNome);
        editor.putString(email, email);
        editor.putString(senha, senha);
        editor.apply();
    }
}