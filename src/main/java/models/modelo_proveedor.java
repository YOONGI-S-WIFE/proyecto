package models;

import java.sql.*;
import java.util.*;

import connection.Conectar;

public class modelo_proveedor {

    private Integer id_proveedor = null;
    private String correo = null;
    private String nombre = null;
    private String telefono = null;

    // contructor para mostrar
    public modelo_proveedor(Integer id_proveedor, String correo, String nombre, String telefono) {

        this.id_proveedor = id_proveedor;
        this.correo = correo;
        this.nombre = nombre;
        this.telefono = telefono;
        
    }

    public Integer getId_proveedor() {

        return id_proveedor;

    }

    public void setId_proveedor(Integer id_proveedor) {

        this.id_proveedor = id_proveedor;

    }

    public String getCorreo() {

        return correo;

    }

    public void setCorreo(String correo) {

        this.correo = correo;

    }

    public String getNombre() {

        return nombre;

    }

    public void setNombre(String nombre) {

        this.nombre = nombre;

    }

    public String getTelefono() {

        return telefono;

    }

    public void setTelefono(String telefono) {

        this.telefono = telefono;

    }

     public boolean insertar_proveedor (String nombre, String correo, String telefono) {

        Connection connection = null;
        PreparedStatement ps = null;

        try {
            
            connection = Conectar.Connect();

            if (connection != null) {

                // Llamamos al procedimiento almacenado "CREATE_USUARIO"

                String sql = "call create_proveedor(?, ?, ?)";

                ps = connection.prepareStatement(sql);

                // Configuramos los parámetros del procedimiento almacenado

                ps.setString(1, nombre);
                ps.setString(2, correo);
                ps.setString(3, telefono);

                // Ejecuta el procedimiento almacenado

                ps.executeUpdate();

                System.out.println("proveedor registrads con éxito.");

            } else {

                System.out.println("Error de conexión a la base de datos.");

            }
            
        } catch (SQLException e) {

            System.out.println("Error al insertar proveedor: " + e.getMessage());

        } finally {

            try {

                if (ps != null) {

                    ps.close();

                }

                if (connection != null) {

                    Conectar.Cerrar_conexion(connection);

                }

            } catch (SQLException e) {

                System.out.println("Error al cerrar la conexión: " + e.getMessage());

            }

        }

        return false;
        
    }

    public ArrayList<modelo_proveedor> proveedores () {

        ArrayList<modelo_proveedor> proveedores = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            
            connection = Conectar.Connect();

            if (connection != null) {

                String sql = "call read_proveedores()";
                ps = connection.prepareStatement(sql);
                rs = ps.executeQuery();

                while (rs.next()) {

                    int id_consulta = rs.getInt("id_proveedor");
                    String nombre = rs.getString("nombre_proveedor");
                    String correo = rs.getString("correo_proveedor");
                    String telefono = rs.getString("telefono_proveedor");

                    modelo_proveedor proveedor = new modelo_proveedor(id_consulta, nombre, correo, telefono);
                    proveedores.add(proveedor);
                    
                    setId_proveedor(id_consulta);
                    setCorreo(correo);
                    setTelefono(telefono);
                    setNombre(nombre);

                }

            } else {

                System.out.println("Error de conexión a la base de datos.");

            }

        } catch (SQLException e) {

            System.out.println("Error al leer categorias: " + e.getMessage());

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

        return proveedores;

}

public boolean delete_proveedor (Integer id_proveedor_recibido) {

    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {

        connection = Conectar.Connect();

        if (connection != null) {

            // Llamamos al procedimiento almacenado "delete_usuario"

            String sql = "CALL delete_proveedor(?)";

            ps = connection.prepareStatement(sql);


            ps.setInt(1, id_proveedor_recibido);

            rs = ps.executeQuery();

            return rs.next();

        } else {

            System.out.println("Error de conexión a la base de datos.");

        }

    } catch (SQLException e) {

        System.out.println("Error al eliminar usuario: " + e.getMessage());

    } finally {

        try {

            if (ps != null) {

                ps.close();

            }

            if (connection != null) {

                Conectar.Cerrar_conexion(connection);

            }

        } catch (SQLException e) {

            System.out.println("Error al cerrar la conexión: " + e.getMessage());

        }

    }

    return false;
    
}
    
}
