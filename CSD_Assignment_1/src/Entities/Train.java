
package Entities;

import java.io.Serializable;

public class Train implements Serializable {
    public String tcode;
    public String train_name;
    public int seat;
    public int booked;
    public double depart_time;
    public String depart_place;

    public Train() {
    }
    
    public Train(String tcode, String train_name) {
        this.tcode = tcode;
        this.train_name = train_name;
    }

    public Train(String tcode, String train_name, int seat, int booked, double depart_time, String depart_place) {
        this.tcode = tcode;
        this.train_name = train_name;
        this.seat = seat;
        this.booked = booked;
        this.depart_time = depart_time;
        this.depart_place = depart_place;
    }


    @Override
    public String toString() {
        return "Train(" + tcode + "," + train_name + ")";
    }
    
}
