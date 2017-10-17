
package Entities;

public class Booking {
    public String tcode;
    public String ccode;
    public int seat;

    public Booking() {
    }

    public Booking(String tcode, String ccode, int seat) {
        this.tcode = tcode;
        this.ccode = ccode;
        this.seat = seat;
    }
    
}
