
package BinaryTree;

public class Node {
    protected int key;
    protected Node left, right;
    public Node() {
        left = right = null;
    }
    public Node(int value) {
        this(value, null, null);
    }
    public Node(int value, Node left, Node right) {
        this.key = value;
        this.left = left;
        this.right = right;
    }
}
