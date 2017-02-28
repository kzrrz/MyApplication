package com.example.lsc.perrerampal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
    }

    public void ListaAdopcionCambioAct(View v){ //Paso de actividad a los listados de adopción
        Intent i = new Intent (MenuPrincipal.this, ListaAdopcion.class);
        startActivity(i);
    }

    public void LevReportCambioAct (View v) {
        Intent i = new Intent (MenuPrincipal.this, ReporteActivity.class);
        startActivity(i);
    }

    public void TallerCursoCambioAct (View v) {
        Intent i = new Intent(MenuPrincipal.this, TalleresCursosActivity.class);
        startActivity(i);
    }
}
