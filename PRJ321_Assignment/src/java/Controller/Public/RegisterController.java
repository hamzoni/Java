
package Controller.Public;

import Config.PathConfig;
import Config.RoleConfig;
import Entities.User;
import Model.DAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/PublicPages/Register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = new User();
        user.setName(request.getParameter("name"));
        user.setEmail(request.getParameter("email"));
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setPrivilege(RoleConfig.AUTHOR);
        
        if (DAO.usr.search(request.getParameter("username")) == null) {
            DAO.usr.create(user);
            response.sendRedirect(PathConfig.ROOT + "login");
        } else {
            response.sendRedirect(PathConfig.ROOT + "register");
        }
    }

}
