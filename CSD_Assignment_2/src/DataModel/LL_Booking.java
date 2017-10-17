
package DataModel;

import DataStructure.LL_Node;
import DataStructure.LinkedList;
import Entities.Booking;

public class LL_Booking extends LinkedList<Booking> {
    public void sortByCode() {
        LL_Node n = head;
        while (n != null) {
            LL_Node k = head;
            while (k != null) {
                
                if (k.next == null) break;
                
                Booking b = (Booking) k.value;
                Booking bn = (Booking) k.next.value;
                
                if (b.tcode.compareTo(bn.tcode) > 0) {
                    Booking t = b;
                    k.value = bn;
                    k.next.value = t;
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
                LL_Node m = n;
                while (m != null) {
                    if (m.next == null) break;
                    Booking bn = (Booking) m.next.value;
                    Booking bx = (Booking) m.value;
                    if (bn.tcode.equals(bx.tcode)) {
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
    
    private void sortByTCode(int a, int b, LL_Node n) {
        int i = a;
        while (n != null) {

            int j = i;
            LL_Node m = n;
            while (m != null) {
                if (j == b || m.next == null) break;
                Booking bn = (Booking) m.next.value;
                Booking bx = (Booking) m.value;
                
                if (bx.ccode.compareTo(bn.ccode) > 0) {
                    Booking temp = (Booking) m.value;
                    m.value = m.next.value;
                    m.next.value = temp;
                }
                j++;
                m = m.next;
            }

            i++;
            n = n.next;
        }
    }

    @Override
    public void insertAfterVal(Object key, Booking val) {
    }

    @Override
    public void insertBeforeVal(Object key, Booking val) {
    }

    @Override
    public void deleteAfterVal(Object key) {
    }

    @Override
    public void deleteBeforeVal(Object key) {
    }

    @Override
    public void deleteVal(Object key) {
    }

    @Override
    public LL_Node search(Object key) {
        return null;
    }

    @Override
    public void sort(Object key) {
    }
    
}
