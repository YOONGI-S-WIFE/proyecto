package servlets;

import java.io.IOException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;
import controllers.controlador_usuario;

// http://localhost:8080/sapphire_inventory/login_servlet

@WebServlet("/login_servlet")
public class login_servlet extends HttpServlet {
    
        String usuario_recibido = null;
        String contrasenna_recibida = null;
        boolean respuesta = false;
        String rol = null;

        controlador_usuario controlador = new controlador_usuario();

    public boolean isRespuesta() {

            return respuesta;

        }

        public void setRespuesta(boolean respuesta) {

            this.respuesta = respuesta;

        }

    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
        response.setHeader("Window-target", "_top");

        contrasenna_recibida = request.getParameter("contrasena");
        usuario_recibido = request.getParameter("usuario");
        rol = request.getParameter("rol");

        respuesta = controlador.login(usuario_recibido, contrasenna_recibida, rol);

        if (respuesta == true && "administrador".equals(rol)) {

            HttpSession sesion = request.getSession();
            sesion.setAttribute("usuario", usuario_recibido);
            
            RequestDispatcher redireccion = request.getRequestDispatcher("views/inicio_administrador.jsp");
            redireccion.forward(request, response);

        } else if (respuesta == true && "empleado".equals(rol)) {

            HttpSession sesion = request.getSession();
            sesion.setAttribute("usuario", usuario_recibido);
            
            RequestDispatcher redireccion = request.getRequestDispatcher("views/inicio_empleado.jsp");
            redireccion.forward(request, response);     

        } else {

            RequestDispatcher redireccion = request.getRequestDispatcher("/");
            redireccion.forward(request, response);

        }

    }

}
