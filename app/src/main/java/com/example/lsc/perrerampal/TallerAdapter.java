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
 * Created by jesus on 29/03/2017.
 */
/*
clase TallerAdapter el cual es un adaptador para superponer los cardview en el recyclerview
* */
public class TallerAdapter extends RecyclerView.Adapter<TallerAdapter.TallerViewHolder> {

    private List<taller> items; //se obtiene la lista de los talleres
    Context ctx;//PARA DETALLE y vista individual de los talleres

    public static class TallerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // Campos respectivos de un item
        public ImageView imagen_taller; //se declara un imageview para la imagen del taller
        public TextView nombre_taller; //se declara un textview para el nombre del taller
        public TextView descripcion_taller;//se declara un textview para la descripcion del taller

        List<taller>items;//PARA DETALLE
        Context ctx;//PARA DETALLE

        //se declara un constructor para la galeria el cual tendrá imagen, nombre del taller y una descripcion
        public TallerViewHolder(View v, Context ctx, List<taller> items) {
            super(v);

            this.items=items;//para detalle
            this.ctx=ctx; //PARA DETALLE
            v.setOnClickListener(this);//se agrego para detalle

            imagen_taller = (ImageView) v.findViewById(R.id.imagen_taller);
            nombre_taller = (TextView) v.findViewById(R.id.nombre_taller);
            descripcion_taller = (TextView) v.findViewById(R.id.descripcion_taller);
        }

        @Override
        public void onClick(View v) {
            int posicion = getAdapterPosition();
            taller taller_detalle = this.items.get(posicion);
            Intent intent = new Intent(this.ctx, Taller_detalle.class);
            intent.putExtra("imagen",taller_detalle.getImagen_taller());
            intent.putExtra("nombre",taller_detalle.getNombre_taller());
            intent.putExtra("descripcion",taller_detalle.getDescripcion_taller());
            this.ctx.startActivity(intent);

        }
    }

    public TallerAdapter(List<taller> items,Context ctx) {
        this.items = items;
        this.ctx = ctx;//PARA DETALLE
    }

    @Override
    public int getItemCount() {
        return items.size(); //se obtiene el tamaño de las imagenes y los retorna adaptados a la galeria
    }

    @Override
    public TallerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) { //se inflan los cardview en la galeria
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cardview_taller, viewGroup, false);
        return new TallerViewHolder(v,ctx,items);
    }

    @Override/*se muestra la galeria en un recycler view sobreponiendo los cardview, los cuales tendran una imagen del taller,
                 nombre del taller y una descripcion del taller*/
    public void onBindViewHolder(TallerViewHolder viewHolder, int i) {
        viewHolder.imagen_taller.setImageResource(items.get(i).getImagen_taller());
        viewHolder.nombre_taller.setText(""+String.valueOf(items.get(i).getNombre_taller()));
        viewHolder.descripcion_taller.setText(""+String.valueOf(items.get(i).getDescripcion_taller()));
    }

}
