
package Model;

import Entities.Account;
import Entities.Feature;
import Entities.Role;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FeatureModel extends Model<Feature> {

    @Override
    public boolean create(Feature t) {
        try {
            String query = "INSERT INTO features (url, name, fid) VALUES(?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, t.getUrl());
            stmt.setString(2, t.getName());
            stmt.setInt(3, t.getFid());
            return stmt.executeUpdate() != 0;
        } catch (SQLException ex) {
            Logger.getLogger(FeatureModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<Feature> list() {
        ArrayList<Feature> features = null;
        try {
            features = new ArrayList<Feature>();
            String query = "SELECT * FROM features";
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Feature feature = new Feature();
                feature.setId(rs.getInt("id"));
                feature.setUrl(rs.getString("url"));
                feature.setName(rs.getString("name"));
                feature.setFid(rs.getInt("fid"));
                features.add(feature);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FeatureModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return features;
    }

    @Override
    public Feature search(int id) {
        Feature feature = null;
        try {
            String query = "SELECT * FROM features WHERE id = ?";
            
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                feature = new Feature();
                feature.setId(rs.getInt("id"));
                feature.setUrl(rs.getString("url"));
                feature.setName(rs.getString("name"));
                feature.setFid(rs.getInt("fid"));
                return feature;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FeatureModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return feature;
    }

    @Override
    public Feature search2(String s) {
        return null;
    }

    @Override
    public ArrayList<Feature> search(String s) {
        return null;
    }

    @Override
    public boolean update(Feature t) {
        return false;
    }

    @Override
    public boolean delete(int t) {
        try {
            String query = "DELETE TABLE features WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, t);
            return stmt.executeUpdate() != 0;
        } catch (SQLException ex) {
            Logger.getLogger(FeatureModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(String t) {
        return false;
    }
  
}
