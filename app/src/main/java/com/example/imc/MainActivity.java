package com.example.imc;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    private EditText editAltura, editPeso;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editAltura = findViewById(R.id.editAltura);
        editPeso = findViewById(R.id.editPeso);
        btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarDados();
            }
        });
    }

    private void enviarDados() {
        String alturaStr = editAltura.getText().toString();
        String pesoStr = editPeso.getText().toString();

        if(alturaStr.isEmpty() || pesoStr.isEmpty()){
            Toast.makeText(this, "Preencha todos os campos primeiro!", Toast.LENGTH_SHORT).show();
                return;
        }

        float altura = Float.parseFloat(alturaStr);
        float peso = Float.parseFloat(pesoStr);

        Intent intent = new Intent(this, ResultadoActivity.class);
        intent.putExtra("altura", altura);
        intent.putExtra("peso", peso);
        startActivity(intent);
    }
}
