package models;

// importamos las utilerias necesarias

import java.sql.*;
import java.util.*;

// importamos los clases de otras clases de otros paquetes

import connection.Conectar;
import controllers.controlador_producto;

// Se crea la clase modelo_producto

public class modelo_producto {

    // Se le asignan los atributos a la clase anteriormente creada

    private Integer id_producto = 0;
    private String marca_producto = "";
    private boolean estado = true;
    private String nombre_producto = "";
    private String descripcion_producto = "";
    private int cantidad_producto = 0;
    private Integer medida = null;
    private int id_categoria = 0;
    private byte[] imagen;
    private Boolean resultado = false;

    // constructor para mostrar productos por categoria
        public modelo_producto(int id_producto, String marca_producto, boolean estado, String nombre_producto,
            String descripcion_producto, int cantidad_producto, Integer medida, int id_categoria, byte[] imagen) {
        this.id_producto = id_producto;
        this.marca_producto = marca_producto;
        this.estado = estado;
        this.nombre_producto = nombre_producto;
        this.descripcion_producto = descripcion_producto;
        this.cantidad_producto = cantidad_producto;
        this.medida = medida;
        this.id_categoria = id_categoria;
        this.imagen = imagen;

    }

    public modelo_producto() {

    }

        // Se crean los getters y setters de los atributos de la clase

        public byte[] getImagen() {

        return imagen;

    }

    public void setImagen(byte[] imagen) {

        this.imagen = imagen;

    }

    public int getId_producto() {

        return id_producto;

    }

    public void setId_producto(Integer id_producto) {

        this.id_producto = id_producto;

    }

    public String getMarca_producto() {

        return marca_producto;

    }

    public void setMarca_producto(String marca_producto) {

        this.marca_producto = marca_producto;

    }

    public boolean isEstado() {

        return estado;

    }

    public void setEstado(boolean estado) {

        this.estado = estado;

    }

    public String getNombre_producto() {

        return nombre_producto;

    }

    public void setNombre_producto(String nombre_producto) {

        this.nombre_producto = nombre_producto;

    }

    public String getDescripcion_producto() {

        return descripcion_producto;

    }

    public void setDescripcion_producto(String descripcion_producto) {

        this.descripcion_producto = descripcion_producto;

    }

    public int getCantidad_producto() {

        return cantidad_producto;

    }

    public void setCantidad_producto(int cantidad_producto) {

        this.cantidad_producto = cantidad_producto;

    }

    public int getMedida() {

        return medida;

    }

    public void setMedida(int medida) {

        this.medida = medida;

    }

    public int getId_categoria() {

        return id_categoria;

    }

    public void setId_categoria(int id_categoria) {

        this.id_categoria = id_categoria;

    }

    // creamos es metodo insertar_producto

