
package Controller.Private;

import Config.PathConfig;
import Config.RoleConfig;
import Controller.Authentication;
import Entities.User;
import Model.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProfileController extends Authentication {

    @Override
    public void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = Authentication.getAuthUser(request);
        request.setAttribute("user", user);
        request.getRequestDispatcher("/PrivatePages/UserProfile.jsp").forward(request, response);
    }

    @Override
    public void post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = Authentication.getAuthUser(request);
        
        user.setName(request.getParameter("name"));
        user.setUsername(request.getParameter("username"));
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));
        
        DAO.usr.update(user);
        response.sendRedirect(PathConfig.ROOT + "profile");
    }

}
