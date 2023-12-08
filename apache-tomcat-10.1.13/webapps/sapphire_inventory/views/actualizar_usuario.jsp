<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="jakarta.servlet.http.HttpServletRequest" %>
<%@ page import="jakarta.servlet.RequestDispatcher" %>
<%@ page import="models.modelo_usuario" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Objects" %>

<% 

    HttpSession sesion = request.getSession();

    String campoActualizar = Objects.toString(request.getParameter("campoActualizar")); 

    String id_string = Objects.toString(request.getParameter("id")).trim();

    Integer id_integer = Integer.parseInt(id_string);

    modelo_usuario modelo = new modelo_usuario();

    List<modelo_usuario> usuario_especifico = modelo.mostrar_usuario(id_integer);

    if (sesion.getAttribute("usuario") != null) {   

%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Actualizar Datos de Usuario</title>
</head>
<body>
    <h1>Actualizar Datos de Usuario</h1>

    <form action="/sapphire_inventory/actualizar_usuario_servlet" method="post">

    <% for (modelo_usuario usuario : usuario_especifico) { %>

        <input type="hidden" name="tipo_campo_actualizar" value="<%= campoActualizar %>">

        <input type="hidden" name="id_usuario" value="<%= usuario.getId_usuario() %>">
            
        <label for="nombres">Nombres:</label>
        <input type="text" id="nombres" name="nombres" value="<%= usuario.getNombres_usuario() %>" <%= (campoActualizar.equals("nombres")) ? "" : "readonly" %> ><br>

        <label for="apellidos">Apellidos:</label>
        <input type="text" id="apellidos" name="apellidos" value="<%= usuario.getApellidos_usuario() %>" <%= (campoActualizar.equals("apellidos")) ? "" : "readonly" %>><br>

        <label for="tipoDocumento">Tipo de Documento:</label>
        <input type="text" id="tipoDocumento" name="tipoDocumento" value="<%= usuario.getTipo_documento() %>" <%= (campoActualizar.equals("tipoDocumento")) ? "" : "readonly" %>><br>

        <label for="numeroDocumento">Número de Documento:</label>
        <input type="text" id="numeroDocumento" name="numeroDocumento" value="<%= usuario.getNumero_documento_usuario() %>" <%= (campoActualizar.equals("numeroDocumento")) ? "" : "readonly" %>><br>

        <label for="telefono">Teléfono:</label>
        <input type="text" id="telefono" name="telefono" value="<%= usuario.getTelefono_usuario() %>" <%= (campoActualizar.equals("telefono")) ? "" : "readonly" %>><br>

        <label for="rol">Rol:</label>
        <input type="text" id="rol" name="rol" value="<%= usuario.getRol_usuario() %>" <%= (campoActualizar.equals("rol")) ? "" : "readonly" %>><br>

        <label for="usuario">Usuario:</label>
        <input type="text" id="usuario" name="usuario" value="<%= usuario.getUsuario() %>" <%= (campoActualizar.equals("usuario")) ? "" : "readonly" %>><br>

        <label for="contraseña">Contraseña:</label>
        <input type="password" id="contraseña" name="contraseña" value="" <%= (campoActualizar.equals("contraseña")) ? "" : "readonly" %>><br>

        <label for="contraseña">confirmar Contraseña:</label>
        <input type="password" id="contraseña" name="confirmar_contraseña" value="" <%= (campoActualizar.equals("contraseña")) ? "" : "readonly" %>><br>

        <label for="contraseña">Contraseña del administrador:</label>
        <input type="password" id="contraseña" name="administrador_contraseña" value="" required><br>

        <button type="submit">Guardar Cambios</button>

        <% } %>

    </form>
</body>
</html>

<% 

} else {

    RequestDispatcher redireccion = request.getRequestDispatcher("error_sesion.jsp");
    redireccion.forward(request, response);

    }
    
    %>