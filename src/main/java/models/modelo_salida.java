package models;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class modelo_salida {

    Integer id_entrada = null;
    Date fecha = null;
    Integer id_usuario = null;

    public Integer getId_entrada() {

        return id_entrada;

    }

    public void setId_entrada(Integer id_entrada) {

        this.id_entrada = id_entrada;

    }

    public Date getFecha() {

        return fecha;

    }

    public void setFecha(Date fecha) {

        this.fecha = fecha;

    }

    public Integer getId_usuario() {

        return id_usuario;

    }

    public void setId_usuario(Integer id_usuario) {

        this.id_usuario = id_usuario;
        
    }

    public modelo_salida(Integer id_entrada, Date fecha, Integer id_usuario) {

        this.id_entrada = id_entrada;
        this.fecha = fecha;
        this.id_usuario = id_usuario;
        
    }
    
}
