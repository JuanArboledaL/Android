package com.example.act8tema6;

public class Datos {

    private String texto;
    private int icono;
    private boolean checkbox;

    public Datos(int icono,String texto){
        this.texto = texto;
        this.icono = icono;
    }

    public String getTexto(){
        return texto;
    }

    public int getImagen(){
        return icono;
    }

    public boolean getCheckbox() {
        return  checkbox;
    }

    public void setCheckbox(boolean checkbox) {
        this.checkbox = checkbox;
    }
}
