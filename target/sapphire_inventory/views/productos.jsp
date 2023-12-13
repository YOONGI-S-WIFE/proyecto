<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="models.modelo_producto" %>
<%@ page import="java.util.*" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="jakarta.servlet.http.HttpServletRequest" %>
<%@ page import="jakarta.servlet.RequestDispatcher" %>
<%@ page import="servlets.mostrar_productos_servlet" %>

<% 

    modelo_producto products = new modelo_producto();

    String id_categoria_string = Objects.toString(request.getParameter("productos").trim());

    Integer id_categoria = Integer.parseInt(id_categoria_string);
    
    HttpSession sesion = request.getSession();

    ArrayList<modelo_producto> productos =  products.productos_categoria(id_categoria);

    if (sesion.getAttribute("usuario") != null) {   

%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>

    <button><a href="views/registro_usuario.jsp">Registrar usuario</a></button> 

    <button><a href="views/registro_producto.jsp">Registrar producto</a></button> 

    <button><a href="views/registro_categoria.jsp">Registrar categoria</a></button> 

    <button><a href="views/venta.jsp">Registrar venta</a></button> 

    <button><a href="views/entrada.jsp">Registrar entada</a></button> 

    <form action="/sapphire_inventory/mostrar_usuarios_servlet" method="GET">
    <input value="usuarios" name ="usuarios" type = "submit">
    </form>

    <form action="/sapphire_inventory/mostrar_categorias_servlet" method="post">
    <input value="productos" name ="productos" type = "submit">
    </form>

    <form action="/sapphire_inventory/cerrar_sesion_servlet" method="post">
        <input value="cerrar sesion" name ="cerrar_sesion" type = "submit">
        </form>

    <div>

        <% 

            for (modelo_producto producto : productos) {

        %>
                    <div style="border: 1px solid #ccc; padding: 10px; margin: 10px;">
                        <h3><%= producto.getNombre_producto() %></h3>
                        <img src="data:image/png;base64, <%= Base64.getEncoder().encodeToString(producto.getImagen()) %>" alt="Imagen de la categoría">
                        <p><%= producto.getDescripcion_producto() %></p>
                        <br>

                        <button onclick="window.location.href='./views/actualizar_categoria.jsp?id=<%= producto.getId_producto() %>'">Actualizar producto</button>
                    
                    </div>

        <% } %>
    </div>
    
</body>
</html>

<% 

} else {

    RequestDispatcher redireccion = request.getRequestDispatcher("error_sesion.jsp");
    redireccion.forward(request, response);

    }
    
    %>