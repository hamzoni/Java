
package Controller.Public;

import Config.PathConfig;
import Controller.Authentication;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect(PathConfig.ROOT + "home");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Authentication.removeAuthUser(request);
        Authentication.removeCookie(request, response);
        response.sendRedirect(PathConfig.ROOT + "home");
        
    }

}
