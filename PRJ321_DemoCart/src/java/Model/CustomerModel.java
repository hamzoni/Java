
package Model;

import Entities.Customer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerModel extends Model<Customer> {

    public CustomerModel(String tableName) {
        super(tableName);
    }

    public Customer login(String username, String password) {
        Customer acc = null;
        try {
            String query = "SELECT * FROM " + tableName + " WHERE [username] = ? AND [password] = ?";
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, username);
            pstm.setString(2, password);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                acc = new Customer();
                acc.setUsername(rs.getString("username"));
                acc.setPassword(rs.getString("password"));
                return acc;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return acc;
    }
    
    @Override
    public boolean create(Customer t) {
        try {
            String query = "INSERT INTO " + tableName + "([username], [password]) VALUES(?, ?)";
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, t.getUsername());
            pstm.setString(2, t.getPassword());
            return pstm.executeUpdate() != 0;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<Customer> list() {
        ArrayList<Customer> customers = new ArrayList<Customer>();
        try {
            String query = "SELECT * FROM " + tableName ;
            PreparedStatement pstm = con.prepareStatement(query);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setUsername(rs.getString("username"));
                customer.setPassword(rs.getString("password"));
                customers.add(customer);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customers;
    }

    @Override
    public Customer search(int i) {
        
        return null;
    }

    @Override
    public boolean update(Customer t) {
        try {
            String query = "INSERT INTO " + tableName + "([username], [password]) VALUES(?, ?)";
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, t.getUsername());
            pstm.setString(2, t.getPassword());
            return pstm.executeUpdate() != 0;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(int t) {
        try {
            String query = "INSERT INTO " + tableName + "([username], [password]) VALUES(?, ?)";
            PreparedStatement pstm = con.prepareStatement(query);
            return pstm.executeUpdate() != 0;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
