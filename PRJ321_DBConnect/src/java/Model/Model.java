
package Model;

import DBContext.DBConnection;
import Entities.Fruit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public abstract class Model<E> {
    protected DBConnection db;
    protected Connection con;
    protected String table;
    public Model(String table) {
        this.db = new DBConnection();
        this.con = db.on();
        this.table = table;
    }
    
    public abstract boolean create(E t);
    public abstract ArrayList<E> list();
    public abstract E search(int id);
    public abstract boolean update(E t);
    public abstract <T> boolean delete(T t);
    
}
