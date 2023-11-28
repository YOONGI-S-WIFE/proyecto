package servlets;

import java.io.IOException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;

// http://localhost:8080/sapphire_inventory/ventas_servlet

@WebServlet("/ventas_servlet")
public class ventas_servlet extends HttpServlet {

    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    }

    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
        response.setHeader("Window-target", "_top");
    
        RequestDispatcher redireccion = request.getRequestDispatcher("views/venta.jsp");
        redireccion.forward(request, response);

    }

}
