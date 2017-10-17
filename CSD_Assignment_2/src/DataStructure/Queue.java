
package DataStructure;

public class Queue {
    private java.util.LinkedList list = new java.util.LinkedList() {};
    public Queue() {
    }
    
    public int size() {
        return list.size();
    }
    
    public void clear() {
        list.clear();
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    public Object firstEl() {
        return list.getFirst();
    }
    
    public Object dequeue() {
        return list.removeFirst();
    }
    
    public void enqueue(Object el) {
        list.addLast(el);
    }
    
    public String toString() {
        return list.toString();
    }
}
