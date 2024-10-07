package com.example.unidadeverificar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

/*
 *@author:<Brenda Santana>
 *@author:<1110482313042>
 */

public class MainActivity extends AppCompatActivity {

    private EditText editTextNumero;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumero = findViewById(R.id.editTextNumero);
        Button buttonSeparar = findViewById(R.id.buttonSeparar);
        textViewResultado = findViewById(R.id.textViewResultado);

        buttonSeparar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                separarNumero();
            }
        });
    }

    private void separarNumero() {
        String input = editTextNumero.getText().toString();

        if (input.isEmpty()) {
            textViewResultado.setText("Por favor, digite um número.");
            return;
        }

        int numero;
        try {
            numero = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            textViewResultado.setText("Entrada inválida.");
            return;
        }

        if (numero < 100 || numero > 999) {
            textViewResultado.setText("O número deve estar entre 100 e 999.");
            return;
        }

        int centena = numero / 100;
        int dezena = (numero % 100) / 10;
        int unidade = numero % 10;

        textViewResultado.setText(String.format("CENTENA = %d\nDEZENA = %d\nUNIDADE = %d", centena, dezena, unidade));
    }
}
