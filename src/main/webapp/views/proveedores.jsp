<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="models.modelo_proveedor" %>
<%@ page import="java.util.*" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="jakarta.servlet.http.HttpServletRequest" %>
<%@ page import="jakarta.servlet.RequestDispatcher" %>

<% 

    HttpSession sesion = request.getSession();

    modelo_proveedor modelo = new modelo_proveedor();

    List<modelo_proveedor> proveedores = modelo.proveedores();

    if (sesion.getAttribute("usuario") != null) {   

%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>proveedores</title>
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

    <h1>USUARIOS</h1>

    <br>

    <table border="1">

        <thead>

            <tr>

                <th>Id</th>
                <th>Nombre</th>
                <th>correo</th>
                <th>telefono</th>

            </tr>

        </thead>

        <tbody>

            <% for (modelo_proveedor proveedor : proveedores) { %>

<tr>

    <td><%= proveedor.getId_proveedor() %></td>
    <td><%= proveedor.getCorreoo() %></td>
    <td><%= proveedor.getTelefono() %></td>
    <td><%= proveedor.getNombre() %></td>

    <td>
        <form action="views/menu_actualizacion_proveedor.jsp" method="GET">
            <input type="hidden" name="id_actualizar" value="<%=proveedor.getId_proveedor()%>">
            <input type="submit" value="Actualizar">
        </form>
        <form action="/sapphire_inventory/eliminar_proveedor_servlet" method="GET">
            <input type="hidden" name="id_inactivar" value="<%=proveedor.getId_proveedor()%>">
            <input type="submit" value="inactivar">
        </form>
    </td>
</tr>

<% } %>

        </tbody>
    </table>
    
</body>
</html>

<% 

} else {

    RequestDispatcher redireccion = request.getRequestDispatcher("error_sesion.jsp");
    redireccion.forward(request, response);

    }
    
    %>