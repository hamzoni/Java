
package Controller.Account;

import Config.FeaturesConfig;
import Controller.Authentication;
import Entities.Account;
import Entities.Feature;
import Entities.Role;
import Model.ModelGroup;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccountUpdateController extends Authentication {

    @Override
    public void get(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
       
        if (!authorized(request, response, FeaturesConfig.Account.UPDATE)) return;
        
        request.setAttribute("title", "Account Update");
        request.setAttribute("navbar", "account.list");

        String username = request.getParameter("username");
        Account account = ModelGroup.accMdl.search2(username);
        if (account != null) {
            request.setAttribute("account", account);
            request.getRequestDispatcher("/WEB-INF/Account/Update.jsp").forward(request, response);
        } else {
            response.sendRedirect("list");
        }
    }

    @Override
    public void post(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        if (!authorized(request, response, FeaturesConfig.Account.UPDATE)) return;
        
        String usernameRoot = request.getParameter("usernameRoot");
        String username = request.getParameter("login");
        String password = request.getParameter("password");
        String features[] = request.getParameterValues("features");
        
        Account account = ModelGroup.accMdl.search2(usernameRoot);
        boolean duplicated = ModelGroup.accMdl.search2(username) != null && !usernameRoot.equals(username);
        if (duplicated) {
            response.sendRedirect("update?username=" + usernameRoot);
            return;
        }
        
        // Update account
        account.setUsername(username);
        account.setPassword(password);
        
        ArrayList<Feature> ftrs = ModelGroup.ftrMdl.list();
        ArrayList<Role> roles = new ArrayList<Role>();
        
        if (features != null) {
            for (int i = 0; i < features.length; i++) {
                for (Feature ftr : ftrs) {
                    int fid = Integer.parseInt(features[i]);
                    
                    if (fid == ftr.getFid()) {
                        Role role = new Role();
                        role.setUsername(username);
                        role.setFeature(ftr);
                        roles.add(role);
                        break;
                    }
                }
            }
        }
        
        account.setRoles(roles);
        if (ModelGroup.accMdl.update(account, usernameRoot)) {
            response.sendRedirect("list");
        } else {
            response.sendRedirect("update?username=" + usernameRoot);
        }

    }

}