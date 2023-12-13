<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="servlets.registro_usuario_servlet" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>REGISTRO DE USUARIO</title>
    <link  rel="stylesheet" type="text/css" href="../webapp/css/styles.css">
    <link  rel="stylesheet" type="text/css" href="../webapp/css/products.css">
</head>
<body>

    <button><a href="registro_usuario.jsp">Registrar usuario</a></button> 

    <button><a href="registro_producto.jsp">Registrar producto</a></button> 

    <button><a href="registro_categoria.jsp">Registrar categoria</a></button> 

    <button><a href="venta.jsp">Registrar venta</a></button> 

    <button><a href="entrada.jsp">Registrar entrada</a></button> 

    <form action="/sapphire_inventory/mostrar_usuarios_servlet" method="GET">
    <input value="usuarios" name ="usuarios" type = "submit">
    </form>

    <form action="/sapphire_inventory/mostrar_categorias_servlet" method="post">
    <input value="productos" name ="productos" type = "submit">
    </form>

    <form action="/sapphire_inventory/cerrar_sesion_servlet" method="post">
    <input value="cerrar sesion" name ="cerrar_sesion" type = "submit">
    </form>

    <div class="uptadeProductContainer">
        <h2>Formulario de Registro de Usuario</h2>

        <form action="/sapphire_inventory/registro_usuario_servlet" method="POST">

            <label for="nombres">Nombres:</label>
            <input type="text" id="nombres_usuario" name="nombres_usuario" required>

            <label for="apellidos">Apellidos:</label>
            <input type="text" id="apellidos_usuario" name="apellidos_usuario" required>

            <label for="tipo_documento">Tipo de Documento:</label>
            <select id="tipo_documento_usuario" name="tipo_documento_usuario" required>

                <option value="cedula">Cedula de ciudadania</option>
                <option value="cedula_extranjeria">cedula de extranjeria</option>
                <option value="pasaporte">pasaporte</option>

            </select>

            <label for="numero_documento">Numero de Documento:</label>
            <input type="text" id="numero_documento_usuario" name="numero_documento_usuario" required>
            
            <label for="numero_telefono">Numero de Telefono:</label>
            <input type="tel" id="numero_telefono_usuario" name="numero_telefono_usuario" required>
            
            <label for="rol_usuario">rol_usuario:</label>
            <input type="text" id="rol_usuario" name="rol_usuario" value="empleado" readonly>
            
            <label for="usuario">Usuario:</label>
            <input type="text" id="usuario" name="usuario" required>
            
            <label for="contrasena">Contraseña:</label>
            <input type="password" id="contrasenna_usuario" name="contrasenna_usuario" required>
            
            <div class="btnUpdateContainer">
                <button name ="registrar" type = "submit" class="btn">Registrar</button>
            </div>

        </form>
    </div>
    
</body>
</html>