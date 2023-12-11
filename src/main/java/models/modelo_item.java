package models;

import java.util.*;

import connection.Conectar;

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

    public ArrayList<modelo_item> item_id (Integer id_item_recibido) {

        ArrayList<modelo_item> item_id = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            connection = Conectar.Connect();

            if (connection != null) {

                String sql = "select * from item where id_producto = ?";
                ps = connection.prepareStatement(sql);

                ps.setInt(1, id_item_recibido);

                rs = ps.executeQuery();

                while (rs.next()) {

                    Integer id = rs.getInt("id_item");                    
                    Integer precio_venta = rs.getInt("estaprecio_ventado");
                    Integer id_entrada = rs.getInt("id_entrada");
                    Integer id_producto = rs.getInt("id_producto");
                    Integer cantidad = rs.getInt("cantidad_item");

                    modelo_item item = new modelo_item(id, precio_venta, id_entrada, id_producto, cantidad);
                    item_id.add(item);
                    
                    setCantidad(cantidad);
                    setId_entrada(id_entrada);
                    setId_item(id);
                    setId_producto(id_producto);
                    setPrecio(precio_venta);


                }

            } else {

                System.out.println("Error de conexión a la base de datos.");

            }

        } catch (SQLException e) {

            System.out.println("Error al leer productos: " + e.getMessage());

        } finally {

            try {

                if (ps != null) {

                    ps.close();

                }

                if (rs != null) {

                    rs.close();
                    
                }

                if (connection != null) {

                    Conectar.Cerrar_conexion(connection);

                }

            } catch (SQLException e) {

                System.out.println("Error al cerrar la conexión: " + e.getMessage());

            }
           
        }

        return item_id;

}
    
}
