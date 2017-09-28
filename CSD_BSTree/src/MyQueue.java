
import java.util.LinkedList;


public class MyQueue {
    LinkedList<Node> t;

    public MyQueue() {
        t = new LinkedList<Node>();
    }
    
    void clear() {
        t.clear();
    }
    
    boolean isEmpty() {
        return t.isEmpty();
    }
    
    void enqueue(Node x) {
        t.addLast(x);
    
    }
    
    Node dequeue() {
        if (isEmpty()) return null;
        return t.removeFirst();
    }
    
    Node front() {
        if (isEmpty()) return null;
        return t.getFirst();
    }
    
}