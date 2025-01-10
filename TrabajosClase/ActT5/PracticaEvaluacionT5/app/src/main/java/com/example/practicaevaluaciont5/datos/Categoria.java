package com.example.practicaevaluaciont5.datos;

public class Categoria {

    private int categoria;
    private String nombre;
    private int imagen;

    public Categoria(int categoria, String nombre, int imagen) {
        this.categoria = categoria;
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public int getCategoria() {
        return categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public int getImagen() {
        return imagen;
    }
}
