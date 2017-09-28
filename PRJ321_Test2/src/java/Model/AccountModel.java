
package Model;

import Entities.Account;
import Entities.Role;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccountModel extends Model<Account> {

    public Account login(String username, String password) {
        Account account = null;
        try {
            String query = "SELECT * FROM accounts WHERE username = ? AND password = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                account = new Account();
                account.setUsername(rs.getString("username"));
                account.setPassword(rs.getString("password"));
                return account;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return account;
    }

    @Override
    public boolean create(Account t) {
        try {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO accounts ([username], [password]) VALUES (?, ?)");
            stmt.setString(1, t.getUsername());
            stmt.setString(2, t.getPassword());
            
            for (Role role : t.getRoles()) {
                ModelGroup.roleMdl.create(role);
                System.out.println("ok");
            }
            
            return stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AccountModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<Account> list() {
        ArrayList<Account> accs = new ArrayList<Account>();
        try {
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM accounts";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Account acc = new Account();
                acc.setUsername(rs.getString("username"));
                acc.setPassword(rs.getString("password"));
                
                ArrayList<Role> roles = ModelGroup.roleMdl.search(acc.getUsername());
                acc.setRoles(roles);
                
                accs.add(acc);
            }
            return accs;
        } catch (SQLException ex) {
            Logger.getLogger(AccountModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return accs;
    }

    @Override
    public Account search(int id) {
        return null;
    }

    @Override
    public boolean update(Account t) {
        try {
            PreparedStatement stmt = con.prepareStatement("UPDATE accounts SET username = ? , password = ?");
            stmt.setString(1, t.getUsername());
            stmt.setString(2, t.getPassword());
            return stmt.executeUpdate() != 0;
        } catch (SQLException ex) {
            Logger.getLogger(AccountModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(int t) {
        try {
            String query = "DELETE FROM accounts WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement((String) query);
            stmt.setInt(1, t);
            return stmt.executeUpdate() != 0;
        } catch (SQLException ex) {
            Logger.getLogger(AccountModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(String t) {
        return false;
    }

    @Override
    public ArrayList<Account> search(String username) {
        return null;
    }

    @Override
    public Account search2(String username) {
        Account account = null;
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM accounts WHERE username = ?");
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                account = new Account();
                account.setUsername(rs.getString("username"));
                account.setPassword(rs.getString("password"));
                return account;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return account;
    }
    
}
