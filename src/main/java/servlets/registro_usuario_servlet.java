package servlets;

import java.io.IOException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;

import controllers.controlador_usuario;

// http://localhost:8080/sapphire_inventory/registro_usuario_servlet

@WebServlet("/registro_usuario_servlet")
public class registro_usuario_servlet extends HttpServlet {
    
    controlador_usuario enviar_datos = new controlador_usuario();

    private String resultado = "";

    public String getResultado() {

        return resultado;
        
    }

    public void setResultado(String resultado) {

        this.resultado = resultado;

    }

    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    }

    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String nombres_usuario = request.getParameter("nombres_usuario");
        String apellidos_usuario = request.getParameter("apellidos_usuario");
        String tipo_documento_usuario = request.getParameter("tipo_documento_usuario");
        String numero_documento_usuario = request.getParameter("numero_documento_usuario");
        String telefono_usuario = request.getParameter("numero_telefono_usuario");
        String rol = request.getParameter("rol_usuario");
        String usuario = request.getParameter("usuario");
        String contrasenna = request.getParameter("contrasenna_usuario");

        enviar_datos.setApellidos_usuario(apellidos_usuario);
        enviar_datos.setContraseña(contrasenna);
        enviar_datos.setNombres_usuario(nombres_usuario);
        enviar_datos.setNumero_documento_usuario(numero_documento_usuario);
        enviar_datos.setTipo_documento(tipo_documento_usuario);
        enviar_datos.setRol_usuario(rol);
        enviar_datos.setUsuario(usuario);
        enviar_datos.setTelefono_usuario(telefono_usuario);

        enviar_datos.enviar_modelo();
            
        RequestDispatcher redireccion = request.getRequestDispatcher("views/registro_usuario.jsp");
        redireccion.forward(request, response);

    }

}
