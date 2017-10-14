
package Controller.Private;

import Config.PathConfig;
import Config.RoleConfig;
import Controller.Authentication;
import Entities.Category;
import Model.DAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CategoryCreateController extends Authentication {

    @Override
    public void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (authorized(request, response, new int[]{RoleConfig.MOD, RoleConfig.ADMIN})) {
            request.getRequestDispatcher("/PrivatePages/CategoryCreate.jsp").forward(request, response);
        } else {
            response.sendRedirect(PathConfig.ROOT + "post/list");
        }
    }

    @Override
    public void post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!authorized(request, response, new int[]{RoleConfig.MOD, RoleConfig.ADMIN})) {
            response.sendRedirect(PathConfig.ROOT + "post/list");
            return;
        }
        String name = request.getParameter("name");
        if (name.length() != 0) {
            Category category = new Category();
            category.setName(name);
            if (DAO.ctg.create(category)) {
                response.sendRedirect(PathConfig.ROOT + "category/list");
                return;
            }
        }
        request.getRequestDispatcher("/PrivatePages/CategoryCreate.jsp").forward(request, response);
    }

}
