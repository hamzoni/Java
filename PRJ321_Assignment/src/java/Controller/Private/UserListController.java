package Controller.Private;

import Config.PathConfig;
import Config.RoleConfig;
import Controller.Authentication;
import Entities.Post;
import Entities.User;
import Model.DAO;
import Utility.Pagination;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserListController extends Authentication {

    @Override
    public void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!authorized(request, response, new int[]{RoleConfig.ADMIN})) {
            response.sendRedirect(PathConfig.ROOT + "post/list");
            return;
        }
        int page = 1;
        int pageSize = 10;
        try {
            page = Integer.parseInt(request.getParameter("page"));
        } catch (Exception ex) {}
        
        // Set posts data
        ArrayList<User> users = DAO.usr.pagination(page, pageSize);
        request.setAttribute("users", users);
        // Set paginator urls
        int pageCount = (int) Math.ceil(DAO.usr.count() / (double) pageSize);
        response.getWriter().println(pageCount);
        
        Pagination pgn = new Pagination("?page", page, pageCount, 2);
        request.setAttribute("pgn", pgn);
        request.setAttribute("pageCount", pageCount);
        
        request.getRequestDispatcher("/PrivatePages/UserList.jsp").forward(request, response);
    }

    @Override
    public void post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

}
