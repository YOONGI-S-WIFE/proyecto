package controllers;

import models.modelo_categoria;

public class controlador_categoria {

    Integer id_convertido = null;

    public void registrar_categoria (String nombre, String descripcion, byte[] imagen) {

        modelo_categoria modelo = new modelo_categoria();

        modelo.insertar_categoria(nombre, descripcion, imagen);

    }

    public void eliminar_categoria (String id_recibido) {

        id_convertido = Integer.parseInt(id_recibido.trim());

        modelo_categoria modelo = new modelo_categoria();

        modelo.eliminar_categoria(id_convertido);

    }
    
}
