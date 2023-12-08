package models;

import java.util.*;
import java.sql.*;
import java.sql.Date;

public class modelo_entrada {

    Integer id_entrada = null;
    Date fecha = null;
    Integer id_proveedor = null;

    public Date getFecha() {

        return fecha;

    }
    public void setFecha(Date fecha) {

        this.fecha = fecha;

    }
    
}
