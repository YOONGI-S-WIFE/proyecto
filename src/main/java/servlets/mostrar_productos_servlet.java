package servlets;

import java.io.IOException;

import controllers.controlador_producto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;

// http://localhost:8080/sapphire_inventory/mostrar_productos_servlet

@WebServlet("/mostrar_productos_servlet")
public class mostrar_productos_servlet extends HttpServlet {

    controlador_producto controlador = new controlador_producto();

    Integer id_categoria = null;
    
    public void setId_categoria(Integer id_categoria) {

        this.id_categoria = id_categoria;

    }

    public Integer getId_categoria() {

        return id_categoria;
        
    }

    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    }

    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        RequestDispatcher redireccion = request.getRequestDispatcher("views/productos.jsp");
        redireccion.forward(request, response);

    }

}
