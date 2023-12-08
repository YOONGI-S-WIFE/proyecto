package servlets;

import java.io.IOException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/cerrar_sesion_servlet")

public class cerrar_sesion_servlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession sesion = req.getSession();
        sesion.removeAttribute("usuario");

        RequestDispatcher redireccion = req.getRequestDispatcher("/");
        redireccion.forward(req, resp);

    }
    
}
