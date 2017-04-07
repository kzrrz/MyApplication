package com.example.lsc.perrerampal;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/*CLASE TalleresCursosActivity en el cual  se implementa el recyclerView y el Cardview para la galeria mediante un administrador, aqui se
  obtiene la informacion de cada taller y la imagen del taller

*/
public class TalleresCursosActivity extends AppCompatActivity {
    private RecyclerView recycler_taller; //se declara un recyvler view para la galeria
    private RecyclerView.Adapter adapter_taller;//se declara un adaptador para la galeria
    private RecyclerView.LayoutManager lManager_taller;//se declara un administrador para que junte el RecyclerView y el Cardview en la galeria
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talleres_cursos); //se liga con el xml de la clase JAVA TalleresCursosActivity (QUE ES ESTA)

        // Se inicializar el arreglo para la lista de talleres que aparecerán en la galeria

        List items = new ArrayList(); //se declara la lista de items (talleres)

        //se agregan los talleres a la lista antes declarada
        items.add(new taller(R.drawable.taller_educar_sin_castigar, "Taller educar sin castigar", "Impartida por el especialista juan en el estacionamiento de la perrera a las 6:30"));
        items.add(new taller(R.drawable.taller_gratuito, "Taller gratuito", "Impartida por firulais experto en domar leones, se llevará a cabo el próximo lunes en el parque a las 6:30"));
        items.add(new taller(R.drawable.taller_juego_canino, "Taller juego canino", "Impartida por pepito chofer de la ruta gris, en la base a las 4:30"));
        items.add(new taller(R.drawable.taller_primeros_auxilios, "Taller primeros auxilios", "Impartida por perengano paramedico recien graduado, el taller será en el centro a las 6:30"));
        items.add(new taller(R.drawable.taller_gratuito, "Taller gratuito", "Impartida por gumercindo, no alcanza para más, te esperamos en el estadio a las 6:30"));
        items.add(new taller(R.drawable.taller_educar_sin_castigar, "Taller educar sin castigar", "Impartida por fulanito primo de gumercindo, será en el parque a las 6:30"));
        items.add(new taller(R.drawable.taller_juego_canino, "Taller juego canino", "Ni vayas, tu mascota no aprenderá nada, pero será en el parque a las 6:30 por si quieres ir"));
        items.add(new taller(R.drawable.taller_primeros_auxilios, "Taller primeros auxilios", "Impartida por fulanito en el parque a las 6:30, te esperamos, luego nadie va XD"));
        items.add(new taller(R.drawable.taller_educar_sin_castigar, "Taller educar sin castigar", "Impartida por quiquin, cobra caro asi que llevate una lana, es en el parque a las 6:30"));
        items.add(new taller(R.drawable.taller_juego_canino, "Taller juego canino", "pablito le enseñará a tu perro a hablar chino, jalate las greñas será en el parque a las 6:30"));
        items.add(new taller(R.drawable.taller_gratuito, "Taller gratuito", "Impartida por El kevin, se ha robado varios perros, tome sus precauciones"));
        items.add(new taller(R.drawable.taller_educar_sin_castigar, "Taller educar sin castigar", "Impartida por cirilo, vende tacos de perro en el centro"));
        items.add(new taller(R.drawable.taller_gratuito, "Taller gratuito", "Impartida otra vez por fulanito en el parque a las 6:30 como siempre"));
        items.add(new taller(R.drawable.taller_primeros_auxilios, "Taller primeros auxilios", "ni vengas, hoy no habrá taller"));
        items.add(new taller(R.drawable.taller_juego_canino, "Taller juego canino", "otra vez fulanito en el parque a las 6:30"));
        items.add(new taller(R.drawable.taller_educar_sin_castigar, "Taller educar sin castigar", "Impartida por pancracio, será acá atrasito de la perrera"));

// Se obtiene el recycler view (se declaró al principio) el cual es un xml, mediante su id (reciclador_taller)
        recycler_taller = (RecyclerView) findViewById(R.id.reciclador_taller);
        recycler_taller.setHasFixedSize(true);

// Se usa un administrador (se declaró al principio) para LinearLayout de la galeria de talleres
        lManager_taller = new LinearLayoutManager(this);
        recycler_taller.setLayoutManager(lManager_taller);

// Se crea un nuevo adaptador (se declaró al principio) para juntar el recyclerview con los cardview
        adapter_taller = new TallerAdapter(items, this);//se gregó this para vista individual del taller
        recycler_taller.setAdapter(adapter_taller);
    }
}
