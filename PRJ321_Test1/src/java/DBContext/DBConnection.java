
package DBContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
    private Connection con;
    public DBConnection() {
        try {
            DBConfig cf = new DBConfig();
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://" + cf.HOST + ":" + cf.PORT +  ";databaseName=" + cf.DBNAME,cf.USER, cf.PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        DBConnection db = new DBConnection();
        db.checkCon(db);
    }
    
    public void checkCon(DBConnection db) {
        if (db.con == null) {
            System.out.println("null");
        }
    }
    
    public Connection on() {
        return con;
    }
    public void close() throws SQLException {
        con.close();
    }
}