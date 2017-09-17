
import DataStructure.*;
import Entities.*;
import File.FileIO;
import View.View;
import java.util.Scanner;


public class Main {
    
    private Scanner sc;
    private FileIO fc;
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
        view = new View();
        
        // Initalize linked list
        llt = new LL_Train();
        llc = new LL_Customer();
        llb = new LL_Booking();
        
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
                    System.out.println(">> Add Train Head");
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
    
    private void menuCustomer() {}
    private void menuBooking() {}
    
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
