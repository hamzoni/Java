
package Ultility;

import DataModel.*;
import DataStructure.*;
import Entities.*;
import java.io.*;

public class FileIO {
    
    public void writeCustomer(String fn, LL_Customer llc) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fn));
            
            LL_Node p = llc.head;
            while (p != null) {
                Customer c = (Customer) p.value;
                bw.append(c.ccode + " | " + c.name + " | " + c.phone);
                bw.newLine();
                p = p.next;
            }

            bw.close();
        } catch (IOException ex) {
            System.out.println("IOException: Could not write file");
        }
    }
    
    public LL_Customer readCustomer(String fn) {
        LL_Customer llc = null;
        try (BufferedReader br = new BufferedReader(new FileReader(fn))) {
            llc = new LL_Customer();
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                String[] fields = trim(line.split("\\|"));
                Customer c = new Customer();
                
                c.ccode = fields[0];
                c.name = fields[1];
                c.phone = fields[2];
                
                LL_Node nc = new LL_Node(c);
                llc.insertLast(nc);
            }
        } catch (IOException ex) {
            System.out.println("Cannot read file.");
        }
        return llc;
    }
    
    public BST_Train readTrain(String fn) {
        BST_Train bstt = null;
        try (BufferedReader br = new BufferedReader(new FileReader(fn))) {
            bstt = new BST_Train();
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                String[] fields = trim(line.split("\\|"));
                Train c = new Train();
                
                c.tcode = fields[0];
                c.train_name = fields[1];
                c.seat = Integer.parseInt(fields[2]);
                c.booked  = Integer.parseInt(fields[3]);
                c.depart_time = Double.parseDouble(fields[4]);
                c.depart_place = fields[5];
                
                BST_Node nc = new BST_Node(c);
                bstt.insert(nc);
            }
        } catch (IOException ex) {
            System.out.println("Cannot read file.");
        }
        return bstt;
    }
    
    private String[] trim(String[] ss) {
        for (int i = 0; i < ss.length; i++) {
            ss[i] = ss[i].trim();
        }
        return ss;
    }
}
