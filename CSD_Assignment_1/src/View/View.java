
package View;

import DataStructure.LL_Train;
import DataStructure.N_Train;
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
