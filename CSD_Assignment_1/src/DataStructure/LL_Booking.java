
package DataStructure;

import Entities.Booking;
import java.io.Serializable;

public class LL_Booking implements Serializable {
     
    private N_Booking head;
    private N_Booking tail;
    
    public void display() {
        N_Booking n = head;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }
    
    public boolean isEmpty() {
        return head == null && tail == null;
    }
    
    public void addFirst(N_Booking nt) {
        if (isEmpty()) {
            head = tail = nt;
            return;
        }
        nt.next = head;
        head= nt;
    }
    
    public void addLast(N_Booking nt) {
        if (isEmpty()) {
            head = tail = nt;
            return;
        }
        tail.next = nt;
        tail = nt;
    }
    
    public void addMany(N_Booking[] Bookings) {
        for (int i = 0; i < Bookings.length; i++) {
            addLast(Bookings[i]);
        }
    }
    
    public Booking search(String ccode) {
        N_Booking n = head;
        while (n != null) {
            if (n.data.ccode.equals(ccode)) {
                return n.data;
            }
            n = n.next;
        }
        return null;
    }
    
    public N_Booking findPrev(N_Booking nt) {
        N_Booking n = head;
        while (n != null) {
            if (n.next == nt) {
                return n;
            }
            n = n.next;
        }
        return null;
    }
    
    public void delete(String ccode) {
        N_Booking n = head;
        while (n != null) {
            if (n.data.ccode.equals(ccode)) {
                N_Booking pn = findPrev(n);
                pn.next = n.next;
                return;
            }
            n = n.next;
        }
    }
    
    public void deleteBefore(String ccode) {
        N_Booking n = head;
        while (n != null) {
            if (n.data.ccode.equals(ccode)) {
                N_Booking pn = findPrev(n);
                delete(pn.data.ccode);
                return;
            }
            n = n.next;
        }
    }
    
    public void sortByCode() {
        N_Booking n = head;
        while (n != null) {
            N_Booking k = head;
            while (k != null) {
                if (k.next == null) break;
                if (k.data.ccode.compareTo(k.next.data.ccode) < 0) {
                    Booking t = k.data;
                    k.data = k.next.data;
                    k.next.data = t;
                }
                k = k.next;
            }
            n = n.next;
        }
    }
}
