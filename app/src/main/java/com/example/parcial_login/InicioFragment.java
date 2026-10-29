package com.example.parcial_login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class InicioFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_inicio, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LinearLayout contenedor = view.findViewById(R.id.contenedorTarjetas);

        // CAMBIA AQUÍ los datos de las tarjetas
        int[] fotos = {
                R.drawable.escudo,
                R.drawable.campnou,
                R.drawable.camiseta,
                R.drawable.hinchada,
                R.drawable.trofeos,
                R.drawable.messi
        };
        String[] nombres = {"Escudo", "Camp Nou", "Camiseta",
                "La afición", "Trofeos", "Mi jugador favorito"};
        String[] detalles = {"FC Barcelona", "Estadio del Barça · Barcelona", "Blaugrana",
                "Los culés", "Historia y títulos", "Lionel Messi"};
        String[] datos = {"Fundado en 1899", "Casa del Barça", "Azul y grana",
                "Cataluña · España", "Més que un club", "#ForçaBarça"};

        for (int i = 0; i < fotos.length; i++) {
            View tarjeta = LayoutInflater.from(requireContext())
                    .inflate(R.layout.item_tarjeta, contenedor, false);

            CircleImageView img = tarjeta.findViewById(R.id.imgAvatar);
            TextView tvNombre = tarjeta.findViewById(R.id.tvNombre);
            TextView tvDetalle = tarjeta.findViewById(R.id.tvDetalle);
            TextView tvDato = tarjeta.findViewById(R.id.tvDato);

            tvNombre.setText(nombres[i]);
            tvDetalle.setText(detalles[i]);
            tvDato.setText(datos[i]);

            Picasso.with(requireContext()).load(fotos[i]).into(img);

            contenedor.addView(tarjeta);
        }
    }
}