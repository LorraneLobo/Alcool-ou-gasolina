package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText campoAlcool;
    EditText campoGasolina;
    Button botaoCalcular;
    TextView textoResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Input
        campoAlcool = findViewById(R.id.editAlcool);
        campoGasolina = findViewById(R.id.editGasolina);

        //Botao
        botaoCalcular = findViewById(R.id.btnCalcular);

        //Texto
        textoResultado = findViewById(R.id.textResultado);

        botaoCalcular.setOnClickListener(v -> compararCombustivel());
    }

    public void compararCombustivel(){

        if (campoAlcool.getText().toString().isEmpty()) {
            Toast.makeText(this, "Preencha o campo alcool", Toast.LENGTH_LONG).show();
        } else if (campoGasolina.getText().toString().isEmpty()) {
            Toast.makeText(this, "Preencha o campo gasolina", Toast.LENGTH_LONG).show();
        } else {
            double alcool = Double.parseDouble(campoAlcool.getText().toString());
            double gasolina = Double.parseDouble(campoGasolina.getText().toString());

            textoResultado.setText((alcool / gasolina) >= 0.7 ? "Coloque Gasolina" : "Coloque Álcool");
        }
    }
}