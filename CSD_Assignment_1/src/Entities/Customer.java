
package Entities;

import java.io.Serializable;

public class Customer implements Serializable {
    public String ccode ;
    public String cus_name;
    public String phone;

    public Customer() {
    }
    
    public Customer(String ccode, String cus_name, String phone) {
        this.ccode = ccode;
        this.cus_name = cus_name;
        this.phone = phone;
    }
    
}
