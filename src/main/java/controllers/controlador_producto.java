package controllers;

import models.modelo_producto;
import servlets.registro_usuario_servlet;

// Se crea la clase controlador_producto

public class controlador_producto {

    // Se le asignan los atributos a la clase anteriormente creada

    private boolean estado_convertido = true;
    private Integer cantidad_convertida = null;
    private Integer id_categoria_convertido = null;
    private Integer media_convertida = null;
    private String mensaje = null;    
    private Boolean resultado = false;

    // contructor vacio

    public controlador_producto() {
        
    }

    //getters y setters

    public Boolean getResultado() {

        return resultado;

    }

    public void setResultado(Boolean resultado) {

        this.resultado = resultado;

    }

    public void registrar_producto(String marca, String estado, String nombre, String descripcion, String cantidad, String medida, String id_categoria, byte[] imagen) {

        if (estado == "activo") {

            estado_convertido = true;
            
        } else {

            estado_convertido = false;
            
        }

        if (medida == "unidad") {

            media_convertida = 1;
            
        } else if (medida == "libra") {

            media_convertida = 2;
            
        } else if (medida == "kilo") {

            media_convertida = 3;
            
        } else if (medida == "arroba") {

            media_convertida = 4;
            
        } else {

            media_convertida = 5;

        }

        cantidad_convertida = Integer.parseInt(cantidad);
        id_categoria_convertido = Integer.parseInt(id_categoria);

        modelo_producto modelo = new modelo_producto();

        modelo.insertar_producto(marca, estado_convertido, nombre, descripcion, cantidad_convertida, media_convertida, id_categoria_convertido, imagen);

    }

    public void resultado() {

        if (resultado == true) {

            mensaje = "¡LA INSERCION DEL PRODUCTO HA SIDO EXITOSA!";

            registro_usuario_servlet obtener_mensaje = new registro_usuario_servlet();

            obtener_mensaje.setResultado(mensaje);
            
        } else {

            System.out.println("hubo un error");
            
        }
    }

}