    public boolean insertar_producto(String marca, Boolean estado, String nombre, String descripcion, Integer cantidad, Integer medida, Integer id_categoria, byte[] imagen) {

        Connection connection = null;
        PreparedStatement ps = null;

        try {
            
            connection = Conectar.Connect();

            if (connection != null) {

                // Llamamos al procedimiento almacenado "CREATE_USUARIO"

                String sql = "call create_producto(?, ?, ?, ?, ?, ?, ?, ?)";

                ps = connection.prepareStatement(sql);

                // Configuramos los parámetros del procedimiento almacenado

                ps.setString(1, marca_producto);
                ps.setBoolean(2,estado);
                ps.setString(3, nombre_producto);
                ps.setString(4, descripcion_producto);
                ps.setInt(5, cantidad_producto);
                ps.setInt(6, medida);
                ps.setInt(7, id_categoria);
                ps.setBytes(8, imagen);

                // Ejecuta el procedimiento almacenado

                ps.executeUpdate();

                System.out.println("Producto registrado con éxito.");

                resultado = true;

                controlador_producto pasar_resultado = new controlador_producto();

                pasar_resultado.setResultado(resultado);

                pasar_resultado.resultado();

            } else {

                System.out.println("Error de conexión a la base de datos.");

            }
            
        } catch (SQLException e) {

            System.out.println("Error al insertar usuario: " + e.getMessage());

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

    public ArrayList<modelo_producto> productos_categoria (Integer id_categoria_recibido) {

        ArrayList<modelo_producto> productos_categoria = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            connection = Conectar.Connect();

            if (connection != null) {

                String sql = "call read_productos_categoria(?)";
                ps = connection.prepareStatement(sql);

                ps.setInt(1, id_categoria_recibido);

                rs = ps.executeQuery();

                while (rs.next()) {

                    Integer id = rs.getInt("id_producto");                    
                    String marca = rs.getString("marca_producto");
                    Boolean estado = rs.getBoolean("estado");
                    String nombre = rs.getString("nombre_producto");
                    String descripcion = rs.getString("descripcion_producto");
                    Integer cantidad = rs.getInt("cantidad_producto");
                    Integer medida = rs.getInt("medida");
                    Integer id_categoria_consulta = rs.getInt("id_categoria");
                    byte [] imagen = rs.getBytes("imagen");

                    modelo_producto productos = new modelo_producto(id, marca, estado, nombre, descripcion, cantidad, medida, id_categoria_consulta, imagen);
                    productos_categoria.add(productos);
                    
                    setId_producto(id);
                    setMarca_producto(marca);
                    setEstado(estado);
                    setNombre_producto(nombre);
                    setDescripcion_producto(descripcion);
                    setCantidad_producto(cantidad_producto);
                    setMedida(medida);
                    setId_categoria(id_categoria_consulta);
                    setImagen(imagen);

                    System.out.println(id_producto);
                    System.out.println(marca_producto);
                    System.out.println(estado);
                    System.out.println(nombre_producto);
                    System.out.println(descripcion_producto);
                    System.out.println(cantidad_producto);
                    System.out.println(medida);
                    System.out.println(id_categoria);
                    System.out.println(imagen);

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

        return productos_categoria;

}

public ArrayList<modelo_producto> producto_id (Integer id_producto_recibido) {

        ArrayList<modelo_producto> producto_id = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            connection = Conectar.Connect();

            if (connection != null) {

                String sql = "select * from producto where id_producto = ?";
                ps = connection.prepareStatement(sql);

                ps.setInt(1, id_producto_recibido);

                rs = ps.executeQuery();

                while (rs.next()) {

                    Integer id = rs.getInt("id_producto");                    
                    String marca = rs.getString("marca_producto");
                    Boolean estado = rs.getBoolean("estado");
                    String nombre = rs.getString("nombre_producto");
                    String descripcion = rs.getString("descripcion_producto");
                    Integer cantidad = rs.getInt("cantidad_producto");
                    Integer medida = rs.getInt("medida");
                    Integer id_categoria_consulta = rs.getInt("id_categoria");
                    byte [] imagen = rs.getBytes("imagen");

                    modelo_producto producto = new modelo_producto(id, marca, estado, nombre, descripcion, cantidad, medida, id_categoria_consulta, imagen);
                    producto_id.add(producto);
                    
                    setId_producto(id);
                    setMarca_producto(marca);
                    setEstado(estado);
                    setNombre_producto(nombre);
                    setDescripcion_producto(descripcion);
                    setCantidad_producto(cantidad_producto);
                    setMedida(medida);
                    setId_categoria(id_categoria_consulta);
                    setImagen(imagen);

                    System.out.println(id_producto);
                    System.out.println(marca_producto);
                    System.out.println(estado);
                    System.out.println(nombre_producto);
                    System.out.println(descripcion_producto);
                    System.out.println(cantidad_producto);
                    System.out.println(medida);
                    System.out.println(id_categoria);
                    System.out.println(imagen);

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

        return producto_id;

}

}
