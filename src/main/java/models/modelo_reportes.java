package models;

import java.io.FileOutputStream;
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.*;
import connection.Conectar;
import jakarta.servlet.ServletOutputStream;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

public class modelo_reportes {

    private int idProducto;
    private String nombreProducto;
    private int totalVendido;

    public modelo_reportes(int idProducto, String nombreProducto, int totalVendido) {

        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.totalVendido = totalVendido;

    }

    public modelo_reportes() {

    }

    public int getIdProducto() {

        return idProducto;

    }

    public String getNombreProducto() {

        return nombreProducto;

    }

    public int getTotalVendido() {

        return totalVendido;

    }

    public ArrayList<modelo_reportes> productos_mas_vendidos_mes() {

        ArrayList<modelo_reportes> reporte = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            
            connection = Conectar.Connect();

            // Obtener el primer y último día del mes actual
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
            Date firstDayOfMonth = cal.getTime();
            cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
            Date lastDayOfMonth = cal.getTime();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            String sql = "SELECT p.id_producto, p.nombre_producto, SUM(ds.cantidad_item_vendido) as total_vendido " +
                         "FROM producto p " +
                         "JOIN detalle_salida ds ON p.id_producto = ds.id_producto " +
                         "JOIN salida s ON ds.id_salida = s.id_salida " +
                         "WHERE s.fecha_hora_salidaa BETWEEN ? AND ? " +
                         "GROUP BY p.id_producto " +
                         "ORDER BY total_vendido DESC " +
                         "LIMIT 20";

            ps = connection.prepareStatement(sql);
            ps.setString(1, sdf.format(firstDayOfMonth));
            ps.setString(2, sdf.format(lastDayOfMonth));

            rs = ps.executeQuery();

            while (rs.next()) {

                int idProducto = rs.getInt("id_producto");
                String nombreProducto = rs.getString("nombre_producto");
                int totalVendido = rs.getInt("total_vendido");

                System.out.println("ID Producto: " + idProducto);
                System.out.println("Nombre Producto: " + nombreProducto);
                System.out.println("Total Vendido: " + totalVendido);

                modelo_reportes reporteProducto = new modelo_reportes(idProducto, nombreProducto, totalVendido);
                reporte.add(reporteProducto);

            }

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            try {

                if (ps != null) {

                    ps.close();

                }

                if (rs != null) {

                    rs.close();

                }

                if (connection != null) {

                    Conectar.Cerrar_conexion(connection);

                    

                }

            } catch (SQLException e) {

                System.out.println("Error al cerrar la conexión: " + e.getMessage());

            }

        }

        return reporte;
    }

    public void generarPDFProductosMasVendidos() {

        Document document = new Document();

        try {

            PdfWriter.getInstance(document, new FileOutputStream("ProductosMasVendidos.pdf"));
            document.open();

            // Agregar título al documento
            Paragraph title = new Paragraph("Productos Más Vendidos del Mes");
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            // Agregar tabla al documento
            PdfPTable table = new PdfPTable(3);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);

            // Definir encabezados de la tabla
            PdfPCell cell1 = new PdfPCell(new Paragraph("ID Producto"));
            PdfPCell cell2 = new PdfPCell(new Paragraph("Nombre Producto"));
            PdfPCell cell3 = new PdfPCell(new Paragraph("Total Vendido"));

            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);

            // Obtener datos de productos más vendidos
            ArrayList<modelo_reportes> productosMasVendidos = productos_mas_vendidos_mes();

            // Llenar la tabla con los datos obtenidos
            for (modelo_reportes producto : productosMasVendidos) {
                table.addCell(String.valueOf(producto.getIdProducto()));
                table.addCell(producto.getNombreProducto());
                table.addCell(String.valueOf(producto.getTotalVendido()));
            }

            document.add(table);

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            document.close();

        }

    }

    public void escribirPDF(ServletOutputStream out) throws Exception {
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            // Agregar título al documento
            Paragraph title = new Paragraph("Productos Más Vendidos del Mes");
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            // Agregar tabla al documento
            PdfPTable table = new PdfPTable(3);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);

            // Definir encabezados de la tabla
            PdfPCell cell1 = new PdfPCell(new Paragraph("ID Producto"));
            PdfPCell cell2 = new PdfPCell(new Paragraph("Nombre Producto"));
            PdfPCell cell3 = new PdfPCell(new Paragraph("Total Vendido"));

            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);

            // Obtener datos de productos más vendidos
            ArrayList<modelo_reportes> productosMasVendidos = productos_mas_vendidos_mes();

            // Llenar la tabla con los datos obtenidos
            for (modelo_reportes producto : productosMasVendidos) {
                table.addCell(String.valueOf(producto.getIdProducto()));
                table.addCell(producto.getNombreProducto());
                table.addCell(String.valueOf(producto.getTotalVendido()));
            }

            document.add(table);

        } finally {
            document.close();
        }
    }

}