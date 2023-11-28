<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="models.modelo_categoria" %>
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

    if (sesion.getAttribute("usuario") != null) {   

%>

<!DOCTYPE html>
<html lang="esp">

<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>SAPPHIRE INVENTORY</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

</head>

<body>

    <nav class="navbar bg-dark bg-body-tertiary" data-bs-theme="dark">
        <div class="container-fluid">
            <span class="navbar-brand"><% out.print("bienvenido usuario: " + sesion.getAttribute("usuario")); %></span>
        </div>
    </nav>

    <div class="d-flex flex-column flex-shrink-0 p-3 text-white bg-dark" style=" height: 80%; width: 20%; padding-bottom: 20%; ">
        <span class="fs-4 d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none"><% out.print(sesion.getAttribute("usuario")); %></span>
        <hr>
        <ul class="nav nav-pills flex-column mb-auto p-3">
            <li class="nav-item">
                <a class="btn btn-outline-primary" href="views/registro_usuario.jsp">Home</a>
            </li>
            <br>
            <li>
                <a class="btn btn-outline-primary" href="views/registro_usuario.jsp">Registrar usuario</a>
            </li>
            <br>
            <li>
                <form action="/sapphire_inventory/mostrar_usuarios_servlet" method="GET">
                    <input class="btn btn-outline-primary" value="usuarios" name ="usuarios" type = "submit">
                </form>
            </li>
            <br>
            <li>
                <a class="btn btn-outline-primary" href="views/registro_categoria.jsp">Registrar categoria</a>
            </li>
            <br>
            <li>
                <a class="btn btn-outline-primary" href="views/venta.jsp">Registrar venta</a>
            </li>
            <br>
            <li>
                <a class="btn btn-outline-primary" href="views/entrada.jsp">Registrar entada</a>
            </li>
            <br>
            <li>
                <a class="btn btn-outline-primary" href="views/registro_producto.jsp">Registrar producto</a>
            </li>
            <br>
            <li>
                <form action="/sapphire_inventory/mostrar_categorias_servlet" method="post">
                    <input class="btn btn-outline-primary" value="productos" name ="productos" type = "submit">
                </form>
            </li>
        </ul>
        <hr>
        <div class="dropdown">
            <a href="#" class="d-flex align-items-center text-white text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
                <strong><% out.print(sesion.getAttribute("usuario")); %></strong>
            </a>
            <ul class="dropdown-menu dropdown-menu-dark text-small shadow" aria-labelledby="dropdownUser1">
                <li><a class="dropdown-item" href="#">New project...</a></li>
                <li>
                    <form action="/sapphire_inventory/cerrar_sesion_servlet" method="post">
                        <input class="dropdown-item" value="cerrar sesion" name ="cerrar_sesion" type = "submit">
                    </form>
                </li>
            </ul>
        </div>
    </div>
    

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