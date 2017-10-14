
package Controller.Public;

import Config.PathConfig;
import Controller.Authentication;
import Entities.User;
import Model.DAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = Authentication.getCookie(request, response);
        if (user != null) Authentication.setAuthUser(request, user);
        
        if (Authentication.getAuthUser(request) != null) {
            response.sendRedirect(PathConfig.ROOT + "post/list");
        } else {
            request.getRequestDispatcher("/PublicPages/Login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        
        User user = DAO.usr.login(login, password);
        if (user != null) {
            Authentication.setAuthUser(request, user);
            if (remember != null) 
                Authentication.setCookie(response, user.getId());
            response.sendRedirect(PathConfig.ROOT + "post/list");
        } else {
            request.getRequestDispatcher("/PublicPages/Login.jsp").forward(request, response);
        }
    }

}
