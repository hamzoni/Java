
import DataStructure.*;
import Entities.*;
import File.FileIO;
import File.FileIO2;
import View.View;
import java.util.Scanner;


public class Main {
    
    private Scanner sc;
    
    private FileIO fc;
    private FileIO2 fc2;
    
    private LL_Train llt;
    private LL_Customer llc;
    private LL_Booking llb;
    private View view;
    
    private boolean alive;
    
    public static void main(String[] args) {
        new Main().init();
    }
    
    private void init() {
        alive = true;
        sc = new Scanner(System.in);
        fc = new FileIO();
        fc2 = new FileIO2();
        view = new View();

        // Initalize linked list
        llt = fc2.readTrain("train2.txt");
        llt = new LL_Train();

        llc = fc2.readCustomer("customer2.txt");
        if (llc == null) llc = new LL_Customer();

        llb = fc2.readBooking("booking2.txt");
        llb = new LL_Booking();
        
        llb.addMany(new N_Booking[] {
//            new N_Booking(new Booking("a", "c", 1)),
//            new N_Booking(new Booking("b", "d", 1)),
//            new N_Booking(new Booking("a", "a", 1)),
//            new N_Booking(new Booking("a", "d", 1)),
//            new N_Booking(new Booking("b", "a", 1)),
//            new N_Booking(new Booking("b", "c", 1)),
        });
        
        while (alive) {
            view.menu();
            System.out.println("Your option: ");
            switch (getInt()) {
                case 1: /* Train */
                    menuTrain();
                    break;
                case 2: /* Customer */
                    menuCustomer();
                    break;
                case 3: /* Booking */
                    menuBooking();
                    break;
                case 0:
                    alive = false;
                    break;
            }
        }
        
        
    }
    
    private void menuTrain() {
        boolean alive = true;
        String fn = "";
        while (alive) {
            view.menuTrain();
            System.out.println("Your option: ");
            switch (getInt()) {
                case 1: /* Load */
                    System.out.println("Enter file name: ");
                    fn = sc.nextLine();
                    load(0, fn);
                    break;
                case 2: /* Add to head*/
                    System.out.println("Add Train Head");
                    llt.addFirst(getNTrain());
                    break;
                case 3: /* Display data */
                    view.displayTrain(llt);
                    break;
                case 4: /* Save */
                    System.out.println("Enter file name: ");
                    fn = sc.nextLine();
                    save(0, fn);
                    break;
                case 5: /* Search */
                    System.out.println("Search by tcode: ");
                    String tc = sc.nextLine();
                    Train t = llt.search(tc);
                    view.displayTrain(t);
                    break;
                case 6: /* Delete */
                    System.out.println("Delete by tcode: ");
                    String tc1 = sc.nextLine();
                    llt.delete(tc1);
                    break;
                case 7: /* Sort */
                    System.out.println("Sort by tcode. Sorted");
                    llt.sortByCode();
                    break;
                case 8: /* Add after position k */
                    int pMin = 0;
                    int pMax = llt.size() - 1;
                    
                    if (pMax == -1) {
                        System.out.println("List is empty. Adding to head...");
                        llt.addFirst(getNTrain());
                    } else {
                        System.out.println("Enter position (" + pMin + "-" + pMax +"): ");
                        int k = getIntCond(pMin, pMax);
                        llt.addAfterPos(k, getNTrain());
                    }
                    break;
                case 9: /* Delete before */ 
                    System.out.println("Delete before tcode: ");
                    String tc2 = sc.nextLine();
                    llt.deleteBefore(tc2);
                    break;
                case 10: // Load and display
                    System.out.println("Enter file name: ");
                    String fnt = sc.nextLine(); // train2.txt
                    llt = fc2.readTrain(fnt);
                    view.displayTrain(llt);
                    break;
                case 11: // Search code = 2, name = XY
                    llt.changeName();
                    Train t2 = llt.search("2");
                    System.out.println("Change train 2 name to XY");
                    view.displayTrain(t2);
                    break;
                case 12: // Sort by seat & display
                    System.out.println("SORT BY CODE");
                    llt.sortByCode();
                    view.displayTrain(llt);
                    break;
                case 13: // Sort by seat & display
                    System.out.println("SORT BY SEAT");
                    llt.sortBySeat();
                    view.displayTrain(llt);
                    break;
                case 14:
                    System.out.println("DELETE XY");
                    llt.deleteByName("XY");
                    view.displayTrain(llt);
                    break;
                case 0:
                    alive = false;
                    break;
            }
        }
    }
    
