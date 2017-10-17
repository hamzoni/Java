
package Controller;

import Config.FeaturesConfig;
import Config.PathConfig;
import Entities.Account;
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
        Account account = (Account) session.getAttribute("account");
        return account != null;
        
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
        Account acc = (Account) request.getSession().getAttribute("account");
        if (!acc.hasRole(featureID)) {
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
