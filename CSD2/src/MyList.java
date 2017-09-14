
public class MyList {
    public Node head;
    public Node tail;

    void clear() {
        head = null;
        tail = null;
    }

    void addMany(String[] a, int[] b) {
        Person p;
        for (int i = 0; i < a.length; i++) {
            p = new Person(a[i], b[i]);
            addLast(p);
        }
    }

    void traverse() {
        Node h = head;
        while (h != null) {
            System.out.print(h.info + " ");
            h = h.next;
        }
    }

    Node searchByName(String b) {
        Node h = head;
        while (h != null) {
            if (h.info.name.equals(b)) {
                return h;
            }
            h = h.next;
        }
        return null;
    }

    void visit(Node p) {
        if (p != null) {
            System.out.print(p.info);
        }
    }
    
    void addLast(Person x) {
        Node n = new Node(x);
        
        if (head == null) {
            head = tail = n;
            return;
        }
        
        tail.next = n;
        tail = n;
    }

    void addFirst(Person x) {
        Node n = new Node();
        n.info = x;
        
        n.next = head;
        head = n;
    }

    void insertAfter(Node q, Person x) {
    }

    void insertBefore(Node q, Person x) {
    }

    void dele(Node q) {
        Node h = head;
        while (h != null) {
            if (h.next == q) {
                h.next = q.next;
                break;
            }
            h = h.next;
        }
        q = null;
    }

    void dele(String b) {
    }

    void dele(int i) {
        Node h = head;
        int c = 0;
        while (h != null) {
            if (c++ == i) {
                dele(h);
                return;
            }
            h = h.next;
        }
    }

    void deleAll(int age) {
        Node h = head;
        while (h != null) {
            if (h.info.age == age) {
                dele(h);
                return;
            }
            h = h.next;
        }
    }

    Node pos(int i) {
        Node h = head;
        int c = 0;
        while (h != null) {
            if (c++ == i) return h;
            h = h.next;
        }
        return null;
    }

    void delePos(int i) {
        Node h = head;
        int c = 0;
        while (h != null) {
            if (c++ == i) {
                dele(h);
                return;
            }
            h = h.next;
        }
    }

    void sortByName() {
    }

    void sortByAge() {
    }

    int size() {
        int s = 0;
        Node h = head;
        while (h != null) {
            s++;
            h = h.next;
        }
        return s;
    }

    Person[] toArray() {
        Person[] people = new Person[size()];
        int i = 0;
        Node h = head;
        while (h != null) {
            people[i++] = h.info;
            h = h.next;
        }
        return people;
    }

    void reverse() {
        MyList list = new MyList();
        Node h = head;
        while (h != null) {
            list.addLast(h.info);
            h = h.next;
        }
        head = list.head;
        tail = list.tail;
    }

    Node findMaxAge() {
        Node n = head;
        Node h = head;
        while (h != null) {
            if (h.info.age > n.info.age) {
                n = h;
            }
            h = h.next;
        }
        return n;
    }

    Node findMinAge() {
        Node n = null;
        
        return n;
    }

    void setData(Node p, Person x) {
        p.info = x;
    }

    void sortByAge(int i, int i0) {
    }
}
