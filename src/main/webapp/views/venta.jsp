<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="models.modelo_producto" %>
<%@ page import="models.modelo_item" %>
<%@ page import="java.util.*" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="jakarta.servlet.http.HttpServletRequest" %>
<%@ page import="jakarta.servlet.RequestDispatcher" %>

<% 

    HttpSession sesion = request.getSession();

    modelo_producto modelo = new modelo_producto();

    List<modelo_producto> producto_id =  modelo.producto_id();

    modelo_item modelo = new modelo_item();

    List<modelo_item> item_id =  modelo.item_id();

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

    <form action="/sapphire_inventory/venta_servlet" method="POST">

        <label for="id">id producto</label>
        <input type="number" id="id_producto" name="nombre" required>

        <br><br>

        <% for (modelo_producto producto : producto_id) { %>

        <label for="precio_producto">nombre</label>
        <input type="text" id="nombre" value=" <=% producto.getNombre_producto() %> ">

        <br><br>
        
        <% } 
        
        for (modelo_item item : item_id) {
            
        %>

        <label for="precio_producto">precio producto</label>
        <input type="text" id="precio" value=" <=% item.getPrecio_venta() %> ">

        <br><br>

        <% } %>

        <label for="cantidad">cantidad</label>
        <input type="number" id="cantidad" name="imagen" required>

        <br><br>

        <button name ="registrar" type = "submit" class="btn">Registrar</button>

    </form>

    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <script>
        $(document).ready(function() {
            $("#id_producto").change(function() {
                var idProducto = $(this).val();
                $.ajax({
                    type: "GET",
                    url: "/sapphire_inventory/obtener_datos_producto?id=" + idProducto,
                    success: function(data) {
                        // Actualiza los campos con los datos del producto
                        $("#nombre").val(data.nombre);
                        $("#precio").val(data.precio);
                    },
                    error: function(error) {
                        console.log(error);
                    }
                });
            });
        });
    </script>
    
</body>
</html>

<% 

} else {

    RequestDispatcher redireccion = request.getRequestDispatcher("error_sesion.jsp");
    redireccion.forward(request, response);

    }
    
    %>