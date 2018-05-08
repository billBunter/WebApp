/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guestbook;

import guestbook.helper.AccountHelper;
import guestbook.pojo.Account;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Billy
 */
public class Controller extends HttpServlet {

    //private LinkedList<String> sessions = new LinkedList<>();
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

        String redirect = request.getParameter("redirect");
        AccountController accController = AccountController.getInstanz();

        if (request.getParameter("userId") == null) {
            //kommt nicht vom Login
            if (redirect == null) {
                response.sendRedirect("index.html");
                return;
            } else if (redirect.equals("index")) {
                accController.addToHistory(redirect);
                response.sendRedirect(redirect + ".html");
            } else if (redirect.equals("evaluationForm")) {
                if (accController.getAccount() == null) {
                    sendAlert("Sie sind nicht angemeldet", response);
                    response.sendRedirect("home.html");
                    return;
                } else {
                    if (accController.getAccount().getRechte().equals("student")) {
                        response.sendRedirect(redirect + ".xhtml");
                    } else {
                        response.sendRedirect("evaluationOverview.xhtml");
                    }
                }
            } else {
                if (redirect.equals("webapplicationen") || redirect.equals("english")) {
                    if (!accController.isRegistered()) {
                        response.sendRedirect("logon.jsp");
                        return;
                    } else {
                        accController.addToHistory(redirect);
                        response.sendRedirect(redirect + ".html");
                        return;
                    }
                } else if (redirect.equals("loggoff")) {
                    if (accController.getAccount() == null) {
                        response.sendRedirect("logon.jsp");
                        return;
                    } else {
                        accController.loggOff();
                        sendAlert("Sie sind jetzt abgemeldet!", response);
                        response.sendRedirect("index.html");
                        return;
                    }
                } else if (redirect.equals("history")) {
                    accController.addToHistory(redirect);
                    response.sendRedirect(redirect + ".html");
                }
            }
        } else {
            //kommt von logon.jsp
            String userid = request.getParameter("userId");
            String passwd = request.getParameter("passwd");

            AccountHelper accHelper = new AccountHelper();
            List<Account> accs = accHelper.getByUserid(userid);
            if (accs.size() < 1) {
                //nicht registriet
                response.sendRedirect("register.html");
            } else if (accs.size() == 1) {
                accController.setAccount(accs.get(0));
                if (redirect != null) {
                    response.sendRedirect(redirect + ".html");
                } else {
                    response.sendRedirect("index.html");
                }
            } else {
                String alert = "Hoppala das ist wohl was schief gelaufen!!";
                sendAlert(alert, response);
            }

        }
    }

    private void sendAlert(String alert, HttpServletResponse response) {
        try (PrintWriter out = response.getWriter()) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('" + alert + "');");
            out.println("location='index.html';");
            out.println("</script>");
        } catch (IOException e) {
            e.printStackTrace();
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

}
