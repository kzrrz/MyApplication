package com.example.lsc.perrerampal;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jesus on 23/03/2017.
 */

/*
clase AnimalAdapter el cual es un adaptador para superponer los cardview en el recyclerview
* */
public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder> {
//:V
private List<animal> items;//se obtiene la lista de los animales
    Context ctx;//PARA DETALLE y vista individual de los talleres

public static class AnimalViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    // Campos respectivos de un item
    public ImageView imagen; //se declara un imageview para la imagen del animal
    public TextView nombre;//se declara un imageview para la imagen del animal
    public TextView descripcion; //se declara un textview para la imagen del animal

    List<animal>items;//PARA DETALLE
    Context ctx;//PARA DETALLE


    //se declara un constructor para la galeria el cual tendrá imagen, nombre y una descripcion del animal
    public AnimalViewHolder(View v, Context ctx, List<animal> items) {
        super(v);

        this.items=items;//para detalle
        this.ctx=ctx; //PARA DETALLE
        v.setOnClickListener(this);//se agrego para detalle

        imagen = (ImageView) v.findViewById(R.id.imagen);
        nombre = (TextView) v.findViewById(R.id.nombre);
        descripcion = (TextView) v.findViewById(R.id.descripcion);
    }

    @Override
    public void onClick(View v) {
        int posicion = getAdapterPosition();
        animal animal_detalle = this.items.get(posicion);
        Intent intent = new Intent(this.ctx, Animal_detalle.class);
        intent.putExtra("imagen",animal_detalle.getImagen_animal());
        intent.putExtra("nombre",animal_detalle.getNombre_animal());
        intent.putExtra("descripcion",animal_detalle.getDescripcion_animal());
        this.ctx.startActivity(intent);
    }
}

    public AnimalAdapter(List<animal> items,Context ctx) {
        this.items = items;
        this.ctx = ctx;//PARA DETALLE
    }

    @Override
    public int getItemCount() {
        return items.size();//se obtiene el tamaño de las imagenes y los retorna adaptados a la galeria
    }

    @Override
    public AnimalAdapter.AnimalViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cardview, viewGroup, false);//se inflan los cardview en la galeria
        return new AnimalAdapter.AnimalViewHolder(v,ctx,items);
    }

    @Override
    /*se muestra la galeria en un recycler view sobreponiendo los cardview, los cuales tendran una imagen del animal,
                 nombre del animal y una descripcion del animal*/
    public void onBindViewHolder(AnimalAdapter.AnimalViewHolder viewHolder, int i) {
        viewHolder.imagen.setImageResource(items.get(i).getImagen_animal());
        viewHolder.nombre.setText(""+String.valueOf(items.get(i).getNombre_animal()));
        viewHolder.descripcion.setText("Descripción: "+String.valueOf(items.get(i).getDescripcion_animal()));
    }
}