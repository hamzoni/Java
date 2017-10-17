
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrderDetailListController extends Authentication {

    @Override
    public void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/cart.jsp").forward(request, response);
    }

    @Override
    public void post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

}
