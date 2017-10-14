
package Controller.Private;

import Config.PathConfig;
import Config.RoleConfig;
import Controller.Authentication;
import Entities.Category;
import Model.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CategoryUpdateController extends Authentication {

    @Override
    public void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!authorized(request, response, new int[]{RoleConfig.MOD, RoleConfig.ADMIN})) {
            response.sendRedirect(PathConfig.ROOT + "post/list");
            return;
        }
        try {
            // Find old category
            int id = Integer.parseInt(request.getParameter("id"));
            Category category = DAO.ctg.search(id);
            request.setAttribute("category", category);

            request.getRequestDispatcher("/PrivatePages/CategoryUpdate.jsp").forward(request, response);
        } catch (Exception ex) {
            response.sendRedirect(PathConfig.ROOT + "category/list");
        }
        
    }

    @Override
    public void post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!authorized(request, response, new int[]{RoleConfig.MOD, RoleConfig.ADMIN})) {
            response.sendRedirect(PathConfig.ROOT + "post/list");
            return;
        }
        try {
            // Find old category
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            Category category = new Category();
            category.setId(id);
            category.setName(name);
            
            if (DAO.ctg.update(category)) {
                response.sendRedirect(PathConfig.ROOT + "category/list");
                return;
            }
        } catch (Exception ex) {
            
        }
        response.sendRedirect(PathConfig.ROOT + "category/update");
    }

}
