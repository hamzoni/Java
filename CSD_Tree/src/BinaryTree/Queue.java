
package BinaryTree;

import java.util.LinkedList;


public class Queue {
    LinkedList<Node> t;

    public Queue() {
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