
package DataStructure;

import Entities.Customer;
import java.io.Serializable;

public class LL_Customer implements Serializable {
     
    private N_Customer head;
    private N_Customer tail;
    
    public void display() {
        N_Customer n = head;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }
    
    public boolean isEmpty() {
        return head == null && tail == null;
    }
    
    public void addFirst(N_Customer nt) {
        if (isEmpty()) {
            head = tail = nt;
            return;
        }
        nt.next = head;
        head= nt;
    }
    
    public void addLast(N_Customer nt) {
        if (isEmpty()) {
            head = tail = nt;
            return;
        }
        tail.next = nt;
        tail = nt;
    }
    
    public void addMany(N_Customer[] customers) {
        for (int i = 0; i < customers.length; i++) {
            addLast(customers[i]);
        }
    }
    
    public Customer search(String ccode) {
        N_Customer n = head;
        while (n != null) {
            if (n.data.ccode.equals(ccode)) {
                return n.data;
            }
            n = n.next;
        }
        return null;
    }
    
    public N_Customer findPrev(N_Customer nt) {
        N_Customer n = head;
        while (n != null) {
            if (n.next == nt) {
                return n;
            }
            n = n.next;
        }
        return null;
    }
    
    public void delete(String ccode) {
        N_Customer n = head;
        while (n != null) {
            if (n.data.ccode.equals(ccode)) {
                N_Customer pn = findPrev(n);
                pn.next = n.next;
                return;
            }
            n = n.next;
        }
    }
    
    public void deleteBefore(String ccode) {
        N_Customer n = head;
        while (n != null) {
            if (n.data.ccode.equals(ccode)) {
                N_Customer pn = findPrev(n);
                delete(pn.data.ccode);
                return;
            }
            n = n.next;
        }
    }
    
    public void sortByCode() {
        N_Customer n = head;
        while (n != null) {
            N_Customer k = head;
            while (k != null) {
                if (k.next == null) break;
                if (k.data.ccode.compareTo(k.next.data.ccode) < 0) {
                    Customer t = k.data;
                    k.data = k.next.data;
                    k.next.data = t;
                }
                k = k.next;
            }
            n = n.next;
        }
    }
    
}
