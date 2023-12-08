package connection;

//importamos todas las librerias de java sql

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectar {

    // declaramos los atributos de la clase

    private static final String data_base = "jdbc:mysql://localhost/sapphire_inventory";
    private static final String user = "root";
    private static final String pass = "";
    private static final String driver = "com.mysql.cj.jdbc.Driver";

    // Creamos el método para conectarnos a la base de datos el cual devolverá un
    // objeto de tipo Connection

    public static Connection Connect() {

        // creamos la variable para almacenar la cadena de conexion y la inicializamos
        // en null

        Connection conexion = null;

        // creamos un bloque trycatch para controlar las excepciones que puedan surgir
        // al momento de la conexion

        try {

            // registramos el driver que utilizaremos

            Class.forName(driver);

            // creamos la conexion

            conexion = DriverManager.getConnection(data_base, user, pass);

            // si se presentas errores se los mostraremos al usuario

        } catch (Exception e) {

            System.out.println("hubo un error a la hora de conectar con la base de datos"
                    + e.getMessage().toString().toUpperCase());

        }

        // returnamos las conexion

        return conexion;

    }

    // creamos el metodo para cerrar la conexion

    public static void Cerrar_conexion(Connection conexion) {

        // bloque try catch para cerrar la conexion y mostrar posibles errores

        try {

            // cerramos la conexion

            conexion.close();

        } catch (SQLException e) {

            // controlamos las excepciones en caso de que produsca un error en el proceso

            System.out.println(e.getMessage().toString().toUpperCase());

        }

    }

    public static void main(String[] args) {

        // Declaramos una variable para almacenar la conexión que nos va a devolver el
        // método Connection(). Primero la iniciamos en null

        Connection conexion = null;

        // almacenamos todo lo que nos devolvera el metodo connect en la variable
        // connection y la inicializamos en null

        conexion = Connect();

        // bloque if else para representar posibles mensajes

        if (conexion == null) {

            // le informamos al usuario que no nos hemos podido conectar

            System.out.println("no nos hemos podido conectar, verifica por favor");

        } else {

            // le informamos al susuario que la conexion es correcta

            System.out.println("la conexion es correcta y funcional");

        }

    }

}