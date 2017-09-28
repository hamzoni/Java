
package DataStructure;

import Entities.Booking;
import java.io.Serializable;

public class LL_Booking implements Serializable {
     
    public N_Booking head;
    public N_Booking tail;
    
    public void display() {
        N_Booking n = head;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }
    
    public boolean duplicateBooking(String tcode, String ccode) {
        N_Booking n = head;
        while (n != null) {
            if (n.data.tcode.equals(tcode) && n.data.ccode.equals(ccode)) {
                return true;
            }
            n = n.next;
        }
        return false;
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
                if (k.data.tcode.compareTo(k.next.data.tcode) > 0) {
                    Booking t = k.data;
                    k.data = k.next.data;
                    k.next.data = t;
                }
                k = k.next;
            }
            n = n.next;
        }
        
        n = head;
        int i = 0;
        int a;
        int b = -1;
        while (n != null) {
            
            if (i > b) {
                a = i;
                b = i;
                N_Booking m = n;
                while (m != null) {
                    if (m.next == null) break;
                    if (m.next.data.tcode.equals(m.data.tcode)) {
                        b++;
                    } else {
                        break;
                    }
                    m = m.next;
                }
                sortByTCode(a, b, n);
            }
            
            i++;
            n = n.next;
        }
    }
    
    private void sortByTCode(int a, int b, N_Booking n) {
        int i = a;
        while (n != null) {

            int j = i;
            N_Booking m = n;
            while (m != null) {
                if (j == b || m.next == null) break;
                if (m.data.ccode.compareTo(m.next.data.ccode) > 0) {
                    Booking temp = m.data;
                    m.data = m.next.data;
                    m.next.data = temp;
                }
                j++;
                m = m.next;
            }

            i++;
            n = n.next;
        }
    }
}
