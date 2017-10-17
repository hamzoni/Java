
package Controller;

import Entities.Product;
import Model.DAO;
import SessionControl.SessionController;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrderDetailCreate extends Authentication {

    @Override
    public void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    public void post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product prd = DAO.prd.search(id);
        if (prd != null) {
            SessionController.insertCart(request, response, prd, 1);
        }
        response.sendRedirect("../cart/list");
    }
    
}
