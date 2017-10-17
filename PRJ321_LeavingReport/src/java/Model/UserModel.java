
package Model;

import Entities.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserModel extends Model<User> {

    public User login(String username, String password) {
        User user = null;
        try {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getInt("role"));
                
                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    @Override
    public boolean create(User t) {
        try {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO users ([username], [password]) VALUES (?, ?)");
            stmt.setString(1, t.getUsername());
            stmt.setString(2, t.getPassword());
            stmt.setInt(3, t.getRole());
            
            return stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<User> list() {
        ArrayList<User> users = new ArrayList<User>();
        try {
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM users";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                User user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getInt("role"));
                
                users.add(user);
            }
            return users;
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

    @Override
    public User search(int id) {
        return null;
    }
    
    public boolean update(User t, String username) {
        try {
            PreparedStatement stmt = con.prepareStatement("UPDATE users SET username = ?, password = ?, role = ? WHERE username = ?");
            stmt.setString(1, t.getUsername());
            stmt.setString(2, t.getPassword());
            stmt.setInt(3, t.getRole());
            stmt.setString(4, username);
            
            return stmt.executeUpdate() != 0;
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    @Override
    public boolean update(User t) {
        return false;
    }

    @Override
    public boolean delete(int t) {
        return false;
    }

    @Override
    public boolean delete(String username) {
        try {
            String query = "DELETE FROM users WHERE username = ?";
            PreparedStatement stmt = con.prepareStatement((String) query);
            stmt.setString(1, username);
            return stmt.executeUpdate() != 0;
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<User> search(String username) {
        return null;
    }

    @Override
    public User search2(String username) {
        User user = null;
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM users WHERE username = ?");
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getInt("role"));
                
                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

}
