<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="models.modelo_categoria" %>
<%@ page import="java.util.*" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="jakarta.servlet.http.HttpServletRequest" %>
<%@ page import="jakarta.servlet.RequestDispatcher" %>
<%@ page import="java.util.Objects" %>

<% 

    HttpSession sesion = request.getSession();

    String id_string = Objects.toString(request.getParameter("usuario_id_actualizar"));

    Integer id = null;

    if (id_string != null) {

        try {

           id = Integer.parseInt(id_string.trim());

        } catch (NumberFormatException e) {

            e.printStackTrace(); 

        }

    } else {

    }

    if (sesion.getAttribute("usuario") != null) {   

%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Detalles de Usuario</title>
</head>
<body>

    <h1>¿QUE DATO DEL USUARIO QUIERES ACTUALIZAR?</h1>

    <form action="actualizar_usuario.jsp" method="get">
        <input type="hidden" name="campoActualizar" value="nombres">
        <input type="hidden" name="id" value="<%= id %>">
        <button type="submit">Actualizar Nombres</button>
    </form>

    <form action="actualizar_usuario.jsp" method="get">
        <input type="hidden" name="campoActualizar" value="apellidos">
        <input type="hidden" name="id" value="<%= id %>">
        <button type="submit">Actualizar Apellidos</button>
    </form>

    <form action="actualizar_usuario.jsp" method="get">
        <input type="hidden" name="campoActualizar" value="tipoDocumento">
        <input type="hidden" name="id" value="<%= id %>">
        <button type="submit">Actualizar Tipo de Documento</button>
    </form>

    <form action="actualizar_usuario.jsp" method="get">
        <input type="hidden" name="campoActualizar" value="numeroDocumento">
        <input type="hidden" name="id" value="<%= id %>">
        <button type="submit">Actualizar Número de Documento</button>
    </form>

    <form action="actualizar_usuario.jsp" method="get">
        <input type="hidden" name="campoActualizar" value="telefono">
        <input type="hidden" name="id" value="<%= id %>">
        <button type="submit">Actualizar Teléfono</button>
    </form>

    <form action="actualizar_usuario.jsp" method="get">
        <input type="hidden" name="campoActualizar" value="rol">
        <input type="hidden" name="id" value="<%= id %>">
        <button type="submit">Actualizar Rol</button>
    </form>

    <form action="actualizar_usuario.jsp" method="get">
        <input type="hidden" name="campoActualizar" value="usuario">
        <input type="hidden" name="id" value="<%= id %>">
        <button type="submit">Actualizar Usuario</button>
    </form>

    <form action="actualizar_usuario.jsp" method="get">
        <input type="hidden" name="campoActualizar" value="contraseña">
        <input type="hidden" name="id" value="<%= id %>">
        <button type="submit">Actualizar Contraseña</button>
    </form>
</body>
</html>

<% 

} else {

    RequestDispatcher redireccion = request.getRequestDispatcher("error_sesion.jsp");
    redireccion.forward(request, response);

    }
    
    %>