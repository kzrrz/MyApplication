package com.example.lsc.perrerampal;

/**
 * Created by jesus on 22/03/2017.
 */

public class animal {
    //campos que tendrá cada animal en su cardview
    private int imagen;
    private String nombre;
    private String descripcion;

    public animal(int imagen, String nombre, String descripcion) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.descripcion= descripcion;
    }

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