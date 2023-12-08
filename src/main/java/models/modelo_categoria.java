package models;

import java.sql.*;
import java.util.*;

import connection.Conectar;

public class modelo_categoria {

    private int id_categoria = 0;
    private String nombre = null;
    private String descripcion = null;
    private byte[] imagen = null;

        //constructor para mostrar
    public modelo_categoria(Integer id_categoria, String nombre, String descripcion, byte[] imagen) {

        this.id_categoria = id_categoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;

    }

    //constructor vacio

    public modelo_categoria() {

    }

    // getters y setters

    public int getId_categoria() {

        return id_categoria;

    }

    public void setId_categoria(int id_categoria) {

        this.id_categoria = id_categoria;

    }

    public String getNombre() {

        return nombre;

    }

    public void setNombre(String nombre) {

        this.nombre = nombre;

    }

    public String getDescripcion() {

        return descripcion;

    }

    public void setDescripcion(String descripcion) {

        this.descripcion = descripcion;

    }

    public byte[] getImagen() {

        return imagen;

    }

    public void setImagen(byte[] imagen) {

        this.imagen = imagen;

    }

    // metodos de la clase

    public boolean insertar_categoria (String nombre, String descripcion, byte[] imagen) {

        Connection connection = null;
        PreparedStatement ps = null;

        try {
            
            connection = Conectar.Connect();

            if (connection != null) {

                // Llamamos al procedimiento almacenado "CREATE_USUARIO"

                String sql = "call create_categoria(?, ?, ?)";

                ps = connection.prepareStatement(sql);

                // Configuramos los parámetros del procedimiento almacenado

                ps.setString(1, nombre);
                ps.setString(2, descripcion);
                ps.setBytes(3, imagen);

                // Ejecuta el procedimiento almacenado

                ps.executeUpdate();

                System.out.println("categoria registrads con éxito.");

            } else {

                System.out.println("Error de conexión a la base de datos.");

            }
            
        } catch (SQLException e) {

            System.out.println("Error al insertar categoriA: " + e.getMessage());

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

    public ArrayList<modelo_categoria> categorias () {

        ArrayList<modelo_categoria> categorias = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            
            connection = Conectar.Connect();

            if (connection != null) {

                String sql = "call read_categoria()";
                ps = connection.prepareStatement(sql);
                rs = ps.executeQuery();

                while (rs.next()) {

                    int id_consulta = rs.getInt("id_categoria");
                    String nombre = rs.getString("nombre_categoria");
                    String descripcion = rs.getString("descripcion_categoria");
                    byte [] imagen = rs.getBytes("imagen");

                    modelo_categoria categoria = new modelo_categoria(id_consulta, nombre, descripcion, imagen);
                    categorias.add(categoria);
                    
                    setId_categoria(id_consulta);
                    setDescripcion(descripcion);
                    setNombre(nombre);
                    setImagen(imagen);

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

        return categorias;

}

public boolean eliminar_categoria (Integer id_categoria_recibido) {

    Connection connection = null;
    PreparedStatement ps = null;

    try {

        connection = Conectar.Connect();

        if (connection != null) {

            // Llamamos al procedimiento almacenado "delete_usuario"

            String sql = "CALL delete_categoria(?)";

            ps = connection.prepareStatement(sql);


            ps.setInt(1, id_categoria_recibido);

            ps.executeUpdate();

            System.out.println("categoria eliminado con éxito.");

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
