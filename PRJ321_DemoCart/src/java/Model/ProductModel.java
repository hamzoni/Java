
package Model;

import Entities.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductModel extends Model<Product> {

    public ProductModel(String tableName) {
        super(tableName);
    }

    @Override
    public boolean create(Product t) {
        return false;
    }

    @Override
    public ArrayList<Product> list() {
        ArrayList<Product> lists = new ArrayList<Product>();
        try {
            String query = "SELECT * FROM " + tableName ;
            PreparedStatement pstm = con.prepareStatement(query);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                
                product.setProduct_id(rs.getInt("product_id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getFloat("price"));
                
                lists.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lists;
    }

    @Override
    public Product search(int i) {
        Product prd = null;
        try {
            String query = "SELECT * FROM " + tableName + " WHERE product_id = ?";
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1, i);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                prd = new Product();
                
                prd.setProduct_id(rs.getInt("product_id"));
                prd.setName(rs.getString("name"));
                prd.setPrice(rs.getFloat("price"));
                
                return prd;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prd;
    }

    @Override
    public boolean update(Product t) {
        return false;
    }

    @Override
    public boolean delete(int t) {
        return false;
    }
    
}
