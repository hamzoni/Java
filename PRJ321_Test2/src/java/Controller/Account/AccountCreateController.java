
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

public class AccountCreateController extends Authentication {

    @Override
    public void get(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        if (!authorized(request, response, FeaturesConfig.Account.WRITE)) return;
        
        request.setAttribute("title", "Account Create");
        request.setAttribute("navbar", "account.list");
        request.getRequestDispatcher("/WEB-INF/Account/Create.jsp").forward(request, response);
    }

    @Override
    public void post(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        if (!authorized(request, response, FeaturesConfig.Account.WRITE)) return;
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String features[] = request.getParameterValues("features");
        
        // Validate data
        if (ModelGroup.accMdl.search2(username) != null) {
            response.sendRedirect("create");
            return;
        }
        
        // Create account
        Account account = new Account();
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
        ModelGroup.accMdl.create(account);
        response.sendRedirect("list");
    }

}
