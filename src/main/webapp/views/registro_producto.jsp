<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="models.modelo_categoria" %>
<%@ page import="java.util.*" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="jakarta.servlet.http.HttpServletRequest" %>
<%@ page import="jakarta.servlet.RequestDispatcher" %>

<% 

    HttpSession sesion = request.getSession();

    modelo_categoria modelo_categorias = new modelo_categoria();

    List<modelo_categoria> categorias =  modelo_categorias.categorias();

    if (sesion.getAttribute("usuario") != null) {   

%>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>REGISTRO DE PRODUCTOS </title>

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

    <form action="/sapphire_inventory/registro_producto_servlet" method="POST" enctype="multipart/form-data">

        <label for="marca">Marca:</label>

        <input type="text" id="marca" name="marca" required>

        <br><br>

        <label for="estado">Estado:</label>
        <select id="estado" name="estado" required>

            <option value="activo">Activo</option>
            <option value="inactivo">Inactivo</option>

        </select>

        <br><br>

        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required>

        <br><br>

        <label for="descripcion">Descripción:</label>
        <textarea id="descripcion" name="descripcion" rows="4" required></textarea>

        <br><br>

        <label for="cantidad">Cantidad:</label>
        <input type="number" id="cantidad" name="cantidad" required>

        <br><br>

        <label for="medida">Medida:</label>
        <select id="medida" name="medida" required>

            <option value="unidad">unidad</option>
            <option value="libra">libra</option>
            <option value="kilo">kg</option>
            <option value="arroba">arroba</option>
            <option value="bulto">bulto</option>

        </select>

        <br><br>

        <label for="categoria">Categoría:</label>

        <select id="categoria" name="categoria" required>

        <% for (modelo_categoria categoria : categorias) { %>

            <option value="<%= categoria.getId_categoria() %>"><%= categoria.getNombre() %></option>

            <% } %>

        </select>

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