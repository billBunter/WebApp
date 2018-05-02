/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guestbook;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Billy
 */
public class Controller extends HttpServlet {

    private LinkedList<String> sessions = new LinkedList<>();

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

        HttpSession session = request.getSession();
        if (request.getParameter("userId") == null) {
            ServletContext servletContext = getServletContext();
            String redirect = request.getParameter("redirect");

            if (redirect == null) {
                redirect = "home.html";
            } else {
                if (redirect.equals("webapplicationen") || redirect.equals("english")) {
                    if (!isLogedOn(session.getId())) {
                        response.sendRedirect("logon.jsp");
                        return;
                    } else {
                        executeRedirect(servletContext, redirect, request, response);
                        return;
                    }
                }
            }
        } else {
            String userid = request.getParameter("userId");
            String passwd = request.getParameter("passwd");
            sessions.add(session.getId());
            response.sendRedirect("home.html");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private boolean isLogedOn(String sessionID) {
        boolean returnBoolean = false;
        for (int i = 0; i < sessions.size(); i++) {
            if (sessionID.equals(sessions.get(i))) {
                returnBoolean = true;
            }
        }
        return returnBoolean;
    }

    private void executeRedirect(ServletContext sc, String path, HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher dispatcher = sc.getRequestDispatcher("/" + path + ".html");
            dispatcher.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
