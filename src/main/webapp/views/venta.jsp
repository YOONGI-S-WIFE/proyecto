<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="models.modelo_producto" %>
<%@ page import="models.modelo_item" %>
<%@ page import="java.util.*" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="jakarta.servlet.http.HttpServletRequest" %>
<%@ page import="jakarta.servlet.RequestDispatcher" %>

<% 

    HttpSession sesion = request.getSession();

    if (sesion.getAttribute("usuario") != null) {   

%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>venta por que aja</title>
</head>
<body>

    <h1>VAMO A HACER UNA VENTA :3</h1>

    <form action="/sapphire_inventory/item_servlet" method="post">

        <label for="id">id producto</label>
        <input type="number" id="id_producto" name="id_producto" required>

        <label for="cantidad">cantidad</label>
        <input type="number" id="cantidad" name="cantidad" required>

        <button type="submit">agregar producto</button>
    
    </form>

    <table>

        <thead>

            <tr>

                <th>Id</th>
                <th>Nombre</th>
                <th>precio</th>
                <th>cantidad</th>

            </tr>

        </thead>

        <tbody>

            <tr>

            <% 

            List<modelo_item> listaProductos = (List<modelo_item>) sesion.getAttribute("listaProductos");

                if (listaProductos != null) {
                for (modelo_item item : listaProductos) {

            %>

                <td><%= item.getId_item() %></td>
                <td><%= item.getId_producto() %></td>
                <td><%= item.getPrecio() %></td>
                <td><%= item.getCantidad() %></td>

            </tr>

            <% 
            
            } 
            
            }
            
            %>

        </tbody>

    </table>
    
    <form action="/sapphire_inventory/venta_servlet" method="POST">

    <button type="submit">vender</button>
      
    </form>
    
</body>
</html>

<% 

} else {

    RequestDispatcher redireccion = request.getRequestDispatcher("error_sesion.jsp");
    redireccion.forward(request, response);

    }
    
    %>