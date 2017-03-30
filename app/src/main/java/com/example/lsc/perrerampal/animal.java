package com.example.lsc.perrerampal;

/**
 * Created by jesus on 22/03/2017.
 */

/*
* clase animal donde se obtiene la informacion del animal y los retorna al adaptador para mostrarlos en la galeria
* */

public class animal {
    //campos que tendrá cada animal en su cardview
    private int imagen;
    private String nombre;
    private String descripcion;

    //se declara un constructor para los animales
    public animal(int imagen, String nombre, String descripcion) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.descripcion= descripcion;
    }

    //se retornan la informacion de los animales
    public String getNombre() {
        return nombre;
    }

    public String getVisitas() {
        return descripcion;
    }

    public int getImagen() {
        return imagen;
    }
}