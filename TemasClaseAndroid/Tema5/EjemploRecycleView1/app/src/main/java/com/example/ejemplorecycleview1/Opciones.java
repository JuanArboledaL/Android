package com.example.ejemplorecycleview1;

public class Opciones {
    private String titulo;
    private String subTitulo;
    private int icono;

    public Opciones(String titulo, String subTitulo, int icono) {
        this.titulo = titulo;
        this.subTitulo = subTitulo;
        this.icono = icono;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setSubTitulo(String subTitulo) {
        this.subTitulo = subTitulo;
    }

    public void setIcono(int icono) {
        this.icono = icono;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getSubTitulo() {
        return subTitulo;
    }

    public int getIcono() {
        return icono;
    }
}
