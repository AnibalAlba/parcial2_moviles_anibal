package com.example.parcial_login;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ConfigFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_config, container, false);

        TextView tvUsuario = view.findViewById(R.id.tvUsuario);
        Button btnCerrarSesion = view.findViewById(R.id.btnCerrarSesion);

        // Recibe el nombre que envía el login (clave: "usuario")
        String usuario = requireActivity().getIntent().getStringExtra("usuario");
        if (usuario != null) {
            tvUsuario.setText(usuario);
        }

        // Cerrar sesión: vuelve al login y limpia las pantallas anteriores
        btnCerrarSesion.setOnClickListener(v -> {
            Intent intent = new Intent(requireActivity(), MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        });

        return view;
    }
}