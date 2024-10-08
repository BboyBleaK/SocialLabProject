package com.example.sociallab;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etUsuario, etPass;
    private Button btnInicioSesion, btnRegistro;
    private TextView textOlvidastePass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Vincular los elementos de la interfaz
        etUsuario = findViewById(R.id.ETUsuario);
        etPass = findViewById(R.id.ETPass);
        btnInicioSesion = findViewById(R.id.buttonInicioSesion);
        btnRegistro = findViewById(R.id.buttonRegistro);
        textOlvidastePass = findViewById(R.id.textView4);

        // Acción para botón de Inicio de Sesión
        btnInicioSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = etUsuario.getText().toString();
                String contraseña = etPass.getText().toString();

                // Lógica de autenticación (agrega la tuya aquí)
                if (usuario.equals("admin") && contraseña.equals("1234")) {
                    // Si es correcto, ir a otra actividad
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                } else {
                    // Mostrar error o manejar el fallo
                }
            }
        });

        // Acción para botón de Registro
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ir a la pantalla de registro
                Intent intent = new Intent(MainActivity.this, RegistroActivity.class);
                startActivity(intent);
            }
        });

        // Acción para "Olvidaste tu contraseña?"
        textOlvidastePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para recuperar contraseña o ir a otra pantalla
            }
        });
    }
}
