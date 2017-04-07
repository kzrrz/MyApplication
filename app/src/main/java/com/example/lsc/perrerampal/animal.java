package com.example.lsc.perrerampal;

/**
 * Created by jesus on 22/03/2017.
 */

/*
* clase animal donde se obtiene la informacion del animal y los retorna al adaptador para mostrarlos en la galeria
* */

public class animal {
    //campos que tendrá cada animal en su cardview
    private int imagen_animal;
    private String nombre_animal;
    private String descripcion_animal;

    //se declara un constructor para los animales
    public animal(int imagen, String nombre, String descripcion) {
        this.imagen_animal = imagen;
        this.nombre_animal = nombre;
        this.descripcion_animal= descripcion;
    }

    //se retornan la informacion de los animales
    public String getNombre_animal() {
        return nombre_animal;
    }

    public String getDescripcion_animal() {
        return descripcion_animal;
    }

    public int getImagen_animal() {
        return imagen_animal;
    }
}