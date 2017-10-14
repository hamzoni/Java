
package Model;

import Entities.Category;
import Entities.Post;
import Entities.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserModel extends Model<User> {

    public UserModel(String tableName) {
        super(tableName);
    }
    
    public User login(String login, String password) {
        User user = null;
        try {
            String query = "SELECT * FROM " + tableName + " WHERE (username = ? OR email = ?) AND password = ?";
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, login);
            pstm.setString(2, login);
            pstm.setString(3, password);
            
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setPrivilege(rs.getInt("privilege"));
                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
    
    public ArrayList<User> pagination(int page, int size) {
        ArrayList<User> users = new ArrayList<User>();
        if (page <= 0) return null;
        try {
            String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY id DESC) as r, * FROM " + tableName + ") A WHERE r BETWEEN ? AND ?";
            PreparedStatement pstm =  con.prepareStatement(query);
            pstm.setInt(1, (page - 1) * size + 1);
            pstm.setInt(2, page * size);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                User user = new User();
                
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setPrivilege(rs.getInt("privilege"));
                
                users.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
    
    @Override
    public boolean create(User t) {
        try {
            String query = "INSERT INTO " + tableName + " ([name], [email], [username], [password], [privilege])"
                    + " VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, t.getName());
            pstm.setString(2, t.getEmail());
            pstm.setString(3, t.getUsername());
            pstm.setString(4, t.getPassword());
            pstm.setInt(5, t.getPrivilege());
            
            return pstm.executeUpdate() != 0;
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<User> list() {
        ArrayList<User> users = new ArrayList<User>();
        try {
            String query = "SELECT * FROM " + tableName;
            PreparedStatement pstm = con.prepareStatement(query);
            
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setPrivilege(rs.getInt("privilege"));
                users.add(user);
            }
            return users;
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

    @Override
    public User search(int i) {
        User user = null;
        try {
            String query = "SELECT * FROM " + tableName + " WHERE id = ?";
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1, i);
            
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setPrivilege(rs.getInt("privilege"));
                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    @Override
    public boolean update(User t) {
        try {
            String query = "UPDATE " + tableName + " SET [name] = ?, [email] = ?, [username] = ?, [password] = ?, [privilege] = ? WHERE id = ?";
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, t.getName());
            pstm.setString(2, t.getEmail());
            pstm.setString(3, t.getUsername());
            pstm.setString(4, t.getPassword());
            pstm.setInt(5, t.getPrivilege());
            pstm.setInt(6, t.getId());
            
            return pstm.executeUpdate() != 0;
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(int t) {
        try {
            String query = "DELETE FROM " + tableName + " WHERE id = ?";
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1, t);
            
            return pstm.executeUpdate() != 0;
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
