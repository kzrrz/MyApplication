package com.example.lsc.perrerampal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


/*
CLASE ListaAdopcion en el cual  se implementa el recyclerView y el Cardview para la galeria mediante un administrador, aqui se
  obtiene la informacion de cada taller y la imagen del taller
*/

public class ListaAdopcion extends AppCompatActivity {

    //Se declaran los recycler necesarios
    private RecyclerView recycler;//se declara un recyvler view para la galeria
    private RecyclerView.Adapter adapter;//se declara un adaptador para la galeria
    private RecyclerView.LayoutManager lManager;//se declara un administrador para que junte el RecyclerView y el Cardview en la galeria

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_adopcion);//se liga con el xml de la clase JAVA ListaAdopcion (QUE ES ESTA)

        // Se inicializar el arreglo para la lista de animales que aparecerán en la galeria

        List items = new ArrayList();//se declara la lista de items (animales)

        //se agregan los talleres a la lista antes declarada
        items.add(new animal(R.drawable.perro01, "Firulais", "Es muy cariñoso "));
        items.add(new animal(R.drawable.perro02, "Daisy", "Es juguetón"));
        items.add(new animal(R.drawable.perro03, "Toby", "Es muy peligroso XD"));
        items.add(new animal(R.drawable.perro04, "Bobby", "Te va a morder"));
        items.add(new animal(R.drawable.perro05, "Chester", "Tiene pulgas y rabia"));
        items.add(new animal(R.drawable.perro06, "Doky", "Es muy comelón"));
        items.add(new animal(R.drawable.perro07, "Fido", "Corre mucho"));
        items.add(new animal(R.drawable.perro08, "Doroty", "Es mordelón"));
        items.add(new animal(R.drawable.perro09, "Bandido", "Es ruidoso"));
        items.add(new animal(R.drawable.perro10, "Rex", "Está loca"));
        items.add(new animal(R.drawable.perro11, "Choco", "Habla inglés"));
        items.add(new animal(R.drawable.perro12, "Manchas", "No duerme nunca"));
        items.add(new animal(R.drawable.perro13, "Willy", "Si no lo adoptas le aplicaremos eutanasia"));
        items.add(new animal(R.drawable.perro14, "Bella", "Sabe programar en JAVA"));
        items.add(new animal(R.drawable.perro15, "Bamby", "Tiene doctorado"));
        items.add(new animal(R.drawable.perro16, "Africa", "Especialista en ladrar fuerte"));

// Se obtiene el recycler view (se declaró al principio) el cual es un xml, mediante su id (reciclador)
        recycler = (RecyclerView) findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);

// Se usa un administrador (se declaró al principio) para LinearLayout de la galeria de animales
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

// Se crea un nuevo adaptador (se declaró al principio) para juntar el recyclerview con los cardview
        adapter = new AnimalAdapter(items);
        recycler.setAdapter(adapter);
    }
    }
