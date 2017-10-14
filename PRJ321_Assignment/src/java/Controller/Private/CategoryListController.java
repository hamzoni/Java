package Controller.Private;

import Config.PathConfig;
import Config.RoleConfig;
import Controller.Authentication;
import Entities.Category;
import Entities.User;
import Model.DAO;
import Utility.Pagination;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CategoryListController extends Authentication {

    @Override
    public void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!authorized(request, response, new int[]{RoleConfig.MOD, RoleConfig.ADMIN})) {
            response.sendRedirect(PathConfig.ROOT + "post/list");
            return;
        }
        
        int page = 1;
        int pageSize = 10;
        try {
            page = Integer.parseInt(request.getParameter("page"));
        } catch (Exception ex) {}
        
        // Set posts data
        ArrayList<Category> categories = DAO.ctg.pagination(page, pageSize);
        request.setAttribute("categories", categories);
        // Set paginator urls
        int pageCount = (int) Math.ceil(DAO.ctg.count() / (double) pageSize);
        Pagination pgn = new Pagination("?page", page, pageCount, 2);
        request.setAttribute("pgn", pgn);
        request.setAttribute("pageCount", pageCount);
        
        request.getRequestDispatcher("/PrivatePages/CategoryList.jsp").forward(request, response);
    }

    @Override
    public void post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

}
