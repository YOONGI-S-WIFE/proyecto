package models;

import java.sql.*;
import java.util.*;
import connection.Conectar;
import controllers.controlador_usuario;

public class modelo_usuario {

    private String nombres_usuario = null;
    private String apellidos_usuario = null;
    private int tipo_documento = 0;
    private String numero_documento_usuario = null;
    private String contraseña = null;
    private String usuario = null;
    private String telefono_usuario = null;
    private Integer rol_usuario = null;
    private int id_usuario = 0;
    private String rol_convertido = null;

    controlador_usuario pasar_resultado = new controlador_usuario();

    public modelo_usuario(String nombres_usuario, String apellidos_usuario, int tipo_documento,
            String numero_documento_usuario, String contraseña, String usuario, String telefono_usuario, int id_usuario,
            String rol_convertido) {

        this.nombres_usuario = nombres_usuario;
        this.apellidos_usuario = apellidos_usuario;
        this.tipo_documento = tipo_documento;
        this.numero_documento_usuario = numero_documento_usuario;
        this.contraseña = contraseña;
        this.usuario = usuario;
        this.telefono_usuario = telefono_usuario;
        this.id_usuario = id_usuario;
        this.rol_convertido = rol_convertido;

    }

    public modelo_usuario () {


    }

    public modelo_usuario(String nombres_usuario, String apellidos_usuario, int tipo_documento,
            String numero_documento_usuario, String contraseña, String usuario, String telefono_usuario,
            Integer rol_usuario, int id_usuario) {

        this.nombres_usuario = nombres_usuario;
        this.apellidos_usuario = apellidos_usuario;
        this.tipo_documento = tipo_documento;
        this.numero_documento_usuario = numero_documento_usuario;
        this.contraseña = contraseña;
        this.usuario = usuario;
        this.telefono_usuario = telefono_usuario;
        this.rol_usuario = rol_usuario;
        this.id_usuario = id_usuario;

    }

    public String getRol_convertido() {

        return rol_convertido;
    }

    public void setRol_convertido(String rol_convertido) {

        this.rol_convertido = rol_convertido;
        
    }

    public int getId_usuario() {

        return id_usuario;

    }

    public void setId_usuario(int id_usuario) {

        this.id_usuario = id_usuario;

    }

    public String getNombres_usuario() {

        return nombres_usuario;

    }

    public void setNombres_usuario(String nombres_usuario) {

        this.nombres_usuario = nombres_usuario;

    }

    public String getApellidos_usuario() {

        return apellidos_usuario;

    }

    public void setApellidos_usuario(String apellidos_usuario) {

        this.apellidos_usuario = apellidos_usuario;

    }

    public String getNumero_documento_usuario() {

        return numero_documento_usuario;

    }

    public void setNumero_documento_usuario(String numero_documento_usuario) {

        this.numero_documento_usuario = numero_documento_usuario;

    }

    public String getContraseña() {

        return contraseña;

    }

    public void setContraseña(String contraseña) {

        this.contraseña = contraseña;

    }

    public String getUsuario() {

        return usuario;

    }

    public void setUsuario(String usuario) {

        this.usuario = usuario;

    }

    public String getTelefono_usuario() {

        return telefono_usuario;

    }

    public void setTelefono_usuario(String telefono_usuario) {

        this.telefono_usuario = telefono_usuario;

    }

    public Integer getRol_usuario() {

        return rol_usuario;

    }

    public void setRol_usuario(Integer rol_usuario) {

        this.rol_usuario = rol_usuario;

    }

    public int getTipo_documento() {

        return tipo_documento;

    }

    public void setTipo_documento(int tipo_documento) {

        this.tipo_documento = tipo_documento;

    }

