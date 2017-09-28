
package Entities;

import java.util.ArrayList;

public class Account {
    private String username;
    private String password;
    private ArrayList<Role> roles;

    public Account() {
        roles = new ArrayList<Role>();
    }
    
    public boolean hasRole(int fid) {
        for (Role role : roles) {
            if (fid == role.getFeature().getFid()) {
                return true;
            }
        }
        return false;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Role> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<Role> roles) {
        this.roles = roles;
    }
    
}
