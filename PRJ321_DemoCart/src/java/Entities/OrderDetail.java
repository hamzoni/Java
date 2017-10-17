
package Entities;

import java.io.Serializable;

public class OrderDetail implements Serializable {
    private int order_no;
    private int product_id;
    private int quantity;
    private float price;
    
    private Product prd;
    
    public OrderDetail() {
    }

    public int getOrder_no() {
        return order_no;
    }

    public void setOrder_no(int order_no) {
        this.order_no = order_no;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Product getPrd() {
        return prd;
    }

    public void setPrd(Product prd) {
        this.prd = prd;
    }

    @Override
    public String toString() {
        return "OrderDetail{" + "order_no=" + order_no + ", product_id=" + product_id + ", quantity=" + quantity + ", price=" + price + ", prd=" + prd + '}';
    }
    
    
}
