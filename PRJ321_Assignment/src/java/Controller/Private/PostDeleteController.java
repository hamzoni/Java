
package Controller.Private;

import Config.PathConfig;
import Config.RoleConfig;
import Controller.Authentication;
import Entities.Post;
import Model.DAO;
import Utility.Ajax;
import Utility.FileUpload;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostDeleteController extends Authentication {

    @Override
    public void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // There is no view for delete page
        response.sendRedirect(PathConfig.ROOT + "category/list");
    }

    @Override
    public void post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, Object> params = Ajax.processXhr(request, response);
        int id = Integer.parseInt((String) params.get("id"));
        Post post = DAO.pst.search(id);
        
        if (authorized(request, response, new int[]{RoleConfig.ADMIN, RoleConfig.MOD})) {
            if (post.getThumbnail() != null)
                FileUpload.delete(request, post.getThumbnail());
            DAO.pst.delete(id);
        } else {
            int authorId = Authentication.getAuthUser(request).getId();
            if (post.getThumbnail() != null && post.getAuthor().getId() == authorId)
                FileUpload.delete(request, post.getThumbnail());
            DAO.pst.deleteByAuthor(id, authorId);
        }
        
    }

}
