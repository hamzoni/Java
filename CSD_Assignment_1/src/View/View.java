
package View;

import DataStructure.LL_Booking;
import DataStructure.LL_Customer;
import DataStructure.LL_Train;
import DataStructure.N_Booking;
import DataStructure.N_Customer;
import DataStructure.N_Train;
import Entities.Booking;
import Entities.Customer;
import Entities.Train;

public class View {
    public void menu() {
        String contents[] = {"Train", "Customer", "Booking"};
        System.out.println("===>>MAIN MENU<<===");
        for (int i = 0; i < contents.length; i++) {
            System.out.println((i + 1) + ". " + contents[i]);
        }
        System.out.println("0. Exit");
    }
    
    public void menuBooking() {
        String contents[] = {
            "Input data", "Display booking data", "Sort by tcode + ccode",
            "Save booking", "Load booking"
        };
        System.out.println("===>>BOOKING<<===");
        for (int i = 0; i < contents.length; i++) {
            System.out.println((i + 1) + ". " + contents[i]);
        }
        System.out.println("0. Exit");
    }
    
    public void addBooking(int i) {
        String contents[] = {
            "Enter TCode", "Enter CCode", "Enter Seat"
        };
        System.out.println("Enter " + contents[i] + ": ");
    }
    
    public void menuCustomer() {
        String contents[] = {
            "Input & add to the end", "Display data", "Save customer list",
            "Load customer list","Search by ccode", "Delete by ccode"
        };
        System.out.println("===>>CUSTOMER<<===");
        for (int i = 0; i < contents.length; i++) {
            System.out.println((i + 1) + ". " + contents[i]);
        }
        System.out.println("0. Exit");
    }
    
    public void customerAdd(int i) {
        String contents[] = {"CCode", "Name", "Phone"};
        System.out.println("Enter " + contents[i] + ": ");
    }
    
    public void menuTrain() {
        String contents[] = {
            "Load from file", "Add to head", "Display data", "Save to file", 
            "Search by tcode", "Delete by tcode", "Sort by tcode", 
            "Add after position k", "Delete node before tcode"
        };
        System.out.println("===>>TRAIN<<===");
        for (int i = 0; i < contents.length; i++) {
            System.out.println((i + 1) + ". " + contents[i]);
        }
        System.out.println("0. Exit");
    }
    public void trainAdd(int i) {
        String contents[] = {"TCode", "Name", "Seat", "Booked", "Depart time", "Depart place"};
        System.out.println("Enter " + contents[i] + ": ");
    }
    
    public void displayBooking(LL_Booking llb) {
        String[] headers = {
            "tcode", "ccode", "seat"
        };
        int[] styles = {10, 10, 10};
        // print header
        tableBorder(styles);
        tableHeader(styles, headers);
        tableBorder(styles);
        
        N_Booking n = llb.head;
        while (n != null) {
            Booking b = n.data;
            tableHeader(styles, new String[] {
                b.tcode, b.ccode, b.seat + ""
            });
            tableBorder(styles);
            n = n.next;
        }
    }
    
    public void displayCustomer(Customer c) {
        String[] headers = {
            "ccode", "name", "phone"
        };
        int[] styles = {10, 20, 15};
        // print header
        tableBorder(styles);
        tableHeader(styles, headers);
        tableBorder(styles);
        
        if (c != null) {
            tableHeader(styles, new String[] {
                c.ccode, c.cus_name, c.phone
            });
        } else {
            System.out.println("No Result.");
        }
        tableBorder(styles);
    }
    
    public void displayCustomer(LL_Customer llc) {
        String[] headers = {
            "ccode", "name", "phone"
        };
        int[] styles = {10, 20, 15};
        // print header
        tableBorder(styles);
        tableHeader(styles, headers);
        tableBorder(styles);
        
        N_Customer n = llc.head;
        while (n != null) {
            Customer c = n.data;
            tableHeader(styles, new String[] {
                c.ccode, c.cus_name, c.phone
            });
            tableBorder(styles);
            n = n.next;
        }
    }
    
    public void displayBooking(Booking b) {
        String[] headers = {
            "ccode", "name", "phone"
        };
        int[] styles = {10, 10, 10};
        // print header
        tableBorder(styles);
        tableHeader(styles, headers);
        tableBorder(styles);
        
        if (b != null) {
            tableHeader(styles, new String[] {
                b.tcode, b.ccode, b.seat + ""
            });
        } else {
            System.out.println("No Result.");
        }
        tableBorder(styles);
    }
    
    public void displayTrain(LL_Train llt) {
        String[] headers = {
            "tcode", "train_name", "seat", "booked",
            "depart_time", "depart_place", "availabe_seat"
        };
        int[] styles = {10, 20, 10, 10, 15, 15, 15};
        // print header
        tableBorder(styles);
        tableHeader(styles, headers);
        tableBorder(styles);
        
        N_Train n = llt.head;
        while (n != null) {
            Train t = n.data;
            tableHeader(styles, new String[] {
                t.tcode, t.train_name, t.seat + "",
                t.booked  + "", t.depart_time  + "", 
                t.depart_place, t.seat - t.booked + ""
            });
            tableBorder(styles);
            n = n.next;
        }
    }
    
    public void displayTrain(Train t) {
        String[] headers = {
            "tcode", "train_name", "seat", "booked",
            "depart_time", "depart_place", "availabe_seat"
        };
        int[] styles = {10, 20, 10, 10, 15, 15, 15};
        // print header
        tableBorder(styles);
        tableHeader(styles, headers);
        tableBorder(styles);
        
        if (t == null) {
            System.out.println("No Result.");
            return;
        }
 
        tableHeader(styles, new String[] {
            t.tcode, t.train_name, t.seat + "",
            t.booked  + "", t.depart_time  + "", 
            t.depart_place, t.seat - t.booked + ""
        });
        tableBorder(styles);
    }
    
    public void tableHeader(int[] styles, String[] headers) {
        for (int i = 0; i < styles.length; i++) {
            System.out.print("|");
            System.out.print(tableCell(styles[i], headers[i]));
        }
        System.out.println("|");
    }
    
    public String tableCell(int style, String content) {
        String s = content;
        int offset = style - content.length();
        for (int i = 0; i < offset; i++) {
            content += " ";
        }
        return content;
    }
    
    public void tableBorder(int[] styles) {
        for (int i = 0; i < styles.length; i++) {
            System.out.print("+");
            for (int j = 0; j < styles[i]; j++) {
                System.out.print("-");
            }
        }
        System.out.println("+");
    }
    
}
