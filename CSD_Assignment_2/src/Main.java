
import DataStructure.*;
import DataModel.*;
import Entities.*;
import Model.Data;
import Ultility.FileIO;
import Ultility.Tool;
import View.View;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private boolean alive;

    private View view;
    private Scanner sc;
    private Tool tool;
    private FileIO fc;

    public static void main(String[] args) {
        new Main().init();
    }

    private void test() {
        Data.bstt.insertMany(new BST_Node[]{
            new BST_Node(new Train("2", "BBB", 1, 1, 1, "b")),
            new BST_Node(new Train("1", "AAA", 1, 1, 1, "a")),
            new BST_Node(new Train("4", "DDD", 1, 1, 1, "d")),
            new BST_Node(new Train("3", "CCC", 1, 1, 1, "c")),
            new BST_Node(new Train("6", "FFF", 1, 1, 1, "f")),
            new BST_Node(new Train("5", "EEE", 1, 1, 1, "e")),});
        Data.bstt.inorder();
        System.out.println("");
    }

    private void init() {

        alive = true;
        view = new View();
        sc = new Scanner(System.in);
        tool = new Tool();
        fc = new FileIO();

        while (alive) {
            view.menu();
            switch (tool.getInt()) {
                case 1:
                    trainMenu();
                    break; // Train
                case 2:
                    customerMenu();
                    break; // Customer
                case 3:
                    bookingMenu();
                    break; // Booking
                case 0:
                    System.out.println("Program ended.");
                    alive = false;
                    break;
            }
        }

    }

    private void bookingMenu() {
        boolean alive = true;

        while (alive) {
            view.menuBooking();
            switch (tool.getInt()) {
                case 1:
                    LL_Node bn = getBooking();
                    Data.llb.insertFirst(bn);
                    break; // Input data
                case 2:
                    System.out.println(">> BOOKING LIST <<");
                    view.displayBooking(Data.llb);
                    break; // Display booking data
                case 3:
                    Data.llb.sortByCode();
                    System.out.println("Booking sorted.");
                    break; // Sort  by pcode + ccode
                case 0:
                    alive = false;
                    break;
            }
        }
    }

    private LL_Node getBooking() {
        Booking b = new Booking();

        if (Data.bstt.count() == 0 || Data.llc.size() == 0) {
            System.out.println("Insufficient data");
            return null;
        }

        System.out.println(">> TRAIN LIST <<");
        view.displayTrainHeader();
        Data.bstt.inorder();

        System.out.println(">> CUSTOMERS LIST <<");
        view.displayCustomer(Data.llc);

        // Getting input for booking data
        // Get train code:
        do {
            System.out.println("Enter Train Code: ");
            b.tcode = sc.nextLine();
            if (Data.bstt.isExist(b.tcode)) {
                break;
            }
            System.out.println("TCode " + b.tcode + " does not exists");
            if (!askCont()) {
                return null;
            }
        } while (true);

        // Get customer code:
        do {
            System.out.println("Enter Customer Code: ");
            b.ccode = sc.nextLine();
            if (Data.llc.isExist(b.ccode)) {
                break;
            }
            System.out.println("CCode " + b.ccode + " does not exists");
            if (!askCont()) {
                return null;
            }
        } while (true);

        System.out.println("Enter Seats: ");
        b.seat = tool.getIntCond(0, Integer.MAX_VALUE);

        LL_Node bn = new LL_Node(b);
        return bn;
    }

    private boolean askCont() {
        System.out.println("Try again? (y/n) ");
        String a = sc.nextLine();
        return a.equals("y");
    }

    private void customerMenu() {
        boolean alive = true;

        while (alive) {
            view.menuCustomer();
            switch (tool.getInt()) {
                case 1:
                    System.out.println("Enter file name: ");
                    String fn = sc.nextLine();
                    Data.llc = fc.readCustomer(fn);
                    break; // Load data from file
                case 2:
                    LL_Node cn = getCustomer();
                    Data.llc.insertLast(cn);
                    break; // Input & add to the end
                case 3:
                    System.out.println(">> CUSTOMERS LIST <<");
                    view.displayCustomer(Data.llc);
                    break; // Display data
                case 4:
                    System.out.println("Enter file name: ");
                    fn = sc.nextLine();
                    fc.writeCustomer(fn, Data.llc);
                    break; // Save customer list to file
                case 5:
                    System.out.println("Enter CCode: ");
                    String ccodef = sc.nextLine();
                    view.displayCustomer(Data.llc.search(ccodef));
                    break; // Search by ccode
                case 6:
                    System.out.println("Enter CCode: ");
                    String ccoded = sc.nextLine();
                    Data.llc.deleteVal(ccoded);
                    break; // Delete by ccode
                case 0:
                    alive = false;
                    break;
            }
        }
    }

    private LL_Node getCustomer() {
        Customer c = new Customer();

        // Get customer ccode
        System.out.println("Enter customer code: ");
        do {
            c.ccode = sc.nextLine();
            if (!Data.llc.isExist(c.ccode)) {
                break;
            }
            System.out.println("CCode: " + c.ccode + " is already existed.");
        } while (true);

        // Get customer name
        System.out.println("Enter customer name: ");
        c.name = sc.nextLine();

        // Get customer phoine
        System.out.println("Enter customer phone: ");
        do {
            c.phone = sc.nextLine();
            if (!c.phone.matches("\\D+")) {
                break;
            }
            System.out.println("Err: only digits allowed.");
        } while (true);

        System.out.println("Add new customer successful");
        LL_Node n = new LL_Node(c);
        return n;
    }

    private void trainMenu() {
        boolean alive = true;
        while (alive) {
            view.menuTrain();
            switch (tool.getInt()) {
                case 1:
                    System.out.println("Enter file name: ");
                    String fn = sc.nextLine();
                    Data.bstt = fc.readTrain(fn);
                    break; // Load data from file
                case 2:
                    BST_Node tn = getTrain();
                    Data.bstt.insert(tn);
                    break; // Input & Insert data
                case 3:
                    view.displayTrainHeader();
                    Data.bstt.inorder();
                    break; // In-order traverse
                case 4:
                    view.displayTrainHeader();
                    Data.bstt.breadthfirst();
                    break; // Breadth-first traverse
                case 5:
                    System.out.println("Enter file name: ");
                    String fnt = sc.nextLine();
                    try {
                        Data.bstt.saveInorder(fnt);
                    } catch (IOException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                break; // In-order traverse to file
                case 6:
                    System.out.println("Enter TCode: ");
                    Train t = Data.bstt.search(sc.nextLine());
                    view.displayTrainHeader();
                    View.displayTrain(t);
                    break; // Search by tcode
                case 7:
                    System.out.println("Enter TCode: ");
                    Data.bstt.delcopy(sc.nextLine());
                    break; // Delete by tcode by copying
                case 8:
                    Data.bstt.balancing();
                    System.out.println("Tree balanced");
                    break; // Simply balancing
                case 9:
                    int tc = Data.bstt.count();
                    System.out.println("Count trains: " + tc);
                    break; // Count number of trains
                case 0:
                    alive = false;
                    break;
            }
        }
    }

    private BST_Node getTrain() {
        BST_Node tn = new BST_Node();
        Train t = new Train();

        // Get tcode - train code must be unique
        do {
            System.out.println("Enter TCode: ");
            t.tcode = sc.nextLine();
            if (!Data.bstt.isExist(t.tcode)) {
                break;
            }
            System.out.println("TCode " + t.tcode + " is already existed.");
        } while (true);

        System.out.println("Enter Train name: ");
        t.train_name = sc.nextLine();

        System.out.println("Enter Seat: ");
        t.seat = tool.getIntCond(1, Integer.MAX_VALUE);

        System.out.println("Enter Booked: ");
        t.booked = tool.getIntCond(0, t.seat);

        System.out.println("Enter depart time: ");
        t.depart_time = tool.getDoubleCond(0, Double.MAX_VALUE);

        System.out.println("Enter depart place: ");
        t.depart_place = sc.nextLine();

        tn.value = t;
        return tn;
    }

}
