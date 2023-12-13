package models;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import connection.Conectar;

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

    public modelo_salida(Integer id_entrada, Integer id_usuario) {

        this.id_entrada = id_entrada;
        this.id_usuario = id_usuario;
        
    }

    public modelo_salida() {
        
    }

    public int realizarVenta(ArrayList<modelo_detalle_salida> detallesVenta) {

        Connection connection = null;
        PreparedStatement psSalida = null;
        PreparedStatement psDetalles = null;
        ResultSet rsSalida = null;

        try {

            connection = Conectar.Connect();

            // Iniciar transacción
            connection.setAutoCommit(false);

            // Insertar la salida (venta)
            String sqlSalida = "call create_salida ()";
            psSalida = connection.prepareStatement(sqlSalida, Statement.RETURN_GENERATED_KEYS);

            psSalida.executeUpdate();

            // Obtener el ID de la salida generada
            rsSalida = psSalida.executeQuery();
            int idSalida = -1;

            if (rsSalida.next()) {

                idSalida = rsSalida.getInt("id_salida");

            } else {

                throw new SQLException("No se pudo obtener el ID de la salida generada.");

            }

            // Insertar los detalles de la venta
            String sqlDetalles = "call create_detalle_salida (?, ?, ?, ?)";
            psDetalles = connection.prepareStatement(sqlDetalles);

            for (modelo_detalle_salida detalle : detallesVenta) {
                psDetalles.setInt(1, detalle.getPrecio_item_vendido());
                psDetalles.setInt(2, detalle.getCantidad_item_vendido());
                psDetalles.setInt(3, idSalida);
                psDetalles.setInt(4, detalle.getId_producto());
                // Configurar otros parámetros según sea necesario...
                psDetalles.addBatch(); // Añadir la operación al lote
            }

            psDetalles.executeBatch(); // Ejecutar el lote de inserciones

            // Confirmar la transacción
            connection.commit();

            return idSalida;

        } catch (SQLException e) {

            // Deshacer la transacción en caso de error

            try {

                if (connection != null) {

                    connection.rollback();

                }
            } catch (SQLException ex) {

                ex.printStackTrace();

            }

            e.printStackTrace();

            return -1; // Indicar que ocurrió un error

        } finally {

            // Restaurar la configuración de la conexión

            try {

                if (connection != null) {

                    connection.setAutoCommit(true);

                }

            } catch (SQLException e) {

                e.printStackTrace();

            }

            // Cerrar recursos
            try {

                if (psSalida != null) {

                    psSalida.close();

                }

                if (psDetalles != null) {

                    psDetalles.close();

                }

                if (rsSalida != null) {

                    rsSalida.close();

                }

                if (connection != null) {

                    Conectar.Cerrar_conexion(connection);

                }

            } catch (SQLException e) {

                e.printStackTrace();

            }
        }
    }
    
}
