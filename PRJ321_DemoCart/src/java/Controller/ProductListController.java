
package Controller;

import Entities.Product;
import Model.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductListController extends Authentication {

    @Override
    public void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Product> list = DAO.prd.list();
     
        request.setAttribute("list", list);
        request.getRequestDispatcher("/product.jsp").forward(request, response);
    }

    @Override
    public void post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

}
