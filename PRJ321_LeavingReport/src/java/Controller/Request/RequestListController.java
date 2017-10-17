
package Controller.Request;

import Controller.Authentication;
import Entities.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RequestListController extends Authentication {

    @Override
    public void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        request.setAttribute("user", user);
        request.setAttribute("navbar", "request.list");
        request.setAttribute("title", "Request List");
//        response.getWriter().println("asd");
        request.getRequestDispatcher("/View/Request/List.jsp").forward(request, response);
    }

    @Override
    public void post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    
}
