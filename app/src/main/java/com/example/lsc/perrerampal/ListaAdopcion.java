package com.example.lsc.perrerampal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class ListaAdopcion extends AppCompatActivity {

    //Se declaran los recycler necesarios
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_adopcion);

        // Inicializar lista de animales
        List items = new ArrayList();

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

// Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);

// Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

// Crear un nuevo adaptador
        adapter = new AnimalAdapter(items);
        recycler.setAdapter(adapter);
    }
    }
