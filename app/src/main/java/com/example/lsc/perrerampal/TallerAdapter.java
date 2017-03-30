package com.example.lsc.perrerampal;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jesus on 29/03/2017.
 */
/*
clase TallerAdapter el cual es un adaptador para superponer los cardview en el recyclerview
* */
public class TallerAdapter extends RecyclerView.Adapter<TallerAdapter.TallerViewHolder> {

    private List<taller> items; //se obtiene la lista de los talleres

    public static class TallerViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public ImageView imagen_taller; //se declara un imageview para la imagen del taller
        public TextView nombre_taller; //se declara un textview para el nombre del taller
        public TextView descripcion_taller;//se declara un textview para la descripcion del taller

        //se declara un constructor para la galeria el cual tendrá imagen, nombre del taller y una descripcion
        public TallerViewHolder(View v) {
            super(v);
            imagen_taller = (ImageView) v.findViewById(R.id.imagen_taller);
            nombre_taller = (TextView) v.findViewById(R.id.nombre_taller);
            descripcion_taller = (TextView) v.findViewById(R.id.descripcion_taller);
        }
    }

    public TallerAdapter(List<taller> items) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size(); //se obtiene el tamaño de las imagenes y los retorna adaptados a la galeria
    }

    @Override
    public TallerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) { //se inflan los cardview en la galeria
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cardview_taller, viewGroup, false);
        return new TallerViewHolder(v);
    }

    @Override/*se muestra la galeria en un recycler view sobreponiendo los cardview, los cuales tendran una imagen del taller,
                 nombre del taller y una descripcion del taller*/
    public void onBindViewHolder(TallerViewHolder viewHolder, int i) {
        viewHolder.imagen_taller.setImageResource(items.get(i).getImagen_taller());
        viewHolder.nombre_taller.setText(""+String.valueOf(items.get(i).getNombre_taller()));
        viewHolder.descripcion_taller.setText(""+String.valueOf(items.get(i).getDescripcion_taller()));
    }

}
