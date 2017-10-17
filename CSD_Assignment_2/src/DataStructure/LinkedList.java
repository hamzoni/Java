
package DataStructure;

public abstract class LinkedList <N> {
    public LL_Node<N> head;
    public LL_Node<N> tail;
    
    public boolean isEmpty() {
        return head == null && tail == null;
    }
    
    public void insertFirst(LL_Node n) {
        if (isEmpty()) {
            head = tail = n;
            return;
        }
        n.next = head;
        head = n;
    }
    
    public void insertLast(LL_Node n) {
        if (isEmpty()) {
            head = tail = n;
            return;
        }
        tail.next = n;
        tail = n;
    }
    
    public void addMany(LL_Node[] ns) {
        for (int i = 0; i < ns.length; i++) {
            insertLast(ns[i]);
        }
    }
    
    public LL_Node findPrev(LL_Node tn) {
        LL_Node n = head;
        while (n != null) {
            if (n.next == tn) 
                return n;
            n = n.next;
        }
        return null;
    }
    
    public void visit(LL_Node n) {
        System.out.print(n.value + " ");
    }
    
    public void visitAll() {
        LL_Node n = head;
        while (n != null) {
            visit(n);
            n = n.next;
        }
        System.out.println("");
    }
    
    public void delete(LL_Node tn) {
        LL_Node n = head;
        if (tn == head) {
            head = tn.next;
            return;
        }
        
        while (n != null) {
            if (n == tn) {
                LL_Node pn = findPrev(n);
                pn.next = n.next;
                break;
            }
            n = n.next;
        }
        
    }
    
    public void deleteBefore(LL_Node tn) {
        LL_Node n = head;
        LL_Node pn = null;
        while (n != null) {
            if (n.next == tn) {
                delete(n);
                return;
            }
            n = n.next;
        }
    }
    
    public void deleteAfter(LL_Node tn) {
        LL_Node n = head;
        while (n != null) {
            if (n == tn) {
                if (n.next != null) {
                    n.next = n.next.next;
                }
                break;
            }
            n = n.next;
        }
    }
    
    public int size() {
        LL_Node p = head;
        int c = 0;
        while (p != null) {
            c++;
            p = p.next;
        }
        return c;
    }
    
    public abstract void insertAfterVal(Object key, N val);
    public abstract void insertBeforeVal(Object key, N val);
    public abstract void deleteAfterVal(Object key);
    public abstract void deleteBeforeVal(Object key);
    public abstract void deleteVal(Object key);
    public abstract LL_Node search(Object key);
    public abstract void sort(Object key);
}
