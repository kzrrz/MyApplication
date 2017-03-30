package com.example.lsc.perrerampal;

/**
 * Created by jesus on 29/03/2017.
 */

/*
* clase taller donde se obtiene la informacion del taller y los retorna al adaptador para mostrarlos en la galeria
* */
public class taller {
    //campos que tendrá cada taller en su cardview
    private int imagen_taller;
    private String nombre_taller;
    private String descripcion_taller;

    //se declara un constructor para los talleres
    public taller(int imagen_taller, String nombre_taller, String descripcion_taller) {
        this.imagen_taller = imagen_taller;
        this.nombre_taller = nombre_taller;
        this.descripcion_taller= descripcion_taller;
    }

    //retorna los datos de los talleres
    public String getNombre_taller() {
        return nombre_taller;
    }

    public String getDescripcion_taller() {
        return descripcion_taller;
    }

    public int getImagen_taller() {
        return imagen_taller;
    }
}