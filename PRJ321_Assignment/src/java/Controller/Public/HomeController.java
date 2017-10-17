
package Controller.Public;

import Entities.Category;
import Entities.Post;
import Model.DAO;
import Utility.Pagination;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int page = 1;
        int pageSize = 12;
        try {
            page = Integer.parseInt(request.getParameter("page"));
        } catch (Exception ex) {}
        
        // Set categories data
        ArrayList<Category> categories = DAO.ctg.list();
        request.setAttribute("categories", categories);
        
        // Set posts data
        ArrayList<Post> posts = DAO.pst.pagination(page, pageSize, null);
        for (Post post : posts) {
            if (post.getContent().length() > 100) {
                post.setContent(post.getContent().substring(0, 150) + "...");
            }
        }
        request.setAttribute("posts", posts);
        
        // Set paginator urls
        int pageCount = (int) Math.ceil(DAO.pst.count() / (double) pageSize);
        Pagination pgn = new Pagination("?page", page, pageCount, 2);
        request.setAttribute("pgn", pgn);
        request.setAttribute("pageCount", pageCount);
        
        request.getRequestDispatcher("/PublicPages/Home.jsp").forward(request, response);
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
