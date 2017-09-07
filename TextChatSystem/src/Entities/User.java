
package Entities;

import java.io.Serializable;

public class User implements Serializable {
    private String fullName;
    private String login;
    private String password;

    public User() {
        
    }

    public User(String fullName, String login, String password) {
        this.fullName = fullName;
        this.login = login;
        this.password = password;
    }

    
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
 
    public String toString() {
        return fullName + " " + login + " " + password;
    }
}
