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
    private String nombre_producto = null;

    public String getNombre_producto() {

        return nombre_producto;

    }
    public void setNombre_producto(String nombre_producto) {

        this.nombre_producto = nombre_producto;

    }

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

    public modelo_item(Integer id_item, Integer precio, Integer id_entrada, Integer id_producto, Integer cantidad, String nombre_producto) {

        this.id_item = id_item;
        this.precio = precio;
        this.id_entrada = id_entrada;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
        this.nombre_producto = nombre_producto;
        
    }

    public modelo_item() {
        
    }

    public ArrayList<modelo_item> item_id (Integer id_item_recibido, Integer cantidad) {

        ArrayList<modelo_item> item_id = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
    
        try {

            connection = Conectar.Connect();
    
            if (connection != null) {
    
                String sql = "SELECT i.*, p.nombre_producto, p.id_producto " +
                             "FROM item i " +
                             "JOIN producto p ON i.id_producto = p.id_producto " +
                             "WHERE i.id_producto = ?";

                ps = connection.prepareStatement(sql);
    
                ps.setInt(1, id_item_recibido);
    
                rs = ps.executeQuery();
    
                while (rs.next()) {

                    Integer id = rs.getInt("id_producto");
                    Integer precio_venta = rs.getInt("precio_venta");
                    Integer id_entrada = rs.getInt("id_entrada");
                    Integer id_producto = rs.getInt("id_producto");
                    String nombre_producto = rs.getString("nombre_producto");
    
                    modelo_item item = new modelo_item(id, precio_venta, id_entrada, id_producto, cantidad, nombre_producto);
                    item_id.add(item);
    
                    setCantidad(cantidad);
                    setId_entrada(id_entrada);
                    setId_item(id);
                    setId_producto(id_producto);
                    setPrecio(precio_venta);
                    setNombre_producto(nombre_producto);

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
