
package Model;

import Entities.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RoleModel extends Model<Role> {
    
    @Override
    public boolean create(Role t) {
        try {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO roles (username, f_id) VALUES (?, ?)");            
            stmt.setString(1, t.getUsername());
            stmt.setInt(2, t.getFeature().getId());
            return stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(RoleModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<Role> list() {
        ArrayList<Role> roles = new ArrayList<Role>();
        try {
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM roles LEFT JOIN features ON roles.f_id = features.id";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Role role = new Role();
                role.setUsername(rs.getString("username"));
                
                Feature feature = new Feature();
                feature.setId(rs.getInt("id"));
                feature.setFid(rs.getInt("fid"));
                feature.setName(rs.getString("name"));
                feature.setUrl(rs.getString("url"));
                
                role.setFeature(feature);
                roles.add(role);
            }
            return roles;
        } catch (SQLException ex) {
            Logger.getLogger(RoleModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return roles;
    }

    @Override
    public ArrayList<Role> search(String username) {
        ArrayList<Role> roles = new ArrayList<Role>();
        try {
            
            String query = "SELECT * FROM roles LEFT JOIN features ON roles.f_id = features.id WHERE username = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, username);
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Role role = new Role();
                role.setUsername(rs.getString("username"));
                
                Feature feature = new Feature();
                feature.setId(rs.getInt("id"));
                feature.setFid(rs.getInt("fid"));
                feature.setName(rs.getString("name"));
                feature.setUrl(rs.getString("url"));
                
                role.setFeature(feature);
                roles.add(role);
            }
            return roles;
        } catch (SQLException ex) {
            Logger.getLogger(RoleModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return roles;
    }

    @Override
    public boolean update(Role t) {
        try {
            PreparedStatement stmt = con.prepareStatement("UPDATE roles SET f_id = ? WHERE username = ?");
            stmt.setString(1, t.getUsername());
            stmt.setInt(2, t.getFeature().getId());
            return stmt.executeUpdate() != 0;
        } catch (SQLException ex) {
            Logger.getLogger(RoleModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(String t) {
        try {
            String query = "DELETE FROM roles WHERE username = ?";
            PreparedStatement stmt = con.prepareStatement((String) query);
            stmt.setString(1, t);
            return stmt.executeUpdate() != 0;
        } catch (SQLException ex) {
            Logger.getLogger(RoleModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(int t) {
        return false;
    }

    @Override
    public Role search(int i) {
        return null;
    }

    @Override
    public Role search2(String s) {
        return null;
    }
}
