<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="models.modelo_categoria" %>
<%@ page import="java.util.*" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="jakarta.servlet.http.HttpServletRequest" %>
<%@ page import="jakarta.servlet.RequestDispatcher" %>

<% 

    HttpSession sesion = request.getSession();

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

    <form action="actualizar_usuario.jsp" method="post">
        <input type="hidden" name="nombres" value="nombres">
        <button type="submit">Actualizar Nombres</button>
    </form>

    <form action="actualizar_usuario.jsp" method="post">
        <input type="hidden" name="apellidos" value="apellidos">
        <button type="submit">Actualizar Apellidos</button>
    </form>

    <form action="actualizar_usuario.jsp" method="post">
        <input type="hidden" name="tipoDocumento" value="tipoDocumento">
        <button type="submit">Actualizar Tipo de Documento</button>
    </form>

    <form action="actualizar_usuario.jsp" method="post">
        <input type="hidden" name="numeroDocumento" value="numeroDocumento">
        <button type="submit">Actualizar Número de Documento</button>
    </form>

    <form action="actualizar_usuario.jsp" method="post">
        <input type="hidden" name="telefono" value="telefono">
        <button type="submit">Actualizar Teléfono</button>
    </form>

    <form action="actualizar_usuario.jsp" method="post">
        <input type="hidden" name="rol" value="rol">
        <button type="submit">Actualizar Rol</button>
    </form>

    <form action="actualizar_usuario.jsp" method="post">
        <input type="hidden" name="usuario" value="usuario">
        <button type="submit">Actualizar Usuario</button>
    </form>

    <form action="actualizar_usuario.jsp" method="post">
        <input type="hidden" name="contraseña" value="contraseña">
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