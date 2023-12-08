package servlets;

import java.io.IOException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;

// http://localhost:8080/sapphire_inventory/mostrar_usuarios_servlet

@WebServlet("/mostrar_usuarios_servlet")
public class mostrar_usuarios_servlet extends HttpServlet {

    @Override
    public void doGet (HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        RequestDispatcher redireccion = request.getRequestDispatcher("views/mostrar_usuarios.jsp");
        redireccion.forward(request, response);

    }

    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    }

}