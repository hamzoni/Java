
public class Node {
    public Person info;
    public Node next;

    public Node() {
    }

    public Node(Person info, Node next) {
        this.info = info;
        this.next = next;
    }

    Node(Person x) {
        this.info = x;
    }
    
}
