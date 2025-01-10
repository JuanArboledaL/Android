package com.example.practicaevaluaciont5.datos;

public class Producto {

    private String nombre;
    private double precio;
    private int id;
    private int src;
    private int categoria;
    private String descripcion;

    public Producto(int id, String nombre, double precio, int src,int categoria,String descripcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.id = id;
        this.src = src;
        this.categoria = categoria;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {return descripcion;}

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getSrc() {
        return src;
    }

    public int getId() {
        return id;
    }

    public int getCategoria(){return categoria;}
}
