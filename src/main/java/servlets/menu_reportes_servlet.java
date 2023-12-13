package servlets;

import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.codec.Base64.OutputStream;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import models.modelo_reportes;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;
import models.modelo_reportes;

@WebServlet("/reporte")
public class menu_reportes_servlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // Crear una instancia del modelo de reportes
        modelo_reportes reportesModel = new modelo_reportes();

        // Configurar la respuesta HTTP para descargar el archivo PDF
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=ProductosMasVendidos.pdf");

        // Obtener el flujo de salida de la respuesta
        try (ServletOutputStream out = response.getOutputStream()) {

            // Llamar al método generarPDFProductosMasVendidos
            reportesModel.generarPDFProductosMasVendidos();

            // Llamar al método escribirPDF
            reportesModel.escribirPDF(out);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }

}