    private N_Train getNTrain() {
        
        N_Train ntrain = new N_Train();
        Train train = new Train();
        // Get tcode
        view.trainAdd(0);
        do {
            train.tcode = sc.nextLine();
            if (!llt.duplicateTCode(train.tcode)) break;
            System.out.println("Duplicated tcode " + train.tcode);
        } while (true);
        
        // Get name
        view.trainAdd(1);
        train.train_name = sc.nextLine();
        
        // Get seated
        view.trainAdd(2);
        train.seat = getIntCond(1, Integer.MAX_VALUE);
        
        // Get booked
        view.trainAdd(3);
        train.booked = getIntCond(0, train.seat);
        
        // Get depart time
        view.trainAdd(4);
        train.depart_time = getDouble();
        
        // Get depart place
        view.trainAdd(5);
        train.depart_place = sc.nextLine();
        
        ntrain.data = train;
        return ntrain;
    }
    
    private void menuCustomer() {
         boolean alive = true;
        String fn = "";
        while (alive) {
            view.menuCustomer();
            System.out.println("Your option: ");
            switch (getInt()) {
                case 1: /* Input & add to the end */
                    System.out.println("Add Customer tail");
                    llc.addLast(getNCustomer());
                    break;
                case 2: /* Display data */
                    view.displayCustomer(llc);
                    break;
                case 3: /* Save customer list to file */
                    System.out.println("Enter file name: ");
                    fn = sc.nextLine();
                    save(1, fn);
                    break;
                case 4: /* Load customer list from file */
                    System.out.println("Enter file name: ");
                    fn = sc.nextLine();
                    load(1, fn);
                    break;
                case 5: /* Search by ccode */
                    System.out.println("Search by tcode: ");
                    String cc = sc.nextLine();
                    Customer c = llc.search(cc);
                    view.displayCustomer(c);
                    break;
                case 6: /* Delete by ccode */
                    System.out.println("Delete by ccode: ");
                    String cc1 = sc.nextLine();
                    llc.delete(cc1);
                    break;
                case 0:
                    alive = false;
                    break;
            }
        }
    }
    
    private N_Customer getNCustomer() {
        N_Customer ncustomer = new N_Customer();
        Customer customer = new Customer();
        // Get ccode
        view.customerAdd(0);
        do {
            customer.ccode = sc.nextLine();
            if (!llc.duplicateTCode(customer.ccode)) break;
            System.out.println("Duplicated tcode " + customer.ccode);
        } while (true);
        
        // Get name
        view.customerAdd(1);
        customer.cus_name = sc.nextLine();
        
        // Get seated
        view.customerAdd(2);
        customer.phone = sc.nextLine();
        
        ncustomer.data = customer;
        return ncustomer;
    }
    
