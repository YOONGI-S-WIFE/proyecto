<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>

    <h1>❤️buenas querido empleado ❤️</h1>

    <nav class="navbar bg-dark bg-body-tertiary" data-bs-theme="dark">
        <div class="container-fluid">
            <span class="navbar-brand"><% out.print("bienvenido usuario: " + sesion.getAttribute("usuario")); %></span>
        </div>
    </nav>

    <div class="d-flex flex-column flex-shrink-0 p-3 text-white bg-dark" style=" height: 80%; width: 20%; padding-bottom: 20%; ">
        <span class="fs-4 d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none"><% out.print(sesion.getAttribute("usuario")); %></span>
        <hr>
        <ul class="nav nav-pills flex-column mb-auto p-3">
            <li>
                <a class="btn btn-outline-primary" href="views/venta.jsp">Registrar venta</a>
            </li>
            <br>
            
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
    
</body>
</html>