package com.example.pft_theboys.Terneras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pft_theboys.MenuPrincipal;
import com.example.pft_theboys.R;

public class GestionTerneras extends AppCompatActivity {

    private Button altaTerBtn;
    private Button listarTerBtn;
    private Button volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_terneras);

        altaTerBtn      = findViewById(R.id.AgrTerBtn);
        listarTerBtn    = findViewById(R.id.LisTerBtn);
        volver          = findViewById(R.id.volverBtn);

        altaTerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Cuando el login es exitoso vamos al menu principal
                Intent miIntentTer = new Intent(GestionTerneras.this, AgregarTernera.class);
                startActivity(miIntentTer);
            }
        });

        listarTerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Cuando el login es exitoso vamos al menu principal
                Intent miIntentTer = new Intent(GestionTerneras.this, ListarTernera.class);
                startActivity(miIntentTer);
            }
        });


        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Cuando el login es exitoso vamos al menu principal
                Intent miIntentTer = new Intent(GestionTerneras.this, MenuPrincipal.class);
                startActivity(miIntentTer);
            }
        });
    }

}