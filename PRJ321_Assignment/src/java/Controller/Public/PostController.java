
package Controller.Public;

import Entities.Category;
import Entities.Post;
import Model.DAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Set categories data
            ArrayList<Category> categories = DAO.ctg.list();
            request.setAttribute("categories", categories);
            
            // Set post data
            int id = Integer.parseInt(request.getParameter("id"));
            Post post = DAO.pst.search(id);
            request.setAttribute("post", post);
        } catch (Exception ex) {
            response.sendRedirect("home");
            return;
        }
        request.getRequestDispatcher("/PublicPages/Post.jsp").forward(request, response);
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
