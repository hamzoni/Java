package Controller;

import Config.PathConfig;
import Config.*;
import Entities.*;
import Model.DAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public abstract class Authentication extends HttpServlet {

    public static void removeCookie(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("userId")) {
                cookie.setPath("/");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }

    }

    public static User getCookie(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        Cookie[] cookies = request.getCookies();
        for (Cookie coockie : cookies) {
            if (coockie.getName().equals("userId")) {
                int id = Integer.parseInt(coockie.getValue());
                return DAO.usr.search(id);
            }
        }

        return null;
    }

    public static void setCookie(HttpServletResponse response, int id) {
        Cookie cookie = new Cookie("userId", id + "");
        cookie.setPath("/");
        // Store cookie for 30 days
        cookie.setMaxAge(calcDays(30));
        response.addCookie(cookie);
    }
    
    public static int calcDays(int d) {
        return d * 24 * 60 * 60;
    }

    public static void removeAuthUser(HttpServletRequest request) {
        HttpSession ss = request.getSession();
        ss.removeAttribute("user");
    }

    public static void setAuthUser(HttpServletRequest request, User user) {
        HttpSession ss = request.getSession();
        ss.setAttribute("user", user);
    }

    public static User getAuthUser(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        return user;
    }

    protected boolean authenticating(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return Authentication.getAuthUser(request) != null;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (authenticating(request, response)) {
            // Menu for Admin pages
            String[] menuLabels = new String[] {
                "Category", "Post", "User", "Account"
            };
            
            String[] menuUrls = new String[] {
                "category/list",
                "post/list",
                "user/list",
                "account/list"
            };
            
            request.setAttribute("menuLabels", menuLabels);
            request.setAttribute("menuUrls", menuUrls);
            
            get(request, response);
            return;
        }
        response.sendRedirect(PathConfig.ROOT + "login");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (authenticating(request, response)) {
            post(request, response);
            return;
        }
        response.sendRedirect(PathConfig.ROOT + "login");
    }

    public boolean authorized(HttpServletRequest request, HttpServletResponse response, int featureID) throws IOException {
        User user = Authentication.getAuthUser(request);
        if (user.getPrivilege() != featureID) {
            response.sendRedirect("home");
            return false;
        }
        return true;
    }

    public boolean authorized(HttpServletRequest request, HttpServletResponse response, int[] featureIDs) throws IOException {
        User user = Authentication.getAuthUser(request);

        if (user != null) {
            for (int i = 0; i < featureIDs.length; i++) {
                if (user.getPrivilege() == featureIDs[i]) {
                    return true;
                }
            }
        }

        return false;
    }

    public abstract void get(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

    public abstract void post(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
}
