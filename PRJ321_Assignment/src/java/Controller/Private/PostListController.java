package Controller.Private;

import Config.RoleConfig;
import Controller.Authentication;
import Entities.Post;
import Entities.User;
import Model.DAO;
import Utility.Ajax;
import Utility.Pagination;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PostListController extends Authentication {

    @Override
    public void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        int page = 1;
        int pageSize = 10;
        try {
            page = Integer.parseInt(request.getParameter("page"));
        } catch (Exception ex) {}
        
        ArrayList<Post> posts = new ArrayList<Post>();
        int pageCount = 1;
        if (authorized(request, response, new int[]{RoleConfig.ADMIN, RoleConfig.MOD})) {
            // Set posts data
            posts = DAO.pst.pagination(page, pageSize);
            // Set paginator urls
            pageCount = (int) Math.ceil(DAO.pst.count() / (double) pageSize);
        } else {
            // Get author id
            User user = Authentication.getAuthUser(request);
            // Set posts data
            posts = DAO.pst.listInAuthor(page, pageSize, user.getId());
            // Set paginator urls
            pageCount = (int) Math.ceil(DAO.pst.countPostsByAuthor(user.getId()) / (double) pageSize);
        }
        request.setAttribute("posts", posts);
        
        Pagination pgn = new Pagination("?page", page, pageCount, 2);
        request.setAttribute("pgn", pgn);
        request.setAttribute("pageCount", pageCount);
        
        request.getRequestDispatcher("/PrivatePages/PostList.jsp").forward(request, response);
    }

    @Override
    public void post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, Object> params = Ajax.processXhr(request, response);
        int id = (int) params.get("id");
        Post post = null;
        if (authorized(request, response, new int[]{RoleConfig.ADMIN, RoleConfig.MOD})) {
            post = DAO.pst.search(id);
        } else {
            // Filter for Author posts only
            User user = Authentication.getAuthUser(request);
            post = DAO.pst.searchByAuthor(id, user.getId());
        }
        
        response.getWriter().println(Ajax.toJson(post));
    }

}
