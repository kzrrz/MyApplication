package com.example.lsc.perrerampal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Animal_detalle extends AppCompatActivity {

    ImageView imagen;
    TextView nombre, descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_detalle);

        imagen=(ImageView)findViewById(R.id.id_imagen_detalle);
        nombre=(TextView)findViewById(R.id.id_nombre_detalle);
        descripcion=(TextView)findViewById(R.id.id_descripcion_detalle);

        imagen.setImageResource(getIntent().getIntExtra("imagen",00));
        nombre.setText("Nombre: " + getIntent().getStringExtra("nombre"));
        descripcion.setText("Descripción: " + getIntent().getStringExtra("descripcion"));
    }
}
