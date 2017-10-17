
package Entities;

import java.io.Serializable;
import java.sql.Date;

public class Order implements Serializable {
    private int order_no;
    private Date order_date;
    private String username;

    public Order() {
    }

    public int getOrder_no() {
        return order_no;
    }

    public void setOrder_no(int order_no) {
        this.order_no = order_no;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Order{" + "order_no=" + order_no + ", order_date=" + order_date + ", username=" + username + '}';
    }
    
}
