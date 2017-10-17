
package Model;

import DBContext.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Model<T> {
    protected DBConnection db;
    protected Connection con;
    protected String table;
    public Model(String table) {
        this.db = new DBConnection();
        this.con = db.on();
        this.table = table;
    }
    
    public abstract boolean create(T ent);
    public abstract boolean update(T ent);
    public abstract <E> T search(E id);
    public abstract <T> boolean delete(T id);
    public abstract ArrayList<T> list();
    public int count() {
        int c = 0;
        try {
            String query = "SELECT COUNT(*) FROM [" + table + "]";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) c = rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
}
