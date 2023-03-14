package com.example.pft_theboys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pft_theboys.DatosHistoricos.GestionDatosHistoricos;
import com.example.pft_theboys.Terneras.GestionTerneras;

public class MenuPrincipal extends AppCompatActivity {

    private Button gestTerneras;
    private Button gestDatosHist;
    private Button cerrarSes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        gestTerneras  = findViewById(R.id.gestTernBtn);
        gestDatosHist = findViewById(R.id.datHistBtn);
        cerrarSes     = findViewById(R.id.cerrarSes);
    //Navega hacia la gestion de ternera
    gestTerneras.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //Cuando el login es exitoso vamos al menu principal
            Intent miIntentTer = new Intent(MenuPrincipal.this, GestionTerneras.class);
            startActivity(miIntentTer);

        }
    });

    gestDatosHist.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //Cuando el login es exitoso vamos al menu principal
            //Intent miIntentTer = new Intent(MenuPrincipal.this, GestionDatosHistoricos.class);
            //startActivity(miIntentTer);

        }
    });


    //Vuelve al inicio de sesion
    cerrarSes.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent miIntentSes = new Intent(MenuPrincipal.this, MainActivity.class);
            startActivity(miIntentSes);
        }
    });

    }
}