package models;

public class modelo_detalle_salida {
 
    private Integer id_detalle_salida = null;
    private Integer precio_item_vendido = null;
    private Integer cantidad_item_vendido = null;
    private Integer id_salida = null;
    private Integer id_producto = null;

    public modelo_detalle_salida(Integer precio_item_vendido, Integer cantidad_item_vendido,
            Integer id_salida, Integer id_producto) {

        this.precio_item_vendido = precio_item_vendido;
        this.cantidad_item_vendido = cantidad_item_vendido;
        this.id_salida = id_salida;
        this.id_producto = id_producto;
        
    }

    public Integer getId_detalle_salida() {

        return id_detalle_salida;

    }

    public void setId_detalle_salida(Integer id_detalle_salida) {

        this.id_detalle_salida = id_detalle_salida;

    }

    public Integer getPrecio_item_vendido() {

        return precio_item_vendido;

    }

    public void setPrecio_item_vendido(Integer precio_item_vendido) {

        this.precio_item_vendido = precio_item_vendido;

    }

    public Integer getCantidad_item_vendido() {

        return cantidad_item_vendido;

    }

    public void setCantidad_item_vendido(Integer cantidad_item_vendido) {

        this.cantidad_item_vendido = cantidad_item_vendido;

    }

    public Integer getId_salida() {

        return id_salida;

    }

    public void setId_salida(Integer id_salida) {

        this.id_salida = id_salida;

    }

    public Integer getId_producto() {

        return id_producto;

    }

    public void setId_producto(Integer id_producto) {

        this.id_producto = id_producto;
        
    }
    
}
