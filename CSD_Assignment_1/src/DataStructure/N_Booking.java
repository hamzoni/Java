
package DataStructure;

import Entities.Booking;
import java.io.Serializable;

public class N_Booking implements Serializable {
    public N_Booking next;
    public Booking data;

    public N_Booking() {
    }

    public N_Booking(Booking data) {
        this.data = data;
    }
    
}
