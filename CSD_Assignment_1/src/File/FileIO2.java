
package File;

import DataStructure.*;
import Entities.*;
import java.io.*;

public class FileIO2 {
    public LL_Customer readCustomer(String fn) {
        LL_Customer llc = null;
        try (BufferedReader br = new BufferedReader(new FileReader(fn))) {
            llc = new LL_Customer();
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                String[] fields = trim(line.split("\\|"));
                Customer c = new Customer(fields[0], fields[1], fields[2]);
                N_Customer nc = new N_Customer(c);
                llc.addLast(nc);
            }
        } catch (IOException ex) {
            System.out.println("Cannot read file.");
        }
        return llc;
    }
    
    public LL_Train readTrain(String fn) {
        LL_Train llt = null;
        try (BufferedReader br = new BufferedReader(new FileReader(fn))) {
            llt = new LL_Train();
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                String[] fields = trim(line.split("\\|"));
                Train t = new Train();
                t.tcode = fields[0];
                t.train_name = fields[1];
                t.seat = Integer.parseInt(fields[2]);
                t.booked = Integer.parseInt(fields[3]);
                t.depart_time = Double.parseDouble(fields[4]);
                t.depart_place = fields[5];
                N_Train nt = new N_Train(t);
                llt.addLast(nt);
            }
        } catch (IOException ex) {
            System.out.println("Cannot read file.");
        }
        return llt;
    }
    
    public LL_Booking readBooking(String fn) {
        LL_Booking llb = null;
        try (BufferedReader br = new BufferedReader(new FileReader(fn))) {
            llb = new LL_Booking();
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                String[] fields = trim(line.split("\\|"));
                Booking b = new Booking(fields[0], fields[1], Integer.parseInt(fields[2]));
                N_Booking nb = new N_Booking(b);
                llb.addLast(nb);
            }
        } catch (IOException ex) {
            System.out.println("Cannot read file.");
        }
        return llb;
    }
    
    private String[] trim(String[] ss) {
        for (int i = 0; i < ss.length; i++) {
            ss[i] = ss[i].trim();
        }
        return ss;
    }
}
