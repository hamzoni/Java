
package Model;

import DBContext.DBConnection;
import java.sql.Connection;
import java.util.ArrayList;

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
    
}
