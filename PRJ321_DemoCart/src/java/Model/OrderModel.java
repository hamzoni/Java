
package Model;

import Entities.Order;
import java.util.ArrayList;

public class OrderModel extends Model<Order> {

    public OrderModel(String tableName) {
        super(tableName);
    }

    @Override
    public boolean create(Order t) {
        return false;
    }

    @Override
    public ArrayList<Order> list() {
        return null;
    }

    @Override
    public Order search(int i) {
        return null;
    }

    @Override
    public boolean update(Order t) {
        return false;
    }

    @Override
    public boolean delete(int t) {
        return false;
    }
    
}
