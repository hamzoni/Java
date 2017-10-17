
package Controller;

import Config.FeaturesConfig;
import Entities.Account;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HomeController extends Authentication {

    @Override
    public void get(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession auth = request.getSession();
        Account account = (Account) auth.getAttribute("account");
        
        request.setAttribute("title", "Home");
        request.setAttribute("navbar", "home");
        request.setAttribute("account", account);
        request.getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);
    }

    @Override
    public void post(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
    }

}
