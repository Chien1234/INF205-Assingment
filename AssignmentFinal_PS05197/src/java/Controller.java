/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
//import org.apache.jasper.tagplugins.jstl.core.Url;

/**
 *
 * 
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

    final private String errorPage = "login.html";
    final private String homePage = "index2.jsp";
    //final private String index2Page = "index2.jsp";
    //final private String showPage = "index3.jsp";

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
            String action = request.getParameter("btAction");
            if (action.equals("Login")) {
                String email = request.getParameter("txtEmail");
                String password = request.getParameter("txtPass");
                LoginBean login = new LoginBean();
                boolean result = login.checkLogin(email, password);
                String url = errorPage;

                if (result) {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("EMAIL", email);
                    url = homePage;
                }
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
            }
            //String action2 = request.getParameter("btAction2");
            if (action.equals("Register")) {
                String email = request.getParameter("txtEmail2");
                String password = request.getParameter("txtPass2");
                LoginBean login = new LoginBean();
                boolean result = login.insert(email, password);
                RequestDispatcher rd = request.getRequestDispatcher(errorPage);
                rd.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
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
