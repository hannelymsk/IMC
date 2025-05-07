package com.example.imc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etPeso, etAltura;
    TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPeso = findViewById(R.id.etPeso);
        etAltura = findViewById(R.id.etAltura);
        tvResultado = findViewById(R.id.tvResultado);
        Button btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pesoStr = etPeso.getText().toString();
                String alturaStr = etAltura.getText().toString();

                if (pesoStr.isEmpty() || alturaStr.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Informe peso e altura", Toast.LENGTH_SHORT).show();
                    return;
                }

                float peso = Float.parseFloat(pesoStr);
                float altura = Float.parseFloat(alturaStr);

                float imc = peso / (altura * altura);

                String resultado = String.format("IMC: %.2f - %s", imc, classificaIMC(imc));
                tvResultado.setText(resultado);
            }
        });
    }

    private String classificaIMC(float imc) {
        if (imc < 18.5f) return "Abaixo do peso";
        else if (imc < 24.9f) return "Peso normal";
        else if (imc < 29.9f) return "Sobrepeso";
        else if (imc < 34.9f) return "Obesidade grau I";
        else if (imc < 39.9f) return "Obesidade grau II";
        else return "Obesidade grau III";
    }
}
