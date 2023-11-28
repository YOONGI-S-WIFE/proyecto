package controllers;

import models.modelo_usuario;
import servlets.registro_usuario_servlet;
import java.util.ArrayList;

// creamos la clase controlador_usuario

public class controlador_usuario {

    // le asignamos sus atributos a la clase

    private String nombres_usuario = null;
    private String apellidos_usuario = null;
    private String tipo_documento = null;
    private String numero_documento_usuario = null;
    private String contraseña = null;
    private String usuario = null;
    private String telefono_usuario = null;
    private Integer id_usuario = null;
    private String rol_usuario = null;
    private Integer tipo_documento_usuario_convertido = null;
    private Integer rol_usuario_convertido =  null;
    private String resultado = null;
    public ArrayList<modelo_usuario> mostrar_usuarios;
    
    // creamos el metodo constructor de la clase

// creamos los getters y setters de cada atributo de la clase

    public ArrayList<modelo_usuario> getMostrar_usuarios() {

        return mostrar_usuarios;

    }

    public void setMostrar_usuarios(ArrayList<modelo_usuario> mostrar_usuarios) {

        this.mostrar_usuarios = mostrar_usuarios;

    }

    public Integer getRol_usuario_convertido() {

        return rol_usuario_convertido;

    }

    public void setRol_usuario_convertido(Integer rol_usuario_convertido) {

        this.rol_usuario_convertido = rol_usuario_convertido;

    }

    public Integer getId_usuario() {

        return id_usuario;

    }

    public void setId_usuario(Integer id_usuario) {

        this.id_usuario = id_usuario;

    }

    public String getResultado() {

        return resultado;
        
    }

    public void setResultado(String resultado) {

        this.resultado = resultado;
        
    }

    public Integer getTipo_documento_usuario_convertido() {

        return tipo_documento_usuario_convertido;

    }

    public void setTipo_documento_usuario_convertido(Integer tipo_documento_usuario_convertido) {

        this.tipo_documento_usuario_convertido = tipo_documento_usuario_convertido;

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

    public String getRol_usuario() {

        return rol_usuario;

    }

    public void setRol_usuario(String rol_usuario) {

        this.rol_usuario = rol_usuario;

    }

    public String getTipo_documento() {

        return tipo_documento;

    }

    public void setTipo_documento(String tipo_documento) {

        this.tipo_documento = tipo_documento;

    }

    public void enviar_modelo() {

        modelo_usuario recibir = new modelo_usuario();

        if (tipo_documento == "cedula") {

            tipo_documento_usuario_convertido = 1;
            
        } else if (tipo_documento == "cedula_extranjeria") {

            tipo_documento_usuario_convertido = 2;
            
        } else {

            tipo_documento_usuario_convertido = 3;
            
        } 

        if (rol_usuario == "administrador") {

            rol_usuario_convertido = 0;
            
        } else {

            rol_usuario_convertido = 1;
            
        }

        recibir.setNombres_usuario(nombres_usuario);
        recibir.setApellidos_usuario(apellidos_usuario);
        recibir.setContraseña(contraseña);
        recibir.setRol_usuario(rol_usuario_convertido);
        recibir.setTelefono_usuario(telefono_usuario);
        recibir.setTipo_documento(tipo_documento_usuario_convertido);
        recibir.setUsuario(usuario);
        recibir.setNumero_documento_usuario(numero_documento_usuario);

        if (recibir.insertar_usuario() == true) {

            resultado = "usuario registrado con exito";

            registro_usuario_servlet servlet = new registro_usuario_servlet();

            servlet.setResultado(resultado);
            
        } else {

            resultado = null;
            
        }

    }

    public Boolean login (String usuario_validar, String contrasenna_validar, String rol_recibido) {

        modelo_usuario modelo = new modelo_usuario();

        if ("administrador".equals(rol_recibido)) {

            rol_usuario_convertido = 0;
            
        } else {

            rol_usuario_convertido = 1;
            
        }

        return modelo.login(usuario_validar, contrasenna_validar, rol_usuario_convertido);

    }

    public void eliminar_usuario (String id_usuario_recibido) {

        id_usuario = Integer.parseInt(id_usuario_recibido);

        modelo_usuario modelo = new modelo_usuario();

        modelo.delete_usuario(id_usuario);

    }

}