package Controller;

import Entities.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HomeController extends Authentication {

    @Override
    public void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        request.setAttribute("user", user);
        request.setAttribute("navbar", "home");
        request.setAttribute("title", "Homepage");
        if (user != null) {
            request.getRequestDispatcher("/HomeView.jsp").forward(request, response);
        } else {
            response.sendRedirect("login");
        }
    }

    @Override
    public void post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        HttpSession session = request.getSession();
//        User user = (User) session.getAttribute("user");
        if (request != null) {
            request.getRequestDispatcher("/HomeView.jsp").forward(request, response);
        }

    }

}
