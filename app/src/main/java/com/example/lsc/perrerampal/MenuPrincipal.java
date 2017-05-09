package com.example.lsc.perrerampal;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class MenuPrincipal extends AppCompatActivity {

    //Acciones del menú principal
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
    }

    //Funciones para los onClick de los botones del menú principal.
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