    private void menuBooking() {
        boolean alive = true;
        String fn = "";
        while (alive) {
            view.menuBooking();
            System.out.println("Your option: ");
            switch (getInt()) {
                case 1: /* Input data */
                    System.out.println("==> Train list <==");
                    view.displayTrain(llt);
                    System.out.println("==> Customer list <==");
                    view.displayCustomer(llc);
                    System.out.println("Input data");
                    N_Booking nb = getNBooking();
                    if (nb != null)
                        llb.addLast(nb);
                    break;
                case 2: /* Display booking data */
                    view.displayBooking(llb);
                    break;
                case 3: /* Sort by tcode + ccode */
                    llb.sortByCode();
                    break;
                case 4: /* Save booking list to file */
                    System.out.println("Enter file name: ");
                    fn = sc.nextLine();
                    save(2, fn);
                    break;
                case 5: /* Load booking list from file */
                    System.out.println("Enter file name: ");
                    fn = sc.nextLine();
                    load(2, fn);
                    break;
                case 0:
                    alive = false;
                    break;
            }
        }
    }
    
    private N_Booking getNBooking() {
        N_Booking nbook = new N_Booking();
        Booking book = new Booking();
        boolean add = true;
        if (llt.size() == 0) {
            System.out.println("No Train available.");
            return null;
        }
        if (llc.size() == 0) {
            System.out.println("No Customer available.");
            return null;
        }
        do {
            
            // Get tcode
            do {
                view.addBooking(0);
                book.tcode = sc.nextLine();
                if (llt.duplicateTCode(book.tcode)) break;
                System.out.println(book.tcode + " does not exist");
            } while (true);
            
            // Get ccode
            do {
                view.addBooking(1);
                book.ccode = sc.nextLine();
                if (llc.duplicateTCode(book.ccode)) break;
                System.out.println(book.ccode + " does not exist");
            } while (true);
            
            if (!llb.duplicateBooking(book.tcode, book.ccode)) {
                /* If tcode and ccode found in Traines and customers lists 
                    but booked = seat then inform the user that the train is  exhausted.  
                */
                Train t = llt.search(book.tcode);
                if (t.booked == t.seat) {
                    System.out.println("Train is exhausted.");
                    return null;
                }
                // Get seat
                /* If tcode or ccode found and in the Train list booked < seat and k is the entered seat then if  k <= seat - 
                    booked then data is accepted and  added to the end of the Booking list. 
                */
                do {
                    view.addBooking(2);
                    book.seat = getIntCond(0, Integer.MAX_VALUE);
                    if (t.seat - t.booked >= book.seat) {
                        llt.updateBooked(book.tcode, book.seat);
                        break;
                    }
                    System.out.println("Not enough seat: " + (t.seat - t.booked));
                } while (true);
                break;
            }
            
            System.out.println("Already existed booking.");
            System.out.println("Train Code: " + book.tcode);
            System.out.println("Customer Code: " + book.ccode);
            System.out.print("Try again? (y/n) ");
            if (!sc.nextLine().equals("y")) {
                add = false;
                break;
            }
        } while (true);
        if (add) nbook.data = book;
        if (!add) nbook = null;
        return nbook;
    }
    
    private double getDouble() {
        try {
            return Double.parseDouble(sc.nextLine());
        } catch (Exception e) {
            return getDouble();
        }
    }
    
    private int getIntCond(int min, int max) {
        int n = getInt();
        if (n < min) {
            System.out.println("Input number must be >= " + min);
            return getIntCond(min, max);
        }
        
        if (n > max) {
            System.out.println("Input number must be <= " + max);
            return getIntCond(min, max);
        }
        
        return n;
    }
    
    private int getInt() {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            return getInt();
        }
    }
    
    private void load(int c, String fn) {
        switch (c) {
            case 0:
                llt = fc.read(fn);
                if (llt == null) 
                    llt = new LL_Train();
                break;
            case 1:
                llc = fc.read(fn);
                if (llc == null) 
                    llc = new LL_Customer();
                break;
            case 2:
                llb = fc.read(fn);
                if (llb == null) 
                    llb = new LL_Booking();
                break;
        }
    }
    
    private void save(int c, String fn) {
        switch (c) {
            case 0:
                fc.write(llt, fn);
                break;
            case 1:
                fc.write(llc, fn);
                break;
            case 2:
                fc.write(llb, fn);
                break;
        }
    }
    
}
