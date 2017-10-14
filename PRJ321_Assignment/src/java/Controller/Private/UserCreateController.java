
package Controller.Private;

import Config.PathConfig;
import Config.RoleConfig;
import Controller.Authentication;
import Entities.User;
import Model.DAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserCreateController extends Authentication {

    @Override
    public void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!authorized(request, response, new int[]{RoleConfig.ADMIN})) {
            response.sendRedirect(PathConfig.ROOT + "post/list");
            return;
        }
        request.getRequestDispatcher("/PrivatePages/UserCreate.jsp").forward(request, response);
    }

    @Override
    public void post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setName(request.getParameter("name"));
        user.setUsername(request.getParameter("username"));
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));
        
        RoleConfig rcfg = new RoleConfig();
        int role = rcfg.findRole(Integer.parseInt(request.getParameter("role")));
        if (role != -1) {
            user.setPrivilege(role);
        } else {
            // Invalid role. Redirect to previous page
            response.sendRedirect(PathConfig.ROOT + "user/create");
        }
        
        DAO.usr.create(user);
        response.sendRedirect(PathConfig.ROOT + "user/list");
    }

}
