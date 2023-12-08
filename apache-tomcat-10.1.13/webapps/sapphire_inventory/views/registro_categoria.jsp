<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="jakarta.servlet.http.HttpServletRequest" %>
<%@ page import="jakarta.servlet.RequestDispatcher" %>

<% 

    HttpSession sesion = request.getSession();

    if (sesion.getAttribute("usuario") != null) {   

%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>REGISTRO DE CATEGORIAS</title>
</head>
<body>

    <button><a href="registro_usuario.jsp">Registrar usuario</a></button> 

    <button><a href="registro_producto.jsp">Registrar producto</a></button> 

    <button><a href="registro_categoria.jsp">Registrar categoria</a></button> 

    <button><a href="venta.jsp">Registrar venta</a></button> 

    <button><a href="entrada.jsp">Registrar entada</a></button> 

    <form action="/sapphire_inventory/mostrar_usuarios_servlet" method="GET">
    <input value="usuarios" name ="usuarios" type = "submit">
    </form>

    <form action="/sapphire_inventory/mostrar_categorias_servlet" method="post">
    <input value="productos" name ="productos" type = "submit">
    </form>

    <form action="/sapphire_inventory/cerrar_sesion_servlet" method="post">
        <input value="cerrar sesion" name ="cerrar_sesion" type = "submit">
        </form>

<h2>Registro de Producto</h2>

    <form action="/sapphire_inventory/registro_categoria_servlet" method="POST" enctype="multipart/form-data">

        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required>

        <br><br>

        <label for="descripcion">Descripción:</label>
        <textarea id="descripcion" name="descripcion" rows="4" required></textarea>


        <br><br>

        <label for="imagen">Imagen:</label>
        <input type="file" id="imagen" name="imagen" accept="image/*" required>

        <br><br>

        <button name ="registrar" type = "submit" class="btn">Registrar</button>

    </form>
    
</body>
</html>

<% 

} else {

    RequestDispatcher redireccion = request.getRequestDispatcher("error_sesion.jsp");
    redireccion.forward(request, response);

    }
    
    %>