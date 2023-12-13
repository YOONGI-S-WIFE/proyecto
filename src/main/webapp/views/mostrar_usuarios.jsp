<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="models.modelo_usuario" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="jakarta.servlet.http.HttpServletRequest" %>
<%@ page import="jakarta.servlet.RequestDispatcher" %>

<% 

    HttpSession sesion = request.getSession();

    modelo_usuario modelo = new modelo_usuario();

    List<modelo_usuario> users = modelo.mostrar_usuarios();

    if (sesion.getAttribute("usuario") != null) {   

%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>USUARIOS</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
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
                <th>Nombres</th>
                <th>Apellidos</th>
                <th>Tipo de Documento</th>
                <th>Número de Documento</th>
                <th>Teléfono</th>
                <th>Rol</th>
                <th>Usuario</th>
                <th>Contraseña</th>
                <th>Acciones</th>

            </tr>

        </thead>

        <tbody>

            <% for (modelo_usuario user : users) { %>

<tr>

    <td><%= user.getId_usuario() %></td>
    <td><%= user.getNombres_usuario() %></td>
    <td><%= user.getApellidos_usuario() %></td>
    <td><%= user.getTipo_documento() %></td>
    <td><%= user.getNumero_documento_usuario() %></td>
    <td><%= user.getTelefono_usuario() %></td>
    <td><%= user.getRol_usuario() %></td>
    <td><%= user.getUsuario() %></td>
    <td><%= user.getContraseña() %></td>

    <td>
        <form action="views/menu_actualizacion_usuario.jsp" method="GET">
            <input type="hidden" name="usuario_id_actualizar" value="<%=user.getId_usuario()%>">
            <input type="submit" value="Actualizar">
        </form>
        <form action="/sapphire_inventory/eliminar_usuario_servlet" method="GET">
            <input type="hidden" name="usuario_id_eliminar" value="<%=user.getId_usuario()%>">
            <input type="submit" value="Borrar">
        </form>
    </td>
</tr>

<% } %>

        </tbody>
    </table>

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>

</body>
</html>

<% 

} else {

    RequestDispatcher redireccion = request.getRequestDispatcher("error_sesion.jsp");
    redireccion.forward(request, response);

    }
    
    %>