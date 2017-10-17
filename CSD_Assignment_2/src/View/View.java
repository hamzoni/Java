
package View;

import DataModel.LL_Booking;
import DataModel.LL_Customer;
import DataStructure.LL_Node;
import Entities.Booking;
import Entities.Customer;
import Entities.Train;

public class View {
    public void menu() {
        System.out.println(">>> MAIN <<<");
        String[] menus = {"Train", "Customer", "Booking"};
        for (int i = 0; i < menus.length; i++) {
            System.out.println((i + 1) + ". " + menus[i]);
        }
        System.out.println("0. Exit");
        System.out.print("Option: ");
    }
    
    public void menuBooking() {
        System.out.println(">>> BOOKING <<<");
        String[] opts = {"Input data", "Display booking data", "Sort by pcode + ccode"};
        for (int i = 0; i < opts.length; i++) {
            System.out.println((i + 1) + ". " + opts[i]);
        }
        System.out.println("0. Exit");
        System.out.print("Option: ");
    }
    
    public void menuCustomer() {
        System.out.println(">>> CUSTOMER <<<");
        String[] opts = {"Load data from file", "Input & add to the end", "Display data", 
            "Save customer list to file", "Search by ccode", "Delete by ccode"};
        for (int i = 0; i < opts.length; i++) {
            System.out.println((i + 1) + ". " + opts[i]);
        }
        System.out.println("0. Exit");
        System.out.print("Option: ");
    }
    
    public void menuTrain() {
        System.out.println(">>> TRAIN <<<");
        String[] opts = {"Load data from file", "Input & Insert data", "In-order traverse",
        "Breadth-first traverse", "In-order traverse to file", "Search by tcode", "Delete by tcode",
        "Simply balancing", "Count number of trains"};
        for (int i = 0; i < opts.length; i++) {
            System.out.println((i + 1) + ". " + opts[i]);
        }
        System.out.println("0. Exit");
        System.out.print("Option: ");
    }
    
    public void displayBooking(LL_Booking bookings) {
        int[] styles = {10, 10, 5};
        displayBookingHeader(styles);
        
        LL_Node p = bookings.head;
        if (p == null) System.out.println("No Record");
        while (p != null) {
            Booking b = (Booking) p.value;
            View.tableHeader(styles, new String[] {
                b.tcode, b.ccode, b.seat + ""
            });
            View.tableBorder(styles);
            p = p.next;
        }
    }
    
    private void displayBookingHeader(int[] styles) {
        // Display headers
        String[] headers = {"TCode", "CCode", "Seats"};
        tableBorder(styles);
        View.tableHeader(styles, headers);
        tableBorder(styles);
    }
    
    public void displayCustomer(LL_Node cn) {
        Customer c = (Customer) cn.value;
        
        int[] styles = {10, 15, 15};
        displayCustomerHeader(styles);
        
        if (c == null) System.out.println("No Record");
        View.tableHeader(styles, new String[] {
            c.ccode, c.name, c.phone
        });
        View.tableBorder(styles);
    }
    
    public void displayCustomer(LL_Customer customers) {
        int[] styles = {10, 15, 15};
        displayCustomerHeader(styles);
        
        LL_Node p = customers.head;
        if (p == null) System.out.println("No Record");
        while (p != null) {
            Customer c = (Customer) p.value;
            View.tableHeader(styles, new String[] {
                c.ccode, c.name, c.phone
            });
            View.tableBorder(styles);
            p = p.next;
        }
    }
    
    private void displayCustomerHeader(int[] styles) {
        // Display headers
        String[] headers = {"CCode", "Name", "Phone"};
        tableBorder(styles);
        View.tableHeader(styles, headers);
        tableBorder(styles);
    }

    public void displayTrainHeader() {
        String[] headers = {
            "tcode", "train_name", "seat", "booked",
            "depart_time", "depart_place", "availabe_seat"
        };
        int[] styles = {10, 20, 10, 10, 15, 15, 15};
        // print header
        tableBorder(styles);
        tableHeader(styles, headers);
        tableBorder(styles);
    }
    
    public static void displayTrain(Train t) {
        int[] styles = {10, 20, 10, 10, 15, 15, 15};
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
    
    private static void tableHeader(int[] styles, String[] headers) {
        for (int i = 0; i < styles.length; i++) {
            System.out.print("|");
            System.out.print(tableCell(styles[i], headers[i]));
        }
        System.out.println("|");
    }
    
    private static String tableCell(int style, String content) {
        String s = content;
        int offset = style - content.length();
        for (int i = 0; i < offset; i++) {
            content += " ";
        }
        return content;
    }
    
    private static void tableBorder(int[] styles) {
        for (int i = 0; i < styles.length; i++) {
            System.out.print("+");
            for (int j = 0; j < styles[i]; j++) {
                System.out.print("-");
            }
        }
        System.out.println("+");
    }
}
