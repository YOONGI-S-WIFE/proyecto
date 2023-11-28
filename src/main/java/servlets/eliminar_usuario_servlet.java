package servlets;

import java.io.IOException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;
import controllers.controlador_usuario;

@WebServlet("/eliminar_usuario_servlet")

public class eliminar_usuario_servlet extends HttpServlet{

    controlador_usuario controlador = new controlador_usuario();

    public String id_usuario = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("Expires", "0");
        resp.setHeader("Window-target", "_top");

        id_usuario = req.getParameter("usuario_id_eliminar");

        controlador.eliminar_usuario(id_usuario);

        RequestDispatcher redireccion = req.getRequestDispatcher("views/mostrar_usuarios.jsp");
        redireccion.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    
}
