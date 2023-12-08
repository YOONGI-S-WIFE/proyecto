package servlets;

import java.io.IOException;
import java.io.InputStream;
import controllers.controlador_producto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/registro_producto_servlet")
@MultipartConfig

public class registro_producto_servlet extends HttpServlet {
    
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
        
        controlador_producto controlador = new controlador_producto();

        String marca = request.getParameter("marca");
        String estado = request.getParameter("estado");
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        String cantidad = request.getParameter("cantidad");
        String medida = (request.getParameter("medida"));
        String categoria = request.getParameter("categoria");

        Part imagen = request.getPart("imagen");
        InputStream contenido_imagen = imagen.getInputStream();
        byte[] imagen_bytes = readAllBytes(contenido_imagen);

        System.out.println(marca);
        System.out.println(estado);
        System.out.println(nombre);
        System.out.println(descripcion);
        System.out.println(cantidad);
        System.out.println(medida);
        System.out.println(categoria);
        System.out.println(imagen_bytes);

        controlador.registrar_producto(marca, estado, nombre, descripcion, cantidad, medida, categoria, imagen_bytes);

        RequestDispatcher redireccion = request.getRequestDispatcher("views/registro_producto.jsp");
        redireccion.forward(request, response);

    }

}


