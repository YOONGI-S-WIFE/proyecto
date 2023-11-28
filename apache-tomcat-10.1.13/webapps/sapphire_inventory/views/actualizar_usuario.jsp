.<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="jakarta.servlet.http.HttpServletRequest" %>
<%@ page import="jakarta.servlet.RequestDispatcher" %>
<%@ page import="org.openqa.selenium.WebDriver" %>
<%@ page import="org.openqa.selenium.support.events.WebDriverEventListener" %>

<%
    WebDriver driver = (WebDriver) session.getAttribute("driver");

    driver.onPageLoad(new Runnable() {

        @Override
        public void run() {

            driver.clearHistory();

        }
        
    });

    driver.onPageLoad(new Runnable() {

        @Override
        public void run() {

            driver.deleteAllCookies();

        }

    });

%>

<% 

    HttpSession sesion = request.getSession();

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

    <form action="actualizar_usuario_servlet" method="post">
    
        <input type="hidden" name="campo_actualizar" value="<%= campoActualizar %>">
        
        <label for="nombres">Nombres:</label>
        <input type="text" id="nombres" name="nombres" value="<%= usuario.getNombres() %>" <%= (campoActualizar.equals("nombres")) ? "" : "readonly" %>><br>

        <label for="apellidos">Apellidos:</label>
        <input type="text" id="apellidos" name="apellidos" value="<%= usuario.getApellidos() %>" <%= (campoActualizar.equals("apellidos")) ? "" : "readonly" %>><br>

        <label for="tipoDocumento">Tipo de Documento:</label>
        <input type="text" id="tipoDocumento" name="tipoDocumento" value="<%= usuario.getTipoDocumento() %>" <%= (campoActualizar.equals("tipoDocumento")) ? "" : "readonly" %>><br>

        <label for="numeroDocumento">Número de Documento:</label>
        <input type="text" id="numeroDocumento" name="numeroDocumento" value="<%= usuario.getNumeroDocumento() %>" <%= (campoActualizar.equals("numeroDocumento")) ? "" : "readonly" %>><br>

        <label for="telefono">Teléfono:</label>
        <input type="text" id="telefono" name="telefono" value="<%= usuario.getTelefono() %>" <%= (campoActualizar.equals("telefono")) ? "" : "readonly" %>><br>

        <label for="rol">Rol:</label>
        <input type="text" id="rol" name="rol" value="<%= usuario.getRol() %>" <%= (campoActualizar.equals("rol")) ? "" : "readonly" %>><br>

        <label for="usuario">Usuario:</label>
        <input type="text" id="usuario" name="usuario" value="<%= usuario.getUsuario() %>" <%= (campoActualizar.equals("usuario")) ? "" : "readonly" %>><br>

        <label for="contraseña">Contraseña:</label>
        <input type="password" id="contraseña" name="contraseña" value="<%= usuario.getContraseña() %>" <%= (campoActualizar.equals("contraseña")) ? "" : "readonly" %>><br>

        <button type="submit">Guardar Cambios</button>
    </form>
</body>
</html>

<% 

} else {

    RequestDispatcher redireccion = request.getRequestDispatcher("error_sesion.jsp");
    redireccion.forward(request, response);

    }
    
    %>