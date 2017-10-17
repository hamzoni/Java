
package Controller;

import Entities.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public abstract class Authentication extends HttpServlet {
    protected boolean authenticating(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("user");
//        return user != null;
        return true;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (authenticating(request, response)) {
            get(request, response);
            return;
        }
        response.sendRedirect(request.getContextPath() + "login");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (authenticating(request, response)) {
            post(request, response);
            return;
        }
        response.sendRedirect(request.getContextPath() + "login");
    }

    public abstract void get(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

    public abstract void post(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
}
