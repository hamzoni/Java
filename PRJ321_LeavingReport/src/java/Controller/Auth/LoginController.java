
package Controller.Auth;

import Entities.User;
import Model.ModelGroup;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("title", "Login");
        
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        
        if (user != null) {
            response.sendRedirect("");
        } else {
            request.getRequestDispatcher("/LoginView.jsp").forward(request, response);
            
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = ModelGroup.userMdl.login(username, password);
        
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("");
        } else {
            response.sendRedirect("login");
        }
    }
}
