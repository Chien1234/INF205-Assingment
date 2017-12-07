package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import customs.SanPham;

public final class admin1_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("         ");

                                        SanPham sp = new SanPham();
                                        ArrayList<SanPham> ar = new ArrayList<SanPham>();
                                        ar=sp.getConnectSanPham();
                                        int start = 0, end = 3;
                                        if(ar.size()<3){
                                            end = ar.size();
                                        }
                                        if ( request.getParameter("start") != null){
                                            start = Integer.parseInt(request.getParameter("start"));
                                        }
                                         if ( request.getParameter("end") != null){
                                            end = Integer.parseInt(request.getParameter("end"));
                                        }
                                         ArrayList<SanPham> list = sp.getlist(ar, start, end);
                                        
                                    
      out.write("\n");
      out.write("                                    ");

                                         int ID;
                                        String TenSP;
                                        String imagesSP;
                                        String GiaSP;
                                        String MoTaSP;
                                    
      out.write("\n");
      out.write("                                    <table border=\"1\" style=\"width: 800px\">\n");
      out.write("                                        <thead>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <th>No.</th>\n");
      out.write("                                                <th>Ten SP</th>\n");
      out.write("                                                <th>Hinh Anh</th>\n");
      out.write("                                                <th>Gia SP</th>\n");
      out.write("                                                <th>Mo Ta SP</th>\n");
      out.write("                                            </tr>\n");
      out.write("                                        </thead>\n");
      out.write("                                        ");

                                            for ( SanPham sph:list){
                                                ID=sph.getID();
                                           TenSP=sph.getTenSP();
                                           imagesSP=sph.getImagesSP();
                                           GiaSP=sph.getGiaSP();
                                           MoTaSP=sph.getMoTaSP();
                                            
                                        
      out.write("\n");
      out.write("                                        <tr>\n");
      out.write("                                            <th>");
      out.print(ID);
      out.write("</th>\n");
      out.write("                                            <th>");
      out.print(TenSP);
      out.write("</th>\n");
      out.write("                                            <th><img src=");
      out.print(imagesSP);
      out.write("/></th>\n");
      out.write("                                            <th>");
      out.print(GiaSP);
      out.write("</th>\n");
      out.write("                                            <th>");
      out.print(MoTaSP);
      out.write("</th>\n");
      out.write("                                            ");
}
      out.write("\n");
      out.write("                                        </tr>\n");
      out.write("                                        \n");
      out.write("                                    </table>\n");
      out.write("                                        <ul class=\"pagination\" style=\"margin-left: 40px\">\n");
      out.write("                                             ");

                                        int a,b;
                                        int limit = ar.size()/3;
                                        if (limit * 3 < ar.size()){
                                            limit += 1;
                                            
                                        }
                                        for (int i = 1;i<=limit;i++){
                                            a =(i-1)*3;
                                            b=i*3;
                                            if(b>ar.size()){
                                                b=ar.size();
                                            }
                                        
                                    
      out.write("\n");
      out.write("                                    <li class=\"active\"><a href=\"admin1.jsp?start=");
      out.print(a);
      out.write("&end=");
      out.print(b);
      out.write('"');
      out.write('>');
      out.print(i);
      out.write("</a></li>\n");
      out.write("                                        ");
}
      out.write("\n");
      out.write("                                        </ul>\n");
      out.write("                                        <form action=\"Controller3\" method=\"post\" style=\"width: 300px\">\n");
      out.write("                                            <p> Ten San Pham : <input type=\"text\" name=\"txtTenSP\" style=\"float: right\"/></p> </br>\n");
      out.write("                                            <p> Hinh Anh: <input type=\"text\" name=\"txtImage\" style=\"float: right\"/></p> </br>\n");
      out.write("                                            <p> Gia : <input type=\"text\" name=\"txtGiaSP\" style=\"float: right\"/></p> </br>\n");
      out.write("                                            <p> Mo Ta  : <input type=\"text\" name=\"txtMoTaSP\" style=\"float: right\"/></p> </br>\n");
      out.write("                                            <input type=\"submit\" value=\"Update\" name=\"btnAction\"/>\n");
      out.write("                                            <input type=\"submit\" value=\"Delete\" name=\"btnAction\"/>\n");
      out.write("                                            <input type=\"submit\" value=\"Reset\" name=\"btnAction\"/>\n");
      out.write("                                        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
