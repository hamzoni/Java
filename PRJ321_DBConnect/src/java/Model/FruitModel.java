
package Model;

import Entities.Fruit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FruitModel extends Model<Fruit> {

    public FruitModel(String table) {
        super(table);
    }
    
    
    @Override
    public boolean create(Fruit fruit) {
        try {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO " + this.table + "(name, price) + VALUES (?, ?)");
            stmt.setString(1, fruit.getName());
            stmt.setFloat(2, fruit.getPrice());
            return stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(FruitModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    @Override
    public ArrayList<Fruit> list() {
        ArrayList<Fruit> fruits = new ArrayList<Fruit>();
        try {
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM " + this.table;
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Fruit fruit = new Fruit();
                fruit.setId(rs.getInt("id"));
                fruit.setName(rs.getString("name"));
                fruit.setPrice(rs.getFloat("price"));
                fruits.add(fruit);
            }
            return fruits;
        } catch (SQLException ex) {
            Logger.getLogger(FruitModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fruits;
    }

    @Override
    public boolean update(Fruit fruit) {
        try {
            PreparedStatement stmt = con.prepareStatement("UPDATE " + this.table + " SET name = ? , price = ?");
            stmt.setString(1, fruit.getName());
            stmt.setFloat(2, fruit.getPrice());
            return stmt.executeUpdate() != 0;
        } catch (SQLException ex) {
            Logger.getLogger(FruitModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public <T> boolean delete(T t) {
        try {
            Statement stmt = con.createStatement();
            String query = "DELETE FROM " + this.table + " WHERE id = " + t;
            stmt.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(FruitModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Fruit search(int id) {
        Fruit fruit = null;
        try {
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM " + this.table + " WHERE id = " + id;
            ResultSet rs = stmt.executeQuery(query);
            Fruit mfruit = new Fruit();
            while (rs.next()) {
                mfruit.setId(rs.getInt("id"));
                mfruit.setName(rs.getString("name"));
                mfruit.setPrice(rs.getFloat("price"));
                return mfruit;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FruitModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fruit;
    }
    
}
