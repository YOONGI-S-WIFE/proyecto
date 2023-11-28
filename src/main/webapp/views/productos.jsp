<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="models.modelo_producto" %>
<%@ page import="java.util.*" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="jakarta.servlet.http.HttpServletRequest" %>
<%@ page import="jakarta.servlet.RequestDispatcher" %>
<%@ page import="servlets.mostrar_productos_servlet" %>
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

    modelo_producto products = new modelo_producto();
    HttpSession sesion = request.getSession();

    ArrayList<modelo_producto> productos =  products.productos_categoria();

    if (sesion.getAttribute("usuario") != null) {   

%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>

    <button><a href="registro_usuario.jsp">Registrar usuario</a></button> 

    <button><a href="registro_producto.jsp">Registrar producto</a></button> 

    <button><a href="registro_categoria.jsp">Registrar categoria</a></button> 

    <button><a href="venta.jsp">Registrar venta</a></button> 

    <button><a href="entrada.jsp">Registrar entada</a></button> 

    <form action="/sapphire_inventory/mostrar_usuarios_servlet" method="GET">
    <input value="usuarios" name ="usuarios" type = "submit">
    </form>

    <form action="/sapphire_inventory/mostrar_categorias_servlet" method="post">
    <input value="productos" name ="productos" type = "submit">
    </form>

    <form action="/sapphire_inventory/cerrar_sesion_servlet" method="post">
        <input value="cerrar sesion" name ="cerrar_sesion" type = "submit">
        </form>

    <div>

        <% 

        if (productos != null) {

            for (modelo_producto producto : productos) {

        %>
                    <div style="border: 1px solid #ccc; padding: 10px; margin: 10px;">
                        <h3><%= producto.getNombre_producto() %></h3>
                        <img src="data:image/png;base64, <%= Base64.getEncoder().encodeToString(producto.getImagen()) %>" alt="Imagen de la categoría">
                        <p><%= producto.getDescripcion_producto() %></p>
                        <br>
                        <button onclick="window.location.href='./views/actualizar_categoria.jsp?id=<%= producto.getId_producto() %>'">Actualizar producto</button>
                    </div>

        <%
            }

            } else {

        %>

            <p> <% out.print("no hay categorias disponibles"); %></p>

        <%
            }
        %>

    </div>
    
</body>
</html>

<% 

} else {

    RequestDispatcher redireccion = request.getRequestDispatcher("error_sesion.jsp");
    redireccion.forward(request, response);

    }
    
    %>