package models;

import java.sql.Date;
import java.util.*;
import java.sql.*;

public class modelo_item {

    private Integer id_item = null;
    private Integer precio = null;
    private Integer id_entrada = null;
    private Integer id_producto = null;
    private Integer cantidad = null;

    public Integer getId_item() {

        return id_item;

    }
    public void setId_item(Integer id_item) {

        this.id_item = id_item;

    }
    
    public Integer getId_proveedor() {

        return id_entrada;

    }

    public void setId_proveedor(Integer id_proveedor) {

        this.id_entrada = id_proveedor;

    }

    public Integer getPrecio() {

        return precio;

    }

    public void setPrecio(Integer precio) {

        this.precio = precio;

    }

    public Integer getId_entrada() {

        return id_entrada;

    }

    public void setId_entrada(Integer id_entrada) {

        this.id_entrada = id_entrada;

    }

    public Integer getId_producto() {

        return id_producto;

    }

    public void setId_producto(Integer id_producto) {

        this.id_producto = id_producto;

    }

    public Integer getCantidad() {

        return cantidad;

    }

    public void setCantidad(Integer cantidad) {

        this.cantidad = cantidad;
        
    }

    public modelo_item(Integer id_item, Integer precio, Integer id_entrada, Integer id_producto, Integer cantidad) {

        this.id_item = id_item;
        this.precio = precio;
        this.id_entrada = id_entrada;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
        
    }
    
}
