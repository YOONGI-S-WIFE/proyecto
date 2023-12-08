package servlets;

import java.io.IOException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;
import controllers.controlador_usuario;
import java.util.Objects;


@WebServlet("/actualizar_usuario_servlet")

public class actualizar_usuario_servlet extends HttpServlet{

    Integer id_usuario = null;

    String contraseña_administrador = null;

    controlador_usuario controlador = new controlador_usuario();

    Boolean resultado = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String campo_actualizar = req.getParameter("tipo_campo_actualizar"); 

        String usuario_sesion =  Objects.toString(req.getParameter("usuario"));

        switch (campo_actualizar) {

            case "nombres":

            String nombres = req.getParameter("nombres");
            String contraseña_administrador = req.getParameter("administrador_contraseña");
            id_usuario = Integer.parseInt(req.getParameter("id_usuario"));

            resultado = controlador.validar_contraseña(usuario_sesion, contraseña_administrador);

            if (resultado != false) {

                controlador.actualizar_nombres_usuario(nombres, contraseña_administrador, id_usuario, usuario_sesion);

                RequestDispatcher redireccion = req.getRequestDispatcher("views/mostrar_usuarios.jsp");
                redireccion.forward(req, resp);
                
            } else {

                RequestDispatcher redireccion = req.getRequestDispatcher("views/inicio_administrador.jsp");
                redireccion.forward(req, resp);

            }
                
            break;

            case "apellidos":

            String apellidos = req.getParameter("apellidos");
            contraseña_administrador = req.getParameter("administrador_contraseña");
            id_usuario = Integer.parseInt(req.getParameter("id_usuario"));
            
            resultado = controlador.validar_contraseña(usuario_sesion, contraseña_administrador);

            if (resultado != false) {

                controlador.actualizar_apellidos_usuario(apellidos, contraseña_administrador, id_usuario, usuario_sesion);

                RequestDispatcher redireccion = req.getRequestDispatcher("views/mostrar_usuarios.jsp");
                redireccion.forward(req, resp);
                
            } else {

                RequestDispatcher redireccion = req.getRequestDispatcher("views/inicio_administrador.jsp");
                redireccion.forward(req, resp);

            }

            break;

            case "tipoDocumento":

            Integer tipo_documento = Integer.parseInt(req.getParameter("tipoDocumento"));
            id_usuario = Integer.parseInt(req.getParameter("id_usuario"));
            contraseña_administrador = req.getParameter("administrador_contraseña");

            resultado = controlador.validar_contraseña(usuario_sesion, contraseña_administrador);

            if (resultado != false) {

                controlador.actualizar_tipo_documento_usuario(tipo_documento, contraseña_administrador, id_usuario, usuario_sesion);

                RequestDispatcher redireccion = req.getRequestDispatcher("views/mostrar_usuarios.jsp");
                redireccion.forward(req, resp);
                
            } else {

                RequestDispatcher redireccion = req.getRequestDispatcher("views/inicio_administrador.jsp");
                redireccion.forward(req, resp);

            }
                
            break;

            case "numeroDocumento":

            String numero_documento = req.getParameter("numeroDocumento");
            contraseña_administrador = req.getParameter("administrador_contraseña");
            id_usuario = Integer.parseInt(req.getParameter("id_usuario"));

            resultado = controlador.validar_contraseña(usuario_sesion, contraseña_administrador);

            if (resultado != false) {

                controlador.actualizar_documento_usuario(numero_documento, contraseña_administrador, id_usuario, usuario_sesion);

                RequestDispatcher redireccion = req.getRequestDispatcher("views/mostrar_usuarios.jsp");
                redireccion.forward(req, resp);
                
            } else {

                RequestDispatcher redireccion = req.getRequestDispatcher("views/inicio_administrador.jsp");
                redireccion.forward(req, resp);

            }
                
            break;

            case "telefono":

            String telefono = req.getParameter("telefono");
            contraseña_administrador = req.getParameter("administrador_contraseña");
            id_usuario = Integer.parseInt(req.getParameter("id_usuario"));

            resultado = controlador.validar_contraseña(usuario_sesion, contraseña_administrador);

            if (resultado != false) {

                controlador.actualizar_telefono_usuario(telefono, contraseña_administrador, id_usuario, usuario_sesion);

                RequestDispatcher redireccion = req.getRequestDispatcher("views/mostrar_usuarios.jsp");
                redireccion.forward(req, resp);
                
            } else {

                RequestDispatcher redireccion = req.getRequestDispatcher("views/inicio_administrador.jsp");
                redireccion.forward(req, resp);

            }
                
            break;

            case "rol":

            Integer rol = Integer.parseInt(req.getParameter("rol"));
            contraseña_administrador = req.getParameter("administrador_contraseña");
            id_usuario = Integer.parseInt(req.getParameter("id_usuario"));

            resultado = controlador.validar_contraseña(usuario_sesion, contraseña_administrador);

            if (resultado != false) {

                controlador.actualizar_rol_usuario(rol, contraseña_administrador, id_usuario, usuario_sesion);

                RequestDispatcher redireccion = req.getRequestDispatcher("views/mostrar_usuarios.jsp");
                redireccion.forward(req, resp);
                
            } else {

                RequestDispatcher redireccion = req.getRequestDispatcher("views/inicio_administrador.jsp");
                redireccion.forward(req, resp);

            }
                
            break;

            case "usuario":
                
            String usuario = req.getParameter("usuario");
            contraseña_administrador = req.getParameter("administrador_contraseña");
            id_usuario = Integer.parseInt(req.getParameter("id_usuario"));

            resultado = controlador.validar_contraseña(usuario_sesion, contraseña_administrador);

            if (resultado != false) {

                controlador.actualizar_usuario_usuario(usuario, contraseña_administrador, id_usuario, usuario_sesion);

                RequestDispatcher redireccion = req.getRequestDispatcher("views/mostrar_usuarios.jsp");
                redireccion.forward(req, resp);
                
            } else {

                RequestDispatcher redireccion = req.getRequestDispatcher("views/inicio_administrador.jsp");
                redireccion.forward(req, resp);

            }
            
            break;

            case "contraseña":

            String contraseña = req.getParameter("contraseña");
            String confirmacion_contraseña = req.getParameter("confirmar_contraseña");
            contraseña_administrador = req.getParameter("administrador_contraseña");
            id_usuario = Integer.parseInt(req.getParameter("id_usuario"));

            resultado = controlador.validar_contraseña(usuario_sesion, contraseña_administrador);

            if (resultado != false) {

                controlador.actualizar_contraseña_usuario(contraseña, confirmacion_contraseña, contraseña_administrador, id_usuario, usuario_sesion);

                RequestDispatcher redireccion = req.getRequestDispatcher("views/mostrar_usuarios.jsp");
                redireccion.forward(req, resp);
                
            } else {

                RequestDispatcher redireccion = req.getRequestDispatcher("views/inicio_administrador.jsp");
                redireccion.forward(req, resp);

            }
                
            break;

        }
        
    }
    
}
