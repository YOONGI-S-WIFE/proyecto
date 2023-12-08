package servlets;

import java.io.IOException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/registro_proveedor_servlet")
public class registro_proveedor_servlet extends HttpServlet{

    String nombre = null;
    String correo = null;
    String telefono = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        nombre = req.getParameter("nombre");
        correo = req.getParameter("correo");
        telefono = req.getParameter("telefono");

        

        RequestDispatcher redireccion = req.getRequestDispatcher("views/proveedores.jsp");
        redireccion.forward(req, resp);

    }
    
}
