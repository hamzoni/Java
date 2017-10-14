package Controller.Private;

import Config.PathConfig;
import Controller.Authentication;
import Entities.Category;
import Entities.Post;
import Entities.User;
import Model.DAO;
import Utility.FileUpload;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig
public class PostCreateController extends Authentication {

    @Override
    public void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get categories list
        ArrayList<Category> categories = DAO.ctg.list();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("/PrivatePages/PostCreate.jsp").forward(request, response);
    }

    @Override
    public void post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int category_id = Integer.parseInt(request.getParameter("category"));

            String title = request.getParameter("title");
            String content = request.getParameter("content");
            String description = request.getParameter("description");

            Category category = new Category();
            category.setId(category_id);

            User user = new User();
            user.setId(1);

            Post post = new Post();
            post.setAuthor(user);
            post.setCategory(category);
            post.setTitle(title);
            post.setContent(content);
            post.setDescription(description);

            String thumbnail = FileUpload.upload(request, "thumbnail", "/Assets/images");
            post.setThumbnail(thumbnail);
            if (DAO.pst.create(post)) {
                response.sendRedirect(PathConfig.ROOT + "post/list");
                return;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        response.sendRedirect(PathConfig.ROOT + "post/create");
    }

}
