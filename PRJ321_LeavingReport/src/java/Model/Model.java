
package Model;

import DBContext.DBConnection;
import java.sql.Connection;
import java.util.ArrayList;

public abstract class Model<E> {
    protected DBConnection db;
    protected Connection con;
    public Model() {
        this.db = new DBConnection();
        this.con = db.on();
    }
    
    public abstract boolean create(E t);
    public abstract ArrayList<E> list();
    public abstract E search(int i);
    public abstract E search2(String s);
    public abstract ArrayList<E> search(String s);
    public abstract boolean update(E t);
    public abstract boolean delete(int t);
    public abstract boolean delete(String t);
}
