package servlets;

import java.io.IOException;
import java.io.InputStream;

import controllers.controlador_categoria;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/registro_categoria_servlet")
@MultipartConfig

public class registro_categoria_servlet extends HttpServlet {
    
    private byte[] readAllBytes(InputStream is) throws IOException {
            try (var os = new java.io.ByteArrayOutputStream()) {
                byte[] buffer = new byte[1024];
                int len;
                while ((len = is.read(buffer)) > 0) {
                    os.write(buffer, 0, len);
                }
                return os.toByteArray();
            }
        }
    
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    }

    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        controlador_categoria controlador = new controlador_categoria();

        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");

        Part imagen = request.getPart("imagen");
        InputStream contenido_imagen = imagen.getInputStream();
        byte[] imagen_bytes = readAllBytes(contenido_imagen);

        System.out.println(nombre);
        System.out.println(descripcion);
        System.out.println(imagen_bytes);

        controlador.registrar_categoria(nombre, descripcion, imagen_bytes);

        RequestDispatcher redireccion = request.getRequestDispatcher("views/registro_categoria.jsp");
        redireccion.forward(request, response);

    }

}


