<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="org.openqa.selenium.WebDriver" %>
<%@ page import="org.openqa.selenium.support.events.WebDriverEventListener" %>

<%
    WebDriver driver = (WebDriver) session.getAttribute("driver");

    driver.addEventListener(new WebDriverEventListener() {

        @Override
        public void onPageLoad(WebDriver driver) {

        driver.manage().deleteAllCookies();

        }
    });

%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>inicio de sesion</title>
    <link rel="stylesheet" type="text/css" href="./css/login.css">
    <link  rel="stylesheet" type="text/css"href="./css/styles.css">
</head>
<body>

    <div class="main">
        <div class="formContainer">
            <form action="/sapphire_inventory/login_servlet" method="POST">
                <div class="inputContainer">
                    <label for="usuario" class="fa-solid fa-envelope">Usuario:</label>
                    <input type="email" id="usuario" name="usuario" placeholder="" required>
                </div>

                <div class="inputContainer">
                    <label for="contrasena">Contraseña:</label>
                    <input type="password" id="contrasena" name="contrasena" required>
                </div>

                <div class="inputContainer">
                    <label for="contrasena">rol</label>
                    <select name="rol" id="rol">

                        <option value="empleado">empleado</option>
                        <option value="administrador">administrador</option>

                    </select>
                </div>
                <button type="submit" value="Iniciar Sesión">Iniciar Sesión</button>
                <a class="a" href="views/registro_usuario.jsp">registrarse</a>
            </form>
        </div>

        <div class="titleContainer">
            <h2>BIENVENID@ A </h2>
            <h1>SAPPHIRE INVENTORY</h1>
        </div>
    </div>
</body>
</html>
