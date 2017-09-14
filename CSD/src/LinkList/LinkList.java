package LinkList;

public class LinkList {

    public Node head, tail;

    public LinkList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void clear() {
        head = tail = null;
    }
    
    // (1) 
    public void addLast(Person lastPerson) {
        Node newNode = new Node(lastPerson, null, tail);
        if (tail != null) tail.next = newNode;
        tail = newNode;

        if (head == null) head = tail;
    }

    // (3)
    public void addFirst(Person firstPerson) {
        Node newNode = new Node(firstPerson, head, null);
        head.prev = newNode;
        head = newNode;
        
        if (tail == null) tail = head;
    }

    // search by name
    public Node search(String personName) {
        Node p = head;
        while (p != null) {
            if (p.info.name.equals(personName)) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    public void visit(Node p) {
        if (p == null) return;
        System.out.print(p.info + " ");
    }

    public void traverse() {
        Node p = head;
        while (p != null) {
            visit(p);
            p = p.next;
        }
        System.out.println();
    }

    public void addLastMany(String[] a, int[] b) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addLast(new Person(a[i], b[i]));
        }
    }
    
    // (2)
    public Node searchByName(String xName) {
        Node p = head;
        while (p != null) {
            if (p.info.name.equals(xName)) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    // (4)
    public void insertAfter(Node q, Person p) {
        Node h = head;
        while (p != null) {
            if (h.info.name.equals(q.info.name)) {
               Node a = new Node();
               a.info = p;
               
               Node b = h.next;
               b.prev = a;
               h.next = a;
               
               a.prev = h;
               a.next = b;
               
               break;
            }
            h = h.next;
        }
    }

    // (5)
    public void insertBefore(Node q, Person p) {
        Node h = head;
        while (p != null) {
            if (h.info.name.equals(q.info.name)) {
               Node a = new Node();
               a.info = p;
               
               Node b = h.prev;
               b.next = a;
               h.prev = a;
               
               a.next = h;
               a.prev = b;
               
               break;
            }
            h = h.next;
        }
    }

    // (6)
    public void dele(Node p) {
        Node h = head;
        while (p != null) {
            if (h == p) {
               Node a = h.next;
               Node b = h.prev;
               
               a.prev = b;
               b.next = a;
               
               break;
            }
            h = h.next;
        }
    }

    // (7)
    public void dele(String xName) {
        Node h = head;
        while (h != null) {
            if (h.info.name.equals(xName)) {
               Node a = h.next;
               Node b = h.prev;
               
               a.prev = b;
               b.next = a;
               
               break;
            }
            h = h.next;
        }
    }

    // (8)
    public void dele(int xAge) {
        Node h = head;
        while (h != null) {
            if (h.info.age == xAge) {
               Node a = h.next;
               Node b = h.prev;
               
               a.prev = b;
               b.next = a;
               
               break;
            }
            h = h.next;
        }
    }

    // (9)
    public void deleAll(int xAge) {
        Node h = head;
        while (h != null) {
            if (h.info.age == xAge) {
               Node a = h.next;
               Node b = h.prev;
               
               a.prev = b;
               b.next = a;
            }
            h = h.next;
        }
    }
    
    // (10)
    public Node pos(int k) {
        Node h = head;
        int i = 0;
        while (h != null) {
            if (i++ == k) {
               return h;
            }
            h = h.next;
        }
        return (null);
    }

    // (11)
    public void delePos(int k) {
        Node h = head;
        int i = 0;
        while (h != null) {
            if (i++ == k) {
               Node a = h.next;
               Node b = h.prev;
               
               a.prev = b;
               b.next = a;
               
               break;
            }
            h = h.next;
        }
    }

    // (12)
    public void sortByName() {
        // SORT ASC
        if (head == null) return;
        Node i = head;
        while (i != null) {
            Node j = i.next;
            while (j != null) {
                if (j.info.name.compareTo(i.info.name) >= 0) {
                    Person t = i.info;
                    i.info = j.info;
                    j.info = t;
                }
                j = j.next;
            }
            i = i.next;
        }
    }
    
    // (13)
    public void sortByAge() {
        if (head == null) return;
        Node i = head;
        while (i != null) {
            Node j = i.next;
            while (j != null) {
                if (j.info.age >= i.info.age) {
                    Person t = i.info;
                    i.info = j.info;
                    j.info = t;
                }
                j = j.next;
            }
            i = i.next;
        }
    }
    
    // (16)
    public void reverse() {
        if (head == null) return;
        
        Person temp = head.info;
        head.info = tail.info;
        tail.info = temp;
        
        int size = (int) Math.floor(size() / 2);
        Node h = head.next;
        Node t = findPrev(tail);
        
        for (int i = 0; i < size - 1; i++) {
            temp = h.info;
            h.info = t.info;
            t.info = temp;
            
            h = h.next;
            t = findPrev(t);
        }
    }
    
    public Node findPrev(Node q) {
        Node h = head;
        while (h != null) {
            if (h.next == q) return h;
            h = h.next;
        }
        return null;
    }
    // (14)
    int size() {
        Node h = head;
        int i = 0;
        while (h != null) {
            i++;
            h = h.next;
        }
        return i;
    }

    // (15)
    Person[] toArray() {
        Person[] group = new Person[this.size()];
        Node h = head;
        int i = 0;
        while (h != null) {
            group[i++] = h.info;
            h = h.next;
        }
        return group;
    }

    // (17) 
    public Node findMaxAge() {
        Node h = head;
        Node maxNode = h;
        while (h != null) {
            if (h.info.age > maxNode.info.age) {
                maxNode = h;
            }
            h = h.next;
        }
        return maxNode;
    }

    // (18) 
    public Node findMinAge() {
        Node h = head;
        Node minNode = h;
        while (h != null) {
            if (h.info.age < minNode.info.age) {
                minNode = h;
            }
            h = h.next;
        }
        return minNode;
    }

    // (19) 
    public void setData(Node p, Person x) {
        p.info = x;
    }
}