    public boolean insertar_usuario () {

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            
            connection = Conectar.Connect();

            if (connection != null) {

                // Llamamos al procedimiento almacenado "CREATE_USUARIO"

                String sql = "CALL CREATE_USUARIO(?, ?, ?, ?, ?, ?, ?, ?)";

                ps = connection.prepareStatement(sql);

                // Configuramos los parámetros del procedimiento almacenado

                ps.setString(1, nombres_usuario);
                ps.setString(2, apellidos_usuario);
                ps.setInt(3, tipo_documento);
                ps.setString(4, numero_documento_usuario);
                ps.setString(5, usuario);
                ps.setString(6, contraseña);
                ps.setString(7, telefono_usuario);
                ps.setInt(8, rol_usuario);

                // Ejecuta el procedimiento almacenado

                rs = ps.executeQuery();

                return rs.next();

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

    public List<modelo_usuario> mostrar_usuarios() {

        List<modelo_usuario> usuarios = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connection = Conectar.Connect();

            if (connection != null) {

                String sql = "CALL READ_USUARIO()";
                ps = connection.prepareStatement(sql);
                rs = ps.executeQuery();

                while (rs.next()) {

                    int id = rs.getInt("id_usuario");
                    String nombres = rs.getString("nombres_usuario");
                    String apellidos = rs.getString("apellidos_usuario");
                    int tipoDocumento = rs.getInt("tipo_documento");
                    String numeroDocumento = rs.getString("numero_documento_usuario");
                    String usuario_rs = rs.getString("usuario");
                    String telefono = rs.getString("telefono_usuario");
                    Integer rol = Integer.parseInt(rs.getString("rol_usuario"));
                    String contraseña = rs.getString("contraseña");

                    setId_usuario(id);
                    setNombres_usuario(usuario_rs);
                    setApellidos_usuario(apellidos);
                    setTipo_documento(tipoDocumento);
                    setNumero_documento_usuario(numeroDocumento);
                    setUsuario(usuario_rs);
                    setTelefono_usuario(telefono);
                    setRol_usuario(rol);
                    setContraseña(contraseña);

                    modelo_usuario usuario = new modelo_usuario(nombres, apellidos, tipoDocumento, numeroDocumento, contraseña, usuario_rs, telefono, rol, id);
                    usuarios.add(usuario);

                }

            } else {

                System.out.println("Error de conexión a la base de datos.");

            }

        } catch (SQLException e) {

            System.out.println("Error al leer usuarios: " + e.getMessage());

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

        return usuarios;

    }

    public List<modelo_usuario> mostrar_usuario(Integer id_usuario_recibido) {

        List<modelo_usuario> usuario = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connection = Conectar.Connect();

            if (connection != null) {

                String sql = "call read_usuario_especifico(?)";
                ps = connection.prepareStatement(sql);
                ps.setInt(1, id_usuario_recibido);
                rs = ps.executeQuery();
                

                while (rs.next()) {

                    int id = rs.getInt("id_usuario");
                    String nombres = rs.getString("nombres_usuario");
                    String apellidos = rs.getString("apellidos_usuario");
                    int tipoDocumento = rs.getInt("tipo_documento");
                    String numeroDocumento = rs.getString("numero_documento_usuario");
                    String usuario_rs = rs.getString("usuario");
                    String telefono = rs.getString("telefono_usuario");
                    Integer rol = Integer.parseInt(rs.getString("rol_usuario"));
                    String contraseña = rs.getString("contraseña");

                    setId_usuario(id);
                    setNombres_usuario(usuario_rs);
                    setApellidos_usuario(apellidos);
                    setTipo_documento(tipoDocumento);
                    setNumero_documento_usuario(numeroDocumento);
                    setUsuario(usuario_rs);
                    setTelefono_usuario(telefono);
                    setRol_usuario(rol);
                    setContraseña(contraseña);

                    modelo_usuario usuario_especifico = new modelo_usuario(nombres, apellidos, tipoDocumento, numeroDocumento, contraseña, usuario_rs, telefono, rol, id);
                    usuario.add(usuario_especifico);

                }

            } else {

                System.out.println("Error de conexión a la base de datos.");

            }

        } catch (SQLException e) {

            System.out.println("Error al leer usuario: " + e.getMessage());

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

        return usuario;

    }

    public boolean actualizar_nombres_usuario(String nombres, Integer id_recibido) {

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connection = Conectar.Connect();

            if (connection != null) {

                String sql = "CALL update_nombres_usuario(?, ?)";

                ps = connection.prepareStatement(sql);

                // Configuramos los parámetros del procedimiento almacenado

                ps.setInt(1, id_recibido);
                ps.setString(2, nombres);

                rs = ps.executeQuery();

                return rs.next();

            } else {

                System.out.println("Error de conexión a la base de datos.");

            }

        } catch (SQLException e) {

            System.out.println("Error al actualizar usuario: " + e.getMessage());

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

     public boolean actualizar_apellidos_usuario(String apellidos, Integer id_recibido) {

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connection = Conectar.Connect();

            if (connection != null) {

                String sql = "CALL update_nombres_usuario(?, ?)";

                ps = connection.prepareStatement(sql);

                // Configuramos los parámetros del procedimiento almacenado

                ps.setInt(1, id_recibido);
                ps.setString(1, apellidos);

                rs = ps.executeQuery();

                return rs.next();

            } else {

                System.out.println("Error de conexión a la base de datos.");

            }

        } catch (SQLException e) {

            System.out.println("Error al actualizar usuario: " + e.getMessage());

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

     public boolean actualizar_tipo_documento_usuario(Integer tipo_documento_recibido, Integer id_recibido) {

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connection = Conectar.Connect();

            if (connection != null) {

                String sql = "CALL update_tipo_documento_usuario(?, ?)";

                ps = connection.prepareStatement(sql);

                // Configuramos los parámetros del procedimiento almacenado

                ps.setInt(1, id_recibido);
                ps.setInt(1, tipo_documento_recibido);

                rs = ps.executeQuery();

                return rs.next();
            } else {

                System.out.println("Error de conexión a la base de datos.");

            }

        } catch (SQLException e) {

            System.out.println("Error al actualizar usuario: " + e.getMessage());

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

     public boolean actualizar_numero_documento_usuario(String documento_recibido, Integer id_recibido) {

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connection = Conectar.Connect();

            if (connection != null) {

                String sql = "CALL update_numero_documento_usuario(?, ?)";

                ps = connection.prepareStatement(sql);

                // Configuramos los parámetros del procedimiento almacenado

                ps.setInt(1, id_recibido);
                ps.setString(1, documento_recibido);

                rs = ps.executeQuery();

                return rs.next();

            } else {

                System.out.println("Error de conexión a la base de datos.");

            }

        } catch (SQLException e) {

            System.out.println("Error al actualizar usuario: " + e.getMessage());

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

     public boolean actualizar_telefono_usuario(String telefono_recibido, Integer id_recibido) {

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connection = Conectar.Connect();

            if (connection != null) {

                String sql = "CALL update_telefono_usuario(?, ?)";

                ps = connection.prepareStatement(sql);

                // Configuramos los parámetros del procedimiento almacenado

                ps.setInt(1, id_recibido);
                ps.setString(1, telefono_recibido);

                rs = ps.executeQuery();

                return rs.next();

            } else {

                System.out.println("Error de conexión a la base de datos.");

            }

        } catch (SQLException e) {

            System.out.println("Error al actualizar usuario: " + e.getMessage());

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

     public boolean actualizar_rol_usuario(Integer rol_recibido, Integer id_recibido) {

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connection = Conectar.Connect();

            if (connection != null) {

                String sql = "CALL update_rol_usuario(?, ?)";

                ps = connection.prepareStatement(sql);

                // Configuramos los parámetros del procedimiento almacenado

                ps.setInt(1, id_recibido);
                ps.setInt(1, rol_recibido);

                rs = ps.executeQuery();

                return rs.next();

            } else {

                System.out.println("Error de conexión a la base de datos.");

            }

        } catch (SQLException e) {

            System.out.println("Error al actualizar usuario: " + e.getMessage());

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

     public boolean actualizar_usuario_usuario(String usuario_recibido, Integer id_recibido) {

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connection = Conectar.Connect();

            if (connection != null) {

                String sql = "CALL update_usuario_usuario(?, ?)";

                ps = connection.prepareStatement(sql);

                // Configuramos los parámetros del procedimiento almacenado

                ps.setInt(1, id_recibido);
                ps.setString(1, usuario_recibido);

                rs = ps.executeQuery();

                return rs.next();

            } else {

                System.out.println("Error de conexión a la base de datos.");

            }

        } catch (SQLException e) {

            System.out.println("Error al actualizar usuario: " + e.getMessage());

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

     public boolean actualizar_contraseña_usuario(String contraseña_recibida, Integer id_recibido) {

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connection = Conectar.Connect();

            if (connection != null) {

                String sql = "CALL update_contraseña_usuario(?, ?)";

                ps = connection.prepareStatement(sql);

                // Configuramos los parámetros del procedimiento almacenado

                ps.setInt(1, id_recibido);
                ps.setString(1, contraseña_recibida);

                rs = ps.executeQuery();

                return rs.next();

            } else {

                System.out.println("Error de conexión a la base de datos.");

            }

        } catch (SQLException e) {

            System.out.println("Error al actualizar usuario: " + e.getMessage());

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

    public boolean delete_usuario(Integer id_usuario) {

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            connection = Conectar.Connect();

            if (connection != null) {

                // Llamamos al procedimiento almacenado "delete_usuario"

                String sql = "CALL delete_usuario(?)";

                ps = connection.prepareStatement(sql);

                ps.setInt(1, id_usuario);

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

    public boolean login (String usuario, String contrasenna, Integer rol_recibido) {

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            
            connection = Conectar.Connect();

            if (connection != null) {

                String sql = "SELECT * FROM usuario WHERE usuario = ? AND contraseña = ? AND rol_usuario = ?";

                ps = connection.prepareStatement(sql);
                ps.setString(1, usuario);
                ps.setString(2, contrasenna);
                ps.setInt(3, rol_recibido);
                rs = ps.executeQuery();

                return rs.next();  

            } else {

                System.out.println("Error de conexión a la base de datos.");

            }

        } catch (SQLException e) {

            System.out.println("Error al verificar el usuario: " + e.getMessage());

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

        return false; 

    }

    public boolean validar_contraseña (String usuario, String contrasenna) {

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            
            connection = Conectar.Connect();

            if (connection != null) {

                String sql = "SELECT * FROM usuario WHERE usuario = ? AND contraseña = ?";

                ps = connection.prepareStatement(sql);
                ps.setString(1, usuario);
                ps.setString(2, contrasenna);
                rs = ps.executeQuery();

                return rs.next(); 

            } else {

                System.out.println("Error de conexión a la base de datos.");

            }

        } catch (SQLException e) {

            System.out.println("Error al verificar el usuario: " + e.getMessage());

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

        return false;

    }

}


