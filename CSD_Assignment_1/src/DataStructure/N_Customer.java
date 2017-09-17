
package DataStructure;

import Entities.Customer;
import java.io.Serializable;

public class N_Customer implements Serializable {
    public N_Customer next;
    public Customer data;

    public N_Customer() {
    }

    public N_Customer(Customer data) {
        this.data = data;
    }
}
