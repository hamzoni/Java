
package LinkList;

public class Node {
    public Person info;
    public Node next;
    public Node prev;

    public Node() {
    
    }

    public Node(Person info, Node nextNode, Node prevNode) {
        this.info = info;
        this.next = nextNode;
        this.prev = prevNode;
    }
    
    public Node (Person x) {
        this(x, null, null);
    }
    
}
