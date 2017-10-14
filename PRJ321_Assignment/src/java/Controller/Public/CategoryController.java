
package Controller.Public;

import Entities.Category;
import Entities.Post;
import Model.DAO;
import Utility.Pagination;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CategoryController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int categoryID = Integer.parseInt(request.getParameter("id"));
        // Set categories data
        ArrayList<Category> categories = DAO.ctg.list();
        request.setAttribute("categories", categories);
        
        // Set paginator urls
        int page = 1;
        int pageSize = 4;
        try {
            page = Integer.parseInt(request.getParameter("page"));
        } catch (Exception ex) {}
        int pageCount = (int) Math.ceil(DAO.pst.countPostsInCategory(categoryID)/ (double) pageSize);
        
        // Set posts list
        ArrayList<Post> posts = DAO.pst.listInCategory(page, pageSize, categoryID);
        request.setAttribute("posts", posts);
        
        Pagination pgn = new Pagination("?id=" + categoryID + "&page", page, pageCount, 2);
        request.setAttribute("pgn", pgn);
        request.setAttribute("pageCount", pageCount);
        
        request.getRequestDispatcher("/PublicPages/Category.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
