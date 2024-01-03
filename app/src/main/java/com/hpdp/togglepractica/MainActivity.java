package com.hpdp.togglepractica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton tbtnFondo, tbtnFavoritos, tbtnActivar;
    AppCompatDelegate delegate;
    EditText texto;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tbtnFondo = findViewById(R.id.tbtnFondo);
        tbtnFavoritos = findViewById(R.id.tbtnFavorito);
        tbtnActivar = findViewById(R.id.tbtnActivar);
        delegate = getDelegate();
        texto = findViewById(R.id.txtTexto);

        tbtnFondo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Modo oscuro
                    delegate.setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                } else {
                    // Modo claro
                    delegate.setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });

        tbtnFavoritos.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    tbtnFavoritos.setText("★");
                } else {
                    tbtnFavoritos.setText("☆");
                }
            }
        });

        tbtnActivar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                texto.setEnabled(!isChecked);
            }
        });
    }
}