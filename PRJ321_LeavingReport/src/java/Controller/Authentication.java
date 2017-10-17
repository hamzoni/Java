
package Controller;

import Config.*;
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
        User user = (User) session.getAttribute("user");
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
        response.sendRedirect(PathConfig.root + "auth/login");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (authenticating(request, response)) {
            post(request, response);
            return;
        }
        response.sendRedirect(PathConfig.root + "auth/login");
    }
    
    public boolean authorized(HttpServletRequest request, HttpServletResponse response, int featureID) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user.getRole() != featureID) {
            response.sendRedirect("home");
            return false;
        }
        return true;
    }

    public abstract void get(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

    public abstract void post(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
}
