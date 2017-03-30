package com.example.lsc.perrerampal;

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

public static class AnimalViewHolder extends RecyclerView.ViewHolder {
    // Campos respectivos de un item
    public ImageView imagen; //se declara un imageview para la imagen del animal
    public TextView nombre;//se declara un imageview para la imagen del animal
    public TextView descripcion; //se declara un textview para la imagen del animal

    //se declara un constructor para la galeria el cual tendrá imagen, nombre y una descripcion del animal
    public AnimalViewHolder(View v) {
        super(v);
        imagen = (ImageView) v.findViewById(R.id.imagen);
        nombre = (TextView) v.findViewById(R.id.nombre);
        descripcion = (TextView) v.findViewById(R.id.descripcion);
    }
}

    public AnimalAdapter(List<animal> items) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();//se obtiene el tamaño de las imagenes y los retorna adaptados a la galeria
    }

    @Override
    public AnimalAdapter.AnimalViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cardview, viewGroup, false);//se inflan los cardview en la galeria
        return new AnimalAdapter.AnimalViewHolder(v);
    }

    @Override
    /*se muestra la galeria en un recycler view sobreponiendo los cardview, los cuales tendran una imagen del animal,
                 nombre del animal y una descripcion del animal*/
    public void onBindViewHolder(AnimalAdapter.AnimalViewHolder viewHolder, int i) {
        viewHolder.imagen.setImageResource(items.get(i).getImagen());
        viewHolder.nombre.setText(""+String.valueOf(items.get(i).getNombre()));
        viewHolder.descripcion.setText("Descripción: "+String.valueOf(items.get(i).getVisitas()));
    }
}