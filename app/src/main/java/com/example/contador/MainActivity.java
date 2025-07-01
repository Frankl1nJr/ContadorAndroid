package com.example.contador;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView editTextNumber;
    private EditText etStepValue;
    private Button btnIncrementar, btnDecrementar;

    private int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber = findViewById(R.id.editTextNumber);
        etStepValue = findViewById(R.id.etStepValue);
        btnIncrementar = findViewById(R.id.btnIncrementar);
        btnDecrementar = findViewById(R.id.btnDecrementar);

        btnIncrementar.setOnClickListener(v -> {
            int paso = obtenerPaso();
            contador += paso;
            editTextNumber.setText(String.valueOf(contador));
        });

        btnDecrementar.setOnClickListener(v -> {
            int paso = obtenerPaso();
            contador -= paso;
            editTextNumber.setText(String.valueOf(contador));
        });
    }

    /**
     * Obtiene el valor ingresado en el EditText como número.
     * Si está vacío o no es un número, devuelve 1.
     */
    private int obtenerPaso() {
        String textoPaso = etStepValue.getText().toString().trim();
        if (TextUtils.isEmpty(textoPaso)) {
            return 1;
        }
        try {
            return Integer.parseInt(textoPaso);
        } catch (NumberFormatException e) {
            return 1;
        }
    }
}
