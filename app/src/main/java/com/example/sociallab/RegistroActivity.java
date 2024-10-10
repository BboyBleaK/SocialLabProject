package com.example.sociallab;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegistroActivity extends AppCompatActivity {

    private RadioGroup radioGroupTipoCuenta;
    private Button buttonVolver, buttonContinuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Vincular elementos de la interfaz
        radioGroupTipoCuenta = findViewById(R.id.radioGroupTipoCuenta);
        buttonVolver = findViewById(R.id.buttonVolver);
        buttonContinuar = findViewById(R.id.buttonContinuar);

        // Acción para el botón "Volver"
        buttonVolver.setOnClickListener(v -> {
            // Regresar a MainActivity
            Intent intent = new Intent(RegistroActivity.this, MainActivity.class);
            startActivity(intent);
            finish(); // Cerrar la actividad actual
        });

        // Acción para el botón "Continuar"
        buttonContinuar.setOnClickListener(v -> {
            int selectedId = radioGroupTipoCuenta.getCheckedRadioButtonId();

            if (selectedId == -1) {
                // No se ha seleccionado ningún RadioButton
                Toast.makeText(RegistroActivity.this, "Por favor, selecciona un tipo de cuenta", Toast.LENGTH_SHORT).show();
            } else {
                // Se ha seleccionado un RadioButton
                RadioButton selectedRadioButton = findViewById(selectedId);
                String cuentaTipo = selectedRadioButton.getText().toString();
                Toast.makeText(RegistroActivity.this, "Tipo de cuenta seleccionada: " + cuentaTipo, Toast.LENGTH_SHORT).show();
                // Aquí puedes continuar con la lógica para el siguiente paso
            }
        });
    }
}
