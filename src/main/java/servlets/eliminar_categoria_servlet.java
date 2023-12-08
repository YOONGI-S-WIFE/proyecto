package servlets;

import java.io.IOException;

import controllers.controlador_categoria;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/eliminar_categoria_servlet")

public class eliminar_categoria_servlet extends HttpServlet{

    controlador_categoria controlador = new controlador_categoria();

    public String id_categoria = null;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            
        id_categoria = req.getParameter("categoria");

        controlador.eliminar_categoria(id_categoria);

        RequestDispatcher redireccion = req.getRequestDispatcher("views/categorias.jsp");
        redireccion.forward(req, resp);

    }

    
}
