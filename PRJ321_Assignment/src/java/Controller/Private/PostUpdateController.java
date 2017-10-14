package Controller.Private;

import Config.PathConfig;
import Config.RoleConfig;
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
public class PostUpdateController extends Authentication {

    @Override
    public void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Get categories list
            ArrayList<Category> categories = DAO.ctg.list();
            request.setAttribute("categories", categories);

            // Find old category
            int id = Integer.parseInt(request.getParameter("id"));
            Post post = null;
            if (authorized(request, response, new int[]{RoleConfig.ADMIN, RoleConfig.MOD})) {
                post = DAO.pst.search(id);
            } else {
                int authorId = Authentication.getAuthUser(request).getId();
                post = DAO.pst.searchByAuthor(id, authorId);
            }
            
            request.setAttribute("post", post);

            request.getRequestDispatcher("/PrivatePages/PostUpdate.jsp").forward(request, response);
        } catch (Exception ex) {
            response.sendRedirect(PathConfig.ROOT + "post/list");
        }
    }

    @Override

    public void post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("post_id"));
            int category_id = Integer.parseInt(request.getParameter("category"));
            int author_id = Integer.parseInt(request.getParameter("author_id"));

            String title = request.getParameter("title");
            String content = request.getParameter("content");
            String description = request.getParameter("description");

            Category category = new Category();
            category.setId(category_id);

            User user = new User();
            user.setId(author_id);

            Post post = new Post();
            post.setId(id);
            post.setAuthor(user);
            post.setCategory(category);
            post.setTitle(title);
            post.setContent(content);
            post.setDescription(description);

            String oldThumbnail = request.getParameter("oldThumbnail");

            if (oldThumbnail != null)
                FileUpload.delete(request, oldThumbnail);
                    
            String thumbnail = FileUpload.upload(request, "thumbnail", "/Assets/images");
            post.setThumbnail(thumbnail);
            
            if (authorized(request, response, new int[]{RoleConfig.ADMIN, RoleConfig.MOD})) {
                DAO.pst.update(post);
            } else {
                int authorId = Authentication.getAuthUser(request).getId();
                DAO.pst.updateByAuthor(post, authorId);
            }
            
            response.sendRedirect(PathConfig.ROOT + "post/list");
            return;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        response.sendRedirect(PathConfig.ROOT + "post/update");
    }

}
