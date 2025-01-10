package com.example.practicaevaluaciont5.datos;

import com.example.practicaevaluaciont5.R;

public class FuenteDeDatos {

    private static Producto[] granizados;
    private static Producto[] micheladas;
    private static Producto[] cocktails;
    private static Producto[] cervezas;
    private static FuenteDeDatos fuenteDeDatos;
    private static Categoria[] categoria;

    private FuenteDeDatos(){}

    public static FuenteDeDatos getInstance(){

        if(fuenteDeDatos == null){

            fuenteDeDatos=new FuenteDeDatos();
        }

        return fuenteDeDatos;
    }

    public static Producto getProducto(int id, int categoria){

        Producto item=null;
        Producto[] cate= null;

        switch (categoria){
            case 1: {
                cate = granizados;
                break;
            }
            case 2:{
                cate = micheladas;
                break;
            }
            case 3:{

                cate = cocktails;
                break;
            }
            case 4:{

                cate = cervezas;
                break;
            }
        }

        for (Producto producto : cate){

            if (producto.getId() == id) {

                item = producto;
            }

        }
        return item;
    }

    public static void inicializar(){

        granizados = new Producto[]{

                new Producto(1,"Granizado sabor Mora azúl",7, R.drawable.congelado,1,"Este Granizado contiene saborizantes artificiales (sabor mora azul), está hecho con vodka (Absolut), a demás tiene distintas gomitas/chuches"),
                new Producto(2,"Granizado de café",6, R.drawable.congelado,1,"Este Granizado están hecho a base de café colombiano, contiene ron (Ron viejo de caldas) , a demás tiene distintas gomitas/chuches"),
                new Producto(3,"Granizado sabor chicle",6,R.drawable.congelado,1,"Este Granizado contiene saborizantes artificiales (sabor chicle), está hecho con tequila (Jose Cuervo), a demás tiene distintas gomitas/chuches"),
                new Producto(4,"Granizado de mango", 6, R.drawable.congelado,1,"Este Granizado está hecho con mango, contiene ginebra (Larios), a demás tiene distintas gomitas/chuches")
        };

        micheladas = new Producto[]{

                new Producto(1, "Michelada de mango viche", 5, R.drawable.chelada, 2, "Una combinación refrescante y única que mezcla el sabor tropical del mango viche con un toque de cerveza y especias."),
                new Producto(2, "Michelada tradicional", 4, R.drawable.chelada, 2, "La clásica michelada que nunca falla, con cerveza fría, limón, sal y un toque de salsas que realzan su sabor."),
                new Producto(3, "Michelada de maracuyá", 6, R.drawable.chelada, 2, "Una fusión exótica que combina el sabor ácido y dulce del maracuyá con la tradicional michelada."),
                new Producto(4, "Michelada de fresa", 4, R.drawable.chelada, 2, "Una deliciosa opción frutal con el dulzor de la fresa mezclado con cerveza y un toque de picante.")

        };

        cocktails = new Producto[]{

                new Producto(1, "Mojito", 5, R.drawable.cocktailfoto, 3, "Un cóctel clásico cubano, refrescante y lleno de sabor, con ron, menta, limón y un toque de soda."),
                new Producto(2, "Daikiri", 6, R.drawable.cocktailfoto, 3, "Un cóctel elegante y tropical a base de ron blanco, jugo de limón fresco y un toque de azúcar."),
                new Producto(3, "Piña Colada", 5, R.drawable.cocktailfoto, 3, "El cóctel tropical por excelencia, con ron, crema de coco y jugo de piña, perfecto para transportarte a la playa."),
                new Producto(4, "Negroni", 7, R.drawable.cocktailfoto, 3, "Un cóctel clásico italiano, equilibrado y sofisticado, con ginebra, vermut rojo y Campari.")

        };

        cervezas = new Producto[]{

                new Producto(1, "Paulaner", 6, R.drawable.cervezalogo, 4, "Paulaner es una cerveza de trigo alemana con un sabor suave y ligeramente afrutado, ideal para disfrutar en cualquier ocasión."),
                new Producto(2, "Club Colombia", 4, R.drawable.cervezalogo, 4, "Club Colombia es una cerveza premium colombiana, reconocida por su equilibrio perfecto entre amargor y dulzura."),
                new Producto(3, "Guinness", 4, R.drawable.cervezalogo, 4, "Guinness es una cerveza negra irlandesa icónica, famosa por su textura cremosa y notas tostadas."),
                new Producto(4, "Leffe", 6, R.drawable.cervezalogo, 4, "Leffe es una cerveza belga de abadía con un sabor rico y especiado, perfecta para los amantes de las cervezas complejas.")


        };

        categoria = new Categoria[]{

                new Categoria(1,"Granizados", R.drawable.granizadosfoto),
                new Categoria(2,"Micheladas", R.drawable.micheladafoto),
                new Categoria(3,"Cocktails", R.drawable.cocktailfoto),
                new Categoria(4,"Cervezas", R.drawable.cervezalogo)

        };

    }

    public static Producto[] getCervezas() {return cervezas;}
    public Producto[] getGranizados(){return  granizados;}
    public static Categoria[] getCategorias(){return  categoria;}
    public Producto[] getMicheladas(){return micheladas;}
    public Producto[] getCocktails(){return cocktails;}


}
