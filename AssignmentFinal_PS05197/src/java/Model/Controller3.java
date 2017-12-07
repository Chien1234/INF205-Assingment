package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Model.ConnectionData;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * 
 */
@WebServlet(name = "Controller3", urlPatterns = {"/Controller3"})
public class Controller3 extends HttpServlet {

    final private String adminPage = "admin1.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        /* TODO output your page here. You may use following sample code. */
        try {
            String action = request.getParameter("btnAction");
            if (action.equals("Update")) {
                String tensp = request.getParameter("txtTenSP");
                String hinhanh = request.getParameter("txtImage");
                String giasp = request.getParameter("txtGiaSP");
                String mota = request.getParameter("txtMoTaSP");
                ConnectionData c = new ConnectionData();
                boolean result = c.insert(tensp, hinhanh, giasp, mota);
                RequestDispatcher rd = request.getRequestDispatcher(adminPage);
                rd.forward(request, response);
            } else if (action.equals("Delete")) {
                String tensp = request.getParameter("txtTenSP");
                ConnectionData c = new ConnectionData();
                boolean result = c.delete(tensp);
                RequestDispatcher rd = request.getRequestDispatcher(adminPage);
                rd.forward(request, response);
            } else if (action.equals("Reset")) {
                RequestDispatcher rd = request.getRequestDispatcher(adminPage);
                rd.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */// </editor-fold>
}
