
package Entities;

public class Customer {
    public String ccode;
    public String name;
    public String phone;

    public Customer() {
    }

    public Customer(String ccode, String name, String phone) {
        this.ccode = ccode;
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return ccode;
//        return "(" + ccode + ", " + name + ", " + phone + ')';
    }
    
}
