<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="servlets.registro_proveedor_servlet" %>
<%@ page import="java.util.*" %>
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
    
    modelo_categoria modelo_categorias = new modelo_categoria();

    List<modelo_categoria> categorias =  modelo_categorias.categorias();

    if (sesion.getAttribute("usuario") != null) {   

%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>registro proveedores</title>
</head>
<body>

<h2>Registro de Producto</h2>

    <form action="/sapphire_inventory/registro_proveedor_servlet" method="POST" enctype="multipart/form-data">

        <label for="nombre">Nombre</label>
        <input type="text" id="nombre" name="nombre" required>

        <br><br>

        <label for="telefono">telefono</label>
        <input type="text" id="telefono" name="telefono" required>

        <br><br>

        <label for="telefono">correo</label>
        <input type="text" id="correo" name="correo" required>

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