package Controller.Private;

import Config.PathConfig;
import Config.RoleConfig;
import Controller.Authentication;
import Model.DAO;
import Utility.Ajax;
import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CategoryDeleteController extends Authentication {

    @Override
    public void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(PathConfig.ROOT + "category/list");
    }

    @Override
    public void post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!authorized(request, response, new int[]{RoleConfig.MOD, RoleConfig.ADMIN})) {
            response.sendRedirect(PathConfig.ROOT + "post/list");
            return;
        }
        Map<String, Object> params = Ajax.processXhr(request, response);
        int id = Integer.parseInt((String) params.get("id"));
        DAO.ctg.delete(id);
    }

}
