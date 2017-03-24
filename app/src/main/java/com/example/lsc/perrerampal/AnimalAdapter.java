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

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder> {
//:V
private List<animal> items;

public static class AnimalViewHolder extends RecyclerView.ViewHolder {
    // Campos respectivos de un item
    public ImageView imagen;
    public TextView nombre;
    public TextView descripcion;

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
        return items.size();
    }

    @Override
    public AnimalAdapter.AnimalViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cardview, viewGroup, false);
        return new AnimalAdapter.AnimalViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AnimalAdapter.AnimalViewHolder viewHolder, int i) {
        viewHolder.imagen.setImageResource(items.get(i).getImagen());
        viewHolder.nombre.setText(""+String.valueOf(items.get(i).getNombre()));
        viewHolder.descripcion.setText("Descripción: "+String.valueOf(items.get(i).getVisitas()));
    }
}

