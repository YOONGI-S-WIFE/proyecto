/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.13
 * Generated at: 2023-11-28 02:52:38 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import models.modelo_categoria;
import java.util.*;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.RequestDispatcher;

public final class registro_005fproducto_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("jakarta.servlet.http.HttpSession");
    _jspx_imports_classes.add("jakarta.servlet.RequestDispatcher");
    _jspx_imports_classes.add("jakarta.servlet.http.HttpServletRequest");
    _jspx_imports_classes.add("models.modelo_categoria");
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
 

    HttpSession sesion = request.getSession();

    if (sesion.getAttribute("usuario") != null) {   


      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>REGISTRO DE PRODUCTOS </title>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");


    modelo_categoria modelo_categorias = new modelo_categoria();

    List<modelo_categoria> categorias =  modelo_categorias.categorias();

    
      out.write(" \r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("    <button><a href=\"registro_usuario.jsp\">Registrar usuario</a></button> \r\n");
      out.write("\r\n");
      out.write("    <button><a href=\"registro_producto.jsp\">Registrar producto</a></button> \r\n");
      out.write("\r\n");
      out.write("    <button><a href=\"registro_categoria.jsp\">Registrar categoria</a></button> \r\n");
      out.write("\r\n");
      out.write("    <button><a href=\"venta.jsp\">Registrar venta</a></button> \r\n");
      out.write("\r\n");
      out.write("    <button><a href=\"entrada.jsp\">Registrar entada</a></button> \r\n");
      out.write("\r\n");
      out.write("    <form action=\"/sapphire_inventory/mostrar_usuarios_servlet\" method=\"GET\">\r\n");
      out.write("    <input value=\"usuarios\" name =\"usuarios\" type = \"submit\">\r\n");
      out.write("    </form>\r\n");
      out.write("\r\n");
      out.write("    <form action=\"/sapphire_inventory/mostrar_categorias_servlet\" method=\"post\">\r\n");
      out.write("    <input value=\"productos\" name =\"productos\" type = \"submit\">\r\n");
      out.write("    </form>\r\n");
      out.write("\r\n");
      out.write("    <form action=\"/sapphire_inventory/cerrar_sesion_servlet\" method=\"post\">\r\n");
      out.write("        <input value=\"cerrar sesion\" name =\"cerrar_sesion\" type = \"submit\">\r\n");
      out.write("        </form>\r\n");
      out.write("\r\n");
      out.write("<h2>Registro de Producto</h2>\r\n");
      out.write("\r\n");
      out.write("    <form action=\"/sapphire_inventory/registro_producto_servlet\" method=\"POST\" enctype=\"multipart/form-data\">\r\n");
      out.write("\r\n");
      out.write("        <label for=\"marca\">Marca:</label>\r\n");
      out.write("\r\n");
      out.write("        <input type=\"text\" id=\"marca\" name=\"marca\" required>\r\n");
      out.write("\r\n");
      out.write("        <br><br>\r\n");
      out.write("\r\n");
      out.write("        <label for=\"estado\">Estado:</label>\r\n");
      out.write("        <select id=\"estado\" name=\"estado\" required>\r\n");
      out.write("\r\n");
      out.write("            <option value=\"activo\">Activo</option>\r\n");
      out.write("            <option value=\"inactivo\">Inactivo</option>\r\n");
      out.write("\r\n");
      out.write("        </select>\r\n");
      out.write("\r\n");
      out.write("        <br><br>\r\n");
      out.write("\r\n");
      out.write("        <label for=\"nombre\">Nombre:</label>\r\n");
      out.write("        <input type=\"text\" id=\"nombre\" name=\"nombre\" required>\r\n");
      out.write("\r\n");
      out.write("        <br><br>\r\n");
      out.write("\r\n");
      out.write("        <label for=\"descripcion\">Descripción:</label>\r\n");
      out.write("        <textarea id=\"descripcion\" name=\"descripcion\" rows=\"4\" required></textarea>\r\n");
      out.write("\r\n");
      out.write("        <br><br>\r\n");
      out.write("\r\n");
      out.write("        <label for=\"cantidad\">Cantidad:</label>\r\n");
      out.write("        <input type=\"number\" id=\"cantidad\" name=\"cantidad\" required>\r\n");
      out.write("\r\n");
      out.write("        <br><br>\r\n");
      out.write("\r\n");
      out.write("        <label for=\"medida\">Medida:</label>\r\n");
      out.write("        <select id=\"medida\" name=\"medida\" required>\r\n");
      out.write("\r\n");
      out.write("            <option value=\"unidad\">unidad</option>\r\n");
      out.write("            <option value=\"libra\">libra</option>\r\n");
      out.write("            <option value=\"kilo\">kg</option>\r\n");
      out.write("            <option value=\"arroba\">arroba</option>\r\n");
      out.write("            <option value=\"bulto\">bulto</option>\r\n");
      out.write("\r\n");
      out.write("        </select>\r\n");
      out.write("\r\n");
      out.write("        <br><br>\r\n");
      out.write("\r\n");
      out.write("        <label for=\"categoria\">Categoría:</label>\r\n");
      out.write("\r\n");
      out.write("        <select id=\"categoria\" name=\"categoria\" required>\r\n");
      out.write("\r\n");
      out.write("        ");
 for (modelo_categoria categoria : categorias) { 
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <option value=\"");
      out.print( categoria.getId_categoria() );
      out.write('"');
      out.write('>');
      out.print( categoria.getNombre() );
      out.write("</option>\r\n");
      out.write("\r\n");
      out.write("            ");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </select>\r\n");
      out.write("\r\n");
      out.write("        <br><br>\r\n");
      out.write("\r\n");
      out.write("        <label for=\"imagen\">Imagen:</label>\r\n");
      out.write("        <input type=\"file\" id=\"imagen\" name=\"imagen\" accept=\"image/*\" required>\r\n");
      out.write("\r\n");
      out.write("        <br><br>\r\n");
      out.write("\r\n");
      out.write("        <button name =\"registrar\" type = \"submit\" class=\"btn\">Registrar</button>\r\n");
      out.write("\r\n");
      out.write("    </form>\r\n");
      out.write("    \r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
 

} else {

    RequestDispatcher redireccion = request.getRequestDispatcher("error_sesion.jsp");
    redireccion.forward(request, response);

    }
    
    
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}