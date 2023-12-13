package servlets;

import java.io.IOException;
import java.util.ArrayList;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.modelo_item;

@WebServlet("/item_servlet")
public class item_servlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Integer idProducto = Integer.parseInt(request.getParameter("id_producto"));
        Integer cantidad = Integer.parseInt(request.getParameter("cantidad"));

        // Crear un nuevo item
        modelo_item modelo = new modelo_item();
       
        modelo.item_id(idProducto, cantidad);
        
        // Obtener la sesión del usuario
        HttpSession sesion = request.getSession();
        
        // Obtener la lista de productos de la sesión o crearla si no existe
        ArrayList<modelo_item> listaProductos = (ArrayList<modelo_item>) sesion.getAttribute("listaProductos");

        if (listaProductos == null) {

            listaProductos = new ArrayList<>();

        }

        // Agregar el nuevo producto a la lista
        listaProductos.add(modelo);

        // Almacenar la lista actualizada en la sesión
        sesion.setAttribute("listaProductos", listaProductos);

        // Redirigir de vuelta al JSP para que se actualice la tabla con los productos
        response.sendRedirect(request.getContextPath() + "/views/venta.jsp");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        

    }
    
}
