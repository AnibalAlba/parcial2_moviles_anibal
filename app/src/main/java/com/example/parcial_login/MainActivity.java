package com.example.parcial_login;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String USUARIO_VALIDO = "Anibal";
    private static final String CLAVE_VALIDA = "12345678";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etUsuario = findViewById(R.id.etUsuario);
        EditText etClave = findViewById(R.id.etClave);
        Button btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> {
            String usuario = etUsuario.getText().toString().trim();
            String clave = etClave.getText().toString().trim();

            if (usuario.isEmpty() || clave.isEmpty()) {
                Toast.makeText(this, "Debes llenar usuario y contraseña", Toast.LENGTH_SHORT).show();
            } else if (usuario.equalsIgnoreCase(USUARIO_VALIDO) && clave.equals(CLAVE_VALIDA)) {
                Intent intent = new Intent(this, HomeActivity.class);
                intent.putExtra("usuario", usuario);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
            }
        });
    }
}