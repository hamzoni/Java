
package Entities;

import java.io.Serializable;

public class Product implements Serializable {
    private int product_id;
    private String name;
    private float price;
    
    public Product() {
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" + "product_id=" + product_id + ", name=" + name + ", price=" + price + '}';
    }
    
}
