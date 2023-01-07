package com.projeto.imcapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.projeto.imcapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnResultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validarCampo();
            }
        });

        binding.btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limparImc();
            }
        });
    }

    private void limparImc() {
        binding.edAltura.setText("");
        binding.edPeso.setText("");
        binding.edImc.setText("");
    }

    public void imcResultado() {
        double peso = Double.parseDouble(binding.edPeso.getText().toString());
        double altura = Double.parseDouble(binding.edAltura.getText().toString());
        double resultado = peso / (altura * altura);

        if (resultado <= 18.5) {
            binding.edImc.setText(" Abaixo do peso");
        } else if (resultado < 18.5 || resultado <= 24.9) {
            binding.edImc.setText("Peso normal");
        } else if (resultado < 24.9 || resultado <= 30) {
            binding.edImc.setText("Sobrepeso(acima do peso desejado)");
        } else if (resultado > 30) {
            binding.edImc.setText("Obesidade");
        }
    }

    private void validarCampo() {

        if (TextUtils.isEmpty(binding.edAltura.getText().toString())) {
            Toast.makeText(this, "Necessario informar a Altura", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(binding.edPeso.getText().toString())) {
            Toast.makeText(this, "Necessario informar o Peso", Toast.LENGTH_SHORT).show();
        } else {
            imcResultado();
        }
    }
}