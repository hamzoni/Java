
package Model;

import Entities.Category;
import Entities.Category;
import Entities.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoryModel extends Model<Category> {

    public CategoryModel(String tableName) {
        super(tableName);
    }
    
    public ArrayList<Category> pagination(int page, int size) {
        ArrayList<Category> categories = new ArrayList<Category>();
        if (page <= 0) return null;
        try {
            String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY id DESC) as r, * FROM " + tableName + ") A "
                    + "WHERE r BETWEEN ? AND ?";
            PreparedStatement pstm =  con.prepareStatement(query);
            pstm.setInt(1, (page - 1) * size + 1);
            pstm.setInt(2, page * size);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
               
                categories.add(category);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categories;
    }
    
    @Override
    public boolean create(Category t) {
        try {
            String query = "INSERT INTO " + tableName + " ([name]) VALUES (?)";
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, t.getName());
            
            return pstm.executeUpdate() != 0;
        } catch (SQLException ex) {
            Logger.getLogger(CategoryModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<Category> list() {
        ArrayList<Category> categories = new ArrayList<Category>();
        try {
            String query = "SELECT * FROM " + tableName;
            PreparedStatement pstm = con.prepareStatement(query);
            
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
               
                categories.add(category);
            }
            return categories;
        } catch (SQLException ex) {
            Logger.getLogger(CategoryModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categories;
    }

    @Override
    public Category search(int i) {
        Category category = null;
        try {
            String query = "SELECT * FROM " + tableName + " WHERE id = ?";
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1, i);
            
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                return category;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return category;
    }

    @Override
    public boolean update(Category t) {
        try {
            String query = "UPDATE " + tableName + " SET [name] = ? WHERE id = ?";
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, t.getName());
            pstm.setInt(2, t.getId());
            
            return pstm.executeUpdate() != 0;
        } catch (SQLException ex) {
            Logger.getLogger(CategoryModel.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CategoryModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
