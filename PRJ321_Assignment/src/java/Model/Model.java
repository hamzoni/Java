
package Model;

import Database.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Model<E> {
    protected DBConnection db;
    protected Connection con;
    protected String tableName;
    public Model(String tableName) {
        this.db = new DBConnection();
        this.con = db.on();
        this.tableName = tableName;
    }
    
    public abstract boolean create(E t);
    public abstract ArrayList<E> list();
    public abstract E search(int i);
    public abstract boolean update(E t);
    public abstract boolean delete(int t);
    public int count() {
        int c = 0;
        try {
            String query = "SELECT COUNT(*) FROM " + tableName;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) c = rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
}
