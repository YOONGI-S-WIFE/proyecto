package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.modelo_item;
import models.modelo_detalle_salida;
import models.modelo_salida;
import models.modelo_usuario;

@WebServlet("/venta_servlet")
public class venta_servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Obtener la sesión del usuario
        HttpSession sesion = request.getSession();

        // Obtener la lista de productos de la sesión
        ArrayList<modelo_item> listaProductos = (ArrayList<modelo_item>) sesion.getAttribute("listaProductos");

        // Obtener el usuario de la sesión
        modelo_usuario usuario = (modelo_usuario) sesion.getAttribute("usuario");

        // Crear un nuevo modelo de salida
        modelo_salida modeloSalida = new modelo_salida();

        // Crear una lista para los detalles de la venta
        ArrayList<modelo_detalle_salida> detallesVenta = new ArrayList<>();

        // Llenar la lista de detalles de la venta con la información de la lista de productos
        for (modelo_item item : listaProductos) {

            modelo_detalle_salida detalle = new modelo_detalle_salida(/* Proporciona los parámetros necesarios */);
            detalle.setId_producto(item.getId_producto());
            detalle.setPrecio_item_vendido(item.getPrecio_venta());
            detalle.setCantidad_item_vendido(item.getCantidad_item());

            detallesVenta.add(detalle);
        }

        // Realizar la venta con los detalles
        int idSalida = modeloSalida.realizarVenta(detallesVenta, usuario.getId_usuario());

        // Limpiar la lista de productos de la sesión
        sesion.removeAttribute("listaProductos");

        // Redirigir a la página de confirmación o a donde sea necesario
        response.sendRedirect("/views/venta.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Aquí puedes manejar las operaciones GET si es necesario
    }
}