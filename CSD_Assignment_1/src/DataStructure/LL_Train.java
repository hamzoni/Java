
package DataStructure;

import Entities.Train;
import java.io.Serializable;

public class LL_Train implements Serializable {
    
    public N_Train head;
    public N_Train tail;
    
    public void display() {
        N_Train n = head;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }
    
    public void changeName() {
        N_Train n = head;
        while (n != null) {
            if (n.data.tcode.equals("2")) {
                n.data.train_name = "XY";
                break;
            }
            n = n.next;
        }
    }
    
    public int size() {
        N_Train n = head;
        int counter = 0;
        while (n != null) {
            counter++;
            n = n.next;
        }
        return counter;
    }
    
    public boolean isEmpty() {
        return head == null && tail == null;
    }
    
    public boolean duplicateTCode(String tcode) {
        N_Train n = head;
        while (n != null) {
            if (n.data.tcode.equals(tcode))
                return true;
            n = n.next;
        }
        return false;
    }
    
    public void addFirst(N_Train nt) {
        if (isEmpty()) {
            head = tail = nt;
            return;
        }
        nt.next = head;
        head= nt;
    }
    
    public void addLast(N_Train nt) {
        if (isEmpty()) {
            head = tail = nt;
            return;
        }
        tail.next = nt;
        tail = nt;
    }
    
    public void addAfterPos(int k, N_Train nt) {
        N_Train n = head;
        int counter = 0;
        while (n != null) {
            if (counter == k) {
                nt.next = n.next;
                n.next = nt;
                return;
            }
            counter++;
            n = n.next;
        }
    }
    
    public void addMany(N_Train[] trains) {
        for (int i = 0; i < trains.length; i++) {
            addLast(trains[i]);
        }
    }
    
    public Train search(String tcode) {
        N_Train n = head;
        while (n != null) {
            if (n.data.tcode.equals(tcode)) {
                return n.data;
            }
            n = n.next;
        }
        return null;
    }
    
    public N_Train findPrev(N_Train nt) {
        N_Train n = head;
        while (n != null) {
            if (n.next == nt) {
                return n;
            }
            n = n.next;
        }
        return null;
    }
    
    public void delete(String tcode) {
        N_Train n = head;
        while (n != null) {
            if (n.data.tcode.equals(tcode)) {
                N_Train pn = findPrev(n);
                if (pn != null) {
                    pn.next = n.next;
                } else {
                    head = n.next;
                }
                return;
            }
            n = n.next;
        }
    }
    
    public void deleteByName(String name) {
        N_Train n = head;
        while (n != null) {
            if (n.data.train_name.equals(name)) {
                N_Train pn = findPrev(n);
                if (pn != null) {
                    pn.next = n.next;
                } else {
                    head = n.next;
                }
                return;
            }
            n = n.next;
        }
    }
    
    public void deleteBefore(String tcode) {
        N_Train n = head;
        while (n != null) {
            if (n.data.tcode.equals(tcode)) {
                N_Train pn = findPrev(n);
                delete(pn.data.tcode);
                return;
            }
            n = n.next;
        }
    }
    
    public void sortByCode() {
        N_Train n = head;
        while (n != null) {
            N_Train k = head;
            while (k != null) {
                if (k.next == null) break;
                if (k.data.tcode.compareTo(k.next.data.tcode) < 0) {
                    Train t = k.data;
                    k.data = k.next.data;
                    k.next.data = t;
                }
                k = k.next;
            }
            n = n.next;
        }
    }
    
    public void sortBySeat() {
        N_Train n = head;
        while (n != null) {
            N_Train k = head;
            while (k != null) {
                if (k.next == null) break;
                if (k.data.seat > k.next.data.seat) {
                    Train t = k.data;
                    k.data = k.next.data;
                    k.next.data = t;
                }
                k = k.next;
            }
            n = n.next;
        }
    }

    public void updateBooked(String tcode, int seat) {
        N_Train n = head;
        while (n != null) {
            if (n.data.tcode.equals(tcode)) {
                n.data.booked += seat;
                return;
            }
            n = n.next;
        }
    }
    
    
}
