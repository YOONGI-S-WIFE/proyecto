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
<html lang="esp">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PRODUCTOS</title>

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
    <input value="productos" name ="servlet" type = "submit">
    </form>

    <form action="/sapphire_inventory/cerrar_sesion_servlet" method="post">
    <input value="cerrar sesion" name ="cerrar_sesion" type = "submit">
    </form>

<div>
        <% 

            if (categorias != null) {

                for (modelo_categoria categoria : categorias) {
                    
        %>
                    <div style="border: 1px solid #ccc; padding: 10px; margin: 10px;">
                        <h3><%= categoria.getNombre() %></h3>
                        <img src="data:image/png;base64, <%= Base64.getEncoder().encodeToString(categoria.getImagen()) %>" alt="Imagen de la categoría">
                        <p><%= categoria.getDescripcion() %></p>
                        <br>

                        <form action="/sapphire_inventory/mostrar_productos_servlet" method="post">
                        <input type="hidden" name="productos" value="<%=categoria.getId_categoria() %>">
                        <button type="submit">productos</button>
                        </form>

                        <button onclick="window.location.href='./views/actualizar_categoria.jsp?id=<%=categoria.getId_categoria() %>'">Actualizar Categoría</button>

                        <form action="/sapphire_inventory/eliminar_categoria_servlet" method="GET">
                        <input type="hidden" name="categoria" value=" <%=categoria.getId_categoria() %> ">
                        <button type="submit">eliminar</button>

                        </form>
                        
                    </div>
        <%
                }

            } else {
                
        %>
                <p> <% out.print("no hay categorias disponibles"); %></p>
        <%
            }
        %>
    </div>

</body>

</html>

<% 

} else {

    RequestDispatcher redireccion = request.getRequestDispatcher("error_sesion.jsp");
    redireccion.forward(request, response);

    }
    
    %>