
package DataModel;

import DataStructure.LinkedList;
import DataStructure.LL_Node;
import Entities.Customer;

public class LL_Customer extends LinkedList<Customer> {

    public boolean isExist(String ccode) {
        LL_Node p = head;
        while (p != null) {
            Customer c = (Customer) p.value;
            if (c.ccode.equals(ccode)) 
                return true;
            p = p.next;
        }
        return false;
    }
    
    @Override
    public LL_Node search(Object key) {
        String ccode = (String) key;
        LL_Node p = head;
        while (p != null) {
            Customer c = (Customer) p.value;
            if (c.ccode.equals(ccode)) return p;
            p = p.next;
        }
        return null;
    }

    @Override
    public void sort(Object key) {
    }
    
    @Override
    public void insertAfterVal(Object key, Customer val) {
        String ccode = (String) key;
        LL_Node nn = new LL_Node(val);
        Customer c = null;
        
        LL_Node n = head;
        while (n != null) {
            c = (Customer) n.value;
            if (c.ccode.equals(ccode)) {
                nn.next = n.next;
                n.next = nn;
                break;
            }
            n = n.next;
        }
    }

    @Override
    public void insertBeforeVal(Object key, Customer val) {
        String ccode = (String) key;
        LL_Node nn = new LL_Node(val);
        Customer c = null;
        
        LL_Node n = head;
        LL_Node pn = null;
        while (n != null) {
            c = (Customer) n.value;
            if (c.ccode.equals(ccode)) {
                pn = findPrev(n);
                if (pn == null) pn = head;
                nn.next = pn.next;
                pn.next = nn;
                break;
            }
            n = n.next;
        }
    }

    @Override
    public void deleteVal(Object key) {
        String ccode = (String) key;
        Customer c = null;
        
        LL_Node n = head;
        while (n != null) {
            c = (Customer) n.value;
            if (c.ccode.equals(ccode)) {
                delete(n);
                break;
            }
            n = n.next;
        }
        
    }

    @Override
    public void deleteAfterVal(Object key) {
        String ccode = (String) key;
        Customer c = null;
        
        LL_Node n = head;
        while (n != null) {
            c = (Customer) n.value;
            if (c.ccode.equals(ccode)) {
                LL_Node nn = n.next;
                if (nn != null) {
                    delete(nn);
                }
            }
            n = n.next;
        }
        
    }

    @Override
    public void deleteBeforeVal(Object key) {
        String ccode = (String) key;
        Customer c = null;
        
        LL_Node n = head;
        LL_Node pn = null;
        
        while (n != null) {
            c = (Customer) n.value;
            if (c.ccode.equals(ccode)) {
                pn = findPrev(n);
                delete(pn);
                break;
            }
            n = n.next;
        }
    }
    
}
